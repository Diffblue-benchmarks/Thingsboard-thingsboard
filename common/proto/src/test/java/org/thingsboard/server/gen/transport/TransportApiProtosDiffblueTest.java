package org.thingsboard.server.gen.transport;

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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.TransportApiProtos.AttributesMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.AttributesRequest;
import org.thingsboard.server.gen.transport.TransportApiProtos.ClaimDevice;
import org.thingsboard.server.gen.transport.TransportApiProtos.ClaimDeviceMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.ConnectMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.DisconnectMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.GatewayAttributeResponseMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.GatewayAttributeUpdateNotificationMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.GatewayAttributesMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.GatewayAttributesRequestMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.GatewayClaimMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.GatewayDeviceRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.GatewayRpcResponseMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.GatewayTelemetryMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.RpcRequest;
import org.thingsboard.server.gen.transport.TransportApiProtos.TelemetryMsg;

class TransportApiProtosDiffblueTest {
  /**
   * Test AttributesMsg {@link AttributesMsg#equals(Object)}, and
   * {@link AttributesMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.AttributesMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.AttributesMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test AttributesMsg equals(Object), and hashCode(); when other is equal; then return equal")
  void testAttributesMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.AttributesMsg defaultInstance = TransportApiProtos.AttributesMsg.getDefaultInstance();
    TransportApiProtos.AttributesMsg defaultInstance2 = TransportApiProtos.AttributesMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#equals(Object)}, and
   * {@link AttributesMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.AttributesMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.AttributesMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test AttributesMsg equals(Object), and hashCode(); when other is same; then return equal")
  void testAttributesMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.AttributesMsg defaultInstance = TransportApiProtos.AttributesMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.AttributesMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test AttributesMsg equals(Object); when other is different; then return not equal")
  void testAttributesMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.AttributesMsg.getDefaultInstance(), 1);
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.AttributesMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test AttributesMsg equals(Object); when other is 'null'; then return not equal")
  void testAttributesMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.AttributesMsg.getDefaultInstance(), null);
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.AttributesMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test AttributesMsg equals(Object); when other is wrong type; then return not equal")
  void testAttributesMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.AttributesMsg.getDefaultInstance(), "Different type to AttributesMsg");
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test AttributesMsg getDefaultInstanceForType()")
  void testAttributesMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.AttributesMsg defaultInstance = TransportApiProtos.AttributesMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#getDeviceName()}.
   * <p>
   * Method under test: {@link TransportApiProtos.AttributesMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test AttributesMsg getDeviceName()")
  void testAttributesMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.AttributesMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test AttributesMsg getDeviceNameBytes()")
  void testAttributesMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.AttributesMsg defaultInstance = TransportApiProtos.AttributesMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
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
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test AttributesMsg getSerializedSize()")
  void testAttributesMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.AttributesMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#hasMsg()}.
   * <p>
   * Method under test: {@link TransportApiProtos.AttributesMsg#hasMsg()}
   */
  @Test
  @DisplayName("Test AttributesMsg hasMsg()")
  void testAttributesMsgHasMsg() {
    // Arrange, Act and Assert
    assertFalse(TransportApiProtos.AttributesMsg.getDefaultInstance().hasMsg());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#isInitialized()}.
   * <p>
   * Method under test: {@link TransportApiProtos.AttributesMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test AttributesMsg isInitialized()")
  void testAttributesMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.AttributesMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test AttributesMsg newInstance(UnusedPrivateParameter)")
  void testAttributesMsgNewInstance() {
    // Arrange
    TransportApiProtos.AttributesMsg defaultInstance = TransportApiProtos.AttributesMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.AttributesMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream) with 'input'")
  void testAttributesMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.AttributesMsg actualParseDelimitedFromResult = TransportApiProtos.AttributesMsg
        .parseDelimitedFrom(input);

    // Assert
    TransportApiProtos.AttributesMsg defaultInstanceForType = actualParseDelimitedFromResult
        .getDefaultInstanceForType();
    UnknownFieldSet unknownFields = defaultInstanceForType.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg msg = actualParseDelimitedFromResult.getMsg();
    Descriptors.Descriptor descriptorForType2 = msg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(2, fields2.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType3, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType2.toProto();
    assertSame(defaultInstanceForType3, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType2.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType2.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType4 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType4.getDependencyList());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(descriptorForType2.getFile(), dependencies.get(0));
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
    assertSame(options3, defaultInstanceForType2.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType2, fields.get(0).getContainingType());
    assertSame(descriptorForType2, getResult6.getMessageType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(msg, defaultInstanceForType.getMsg());
    assertSame(msg, defaultInstanceForType.getMsgOrBuilder());
    assertSame(msg, actualParseDelimitedFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream) with 'input'")
  void testAttributesMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.AttributesMsg actualParseDelimitedFromResult = TransportApiProtos.AttributesMsg
        .parseDelimitedFrom(input);

    // Assert
    TransportProtos.PostAttributeMsg msg = actualParseDelimitedFromResult.getMsg();
    Descriptors.Descriptor descriptorForType = msg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertEquals("transport.PostAttributeMsg.kv", getResult.getFullName());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(2, fields2.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(Descriptors.FieldDescriptor.JavaType.MESSAGE, getResult.getJavaType());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType.toProto();
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
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.FileDescriptor file2 = descriptorForType.getFile();
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
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
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getMessageType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(msg, actualParseDelimitedFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream) with 'input'")
  void testAttributesMsgParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.AttributesMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesMsg
   * {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testAttributesMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.AttributesMsg actualParseDelimitedFromResult = TransportApiProtos.AttributesMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    TransportApiProtos.AttributesMsg defaultInstanceForType = actualParseDelimitedFromResult
        .getDefaultInstanceForType();
    UnknownFieldSet unknownFields = defaultInstanceForType.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg msg = actualParseDelimitedFromResult.getMsg();
    Descriptors.Descriptor descriptorForType2 = msg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(2, fields2.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType3, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType2.toProto();
    assertSame(defaultInstanceForType3, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType2.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType2.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType4 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType4.getDependencyList());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(descriptorForType2.getFile(), dependencies.get(0));
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
    assertSame(options3, defaultInstanceForType2.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType2, fields.get(0).getContainingType());
    assertSame(descriptorForType2, getResult6.getMessageType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(msg, defaultInstanceForType.getMsg());
    assertSame(msg, defaultInstanceForType.getMsgOrBuilder());
    assertSame(msg, actualParseDelimitedFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AttributesMsg
   * {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testAttributesMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.AttributesMsg actualParseDelimitedFromResult = TransportApiProtos.AttributesMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    TransportProtos.PostAttributeMsg msg = actualParseDelimitedFromResult.getMsg();
    Descriptors.Descriptor descriptorForType = msg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertEquals("transport.PostAttributeMsg.kv", getResult.getFullName());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(2, fields2.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(Descriptors.FieldDescriptor.JavaType.MESSAGE, getResult.getJavaType());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType.toProto();
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
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.FileDescriptor file2 = descriptorForType.getFile();
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
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
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getMessageType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(msg, actualParseDelimitedFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AttributesMsg
   * {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testAttributesMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.AttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesMsg
   * {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testAttributesMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.AttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesMsg
   * {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testAttributesMsgParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.AttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesMsg
   * {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testAttributesMsgParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.AttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testAttributesMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.AttributesMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testAttributesMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.AttributesMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testAttributesMsgParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.AttributesMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(InputStream) with 'InputStream'")
  void testAttributesMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransportApiProtos.AttributesMsg actualParseFromResult = TransportApiProtos.AttributesMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg msg = actualParseFromResult.getMsg();
    Descriptors.Descriptor descriptorForType2 = msg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(2, fields2.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType2.toProto();
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
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
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
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult7.getMessageType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(msg, actualParseFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(InputStream) with 'InputStream'")
  void testAttributesMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.AttributesMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AttributesMsg
   * {@link AttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testAttributesMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.AttributesMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AttributesMsg
   * {@link AttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testAttributesMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.AttributesMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testAttributesMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.AttributesMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testAttributesMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransportApiProtos.AttributesMsg actualParseFromResult = TransportApiProtos.AttributesMsg
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg msg = actualParseFromResult.getMsg();
    Descriptors.Descriptor descriptorForType2 = msg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(2, fields2.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType2.toProto();
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
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
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
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult7.getMessageType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(msg, actualParseFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#equals(Object)}, and
   * {@link AttributesRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.AttributesRequest#equals(Object)}
   *   <li>{@link TransportApiProtos.AttributesRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test AttributesRequest equals(Object), and hashCode(); when other is equal; then return equal")
  void testAttributesRequestEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.AttributesRequest defaultInstance = TransportApiProtos.AttributesRequest.getDefaultInstance();
    TransportApiProtos.AttributesRequest defaultInstance2 = TransportApiProtos.AttributesRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#equals(Object)}, and
   * {@link AttributesRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.AttributesRequest#equals(Object)}
   *   <li>{@link TransportApiProtos.AttributesRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test AttributesRequest equals(Object), and hashCode(); when other is same; then return equal")
  void testAttributesRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.AttributesRequest defaultInstance = TransportApiProtos.AttributesRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test AttributesRequest equals(Object); when other is different; then return not equal")
  void testAttributesRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.AttributesRequest.getDefaultInstance(), 1);
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test AttributesRequest equals(Object); when other is 'null'; then return not equal")
  void testAttributesRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.AttributesRequest.getDefaultInstance(), null);
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test AttributesRequest equals(Object); when other is wrong type; then return not equal")
  void testAttributesRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.AttributesRequest.getDefaultInstance(), "Different type to AttributesRequest");
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#getClientKeys()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#getClientKeys()}
   */
  @Test
  @DisplayName("Test AttributesRequest getClientKeys()")
  void testAttributesRequestGetClientKeys() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.AttributesRequest.getDefaultInstance().getClientKeys());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#getClientKeysBytes()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#getClientKeysBytes()}
   */
  @Test
  @DisplayName("Test AttributesRequest getClientKeysBytes()")
  void testAttributesRequestGetClientKeysBytes() {
    // Arrange
    TransportApiProtos.AttributesRequest defaultInstance = TransportApiProtos.AttributesRequest.getDefaultInstance();

    // Act
    ByteString actualClientKeysBytes = defaultInstance.getClientKeysBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualClientKeysBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, dependencies.get(0).getOptions().getCsharpNamespaceBytes());
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
    assertEquals(byteString, actualClientKeysBytes);
    assertEquals(byteString, defaultInstance.getSharedKeysBytes());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test AttributesRequest getDefaultInstanceForType()")
  void testAttributesRequestGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.AttributesRequest defaultInstance = TransportApiProtos.AttributesRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#getSerializedSize()}
   */
  @Test
  @DisplayName("Test AttributesRequest getSerializedSize()")
  void testAttributesRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.AttributesRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#getSharedKeys()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#getSharedKeys()}
   */
  @Test
  @DisplayName("Test AttributesRequest getSharedKeys()")
  void testAttributesRequestGetSharedKeys() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.AttributesRequest.getDefaultInstance().getSharedKeys());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#getSharedKeysBytes()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#getSharedKeysBytes()}
   */
  @Test
  @DisplayName("Test AttributesRequest getSharedKeysBytes()")
  void testAttributesRequestGetSharedKeysBytes() {
    // Arrange
    TransportApiProtos.AttributesRequest defaultInstance = TransportApiProtos.AttributesRequest.getDefaultInstance();

    // Act
    ByteString actualSharedKeysBytes = defaultInstance.getSharedKeysBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualSharedKeysBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, dependencies.get(0).getOptions().getCsharpNamespaceBytes());
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
    assertEquals(byteString, defaultInstance.getClientKeysBytes());
    assertEquals(byteString, actualSharedKeysBytes);
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#isInitialized()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#isInitialized()}
   */
  @Test
  @DisplayName("Test AttributesRequest isInitialized()")
  void testAttributesRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.AttributesRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test AttributesRequest
   * {@link AttributesRequest#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test AttributesRequest newInstance(UnusedPrivateParameter)")
  void testAttributesRequestNewInstance() {
    // Arrange
    TransportApiProtos.AttributesRequest defaultInstance = TransportApiProtos.AttributesRequest.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.AttributesRequest);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test AttributesRequest
   * {@link AttributesRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream) with 'input'")
  void testAttributesRequestParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.AttributesRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesRequest
   * {@link AttributesRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream) with 'input'")
  void testAttributesRequestParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.AttributesRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesRequest
   * {@link AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testAttributesRequestParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.AttributesRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesRequest
   * {@link AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testAttributesRequestParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.AttributesRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesRequest
   * {@link AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testAttributesRequestParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.AttributesRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesRequest
   * {@link AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testAttributesRequestParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        TransportApiProtos.AttributesRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AttributesRequest
   * {@link AttributesRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testAttributesRequestParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.AttributesRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AttributesRequest
   * {@link AttributesRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testAttributesRequestParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.AttributesRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(InputStream) with 'InputStream'")
  void testAttributesRequestParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransportApiProtos.AttributesRequest actualParseFromResult = TransportApiProtos.AttributesRequest
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult5.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult5.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(InputStream) with 'InputStream'")
  void testAttributesRequestParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.AttributesRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AttributesRequest
   * {@link AttributesRequest#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testAttributesRequestParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.AttributesRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AttributesRequest
   * {@link AttributesRequest#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testAttributesRequestParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.AttributesRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testAttributesRequestParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.AttributesRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testAttributesRequestParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransportApiProtos.AttributesRequest actualParseFromResult = TransportApiProtos.AttributesRequest
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult5.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult5.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#equals(Object)}, and
   * {@link ClaimDevice#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.ClaimDevice#equals(Object)}
   *   <li>{@link TransportApiProtos.ClaimDevice#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ClaimDevice equals(Object), and hashCode(); when other is equal; then return equal")
  void testClaimDeviceEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.ClaimDevice defaultInstance = TransportApiProtos.ClaimDevice.getDefaultInstance();
    TransportApiProtos.ClaimDevice defaultInstance2 = TransportApiProtos.ClaimDevice.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#equals(Object)}, and
   * {@link ClaimDevice#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.ClaimDevice#equals(Object)}
   *   <li>{@link TransportApiProtos.ClaimDevice#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ClaimDevice equals(Object), and hashCode(); when other is same; then return equal")
  void testClaimDeviceEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.ClaimDevice defaultInstance = TransportApiProtos.ClaimDevice.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.ClaimDevice#equals(Object)}
   */
  @Test
  @DisplayName("Test ClaimDevice equals(Object); when other is different; then return not equal")
  void testClaimDeviceEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ClaimDevice.getDefaultInstance(), 1);
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.ClaimDevice#equals(Object)}
   */
  @Test
  @DisplayName("Test ClaimDevice equals(Object); when other is 'null'; then return not equal")
  void testClaimDeviceEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ClaimDevice.getDefaultInstance(), null);
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.ClaimDevice#equals(Object)}
   */
  @Test
  @DisplayName("Test ClaimDevice equals(Object); when other is wrong type; then return not equal")
  void testClaimDeviceEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ClaimDevice.getDefaultInstance(), "Different type to ClaimDevice");
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ClaimDevice getDefaultInstanceForType()")
  void testClaimDeviceGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.ClaimDevice defaultInstance = TransportApiProtos.ClaimDevice.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#getSecretKey()}.
   * <p>
   * Method under test: {@link TransportApiProtos.ClaimDevice#getSecretKey()}
   */
  @Test
  @DisplayName("Test ClaimDevice getSecretKey()")
  void testClaimDeviceGetSecretKey() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.ClaimDevice.getDefaultInstance().getSecretKey());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#getSecretKeyBytes()}.
   * <p>
   * Method under test: {@link TransportApiProtos.ClaimDevice#getSecretKeyBytes()}
   */
  @Test
  @DisplayName("Test ClaimDevice getSecretKeyBytes()")
  void testClaimDeviceGetSecretKeyBytes() {
    // Arrange
    TransportApiProtos.ClaimDevice defaultInstance = TransportApiProtos.ClaimDevice.getDefaultInstance();

    // Act
    ByteString actualSecretKeyBytes = defaultInstance.getSecretKeyBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualSecretKeyBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, dependencies.get(0).getOptions().getCsharpNamespaceBytes());
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
    assertEquals(byteString, actualSecretKeyBytes);
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#getSerializedSize()}.
   * <p>
   * Method under test: {@link TransportApiProtos.ClaimDevice#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ClaimDevice getSerializedSize()")
  void testClaimDeviceGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.ClaimDevice.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#isInitialized()}.
   * <p>
   * Method under test: {@link TransportApiProtos.ClaimDevice#isInitialized()}
   */
  @Test
  @DisplayName("Test ClaimDevice isInitialized()")
  void testClaimDeviceIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.ClaimDevice.getDefaultInstance().isInitialized());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#equals(Object)}, and
   * {@link ClaimDeviceMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.ClaimDeviceMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.ClaimDeviceMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg equals(Object), and hashCode(); when other is equal; then return equal")
  void testClaimDeviceMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.ClaimDeviceMsg defaultInstance = TransportApiProtos.ClaimDeviceMsg.getDefaultInstance();
    TransportApiProtos.ClaimDeviceMsg defaultInstance2 = TransportApiProtos.ClaimDeviceMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#equals(Object)}, and
   * {@link ClaimDeviceMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.ClaimDeviceMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.ClaimDeviceMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg equals(Object), and hashCode(); when other is same; then return equal")
  void testClaimDeviceMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.ClaimDeviceMsg defaultInstance = TransportApiProtos.ClaimDeviceMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.ClaimDeviceMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg equals(Object); when other is different; then return not equal")
  void testClaimDeviceMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ClaimDeviceMsg.getDefaultInstance(), 1);
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.ClaimDeviceMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg equals(Object); when other is 'null'; then return not equal")
  void testClaimDeviceMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ClaimDeviceMsg.getDefaultInstance(), null);
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.ClaimDeviceMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg equals(Object); when other is wrong type; then return not equal")
  void testClaimDeviceMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ClaimDeviceMsg.getDefaultInstance(), "Different type to ClaimDeviceMsg");
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg getDefaultInstanceForType()")
  void testClaimDeviceMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.ClaimDeviceMsg defaultInstance = TransportApiProtos.ClaimDeviceMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#getDeviceName()}.
   * <p>
   * Method under test: {@link TransportApiProtos.ClaimDeviceMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg getDeviceName()")
  void testClaimDeviceMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.ClaimDeviceMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg getDeviceNameBytes()")
  void testClaimDeviceMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.ClaimDeviceMsg defaultInstance = TransportApiProtos.ClaimDeviceMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
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
    assertEquals(byteString, defaultInstance.getClaimRequest().getSecretKeyBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg getSerializedSize()")
  void testClaimDeviceMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.ClaimDeviceMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#hasClaimRequest()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#hasClaimRequest()}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg hasClaimRequest()")
  void testClaimDeviceMsgHasClaimRequest() {
    // Arrange, Act and Assert
    assertFalse(TransportApiProtos.ClaimDeviceMsg.getDefaultInstance().hasClaimRequest());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#isInitialized()}.
   * <p>
   * Method under test: {@link TransportApiProtos.ClaimDeviceMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg isInitialized()")
  void testClaimDeviceMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.ClaimDeviceMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test ClaimDeviceMsg
   * {@link ClaimDeviceMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg newInstance(UnusedPrivateParameter)")
  void testClaimDeviceMsgNewInstance() {
    // Arrange
    TransportApiProtos.ClaimDeviceMsg defaultInstance = TransportApiProtos.ClaimDeviceMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.ClaimDeviceMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream) with 'input'")
  void testClaimDeviceMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.ClaimDeviceMsg actualParseDelimitedFromResult = TransportApiProtos.ClaimDeviceMsg
        .parseDelimitedFrom(input);

    // Assert
    TransportApiProtos.ClaimDevice claimRequest = actualParseDelimitedFromResult.getClaimRequest();
    UnknownFieldSet unknownFields = claimRequest.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = claimRequest.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(2, fields2.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, descriptorForType2.getFile());
    Descriptors.Descriptor getResult = messageTypes.get(1);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult6.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult7.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult5, fieldList2.get(0));
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult7.getMessageType());
    assertSame(descriptorForType2, messageTypes.get(0));
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    TransportApiProtos.ClaimDeviceMsg defaultInstanceForType4 = actualParseDelimitedFromResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(claimRequest, claimRequest.getDefaultInstanceForType());
    assertSame(claimRequest, defaultInstanceForType4.getClaimRequest());
    assertSame(claimRequest, defaultInstanceForType4.getClaimRequestOrBuilder());
    assertSame(claimRequest, actualParseDelimitedFromResult.getClaimRequestOrBuilder());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream) with 'input'")
  void testClaimDeviceMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.ClaimDeviceMsg actualParseDelimitedFromResult = TransportApiProtos.ClaimDeviceMsg
        .parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    TransportApiProtos.ClaimDevice claimRequest = actualParseDelimitedFromResult.getClaimRequest();
    Descriptors.Descriptor descriptorForType2 = claimRequest.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(2, fields2.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    Descriptors.Descriptor descriptorForType3 = toProtoResult2.getDescriptorForType();
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, descriptorForType2.getFile());
    Descriptors.Descriptor getResult = messageTypes.get(1);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult6.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult7.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult5, fieldList2.get(0));
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult7.getMessageType());
    assertSame(descriptorForType2, messageTypes.get(0));
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, claimRequest.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(claimRequest, claimRequest.getDefaultInstanceForType());
    assertSame(claimRequest, actualParseDelimitedFromResult.getClaimRequestOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream) with 'input'")
  void testClaimDeviceMsgParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.ClaimDeviceMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDeviceMsg
   * {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testClaimDeviceMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.ClaimDeviceMsg actualParseDelimitedFromResult = TransportApiProtos.ClaimDeviceMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    TransportApiProtos.ClaimDevice claimRequest = actualParseDelimitedFromResult.getClaimRequest();
    UnknownFieldSet unknownFields = claimRequest.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = claimRequest.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(2, fields2.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, descriptorForType2.getFile());
    Descriptors.Descriptor getResult = messageTypes.get(1);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult6.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult7.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult5, fieldList2.get(0));
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult7.getMessageType());
    assertSame(descriptorForType2, messageTypes.get(0));
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    TransportApiProtos.ClaimDeviceMsg defaultInstanceForType4 = actualParseDelimitedFromResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(claimRequest, claimRequest.getDefaultInstanceForType());
    assertSame(claimRequest, defaultInstanceForType4.getClaimRequest());
    assertSame(claimRequest, defaultInstanceForType4.getClaimRequestOrBuilder());
    assertSame(claimRequest, actualParseDelimitedFromResult.getClaimRequestOrBuilder());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ClaimDeviceMsg
   * {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testClaimDeviceMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.ClaimDeviceMsg actualParseDelimitedFromResult = TransportApiProtos.ClaimDeviceMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    TransportApiProtos.ClaimDevice claimRequest = actualParseDelimitedFromResult.getClaimRequest();
    Descriptors.Descriptor descriptorForType2 = claimRequest.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(2, fields2.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    Descriptors.Descriptor descriptorForType3 = toProtoResult2.getDescriptorForType();
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, descriptorForType2.getFile());
    Descriptors.Descriptor getResult = messageTypes.get(1);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult6.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult7.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult5, fieldList2.get(0));
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult7.getMessageType());
    assertSame(descriptorForType2, messageTypes.get(0));
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, claimRequest.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(claimRequest, claimRequest.getDefaultInstanceForType());
    assertSame(claimRequest, actualParseDelimitedFromResult.getClaimRequestOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ClaimDeviceMsg
   * {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testClaimDeviceMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.ClaimDeviceMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDeviceMsg
   * {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testClaimDeviceMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.ClaimDeviceMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDeviceMsg
   * {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testClaimDeviceMsgParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.ClaimDeviceMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDeviceMsg
   * {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testClaimDeviceMsgParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.ClaimDeviceMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testClaimDeviceMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.ClaimDeviceMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testClaimDeviceMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.ClaimDeviceMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testClaimDeviceMsgParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.ClaimDeviceMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(InputStream) with 'InputStream'")
  void testClaimDeviceMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransportApiProtos.ClaimDeviceMsg actualParseFromResult = TransportApiProtos.ClaimDeviceMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    TransportApiProtos.ClaimDevice claimRequest = actualParseFromResult.getClaimRequest();
    Descriptors.Descriptor descriptorForType2 = claimRequest.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(2, fields2.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, descriptorForType2.getFile());
    Descriptors.Descriptor getResult = messageTypes.get(1);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult6.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult7.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult5, fieldList2.get(0));
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult7.getMessageType());
    assertSame(descriptorForType2, messageTypes.get(0));
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, claimRequest.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(claimRequest, claimRequest.getDefaultInstanceForType());
    assertSame(claimRequest, actualParseFromResult.getClaimRequestOrBuilder());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(InputStream) with 'InputStream'")
  void testClaimDeviceMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.ClaimDeviceMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClaimDeviceMsg
   * {@link ClaimDeviceMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testClaimDeviceMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.ClaimDeviceMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClaimDeviceMsg
   * {@link ClaimDeviceMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testClaimDeviceMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.ClaimDeviceMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testClaimDeviceMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.ClaimDeviceMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testClaimDeviceMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransportApiProtos.ClaimDeviceMsg actualParseFromResult = TransportApiProtos.ClaimDeviceMsg
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    TransportApiProtos.ClaimDevice claimRequest = actualParseFromResult.getClaimRequest();
    Descriptors.Descriptor descriptorForType2 = claimRequest.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(2, fields2.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, descriptorForType2.getFile());
    Descriptors.Descriptor getResult = messageTypes.get(1);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult6.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult7.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult5, fieldList2.get(0));
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult7.getMessageType());
    assertSame(descriptorForType2, messageTypes.get(0));
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, claimRequest.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(claimRequest, claimRequest.getDefaultInstanceForType());
    assertSame(claimRequest, actualParseFromResult.getClaimRequestOrBuilder());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test ClaimDevice newInstance(UnusedPrivateParameter)")
  void testClaimDeviceNewInstance() {
    // Arrange
    TransportApiProtos.ClaimDevice defaultInstance = TransportApiProtos.ClaimDevice.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.ClaimDevice);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream) with 'input'")
  void testClaimDeviceParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.ClaimDevice.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDevice
   * {@link ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testClaimDeviceParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.ClaimDevice.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDevice
   * {@link ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testClaimDeviceParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.ClaimDevice.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDevice
   * {@link ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testClaimDeviceParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.ClaimDevice.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ClaimDevice
   * {@link ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  void testClaimDeviceParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.ClaimDevice.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testClaimDeviceParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.ClaimDevice.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testClaimDeviceParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.ClaimDevice.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testClaimDeviceParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.ClaimDevice.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(InputStream) with 'InputStream'")
  void testClaimDeviceParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransportApiProtos.ClaimDevice actualParseFromResult = TransportApiProtos.ClaimDevice
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult5.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult5.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDevice
   * {@link ClaimDevice#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testClaimDeviceParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.ClaimDevice.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClaimDevice
   * {@link ClaimDevice#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testClaimDeviceParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.ClaimDevice.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testClaimDeviceParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.ClaimDevice.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testClaimDeviceParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.ClaimDevice.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testClaimDeviceParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransportApiProtos.ClaimDevice actualParseFromResult = TransportApiProtos.ClaimDevice.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult5.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult5.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#equals(Object)}, and
   * {@link ConnectMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.ConnectMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.ConnectMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ConnectMsg equals(Object), and hashCode(); when other is equal; then return equal")
  void testConnectMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.ConnectMsg defaultInstance = TransportApiProtos.ConnectMsg.getDefaultInstance();
    TransportApiProtos.ConnectMsg defaultInstance2 = TransportApiProtos.ConnectMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#equals(Object)}, and
   * {@link ConnectMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.ConnectMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.ConnectMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ConnectMsg equals(Object), and hashCode(); when other is same; then return equal")
  void testConnectMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.ConnectMsg defaultInstance = TransportApiProtos.ConnectMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.ConnectMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test ConnectMsg equals(Object); when other is different; then return not equal")
  void testConnectMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ConnectMsg.getDefaultInstance(), 1);
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.ConnectMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test ConnectMsg equals(Object); when other is 'null'; then return not equal")
  void testConnectMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ConnectMsg.getDefaultInstance(), null);
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.ConnectMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test ConnectMsg equals(Object); when other is wrong type; then return not equal")
  void testConnectMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ConnectMsg.getDefaultInstance(), "Different type to ConnectMsg");
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ConnectMsg getDefaultInstanceForType()")
  void testConnectMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.ConnectMsg defaultInstance = TransportApiProtos.ConnectMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#getDeviceName()}.
   * <p>
   * Method under test: {@link TransportApiProtos.ConnectMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test ConnectMsg getDeviceName()")
  void testConnectMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.ConnectMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test: {@link TransportApiProtos.ConnectMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test ConnectMsg getDeviceNameBytes()")
  void testConnectMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.ConnectMsg defaultInstance = TransportApiProtos.ConnectMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
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
    assertEquals(byteString, actualDeviceNameBytes);
    assertEquals(byteString, defaultInstance.getDeviceTypeBytes());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#getDeviceType()}.
   * <p>
   * Method under test: {@link TransportApiProtos.ConnectMsg#getDeviceType()}
   */
  @Test
  @DisplayName("Test ConnectMsg getDeviceType()")
  void testConnectMsgGetDeviceType() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.ConnectMsg.getDefaultInstance().getDeviceType());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#getDeviceTypeBytes()}.
   * <p>
   * Method under test: {@link TransportApiProtos.ConnectMsg#getDeviceTypeBytes()}
   */
  @Test
  @DisplayName("Test ConnectMsg getDeviceTypeBytes()")
  void testConnectMsgGetDeviceTypeBytes() {
    // Arrange
    TransportApiProtos.ConnectMsg defaultInstance = TransportApiProtos.ConnectMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceTypeBytes = defaultInstance.getDeviceTypeBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDeviceTypeBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
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
    assertEquals(byteString, defaultInstance.getDeviceNameBytes());
    assertEquals(byteString, actualDeviceTypeBytes);
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link TransportApiProtos.ConnectMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ConnectMsg getSerializedSize()")
  void testConnectMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.ConnectMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#isInitialized()}.
   * <p>
   * Method under test: {@link TransportApiProtos.ConnectMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test ConnectMsg isInitialized()")
  void testConnectMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.ConnectMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test ConnectMsg newInstance(UnusedPrivateParameter)")
  void testConnectMsgNewInstance() {
    // Arrange
    TransportApiProtos.ConnectMsg defaultInstance = TransportApiProtos.ConnectMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.ConnectMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream) with 'input'")
  void testConnectMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.ConnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ConnectMsg
   * {@link ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testConnectMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.ConnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ConnectMsg
   * {@link ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testConnectMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.ConnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ConnectMsg
   * {@link ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testConnectMsgParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.ConnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ConnectMsg
   * {@link ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  void testConnectMsgParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.ConnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testConnectMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.ConnectMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testConnectMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.ConnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testConnectMsgParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.ConnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(InputStream) with 'InputStream'")
  void testConnectMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransportApiProtos.ConnectMsg actualParseFromResult = TransportApiProtos.ConnectMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult5.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult6.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ConnectMsg
   * {@link ConnectMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testConnectMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.ConnectMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ConnectMsg
   * {@link ConnectMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testConnectMsgParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.ConnectMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testConnectMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.ConnectMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testConnectMsgParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.ConnectMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testConnectMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransportApiProtos.ConnectMsg actualParseFromResult = TransportApiProtos.ConnectMsg.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult5.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult6.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#equals(Object)}, and
   * {@link DisconnectMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.DisconnectMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.DisconnectMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test DisconnectMsg equals(Object), and hashCode(); when other is equal; then return equal")
  void testDisconnectMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.DisconnectMsg defaultInstance = TransportApiProtos.DisconnectMsg.getDefaultInstance();
    TransportApiProtos.DisconnectMsg defaultInstance2 = TransportApiProtos.DisconnectMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#equals(Object)}, and
   * {@link DisconnectMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.DisconnectMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.DisconnectMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test DisconnectMsg equals(Object), and hashCode(); when other is same; then return equal")
  void testDisconnectMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.DisconnectMsg defaultInstance = TransportApiProtos.DisconnectMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.DisconnectMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test DisconnectMsg equals(Object); when other is different; then return not equal")
  void testDisconnectMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.DisconnectMsg.getDefaultInstance(), 1);
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.DisconnectMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test DisconnectMsg equals(Object); when other is 'null'; then return not equal")
  void testDisconnectMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.DisconnectMsg.getDefaultInstance(), null);
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.DisconnectMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test DisconnectMsg equals(Object); when other is wrong type; then return not equal")
  void testDisconnectMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.DisconnectMsg.getDefaultInstance(), "Different type to DisconnectMsg");
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test DisconnectMsg getDefaultInstanceForType()")
  void testDisconnectMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.DisconnectMsg defaultInstance = TransportApiProtos.DisconnectMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#getDeviceName()}.
   * <p>
   * Method under test: {@link TransportApiProtos.DisconnectMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test DisconnectMsg getDeviceName()")
  void testDisconnectMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.DisconnectMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test DisconnectMsg getDeviceNameBytes()")
  void testDisconnectMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.DisconnectMsg defaultInstance = TransportApiProtos.DisconnectMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    DescriptorProtos.FileOptions options2 = dependencies.get(0).getOptions();
    assertEquals(byteString, options2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, options2.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test DisconnectMsg getSerializedSize()")
  void testDisconnectMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.DisconnectMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#isInitialized()}.
   * <p>
   * Method under test: {@link TransportApiProtos.DisconnectMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test DisconnectMsg isInitialized()")
  void testDisconnectMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.DisconnectMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test DisconnectMsg newInstance(UnusedPrivateParameter)")
  void testDisconnectMsgNewInstance() {
    // Arrange
    TransportApiProtos.DisconnectMsg defaultInstance = TransportApiProtos.DisconnectMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.DisconnectMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream) with 'input'")
  void testDisconnectMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.DisconnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test DisconnectMsg
   * {@link DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testDisconnectMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.DisconnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test DisconnectMsg
   * {@link DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testDisconnectMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.DisconnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test DisconnectMsg
   * {@link DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testDisconnectMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.DisconnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test DisconnectMsg
   * {@link DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testDisconnectMsgParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.DisconnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testDisconnectMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.DisconnectMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testDisconnectMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.DisconnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testDisconnectMsgParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.DisconnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(InputStream) with 'InputStream'")
  void testDisconnectMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransportApiProtos.DisconnectMsg actualParseFromResult = TransportApiProtos.DisconnectMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult5.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, dependencies.get(0).getOptions().getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(InputStream) with 'InputStream'")
  void testDisconnectMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.DisconnectMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test DisconnectMsg
   * {@link DisconnectMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testDisconnectMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.DisconnectMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test DisconnectMsg
   * {@link DisconnectMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testDisconnectMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.DisconnectMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testDisconnectMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.DisconnectMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testDisconnectMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransportApiProtos.DisconnectMsg actualParseFromResult = TransportApiProtos.DisconnectMsg
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult5.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, dependencies.get(0).getOptions().getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#equals(Object)}, and
   * {@link GatewayAttributeResponseMsg#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayAttributeResponseMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayAttributeResponseMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg equals(Object), and hashCode(); then return equal")
  void testGatewayAttributeResponseMsgEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayAttributeResponseMsg defaultInstance = TransportApiProtos.GatewayAttributeResponseMsg
        .getDefaultInstance();
    TransportApiProtos.GatewayAttributeResponseMsg defaultInstance2 = TransportApiProtos.GatewayAttributeResponseMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#equals(Object)}, and
   * {@link GatewayAttributeResponseMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayAttributeResponseMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayAttributeResponseMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg equals(Object), and hashCode(); when other is same; then return equal")
  void testGatewayAttributeResponseMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayAttributeResponseMsg defaultInstance = TransportApiProtos.GatewayAttributeResponseMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg equals(Object); when other is different; then return not equal")
  void testGatewayAttributeResponseMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributeResponseMsg.getDefaultInstance(), 1);
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg equals(Object); when other is 'null'; then return not equal")
  void testGatewayAttributeResponseMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributeResponseMsg.getDefaultInstance(), null);
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg equals(Object); when other is wrong type; then return not equal")
  void testGatewayAttributeResponseMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributeResponseMsg.getDefaultInstance(),
        "Different type to GatewayAttributeResponseMsg");
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg getDefaultInstanceForType()")
  void testGatewayAttributeResponseMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.GatewayAttributeResponseMsg defaultInstance = TransportApiProtos.GatewayAttributeResponseMsg
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#getDeviceName()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg getDeviceName()")
  void testGatewayAttributeResponseMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.GatewayAttributeResponseMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg getDeviceNameBytes()")
  void testGatewayAttributeResponseMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.GatewayAttributeResponseMsg defaultInstance = TransportApiProtos.GatewayAttributeResponseMsg
        .getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
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
    assertEquals(byteString, actualDeviceNameBytes);
    assertEquals(byteString, defaultInstance.getResponseMsg().getErrorBytes());
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg getSerializedSize()")
  void testGatewayAttributeResponseMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayAttributeResponseMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#hasResponseMsg()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#hasResponseMsg()}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg hasResponseMsg()")
  void testGatewayAttributeResponseMsgHasResponseMsg() {
    // Arrange, Act and Assert
    assertFalse(TransportApiProtos.GatewayAttributeResponseMsg.getDefaultInstance().hasResponseMsg());
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#isInitialized()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg isInitialized()")
  void testGatewayAttributeResponseMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.GatewayAttributeResponseMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg newInstance(UnusedPrivateParameter)")
  void testGatewayAttributeResponseMsgNewInstance() {
    // Arrange
    TransportApiProtos.GatewayAttributeResponseMsg defaultInstance = TransportApiProtos.GatewayAttributeResponseMsg
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.GatewayAttributeResponseMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.GatewayAttributeResponseMsg actualParseDelimitedFromResult = TransportApiProtos.GatewayAttributeResponseMsg
        .parseDelimitedFrom(input);

    // Assert
    TransportApiProtos.GatewayAttributeResponseMsg defaultInstanceForType = actualParseDelimitedFromResult
        .getDefaultInstanceForType();
    UnknownFieldSet unknownFields = defaultInstanceForType.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType3, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    TransportProtos.GetAttributeResponseMsg responseMsg = actualParseDelimitedFromResult.getResponseMsg();
    Descriptors.Descriptor descriptorForType4 = responseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType3, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType2.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType2.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType4 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType4.getDependencyList());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(descriptorForType4.getFile(), dependencies.get(0));
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType2.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType2.getOptionsOrBuilder());
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
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType4, getResult6.getMessageType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, responseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(responseMsg, defaultInstanceForType.getResponseMsg());
    assertSame(responseMsg, defaultInstanceForType.getResponseMsgOrBuilder());
    assertSame(responseMsg, actualParseDelimitedFromResult.getResponseMsgOrBuilder());
    assertSame(responseMsg, responseMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.GatewayAttributeResponseMsg actualParseDelimitedFromResult = TransportApiProtos.GatewayAttributeResponseMsg
        .parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertEquals(825, toProtoResult2.getSerializedSize());
    assertFalse(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasName());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    TransportProtos.GetAttributeResponseMsg responseMsg = actualParseDelimitedFromResult.getResponseMsg();
    Descriptors.Descriptor descriptorForType4 = responseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult2.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(toProtoResult2.getReservedNameList(), toProtoResult2.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(descriptorForType4.getFile(), dependencies.get(0));
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType4, getResult6.getMessageType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, responseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(responseMsg, actualParseDelimitedFromResult.getResponseMsgOrBuilder());
    assertSame(responseMsg, responseMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayAttributeResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInput4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.GatewayAttributeResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.GatewayAttributeResponseMsg actualParseDelimitedFromResult = TransportApiProtos.GatewayAttributeResponseMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    TransportApiProtos.GatewayAttributeResponseMsg defaultInstanceForType = actualParseDelimitedFromResult
        .getDefaultInstanceForType();
    UnknownFieldSet unknownFields = defaultInstanceForType.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType3, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    TransportProtos.GetAttributeResponseMsg responseMsg = actualParseDelimitedFromResult.getResponseMsg();
    Descriptors.Descriptor descriptorForType4 = responseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType3, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType2.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType2.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType4 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType4.getDependencyList());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(descriptorForType4.getFile(), dependencies.get(0));
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType2.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType2.getOptionsOrBuilder());
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
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType4, getResult6.getMessageType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, responseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(responseMsg, defaultInstanceForType.getResponseMsg());
    assertSame(responseMsg, defaultInstanceForType.getResponseMsgOrBuilder());
    assertSame(responseMsg, actualParseDelimitedFromResult.getResponseMsgOrBuilder());
    assertSame(responseMsg, responseMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.GatewayAttributeResponseMsg actualParseDelimitedFromResult = TransportApiProtos.GatewayAttributeResponseMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertEquals(825, toProtoResult2.getSerializedSize());
    assertFalse(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasName());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    TransportProtos.GetAttributeResponseMsg responseMsg = actualParseDelimitedFromResult.getResponseMsg();
    Descriptors.Descriptor descriptorForType4 = responseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult2.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(toProtoResult2.getReservedNameList(), toProtoResult2.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(descriptorForType4.getFile(), dependencies.get(0));
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType4, getResult6.getMessageType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, responseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(responseMsg, actualParseDelimitedFromResult.getResponseMsgOrBuilder());
    assertSame(responseMsg, responseMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayAttributeResponseMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributeResponseMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayAttributeResponseMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInputExtensionRegistry6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.GatewayAttributeResponseMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayAttributeResponseMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributeResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayAttributeResponseMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransportApiProtos.GatewayAttributeResponseMsg actualParseFromResult = TransportApiProtos.GatewayAttributeResponseMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    TransportProtos.GetAttributeResponseMsg responseMsg = actualParseFromResult.getResponseMsg();
    Descriptors.Descriptor descriptorForType4 = responseMsg.getDescriptorForType();
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
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    assertSame(descriptorForType4.getFile(), dependencies.get(0));
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
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
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType4, getResult6.getMessageType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, responseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(responseMsg, actualParseFromResult.getResponseMsgOrBuilder());
    assertSame(responseMsg, responseMsg.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayAttributeResponseMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayAttributeResponseMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testGatewayAttributeResponseMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributeResponseMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testGatewayAttributeResponseMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayAttributeResponseMsg
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testGatewayAttributeResponseMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributeResponseMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributeResponseMsg
   * {@link GatewayAttributeResponseMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testGatewayAttributeResponseMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransportApiProtos.GatewayAttributeResponseMsg actualParseFromResult = TransportApiProtos.GatewayAttributeResponseMsg
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    TransportProtos.GetAttributeResponseMsg responseMsg = actualParseFromResult.getResponseMsg();
    Descriptors.Descriptor descriptorForType4 = responseMsg.getDescriptorForType();
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
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    assertSame(descriptorForType4.getFile(), dependencies.get(0));
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
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
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType4, getResult6.getMessageType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, responseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(responseMsg, actualParseFromResult.getResponseMsgOrBuilder());
    assertSame(responseMsg, responseMsg.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#equals(Object)}, and
   * {@link GatewayAttributeUpdateNotificationMsg#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#equals(Object)}
   *   <li>
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg equals(Object), and hashCode(); then return equal")
  void testGatewayAttributeUpdateNotificationMsgEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg defaultInstance = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#equals(Object)}, and
   * {@link GatewayAttributeUpdateNotificationMsg#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#equals(Object)}
   *   <li>
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg equals(Object), and hashCode(); then return equal")
  void testGatewayAttributeUpdateNotificationMsgEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg defaultInstance = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .getDefaultInstance();
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg defaultInstance2 = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg equals(Object); then return not equal")
  void testGatewayAttributeUpdateNotificationMsgEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributeUpdateNotificationMsg.getDefaultInstance(), null);
    assertNotEquals(TransportApiProtos.GatewayAttributeUpdateNotificationMsg.getDefaultInstance(),
        "Different type to GatewayAttributeUpdateNotificationMsg");
    assertNotEquals(TransportApiProtos.GatewayAttributeUpdateNotificationMsg.getDefaultInstance(), 1);
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg getDefaultInstanceForType()")
  void testGatewayAttributeUpdateNotificationMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg defaultInstance = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#getDeviceName()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg getDeviceName()")
  void testGatewayAttributeUpdateNotificationMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.GatewayAttributeUpdateNotificationMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg getDeviceNameBytes()")
  void testGatewayAttributeUpdateNotificationMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg defaultInstance = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
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
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg getSerializedSize()")
  void testGatewayAttributeUpdateNotificationMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayAttributeUpdateNotificationMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#hasNotificationMsg()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#hasNotificationMsg()}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg hasNotificationMsg()")
  void testGatewayAttributeUpdateNotificationMsgHasNotificationMsg() {
    // Arrange, Act and Assert
    assertFalse(TransportApiProtos.GatewayAttributeUpdateNotificationMsg.getDefaultInstance().hasNotificationMsg());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#isInitialized()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg isInitialized()")
  void testGatewayAttributeUpdateNotificationMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.GatewayAttributeUpdateNotificationMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg newInstance(UnusedPrivateParameter)")
  void testGatewayAttributeUpdateNotificationMsgNewInstance() {
    // Arrange
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg defaultInstance = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.GatewayAttributeUpdateNotificationMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg actualParseDelimitedFromResult = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .parseDelimitedFrom(input);

    // Assert
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg defaultInstanceForType = actualParseDelimitedFromResult
        .getDefaultInstanceForType();
    UnknownFieldSet unknownFields = defaultInstanceForType.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.AttributeUpdateNotificationMsg notificationMsg = actualParseDelimitedFromResult
        .getNotificationMsg();
    Descriptors.Descriptor descriptorForType2 = notificationMsg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(2, fields2.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType3, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType2.toProto();
    assertSame(defaultInstanceForType3, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType2.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType4 = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(descriptorForType2.getFile(), dependencies.get(0));
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
    assertSame(options3, defaultInstanceForType2.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType2, fields.get(0).getContainingType());
    assertSame(descriptorForType2, getResult6.getMessageType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, notificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(notificationMsg, defaultInstanceForType.getNotificationMsg());
    assertSame(notificationMsg, defaultInstanceForType.getNotificationMsgOrBuilder());
    assertSame(notificationMsg, actualParseDelimitedFromResult.getNotificationMsgOrBuilder());
    assertSame(notificationMsg, notificationMsg.getDefaultInstanceForType());
    ProtocolStringList sharedDeletedList = notificationMsg.getSharedDeletedList();
    assertSame(sharedDeletedList, defaultInstanceForType2.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult4.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult3.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult5.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult.getReservedNameList());
    assertSame(sharedDeletedList, defaultInstanceForType4.getDependencyList());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg actualParseDelimitedFromResult = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .parseDelimitedFrom(input);

    // Assert
    TransportProtos.AttributeUpdateNotificationMsg notificationMsg = actualParseDelimitedFromResult
        .getNotificationMsg();
    Descriptors.Descriptor descriptorForType = notificationMsg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertEquals("transport.AttributeUpdateNotificationMsg.sharedUpdated", getResult.getFullName());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(2, fields2.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType.toProto();
    assertSame(defaultInstanceForType2, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.FileDescriptor file2 = descriptorForType.getFile();
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
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
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getMessageType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, notificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(notificationMsg, actualParseDelimitedFromResult.getNotificationMsgOrBuilder());
    assertSame(notificationMsg, notificationMsg.getDefaultInstanceForType());
    ProtocolStringList sharedDeletedList = notificationMsg.getSharedDeletedList();
    assertSame(sharedDeletedList, defaultInstanceForType.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult4.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult3.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult5.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult.getReservedNameList());
    assertSame(sharedDeletedList, defaultInstanceForType3.getDependencyList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInput4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInput5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInput6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg actualParseDelimitedFromResult = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg defaultInstanceForType = actualParseDelimitedFromResult
        .getDefaultInstanceForType();
    UnknownFieldSet unknownFields = defaultInstanceForType.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.AttributeUpdateNotificationMsg notificationMsg = actualParseDelimitedFromResult
        .getNotificationMsg();
    Descriptors.Descriptor descriptorForType2 = notificationMsg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(2, fields2.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType3, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType2.toProto();
    assertSame(defaultInstanceForType3, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType2.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType4 = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(descriptorForType2.getFile(), dependencies.get(0));
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
    assertSame(options3, defaultInstanceForType2.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType2, fields.get(0).getContainingType());
    assertSame(descriptorForType2, getResult6.getMessageType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, notificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(notificationMsg, defaultInstanceForType.getNotificationMsg());
    assertSame(notificationMsg, defaultInstanceForType.getNotificationMsgOrBuilder());
    assertSame(notificationMsg, actualParseDelimitedFromResult.getNotificationMsgOrBuilder());
    assertSame(notificationMsg, notificationMsg.getDefaultInstanceForType());
    ProtocolStringList sharedDeletedList = notificationMsg.getSharedDeletedList();
    assertSame(sharedDeletedList, defaultInstanceForType2.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult4.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult3.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult5.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult.getReservedNameList());
    assertSame(sharedDeletedList, defaultInstanceForType4.getDependencyList());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg actualParseDelimitedFromResult = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    TransportProtos.AttributeUpdateNotificationMsg notificationMsg = actualParseDelimitedFromResult
        .getNotificationMsg();
    Descriptors.Descriptor descriptorForType = notificationMsg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertEquals("transport.AttributeUpdateNotificationMsg.sharedUpdated", getResult.getFullName());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(2, fields2.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType.toProto();
    assertSame(defaultInstanceForType2, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.FileDescriptor file2 = descriptorForType.getFile();
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
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
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getMessageType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, notificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(notificationMsg, actualParseDelimitedFromResult.getNotificationMsgOrBuilder());
    assertSame(notificationMsg, notificationMsg.getDefaultInstanceForType());
    ProtocolStringList sharedDeletedList = notificationMsg.getSharedDeletedList();
    assertSame(sharedDeletedList, defaultInstanceForType.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult4.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult3.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult5.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult.getReservedNameList());
    assertSame(sharedDeletedList, defaultInstanceForType3.getDependencyList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInputExtensionRegistry6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayAttributeUpdateNotificationMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg actualParseFromResult = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.AttributeUpdateNotificationMsg notificationMsg = actualParseFromResult.getNotificationMsg();
    Descriptors.Descriptor descriptorForType2 = notificationMsg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(2, fields2.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType2.toProto();
    assertSame(defaultInstanceForType2, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
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
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult7.getMessageType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, notificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(notificationMsg, actualParseFromResult.getNotificationMsgOrBuilder());
    assertSame(notificationMsg, notificationMsg.getDefaultInstanceForType());
    ProtocolStringList sharedDeletedList = notificationMsg.getSharedDeletedList();
    assertSame(sharedDeletedList, defaultInstanceForType.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult4.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult3.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult5.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult.getReservedNameList());
    assertSame(sharedDeletedList, defaultInstanceForType3.getDependencyList());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayAttributeUpdateNotificationMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayAttributeUpdateNotificationMsgParseFromWithInputStream3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testGatewayAttributeUpdateNotificationMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testGatewayAttributeUpdateNotificationMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg
   * {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testGatewayAttributeUpdateNotificationMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg actualParseFromResult = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.AttributeUpdateNotificationMsg notificationMsg = actualParseFromResult.getNotificationMsg();
    Descriptors.Descriptor descriptorForType2 = notificationMsg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(2, fields2.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType2.toProto();
    assertSame(defaultInstanceForType2, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
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
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult7.getMessageType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, notificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(notificationMsg, actualParseFromResult.getNotificationMsgOrBuilder());
    assertSame(notificationMsg, notificationMsg.getDefaultInstanceForType());
    ProtocolStringList sharedDeletedList = notificationMsg.getSharedDeletedList();
    assertSame(sharedDeletedList, defaultInstanceForType.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult4.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult3.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult5.getReservedNameList());
    assertSame(sharedDeletedList, toProtoResult.getReservedNameList());
    assertSame(sharedDeletedList, defaultInstanceForType3.getDependencyList());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#equals(Object)}, and
   * {@link GatewayAttributesMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayAttributesMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayAttributesMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg equals(Object), and hashCode(); when other is equal; then return equal")
  void testGatewayAttributesMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayAttributesMsg defaultInstance = TransportApiProtos.GatewayAttributesMsg
        .getDefaultInstance();
    TransportApiProtos.GatewayAttributesMsg defaultInstance2 = TransportApiProtos.GatewayAttributesMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#equals(Object)}, and
   * {@link GatewayAttributesMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayAttributesMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayAttributesMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg equals(Object), and hashCode(); when other is same; then return equal")
  void testGatewayAttributesMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayAttributesMsg defaultInstance = TransportApiProtos.GatewayAttributesMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg equals(Object); when other is different; then return not equal")
  void testGatewayAttributesMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributesMsg.getDefaultInstance(), 1);
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg equals(Object); when other is 'null'; then return not equal")
  void testGatewayAttributesMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributesMsg.getDefaultInstance(), null);
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg equals(Object); when other is wrong type; then return not equal")
  void testGatewayAttributesMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributesMsg.getDefaultInstance(),
        "Different type to GatewayAttributesMsg");
  }

  /**
   * Test GatewayAttributesMsg
   * {@link GatewayAttributesMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg getDefaultInstanceForType()")
  void testGatewayAttributesMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.GatewayAttributesMsg defaultInstance = TransportApiProtos.GatewayAttributesMsg
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#getMsgCount()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#getMsgCount()}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg getMsgCount()")
  void testGatewayAttributesMsgGetMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayAttributesMsg.getDefaultInstance().getMsgCount());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg getSerializedSize()")
  void testGatewayAttributesMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayAttributesMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#isInitialized()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg isInitialized()")
  void testGatewayAttributesMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.GatewayAttributesMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test GatewayAttributesMsg
   * {@link GatewayAttributesMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg newInstance(UnusedPrivateParameter)")
  void testGatewayAttributesMsgNewInstance() {
    // Arrange
    TransportApiProtos.GatewayAttributesMsg defaultInstance = TransportApiProtos.GatewayAttributesMsg
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.GatewayAttributesMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test GatewayAttributesMsg
   * {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayAttributesMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayAttributesMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesMsg
   * {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributesMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        TransportApiProtos.GatewayAttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayAttributesMsg
   * {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributesMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributesMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesMsg
   * {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributesMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayAttributesMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesMsg
   * {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testGatewayAttributesMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayAttributesMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayAttributesMsg
   * {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testGatewayAttributesMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributesMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseFrom(InputStream)}
   * with {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayAttributesMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransportApiProtos.GatewayAttributesMsg actualParseFromResult = TransportApiProtos.GatewayAttributesMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult6.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
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
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseFrom(InputStream)}
   * with {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayAttributesMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayAttributesMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributesMsg
   * {@link GatewayAttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testGatewayAttributesMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.GatewayAttributesMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributesMsg
   * {@link GatewayAttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testGatewayAttributesMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayAttributesMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseFrom(InputStream)}
   * with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testGatewayAttributesMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributesMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseFrom(InputStream)}
   * with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testGatewayAttributesMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransportApiProtos.GatewayAttributesMsg actualParseFromResult = TransportApiProtos.GatewayAttributesMsg
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult6.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
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
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#equals(Object)}, and
   * {@link GatewayAttributesRequestMsg#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayAttributesRequestMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayAttributesRequestMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg equals(Object), and hashCode(); then return equal")
  void testGatewayAttributesRequestMsgEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayAttributesRequestMsg defaultInstance = TransportApiProtos.GatewayAttributesRequestMsg
        .getDefaultInstance();
    TransportApiProtos.GatewayAttributesRequestMsg defaultInstance2 = TransportApiProtos.GatewayAttributesRequestMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#equals(Object)}, and
   * {@link GatewayAttributesRequestMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayAttributesRequestMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayAttributesRequestMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg equals(Object), and hashCode(); when other is same; then return equal")
  void testGatewayAttributesRequestMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayAttributesRequestMsg defaultInstance = TransportApiProtos.GatewayAttributesRequestMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg equals(Object); when other is different; then return not equal")
  void testGatewayAttributesRequestMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributesRequestMsg.getDefaultInstance(), 1);
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg equals(Object); when other is 'null'; then return not equal")
  void testGatewayAttributesRequestMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributesRequestMsg.getDefaultInstance(), null);
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg equals(Object); when other is wrong type; then return not equal")
  void testGatewayAttributesRequestMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributesRequestMsg.getDefaultInstance(),
        "Different type to GatewayAttributesRequestMsg");
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg getDefaultInstanceForType()")
  void testGatewayAttributesRequestMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.GatewayAttributesRequestMsg defaultInstance = TransportApiProtos.GatewayAttributesRequestMsg
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#getDeviceName()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg getDeviceName()")
  void testGatewayAttributesRequestMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.GatewayAttributesRequestMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg getDeviceNameBytes()")
  void testGatewayAttributesRequestMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.GatewayAttributesRequestMsg defaultInstance = TransportApiProtos.GatewayAttributesRequestMsg
        .getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
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
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
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
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#getKeysCount()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#getKeysCount()}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg getKeysCount()")
  void testGatewayAttributesRequestMsgGetKeysCount() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayAttributesRequestMsg.getDefaultInstance().getKeysCount());
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#getKeysList()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#getKeysList()}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg getKeysList()")
  void testGatewayAttributesRequestMsgGetKeysList() {
    // Arrange
    TransportApiProtos.GatewayAttributesRequestMsg defaultInstance = TransportApiProtos.GatewayAttributesRequestMsg
        .getDefaultInstance();

    // Act
    ProtocolStringList actualKeysList = defaultInstance.getKeysList();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertTrue(actualKeysList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualKeysList).EMPTY;
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(lazyStringList, defaultInstanceForType.findInitializationErrors());
    assertEquals(lazyStringList, toProtoResult.getSourceCodeInfo().findInitializationErrors());
    DescriptorProtos.FileOptions options = file.getOptions();
    assertEquals(lazyStringList, options.getDefaultInstanceForType().findInitializationErrors());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertEquals(lazyStringList, toProtoResult2.findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    assertEquals(lazyStringList, toProtoResult3.getDescriptorForType().toProto().findInitializationErrors());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals(lazyStringList, options3.findInitializationErrors());
    assertEquals(lazyStringList, getResult.toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(1).toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(2).toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(3).toProto().findInitializationErrors());
    assertEquals(lazyStringList, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType3.getEnumTypes());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertEquals(lazyStringList, getResult2.getEnumTypes());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertEquals(lazyStringList, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertEquals(lazyStringList, getResult4.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = options2.getFeatures().getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType4.getExtensions());
    Descriptors.Descriptor descriptorForType5 = options.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType5.getExtensions());
    assertEquals(lazyStringList, descriptorForType3.getExtensions());
    assertEquals(lazyStringList, getResult2.getExtensions());
    assertEquals(lazyStringList, getResult3.getExtensions());
    assertEquals(lazyStringList, getResult4.getExtensions());
    assertEquals(lazyStringList, descriptorForType4.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType5.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType3.getNestedTypes());
    assertEquals(lazyStringList, getResult2.getNestedTypes());
    assertEquals(lazyStringList, getResult3.getNestedTypes());
    assertEquals(lazyStringList, getResult4.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType4.getOneofs());
    assertEquals(lazyStringList, descriptorForType5.getOneofs());
    assertEquals(lazyStringList, descriptorForType3.getOneofs());
    assertEquals(lazyStringList, getResult2.getOneofs());
    assertEquals(lazyStringList, getResult3.getOneofs());
    assertEquals(lazyStringList, getResult4.getOneofs());
    assertEquals(lazyStringList, descriptorForType4.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType5.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType3.getRealOneofs());
    assertEquals(lazyStringList, getResult2.getRealOneofs());
    assertEquals(lazyStringList, getResult3.getRealOneofs());
    assertEquals(lazyStringList, getResult4.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals(lazyStringList, file2.getDependencies());
    Descriptors.FileDescriptor getResult5 = dependencies.get(0);
    assertEquals(lazyStringList, getResult5.getDependencies());
    assertEquals(lazyStringList, file2.getExtensions());
    assertEquals(lazyStringList, getResult5.getExtensions());
    assertEquals(lazyStringList, file2.getPublicDependencies());
    assertEquals(lazyStringList, getResult5.getPublicDependencies());
    assertEquals(lazyStringList, file2.getServices());
    assertEquals(lazyStringList, getResult5.getServices());
    assertSame(lazyStringList, toProtoResult3.getDefaultInstanceForType().getReservedNameList());
    assertSame(lazyStringList, toProtoResult2.getReservedNameList());
    assertSame(lazyStringList, toProtoResult3.getReservedNameList());
    assertSame(lazyStringList, defaultInstanceForType.getDependencyList());
    assertSame(lazyStringList, actualKeysList);
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg getSerializedSize()")
  void testGatewayAttributesRequestMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayAttributesRequestMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#isInitialized()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg isInitialized()")
  void testGatewayAttributesRequestMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.GatewayAttributesRequestMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg newInstance(UnusedPrivateParameter)")
  void testGatewayAttributesRequestMsgNewInstance() {
    // Arrange
    TransportApiProtos.GatewayAttributesRequestMsg defaultInstance = TransportApiProtos.GatewayAttributesRequestMsg
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.GatewayAttributesRequestMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayAttributesRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.GatewayAttributesRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayAttributesRequestMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributesRequestMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayAttributesRequestMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.GatewayAttributesRequestMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayAttributesRequestMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributesRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayAttributesRequestMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransportApiProtos.GatewayAttributesRequestMsg actualParseFromResult = TransportApiProtos.GatewayAttributesRequestMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(2);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(3);
    assertSame(file, getResult7.getFile());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.MessageOptions options3 = descriptorForType2.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, options.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult4.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult4.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult5.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList keysList = actualParseFromResult.getKeysList();
    assertSame(keysList, defaultInstanceForType.getReservedNameList());
    assertSame(keysList, toProtoResult3.getReservedNameList());
    assertSame(keysList, toProtoResult.getReservedNameList());
    assertSame(keysList, defaultInstanceForType2.getDependencyList());
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayAttributesRequestMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayAttributesRequestMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testGatewayAttributesRequestMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributesRequestMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testGatewayAttributesRequestMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayAttributesRequestMsg
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testGatewayAttributesRequestMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributesRequestMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributesRequestMsg
   * {@link GatewayAttributesRequestMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testGatewayAttributesRequestMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransportApiProtos.GatewayAttributesRequestMsg actualParseFromResult = TransportApiProtos.GatewayAttributesRequestMsg
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(2);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(3);
    assertSame(file, getResult7.getFile());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.MessageOptions options3 = descriptorForType2.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, options.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult4.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult4.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult5.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList keysList = actualParseFromResult.getKeysList();
    assertSame(keysList, defaultInstanceForType.getReservedNameList());
    assertSame(keysList, toProtoResult3.getReservedNameList());
    assertSame(keysList, toProtoResult.getReservedNameList());
    assertSame(keysList, defaultInstanceForType2.getDependencyList());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#equals(Object)}, and
   * {@link GatewayClaimMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayClaimMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayClaimMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayClaimMsg equals(Object), and hashCode(); when other is equal; then return equal")
  void testGatewayClaimMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayClaimMsg defaultInstance = TransportApiProtos.GatewayClaimMsg.getDefaultInstance();
    TransportApiProtos.GatewayClaimMsg defaultInstance2 = TransportApiProtos.GatewayClaimMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#equals(Object)}, and
   * {@link GatewayClaimMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayClaimMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayClaimMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayClaimMsg equals(Object), and hashCode(); when other is same; then return equal")
  void testGatewayClaimMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayClaimMsg defaultInstance = TransportApiProtos.GatewayClaimMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.GatewayClaimMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg equals(Object); when other is different; then return not equal")
  void testGatewayClaimMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayClaimMsg.getDefaultInstance(), 1);
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.GatewayClaimMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg equals(Object); when other is 'null'; then return not equal")
  void testGatewayClaimMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayClaimMsg.getDefaultInstance(), null);
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.GatewayClaimMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg equals(Object); when other is wrong type; then return not equal")
  void testGatewayClaimMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayClaimMsg.getDefaultInstance(), "Different type to GatewayClaimMsg");
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg getDefaultInstanceForType()")
  void testGatewayClaimMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.GatewayClaimMsg defaultInstance = TransportApiProtos.GatewayClaimMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#getMsgCount()}.
   * <p>
   * Method under test: {@link TransportApiProtos.GatewayClaimMsg#getMsgCount()}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg getMsgCount()")
  void testGatewayClaimMsgGetMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayClaimMsg.getDefaultInstance().getMsgCount());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg getSerializedSize()")
  void testGatewayClaimMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayClaimMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#isInitialized()}.
   * <p>
   * Method under test: {@link TransportApiProtos.GatewayClaimMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg isInitialized()")
  void testGatewayClaimMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.GatewayClaimMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test GatewayClaimMsg
   * {@link GatewayClaimMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg newInstance(UnusedPrivateParameter)")
  void testGatewayClaimMsgNewInstance() {
    // Arrange
    TransportApiProtos.GatewayClaimMsg defaultInstance = TransportApiProtos.GatewayClaimMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.GatewayClaimMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayClaimMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayClaimMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayClaimMsg
   * {@link GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayClaimMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.GatewayClaimMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayClaimMsg
   * {@link GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayClaimMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayClaimMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayClaimMsg
   * {@link GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testGatewayClaimMsgParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayClaimMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testGatewayClaimMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayClaimMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testGatewayClaimMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayClaimMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayClaimMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransportApiProtos.GatewayClaimMsg actualParseFromResult = TransportApiProtos.GatewayClaimMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult6.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
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
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayClaimMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayClaimMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayClaimMsg
   * {@link GatewayClaimMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testGatewayClaimMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.GatewayClaimMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayClaimMsg
   * {@link GatewayClaimMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testGatewayClaimMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayClaimMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testGatewayClaimMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayClaimMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testGatewayClaimMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransportApiProtos.GatewayClaimMsg actualParseFromResult = TransportApiProtos.GatewayClaimMsg
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult6.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
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
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#equals(Object)}, and
   * {@link GatewayDeviceRpcRequestMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayDeviceRpcRequestMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayDeviceRpcRequestMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg equals(Object), and hashCode(); when other is equal; then return equal")
  void testGatewayDeviceRpcRequestMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayDeviceRpcRequestMsg defaultInstance = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .getDefaultInstance();
    TransportApiProtos.GatewayDeviceRpcRequestMsg defaultInstance2 = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#equals(Object)}, and
   * {@link GatewayDeviceRpcRequestMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayDeviceRpcRequestMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayDeviceRpcRequestMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg equals(Object), and hashCode(); when other is same; then return equal")
  void testGatewayDeviceRpcRequestMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayDeviceRpcRequestMsg defaultInstance = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg equals(Object); when other is different; then return not equal")
  void testGatewayDeviceRpcRequestMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayDeviceRpcRequestMsg.getDefaultInstance(), 1);
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg equals(Object); when other is 'null'; then return not equal")
  void testGatewayDeviceRpcRequestMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayDeviceRpcRequestMsg.getDefaultInstance(), null);
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg equals(Object); when other is wrong type; then return not equal")
  void testGatewayDeviceRpcRequestMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayDeviceRpcRequestMsg.getDefaultInstance(),
        "Different type to GatewayDeviceRpcRequestMsg");
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg getDefaultInstanceForType()")
  void testGatewayDeviceRpcRequestMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.GatewayDeviceRpcRequestMsg defaultInstance = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#getDeviceName()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg getDeviceName()")
  void testGatewayDeviceRpcRequestMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.GatewayDeviceRpcRequestMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg getDeviceNameBytes()")
  void testGatewayDeviceRpcRequestMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.GatewayDeviceRpcRequestMsg defaultInstance = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
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
    assertEquals(byteString, actualDeviceNameBytes);
    TransportProtos.ToDeviceRpcRequestMsg rpcRequestMsg = defaultInstance.getRpcRequestMsg();
    assertEquals(byteString, rpcRequestMsg.getMethodNameBytes());
    assertEquals(byteString, rpcRequestMsg.getParamsBytes());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg getSerializedSize()")
  void testGatewayDeviceRpcRequestMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayDeviceRpcRequestMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#hasRpcRequestMsg()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#hasRpcRequestMsg()}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg hasRpcRequestMsg()")
  void testGatewayDeviceRpcRequestMsgHasRpcRequestMsg() {
    // Arrange, Act and Assert
    assertFalse(TransportApiProtos.GatewayDeviceRpcRequestMsg.getDefaultInstance().hasRpcRequestMsg());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#isInitialized()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg isInitialized()")
  void testGatewayDeviceRpcRequestMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.GatewayDeviceRpcRequestMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg newInstance(UnusedPrivateParameter)")
  void testGatewayDeviceRpcRequestMsgNewInstance() {
    // Arrange
    TransportApiProtos.GatewayDeviceRpcRequestMsg defaultInstance = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.GatewayDeviceRpcRequestMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.GatewayDeviceRpcRequestMsg actualParseDelimitedFromResult = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .parseDelimitedFrom(input);

    // Assert
    TransportApiProtos.GatewayDeviceRpcRequestMsg defaultInstanceForType = actualParseDelimitedFromResult
        .getDefaultInstanceForType();
    UnknownFieldSet unknownFields = defaultInstanceForType.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    TransportProtos.ToDeviceRpcRequestMsg rpcRequestMsg = actualParseDelimitedFromResult.getRpcRequestMsg();
    Descriptors.Descriptor descriptorForType2 = rpcRequestMsg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(8, fields2.size());
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType3, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType2.toProto();
    assertSame(defaultInstanceForType3, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType2.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType2.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType4 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType4.getDependencyList());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
    assertSame(options3, defaultInstanceForType2.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getMessageType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER));
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, rpcRequestMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(rpcRequestMsg, defaultInstanceForType.getRpcRequestMsg());
    assertSame(rpcRequestMsg, defaultInstanceForType.getRpcRequestMsgOrBuilder());
    assertSame(rpcRequestMsg, actualParseDelimitedFromResult.getRpcRequestMsgOrBuilder());
    assertSame(rpcRequestMsg, rpcRequestMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.GatewayDeviceRpcRequestMsg actualParseDelimitedFromResult = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .parseDelimitedFrom(input);

    // Assert
    TransportProtos.ToDeviceRpcRequestMsg rpcRequestMsg = actualParseDelimitedFromResult.getRpcRequestMsg();
    Descriptors.Descriptor descriptorForType = rpcRequestMsg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertEquals("requestId", getResult.getJsonName());
    assertEquals("transport.ToDeviceRpcRequestMsg.requestId", getResult.getFullName());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(2, fields2.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult.getJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult.getLiteJavaType());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType.toProto();
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
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.FileDescriptor file2 = descriptorForType.getFile();
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
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
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getMessageType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER));
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, rpcRequestMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(rpcRequestMsg, actualParseDelimitedFromResult.getRpcRequestMsgOrBuilder());
    assertSame(rpcRequestMsg, rpcRequestMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInput4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.GatewayDeviceRpcRequestMsg actualParseDelimitedFromResult = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    TransportApiProtos.GatewayDeviceRpcRequestMsg defaultInstanceForType = actualParseDelimitedFromResult
        .getDefaultInstanceForType();
    UnknownFieldSet unknownFields = defaultInstanceForType.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    TransportProtos.ToDeviceRpcRequestMsg rpcRequestMsg = actualParseDelimitedFromResult.getRpcRequestMsg();
    Descriptors.Descriptor descriptorForType2 = rpcRequestMsg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(8, fields2.size());
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType3, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType2.toProto();
    assertSame(defaultInstanceForType3, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType2.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType2.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType4 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType4.getDependencyList());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
    assertSame(options3, defaultInstanceForType2.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getMessageType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER));
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, rpcRequestMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(rpcRequestMsg, defaultInstanceForType.getRpcRequestMsg());
    assertSame(rpcRequestMsg, defaultInstanceForType.getRpcRequestMsgOrBuilder());
    assertSame(rpcRequestMsg, actualParseDelimitedFromResult.getRpcRequestMsgOrBuilder());
    assertSame(rpcRequestMsg, rpcRequestMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.GatewayDeviceRpcRequestMsg actualParseDelimitedFromResult = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    TransportProtos.ToDeviceRpcRequestMsg rpcRequestMsg = actualParseDelimitedFromResult.getRpcRequestMsg();
    Descriptors.Descriptor descriptorForType = rpcRequestMsg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertEquals("requestId", getResult.getJsonName());
    assertEquals("transport.ToDeviceRpcRequestMsg.requestId", getResult.getFullName());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(2, fields2.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult.getJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult.getLiteJavaType());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType.toProto();
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
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.FileDescriptor file2 = descriptorForType.getFile();
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
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
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getMessageType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER));
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, rpcRequestMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(rpcRequestMsg, actualParseDelimitedFromResult.getRpcRequestMsgOrBuilder());
    assertSame(rpcRequestMsg, rpcRequestMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayDeviceRpcRequestMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInputExtensionRegistry6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.GatewayDeviceRpcRequestMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayDeviceRpcRequestMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransportApiProtos.GatewayDeviceRpcRequestMsg actualParseFromResult = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    TransportProtos.ToDeviceRpcRequestMsg rpcRequestMsg = actualParseFromResult.getRpcRequestMsg();
    Descriptors.Descriptor descriptorForType2 = rpcRequestMsg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(8, fields2.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType2.toProto();
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
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
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
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getMessageType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, messageTypes.get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, rpcRequestMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(rpcRequestMsg, actualParseFromResult.getRpcRequestMsgOrBuilder());
    assertSame(rpcRequestMsg, rpcRequestMsg.getDefaultInstanceForType());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayDeviceRpcRequestMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayDeviceRpcRequestMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testGatewayDeviceRpcRequestMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.GatewayDeviceRpcRequestMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testGatewayDeviceRpcRequestMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayDeviceRpcRequestMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testGatewayDeviceRpcRequestMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayDeviceRpcRequestMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayDeviceRpcRequestMsg
   * {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testGatewayDeviceRpcRequestMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransportApiProtos.GatewayDeviceRpcRequestMsg actualParseFromResult = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    TransportProtos.ToDeviceRpcRequestMsg rpcRequestMsg = actualParseFromResult.getRpcRequestMsg();
    Descriptors.Descriptor descriptorForType2 = rpcRequestMsg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(8, fields2.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType2.toProto();
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
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
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
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getMessageType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, messageTypes.get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, rpcRequestMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(rpcRequestMsg, actualParseFromResult.getRpcRequestMsgOrBuilder());
    assertSame(rpcRequestMsg, rpcRequestMsg.getDefaultInstanceForType());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#equals(Object)}, and
   * {@link GatewayRpcResponseMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayRpcResponseMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayRpcResponseMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg equals(Object), and hashCode(); when other is equal; then return equal")
  void testGatewayRpcResponseMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayRpcResponseMsg defaultInstance = TransportApiProtos.GatewayRpcResponseMsg
        .getDefaultInstance();
    TransportApiProtos.GatewayRpcResponseMsg defaultInstance2 = TransportApiProtos.GatewayRpcResponseMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#equals(Object)}, and
   * {@link GatewayRpcResponseMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayRpcResponseMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayRpcResponseMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg equals(Object), and hashCode(); when other is same; then return equal")
  void testGatewayRpcResponseMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayRpcResponseMsg defaultInstance = TransportApiProtos.GatewayRpcResponseMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg equals(Object); when other is different; then return not equal")
  void testGatewayRpcResponseMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayRpcResponseMsg.getDefaultInstance(), 1);
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg equals(Object); when other is 'null'; then return not equal")
  void testGatewayRpcResponseMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayRpcResponseMsg.getDefaultInstance(), null);
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg equals(Object); when other is wrong type; then return not equal")
  void testGatewayRpcResponseMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayRpcResponseMsg.getDefaultInstance(),
        "Different type to GatewayRpcResponseMsg");
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#getData()}.
   * <p>
   * Method under test: {@link TransportApiProtos.GatewayRpcResponseMsg#getData()}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg getData()")
  void testGatewayRpcResponseMsgGetData() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.GatewayRpcResponseMsg.getDefaultInstance().getData());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#getDataBytes()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#getDataBytes()}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg getDataBytes()")
  void testGatewayRpcResponseMsgGetDataBytes() {
    // Arrange
    TransportApiProtos.GatewayRpcResponseMsg defaultInstance = TransportApiProtos.GatewayRpcResponseMsg
        .getDefaultInstance();

    // Act
    ByteString actualDataBytes = defaultInstance.getDataBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    ByteString byteString = actualDataBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(2).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
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
    assertEquals(byteString, actualDataBytes);
    assertEquals(byteString, defaultInstance.getDeviceNameBytes());
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg getDefaultInstanceForType()")
  void testGatewayRpcResponseMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.GatewayRpcResponseMsg defaultInstance = TransportApiProtos.GatewayRpcResponseMsg
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#getDeviceName()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg getDeviceName()")
  void testGatewayRpcResponseMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.GatewayRpcResponseMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg getDeviceNameBytes()")
  void testGatewayRpcResponseMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.GatewayRpcResponseMsg defaultInstance = TransportApiProtos.GatewayRpcResponseMsg
        .getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(2).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
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
    assertEquals(byteString, defaultInstance.getDataBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg getSerializedSize()")
  void testGatewayRpcResponseMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayRpcResponseMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#isInitialized()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg isInitialized()")
  void testGatewayRpcResponseMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.GatewayRpcResponseMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg newInstance(UnusedPrivateParameter)")
  void testGatewayRpcResponseMsgNewInstance() {
    // Arrange
    TransportApiProtos.GatewayRpcResponseMsg defaultInstance = TransportApiProtos.GatewayRpcResponseMsg
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.GatewayRpcResponseMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayRpcResponseMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayRpcResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayRpcResponseMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.GatewayRpcResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayRpcResponseMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        TransportApiProtos.GatewayRpcResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayRpcResponseMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayRpcResponseMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayRpcResponseMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayRpcResponseMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayRpcResponseMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.GatewayRpcResponseMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testGatewayRpcResponseMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayRpcResponseMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testGatewayRpcResponseMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayRpcResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayRpcResponseMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransportApiProtos.GatewayRpcResponseMsg actualParseFromResult = TransportApiProtos.GatewayRpcResponseMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(2);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    assertSame(options4, options4.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult5.toProto();
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult6.toProto().getUnknownFields());
    assertSame(unknownFields, getResult7.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayRpcResponseMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayRpcResponseMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testGatewayRpcResponseMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.GatewayRpcResponseMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testGatewayRpcResponseMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayRpcResponseMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testGatewayRpcResponseMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayRpcResponseMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayRpcResponseMsg
   * {@link GatewayRpcResponseMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testGatewayRpcResponseMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransportApiProtos.GatewayRpcResponseMsg actualParseFromResult = TransportApiProtos.GatewayRpcResponseMsg
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(2);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    assertSame(options4, options4.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult5.toProto();
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult6.toProto().getUnknownFields());
    assertSame(unknownFields, getResult7.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#equals(Object)}, and
   * {@link GatewayTelemetryMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayTelemetryMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayTelemetryMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg equals(Object), and hashCode(); when other is equal; then return equal")
  void testGatewayTelemetryMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayTelemetryMsg defaultInstance = TransportApiProtos.GatewayTelemetryMsg
        .getDefaultInstance();
    TransportApiProtos.GatewayTelemetryMsg defaultInstance2 = TransportApiProtos.GatewayTelemetryMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#equals(Object)}, and
   * {@link GatewayTelemetryMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayTelemetryMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayTelemetryMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg equals(Object), and hashCode(); when other is same; then return equal")
  void testGatewayTelemetryMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayTelemetryMsg defaultInstance = TransportApiProtos.GatewayTelemetryMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg equals(Object); when other is different; then return not equal")
  void testGatewayTelemetryMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayTelemetryMsg.getDefaultInstance(), 1);
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg equals(Object); when other is 'null'; then return not equal")
  void testGatewayTelemetryMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayTelemetryMsg.getDefaultInstance(), null);
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg equals(Object); when other is wrong type; then return not equal")
  void testGatewayTelemetryMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayTelemetryMsg.getDefaultInstance(),
        "Different type to GatewayTelemetryMsg");
  }

  /**
   * Test GatewayTelemetryMsg
   * {@link GatewayTelemetryMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg getDefaultInstanceForType()")
  void testGatewayTelemetryMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.GatewayTelemetryMsg defaultInstance = TransportApiProtos.GatewayTelemetryMsg
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#getMsgCount()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#getMsgCount()}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg getMsgCount()")
  void testGatewayTelemetryMsgGetMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayTelemetryMsg.getDefaultInstance().getMsgCount());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg getSerializedSize()")
  void testGatewayTelemetryMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayTelemetryMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#isInitialized()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg isInitialized()")
  void testGatewayTelemetryMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.GatewayTelemetryMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test GatewayTelemetryMsg
   * {@link GatewayTelemetryMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg newInstance(UnusedPrivateParameter)")
  void testGatewayTelemetryMsgNewInstance() {
    // Arrange
    TransportApiProtos.GatewayTelemetryMsg defaultInstance = TransportApiProtos.GatewayTelemetryMsg
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.GatewayTelemetryMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test GatewayTelemetryMsg
   * {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseDelimitedFrom(InputStream) with 'input'")
  void testGatewayTelemetryMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayTelemetryMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayTelemetryMsg
   * {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayTelemetryMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        TransportApiProtos.GatewayTelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayTelemetryMsg
   * {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayTelemetryMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayTelemetryMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayTelemetryMsg
   * {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testGatewayTelemetryMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayTelemetryMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayTelemetryMsg
   * {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testGatewayTelemetryMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayTelemetryMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayTelemetryMsg
   * {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testGatewayTelemetryMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayTelemetryMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseFrom(InputStream)}
   * with {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayTelemetryMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransportApiProtos.GatewayTelemetryMsg actualParseFromResult = TransportApiProtos.GatewayTelemetryMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult6.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
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
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseFrom(InputStream)}
   * with {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(InputStream) with 'InputStream'")
  void testGatewayTelemetryMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayTelemetryMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayTelemetryMsg
   * {@link GatewayTelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testGatewayTelemetryMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.GatewayTelemetryMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayTelemetryMsg
   * {@link GatewayTelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testGatewayTelemetryMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayTelemetryMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseFrom(InputStream)}
   * with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testGatewayTelemetryMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayTelemetryMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseFrom(InputStream)}
   * with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testGatewayTelemetryMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransportApiProtos.GatewayTelemetryMsg actualParseFromResult = TransportApiProtos.GatewayTelemetryMsg
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult6.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
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
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
   * Test RpcRequest {@link RpcRequest#equals(Object)}, and
   * {@link RpcRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.RpcRequest#equals(Object)}
   *   <li>{@link TransportApiProtos.RpcRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test RpcRequest equals(Object), and hashCode(); when other is equal; then return equal")
  void testRpcRequestEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.RpcRequest defaultInstance = TransportApiProtos.RpcRequest.getDefaultInstance();
    TransportApiProtos.RpcRequest defaultInstance2 = TransportApiProtos.RpcRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test RpcRequest {@link RpcRequest#equals(Object)}, and
   * {@link RpcRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.RpcRequest#equals(Object)}
   *   <li>{@link TransportApiProtos.RpcRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test RpcRequest equals(Object), and hashCode(); when other is same; then return equal")
  void testRpcRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.RpcRequest defaultInstance = TransportApiProtos.RpcRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test RpcRequest {@link RpcRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.RpcRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test RpcRequest equals(Object); when other is different; then return not equal")
  void testRpcRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.RpcRequest.getDefaultInstance(), 1);
  }

  /**
   * Test RpcRequest {@link RpcRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.RpcRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test RpcRequest equals(Object); when other is 'null'; then return not equal")
  void testRpcRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.RpcRequest.getDefaultInstance(), null);
  }

  /**
   * Test RpcRequest {@link RpcRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.RpcRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test RpcRequest equals(Object); when other is wrong type; then return not equal")
  void testRpcRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.RpcRequest.getDefaultInstance(), "Different type to RpcRequest");
  }

  /**
   * Test RpcRequest {@link RpcRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test RpcRequest getDefaultInstanceForType()")
  void testRpcRequestGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.RpcRequest defaultInstance = TransportApiProtos.RpcRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test RpcRequest {@link RpcRequest#getMethod()}.
   * <p>
   * Method under test: {@link TransportApiProtos.RpcRequest#getMethod()}
   */
  @Test
  @DisplayName("Test RpcRequest getMethod()")
  void testRpcRequestGetMethod() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.RpcRequest.getDefaultInstance().getMethod());
  }

  /**
   * Test RpcRequest {@link RpcRequest#getMethodBytes()}.
   * <p>
   * Method under test: {@link TransportApiProtos.RpcRequest#getMethodBytes()}
   */
  @Test
  @DisplayName("Test RpcRequest getMethodBytes()")
  void testRpcRequestGetMethodBytes() {
    // Arrange
    TransportApiProtos.RpcRequest defaultInstance = TransportApiProtos.RpcRequest.getDefaultInstance();

    // Act
    ByteString actualMethodBytes = defaultInstance.getMethodBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualMethodBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
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
    assertEquals(byteString, actualMethodBytes);
    assertEquals(byteString, defaultInstance.getParamsBytes());
  }

  /**
   * Test RpcRequest {@link RpcRequest#getParams()}.
   * <p>
   * Method under test: {@link TransportApiProtos.RpcRequest#getParams()}
   */
  @Test
  @DisplayName("Test RpcRequest getParams()")
  void testRpcRequestGetParams() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.RpcRequest.getDefaultInstance().getParams());
  }

  /**
   * Test RpcRequest {@link RpcRequest#getParamsBytes()}.
   * <p>
   * Method under test: {@link TransportApiProtos.RpcRequest#getParamsBytes()}
   */
  @Test
  @DisplayName("Test RpcRequest getParamsBytes()")
  void testRpcRequestGetParamsBytes() {
    // Arrange
    TransportApiProtos.RpcRequest defaultInstance = TransportApiProtos.RpcRequest.getDefaultInstance();

    // Act
    ByteString actualParamsBytes = defaultInstance.getParamsBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualParamsBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
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
    assertEquals(byteString, defaultInstance.getMethodBytes());
    assertEquals(byteString, actualParamsBytes);
  }

  /**
   * Test RpcRequest {@link RpcRequest#getSerializedSize()}.
   * <p>
   * Method under test: {@link TransportApiProtos.RpcRequest#getSerializedSize()}
   */
  @Test
  @DisplayName("Test RpcRequest getSerializedSize()")
  void testRpcRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.RpcRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test RpcRequest {@link RpcRequest#isInitialized()}.
   * <p>
   * Method under test: {@link TransportApiProtos.RpcRequest#isInitialized()}
   */
  @Test
  @DisplayName("Test RpcRequest isInitialized()")
  void testRpcRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.RpcRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test RpcRequest {@link RpcRequest#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test RpcRequest newInstance(UnusedPrivateParameter)")
  void testRpcRequestNewInstance() {
    // Arrange
    TransportApiProtos.RpcRequest defaultInstance = TransportApiProtos.RpcRequest.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.RpcRequest);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream) with 'input'")
  void testRpcRequestParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.RpcRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RpcRequest
   * {@link RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testRpcRequestParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.RpcRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RpcRequest
   * {@link RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testRpcRequestParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.RpcRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RpcRequest
   * {@link RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testRpcRequestParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.RpcRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test RpcRequest
   * {@link RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  void testRpcRequestParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.RpcRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testRpcRequestParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.RpcRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testRpcRequestParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.RpcRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testRpcRequestParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.RpcRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(InputStream) with 'InputStream'")
  void testRpcRequestParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransportApiProtos.RpcRequest actualParseFromResult = TransportApiProtos.RpcRequest
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult5.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult6.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test RpcRequest
   * {@link RpcRequest#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testRpcRequestParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.RpcRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RpcRequest
   * {@link RpcRequest#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testRpcRequestParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.RpcRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testRpcRequestParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.RpcRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testRpcRequestParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.RpcRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testRpcRequestParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransportApiProtos.RpcRequest actualParseFromResult = TransportApiProtos.RpcRequest.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
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
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult5.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult6.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#equals(Object)}, and
   * {@link TelemetryMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.TelemetryMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.TelemetryMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TelemetryMsg equals(Object), and hashCode(); when other is equal; then return equal")
  void testTelemetryMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.TelemetryMsg defaultInstance = TransportApiProtos.TelemetryMsg.getDefaultInstance();
    TransportApiProtos.TelemetryMsg defaultInstance2 = TransportApiProtos.TelemetryMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#equals(Object)}, and
   * {@link TelemetryMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.TelemetryMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.TelemetryMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TelemetryMsg equals(Object), and hashCode(); when other is same; then return equal")
  void testTelemetryMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.TelemetryMsg defaultInstance = TransportApiProtos.TelemetryMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.TelemetryMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test TelemetryMsg equals(Object); when other is different; then return not equal")
  void testTelemetryMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.TelemetryMsg.getDefaultInstance(), 1);
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.TelemetryMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test TelemetryMsg equals(Object); when other is 'null'; then return not equal")
  void testTelemetryMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.TelemetryMsg.getDefaultInstance(), null);
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportApiProtos.TelemetryMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test TelemetryMsg equals(Object); when other is wrong type; then return not equal")
  void testTelemetryMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.TelemetryMsg.getDefaultInstance(), "Different type to TelemetryMsg");
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test TelemetryMsg getDefaultInstanceForType()")
  void testTelemetryMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.TelemetryMsg defaultInstance = TransportApiProtos.TelemetryMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#getDeviceName()}.
   * <p>
   * Method under test: {@link TransportApiProtos.TelemetryMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test TelemetryMsg getDeviceName()")
  void testTelemetryMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.TelemetryMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test TelemetryMsg getDeviceNameBytes()")
  void testTelemetryMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.TelemetryMsg defaultInstance = TransportApiProtos.TelemetryMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
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
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test TelemetryMsg getSerializedSize()")
  void testTelemetryMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.TelemetryMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#hasMsg()}.
   * <p>
   * Method under test: {@link TransportApiProtos.TelemetryMsg#hasMsg()}
   */
  @Test
  @DisplayName("Test TelemetryMsg hasMsg()")
  void testTelemetryMsgHasMsg() {
    // Arrange, Act and Assert
    assertFalse(TransportApiProtos.TelemetryMsg.getDefaultInstance().hasMsg());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#isInitialized()}.
   * <p>
   * Method under test: {@link TransportApiProtos.TelemetryMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test TelemetryMsg isInitialized()")
  void testTelemetryMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.TelemetryMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test TelemetryMsg newInstance(UnusedPrivateParameter)")
  void testTelemetryMsgNewInstance() {
    // Arrange
    TransportApiProtos.TelemetryMsg defaultInstance = TransportApiProtos.TelemetryMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.TelemetryMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream) with 'input'")
  void testTelemetryMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.TelemetryMsg actualParseDelimitedFromResult = TransportApiProtos.TelemetryMsg
        .parseDelimitedFrom(input);

    // Assert
    TransportApiProtos.TelemetryMsg defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    UnknownFieldSet unknownFields = defaultInstanceForType.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    TransportProtos.PostTelemetryMsg msg = actualParseDelimitedFromResult.getMsg();
    Descriptors.Descriptor descriptorForType = msg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(2, fields2.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType3, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType.toProto();
    assertSame(defaultInstanceForType3, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType2.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType2.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType4 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType4.getDependencyList());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(descriptorForType.getFile(), dependencies.get(0));
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
    assertSame(options3, defaultInstanceForType2.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType, fields.get(0).getContainingType());
    assertSame(descriptorForType, getResult6.getMessageType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, defaultInstanceForType.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(msg, defaultInstanceForType.getMsg());
    assertSame(msg, defaultInstanceForType.getMsgOrBuilder());
    assertSame(msg, actualParseDelimitedFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream) with 'input'")
  void testTelemetryMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.TelemetryMsg actualParseDelimitedFromResult = TransportApiProtos.TelemetryMsg
        .parseDelimitedFrom(input);

    // Assert
    TransportProtos.PostTelemetryMsg msg = actualParseDelimitedFromResult.getMsg();
    Descriptors.Descriptor descriptorForType = msg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertEquals("transport.PostTelemetryMsg.tsKvList", getResult.getFullName());
    assertEquals("tsKvList", getResult.getJsonName());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(2, fields2.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(Descriptors.FieldDescriptor.JavaType.MESSAGE, getResult.getJavaType());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType.toProto();
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
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.FileDescriptor file2 = descriptorForType.getFile();
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
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
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getMessageType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(msg, actualParseDelimitedFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream) with 'input'")
  void testTelemetryMsgParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.TelemetryMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TelemetryMsg
   * {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTelemetryMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.TelemetryMsg actualParseDelimitedFromResult = TransportApiProtos.TelemetryMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    TransportApiProtos.TelemetryMsg defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    UnknownFieldSet unknownFields = defaultInstanceForType.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    TransportProtos.PostTelemetryMsg msg = actualParseDelimitedFromResult.getMsg();
    Descriptors.Descriptor descriptorForType = msg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(2, fields2.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType3, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType.toProto();
    assertSame(defaultInstanceForType3, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType2.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType2.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType4 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType4.getDependencyList());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(descriptorForType.getFile(), dependencies.get(0));
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
    assertSame(options3, defaultInstanceForType2.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType, fields.get(0).getContainingType());
    assertSame(descriptorForType, getResult6.getMessageType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, defaultInstanceForType.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(msg, defaultInstanceForType.getMsg());
    assertSame(msg, defaultInstanceForType.getMsgOrBuilder());
    assertSame(msg, actualParseDelimitedFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TelemetryMsg
   * {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTelemetryMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransportApiProtos.TelemetryMsg actualParseDelimitedFromResult = TransportApiProtos.TelemetryMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    TransportProtos.PostTelemetryMsg msg = actualParseDelimitedFromResult.getMsg();
    Descriptors.Descriptor descriptorForType = msg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertEquals("transport.PostTelemetryMsg.tsKvList", getResult.getFullName());
    assertEquals("tsKvList", getResult.getJsonName());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(2, fields2.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(Descriptors.FieldDescriptor.JavaType.MESSAGE, getResult.getJavaType());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType.toProto();
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
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.FileDescriptor file2 = descriptorForType.getFile();
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
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
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getMessageType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(msg, actualParseDelimitedFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TelemetryMsg
   * {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTelemetryMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.TelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TelemetryMsg
   * {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTelemetryMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.TelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TelemetryMsg
   * {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTelemetryMsgParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.TelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TelemetryMsg
   * {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testTelemetryMsgParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.TelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testTelemetryMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.TelemetryMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testTelemetryMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.TelemetryMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testTelemetryMsgParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.TelemetryMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(InputStream) with 'InputStream'")
  void testTelemetryMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransportApiProtos.TelemetryMsg actualParseFromResult = TransportApiProtos.TelemetryMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    TransportProtos.PostTelemetryMsg msg = actualParseFromResult.getMsg();
    Descriptors.Descriptor descriptorForType = msg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.Descriptor descriptorForType2 = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(2, fields2.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType.toProto();
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
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.FileDescriptor file2 = descriptorForType.getFile();
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
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
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getMessageType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(msg, actualParseFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
  }

  /**
   * Test TelemetryMsg
   * {@link TelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testTelemetryMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.TelemetryMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TelemetryMsg
   * {@link TelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testTelemetryMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.TelemetryMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testTelemetryMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.TelemetryMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testTelemetryMsgParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.TelemetryMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testTelemetryMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransportApiProtos.TelemetryMsg actualParseFromResult = TransportApiProtos.TelemetryMsg
        .parseFrom((InputStream) null);

    // Assert
    TransportProtos.PostTelemetryMsg msg = actualParseFromResult.getMsg();
    Descriptors.Descriptor descriptorForType = msg.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.Descriptor descriptorForType2 = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(2, fields2.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType.toProto();
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
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.FileDescriptor file2 = descriptorForType.getFile();
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file2, getResult.getFile());
    assertSame(file2, dependencies.get(0));
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(TransportProtos.ApiUsageStateProto.SMSEXECSTATE_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
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
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getMessageType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(msg, actualParseFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
  }
}
