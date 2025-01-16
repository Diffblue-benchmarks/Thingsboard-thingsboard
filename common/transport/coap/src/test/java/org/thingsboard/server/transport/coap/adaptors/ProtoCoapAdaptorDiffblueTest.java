package org.thingsboard.server.transport.coap.adaptors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Any;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.Message;
import org.eclipse.californium.core.coap.MessageObserver;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.transport.coap.TbCoapMessageObserver;

@ContextConfiguration(classes = {ProtoCoapAdaptor.class})
@ExtendWith(SpringExtension.class)
class ProtoCoapAdaptorDiffblueTest {
  @Autowired
  private ProtoCoapAdaptor protoCoapAdaptor;

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Given array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, Request, Descriptor); given array of byte with minus one and 'X'")
  void testConvertToPostTelemetry_givenArrayOfByteWithMinusOneAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> protoCoapAdaptor.convertToPostTelemetry(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayload();
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, Request, Descriptor); given array of byte with zero and 'X'")
  void testConvertToPostTelemetry_givenArrayOfByteWithZeroAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> protoCoapAdaptor.convertToPostTelemetry(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayload();
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, Request, Descriptor); given 'AXAXAXAX' Bytes is 'UTF-8'")
  void testConvertToPostTelemetry_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> protoCoapAdaptor.convertToPostTelemetry(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayload();
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Then return DescriptorForType toProto FieldList size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, Request, Descriptor); then return DescriptorForType toProto FieldList size is one")
  void testConvertToPostTelemetry_thenReturnDescriptorForTypeToProtoFieldListSizeIsOne() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = Request.newDelete();

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToPostTelemetryResult = protoCoapAdaptor
        .convertToPostTelemetry(sessionId, inbound, Any.getDescriptor());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToPostTelemetryResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
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
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    Descriptors.Descriptor descriptorForType4 = getResult.getDescriptorForType();
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
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult6.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
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
    assertSame(file, descriptorForType4.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(1);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(178);
    assertSame(file, getResult5.getFile());
    Descriptors.Descriptor getResult6 = messageTypes.get(179);
    assertSame(file, getResult6.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult2.getFile());
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
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType4, getResult2.getMessageType());
    assertSame(descriptorForType, getResult2.getContainingType());
    TransportProtos.PostTelemetryMsg defaultInstanceForType6 = actualConvertToPostTelemetryResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType6.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConvertToPostTelemetryResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
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
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, getResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType6.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType6.getDefaultInstanceForType(),
        defaultInstanceForType6.getDefaultInstanceForType());
    assertSame(tsKvListList, actualConvertToPostTelemetryResult.getTsKvListOrBuilderList());
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, Request, Descriptor); when 'null'")
  void testConvertToPostTelemetry_whenNull() throws AdaptorException {
    // Arrange
    Request inbound = Request.newDelete();

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToPostTelemetryResult = protoCoapAdaptor.convertToPostTelemetry(null,
        inbound, Any.getDescriptor());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToPostTelemetryResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
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
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    Descriptors.Descriptor descriptorForType4 = getResult.getDescriptorForType();
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
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult6.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
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
    assertSame(file, descriptorForType4.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(1);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(178);
    assertSame(file, getResult5.getFile());
    Descriptors.Descriptor getResult6 = messageTypes.get(179);
    assertSame(file, getResult6.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult2.getFile());
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
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType4, getResult2.getMessageType());
    assertSame(descriptorForType, getResult2.getContainingType());
    TransportProtos.PostTelemetryMsg defaultInstanceForType6 = actualConvertToPostTelemetryResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType6.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConvertToPostTelemetryResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
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
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, getResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType6.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType6.getDefaultInstanceForType(),
        defaultInstanceForType6.getDefaultInstanceForType());
    assertSame(tsKvListList, actualConvertToPostTelemetryResult.getTsKvListOrBuilderList());
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptor)}.
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, Request, Descriptor)")
  void testConvertToPostAttributes() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = Request.newDelete();

    // Act
    TransportProtos.PostAttributeMsg actualConvertToPostAttributesResult = protoCoapAdaptor
        .convertToPostAttributes(sessionId, inbound, Any.getDescriptor());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToPostAttributesResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(actualConvertToPostAttributesResult, actualConvertToPostAttributesResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
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
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
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
    assertSame(file, messageType.getFile());
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
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, messageType.getOptions());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options4, options4.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToPostAttributesResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, getResult6.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Given array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, Request, Descriptor); given array of byte with minus one and 'X'")
  void testConvertToPostAttributes_givenArrayOfByteWithMinusOneAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> protoCoapAdaptor.convertToPostAttributes(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayload();
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, Request, Descriptor); given array of byte with zero and 'X'")
  void testConvertToPostAttributes_givenArrayOfByteWithZeroAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> protoCoapAdaptor.convertToPostAttributes(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayload();
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, Request, Descriptor); given 'AXAXAXAX' Bytes is 'UTF-8'")
  void testConvertToPostAttributes_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> protoCoapAdaptor.convertToPostAttributes(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayload();
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, Request, Descriptor); when 'null'")
  void testConvertToPostAttributes_whenNull() throws AdaptorException {
    // Arrange
    Request inbound = Request.newDelete();

    // Act
    TransportProtos.PostAttributeMsg actualConvertToPostAttributesResult = protoCoapAdaptor
        .convertToPostAttributes(null, inbound, Any.getDescriptor());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToPostAttributesResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(actualConvertToPostAttributesResult, actualConvertToPostAttributesResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
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
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
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
    assertSame(file, messageType.getFile());
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
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, messageType.getOptions());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options4, options4.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToPostAttributesResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, getResult6.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToGetAttributes(UUID, Request)}.
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()} addUriQuery {@code Argument}.</li>
   *   <li>Then calls {@link Message#getOptions()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToGetAttributes(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToGetAttributes(UUID, Request); given OptionSet() addUriQuery 'Argument'; then calls getOptions()")
  void testConvertToGetAttributes_givenOptionSetAddUriQueryArgument_thenCallsGetOptions() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    OptionSet optionSet = new OptionSet();
    optionSet.addUriQuery("Argument");
    Request inbound = mock(Request.class);
    when(inbound.getOptions()).thenReturn(optionSet);

    // Act
    TransportProtos.GetAttributeRequestMsg actualConvertToGetAttributesResult = protoCoapAdaptor
        .convertToGetAttributes(sessionId, inbound);

    // Assert
    verify(inbound).getOptions();
    Descriptors.Descriptor descriptorForType = actualConvertToGetAttributesResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertEquals(actualConvertToGetAttributesResult, actualConvertToGetAttributesResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
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
    Descriptors.FieldDescriptor getResult8 = fields.get(3);
    assertSame(file, getResult8.getFile());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
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
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult8.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToGetAttributesResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList clientAttributeNamesList = actualConvertToGetAttributesResult.getClientAttributeNamesList();
    assertSame(clientAttributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(clientAttributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(clientAttributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(clientAttributeNamesList, defaultInstanceForType2.getDependencyList());
    assertSame(clientAttributeNamesList, toProtoResult.getDependencyList());
    assertSame(clientAttributeNamesList, actualConvertToGetAttributesResult.getSharedAttributeNamesList());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToGetAttributes(UUID, Request)}.
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()}.</li>
   *   <li>Then calls {@link Message#getOptions()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToGetAttributes(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToGetAttributes(UUID, Request); given OptionSet(); then calls getOptions()")
  void testConvertToGetAttributes_givenOptionSet_thenCallsGetOptions() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getOptions()).thenReturn(new OptionSet());

    // Act
    TransportProtos.GetAttributeRequestMsg actualConvertToGetAttributesResult = protoCoapAdaptor
        .convertToGetAttributes(sessionId, inbound);

    // Assert
    verify(inbound).getOptions();
    Descriptors.Descriptor descriptorForType = actualConvertToGetAttributesResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertEquals(actualConvertToGetAttributesResult, actualConvertToGetAttributesResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
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
    Descriptors.FieldDescriptor getResult8 = fields.get(3);
    assertSame(file, getResult8.getFile());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
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
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult8.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToGetAttributesResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList clientAttributeNamesList = actualConvertToGetAttributesResult.getClientAttributeNamesList();
    assertSame(clientAttributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(clientAttributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(clientAttributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(clientAttributeNamesList, defaultInstanceForType2.getDependencyList());
    assertSame(clientAttributeNamesList, toProtoResult.getDependencyList());
    assertSame(clientAttributeNamesList, actualConvertToGetAttributesResult.getSharedAttributeNamesList());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToGetAttributes(UUID, Request)}.
   * <ul>
   *   <li>When newDelete.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToGetAttributes(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToGetAttributes(UUID, Request); when newDelete")
  void testConvertToGetAttributes_whenNewDelete() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act
    TransportProtos.GetAttributeRequestMsg actualConvertToGetAttributesResult = protoCoapAdaptor
        .convertToGetAttributes(sessionId, Request.newDelete());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToGetAttributesResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertEquals(actualConvertToGetAttributesResult, actualConvertToGetAttributesResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
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
    Descriptors.FieldDescriptor getResult8 = fields.get(3);
    assertSame(file, getResult8.getFile());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
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
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult8.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToGetAttributesResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList clientAttributeNamesList = actualConvertToGetAttributesResult.getClientAttributeNamesList();
    assertSame(clientAttributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(clientAttributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(clientAttributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(clientAttributeNamesList, defaultInstanceForType2.getDependencyList());
    assertSame(clientAttributeNamesList, toProtoResult.getDependencyList());
    assertSame(clientAttributeNamesList, actualConvertToGetAttributesResult.getSharedAttributeNamesList());
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToDeviceRpcResponse(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()}.</li>
   *   <li>Then calls {@link Message#getOptions()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToDeviceRpcResponse(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToDeviceRpcResponse(UUID, Request, Descriptor); given OptionSet(); then calls getOptions()")
  void testConvertToDeviceRpcResponse_givenOptionSet_thenCallsGetOptions() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getOptions()).thenReturn(new OptionSet());

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> protoCoapAdaptor.convertToDeviceRpcResponse(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getOptions();
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToDeviceRpcResponse(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>When newDelete.</li>
   *   <li>Then throw {@link AdaptorException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToDeviceRpcResponse(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToDeviceRpcResponse(UUID, Request, Descriptor); when newDelete; then throw AdaptorException")
  void testConvertToDeviceRpcResponse_whenNewDelete_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = Request.newDelete();

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> protoCoapAdaptor.convertToDeviceRpcResponse(sessionId, inbound, Any.getDescriptor()));
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request)")
  void testConvertToServerRpcRequest() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = Request.newDelete();
    inbound.addMessageObserver(new TbCoapMessageObserver(1, mock(Consumer.class), mock(Consumer.class)));

    // Act
    TransportProtos.ToServerRpcRequestMsg actualConvertToServerRpcRequestResult = protoCoapAdaptor
        .convertToServerRpcRequest(sessionId, inbound);

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToServerRpcRequestResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(actualConvertToServerRpcRequestResult,
        actualConvertToServerRpcRequestResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
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
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(178);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(179);
    assertSame(file, getResult4.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
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
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult5.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToServerRpcRequestResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   * <ul>
   *   <li>Given {@code A A A A A A A A} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request); given 'A A A A A A A A' Bytes is 'UTF-8'")
  void testConvertToServerRpcRequest_givenAAAAAAAABytesIsUtf8() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   * <ul>
   *   <li>Given array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request); given array of byte with minus one and 'X'")
  void testConvertToServerRpcRequest_givenArrayOfByteWithMinusOneAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code X} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request); given array of byte with 'X' and 'X'")
  void testConvertToServerRpcRequest_givenArrayOfByteWithXAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{'X', 'X', 1, 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request); given array of byte with zero and 'X'")
  void testConvertToServerRpcRequest_givenArrayOfByteWithZeroAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request); given 'AXAXAXAX' Bytes is 'UTF-8'")
  void testConvertToServerRpcRequest_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   * <ul>
   *   <li>Given {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request); given 'XAXAXAX' Bytes is 'UTF-8'")
  void testConvertToServerRpcRequest_givenXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("\nXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   * <ul>
   *   <li>Given {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request); given 'XXAXAXAX' Bytes is 'UTF-8'")
  void testConvertToServerRpcRequest_givenXxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("XXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   * <ul>
   *   <li>When newDelete.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request); when newDelete")
  void testConvertToServerRpcRequest_whenNewDelete() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act
    TransportProtos.ToServerRpcRequestMsg actualConvertToServerRpcRequestResult = protoCoapAdaptor
        .convertToServerRpcRequest(sessionId, Request.newDelete());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToServerRpcRequestResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(actualConvertToServerRpcRequestResult,
        actualConvertToServerRpcRequestResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
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
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(178);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(179);
    assertSame(file, getResult4.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
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
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult5.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToServerRpcRequestResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request); when 'null'")
  void testConvertToServerRpcRequest_whenNull() throws AdaptorException {
    // Arrange and Act
    TransportProtos.ToServerRpcRequestMsg actualConvertToServerRpcRequestResult = protoCoapAdaptor
        .convertToServerRpcRequest(null, Request.newDelete());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToServerRpcRequestResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(actualConvertToServerRpcRequestResult,
        actualConvertToServerRpcRequestResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
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
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(178);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(179);
    assertSame(file, getResult4.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
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
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult5.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToServerRpcRequestResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto)")
  void testConvertToClaimDevice() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = Request.newDelete();
    inbound.addMessageObserver(new TbCoapMessageObserver(1, mock(Consumer.class), mock(Consumer.class)));

    // Act
    TransportProtos.ClaimDeviceMsg actualConvertToClaimDeviceResult = protoCoapAdaptor.convertToClaimDevice(sessionId,
        inbound, TransportProtos.SessionInfoProto.getDefaultInstance());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToClaimDeviceResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertEquals(actualConvertToClaimDeviceResult, actualConvertToClaimDeviceResult.getDefaultInstanceForType());
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
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
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
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
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
    Descriptors.FieldDescriptor getResult8 = fields.get(3);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult6.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult7.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult8.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToClaimDeviceResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <ul>
   *   <li>Given {@code A A A A A A A A} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); given 'A A A A A A A A' Bytes is 'UTF-8'")
  void testConvertToClaimDevice_givenAAAAAAAABytesIsUtf8() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <ul>
   *   <li>Given array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); given array of byte with minus one and 'X'")
  void testConvertToClaimDevice_givenArrayOfByteWithMinusOneAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code X} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); given array of byte with 'X' and 'X'")
  void testConvertToClaimDevice_givenArrayOfByteWithXAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{'X', 'X', 1, 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); given array of byte with zero and 'X'")
  void testConvertToClaimDevice_givenArrayOfByteWithZeroAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); given 'AXAXAXAX' Bytes is 'UTF-8'")
  void testConvertToClaimDevice_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <ul>
   *   <li>Given {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); given 'XAXAXAX' Bytes is 'UTF-8'")
  void testConvertToClaimDevice_givenXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("\nXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <ul>
   *   <li>Given {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); given 'XXAXAXAX' Bytes is 'UTF-8'")
  void testConvertToClaimDevice_givenXxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("XXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <ul>
   *   <li>When newDelete.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); when newDelete")
  void testConvertToClaimDevice_whenNewDelete() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = Request.newDelete();

    // Act
    TransportProtos.ClaimDeviceMsg actualConvertToClaimDeviceResult = protoCoapAdaptor.convertToClaimDevice(sessionId,
        inbound, TransportProtos.SessionInfoProto.getDefaultInstance());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToClaimDeviceResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertEquals(actualConvertToClaimDeviceResult, actualConvertToClaimDeviceResult.getDefaultInstanceForType());
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
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
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
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
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
    Descriptors.FieldDescriptor getResult8 = fields.get(3);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult6.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult7.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult8.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToClaimDeviceResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); when 'null'")
  void testConvertToClaimDevice_whenNull() throws AdaptorException {
    // Arrange
    Request inbound = Request.newDelete();

    // Act
    TransportProtos.ClaimDeviceMsg actualConvertToClaimDeviceResult = protoCoapAdaptor.convertToClaimDevice(null,
        inbound, TransportProtos.SessionInfoProto.getDefaultInstance());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToClaimDeviceResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertEquals(actualConvertToClaimDeviceResult, actualConvertToClaimDeviceResult.getDefaultInstanceForType());
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
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
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
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
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
    Descriptors.FieldDescriptor getResult8 = fields.get(3);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult6.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult7.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult8.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToClaimDeviceResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request)")
  void testConvertToProvisionRequestMsg() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = Request.newDelete();
    inbound.addMessageObserver(new TbCoapMessageObserver(1, mock(Consumer.class), mock(Consumer.class)));

    // Act
    TransportProtos.ProvisionDeviceRequestMsg actualConvertToProvisionRequestMsgResult = protoCoapAdaptor
        .convertToProvisionRequestMsg(sessionId, inbound);

    // Assert
    TransportProtos.CredentialsDataProto credentialsDataProto = actualConvertToProvisionRequestMsgResult
        .getCredentialsDataProto();
    Descriptors.Descriptor descriptorForType = credentialsDataProto.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    Descriptors.Descriptor descriptorForType2 = actualConvertToProvisionRequestMsgResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(5, fields2.size());
    assertEquals(actualConvertToProvisionRequestMsgResult,
        actualConvertToProvisionRequestMsgResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    TransportProtos.ValidateBasicMqttCredRequestMsg validateBasicMqttCredRequestMsg = credentialsDataProto
        .getValidateBasicMqttCredRequestMsg();
    Descriptors.Descriptor descriptorForType3 = validateBasicMqttCredRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    TransportProtos.ValidateDeviceTokenRequestMsg validateDeviceTokenRequestMsg = credentialsDataProto
        .getValidateDeviceTokenRequestMsg();
    Descriptors.Descriptor descriptorForType4 = validateDeviceTokenRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    TransportProtos.ValidateDeviceX509CertRequestMsg validateDeviceX509CertRequestMsg = credentialsDataProto
        .getValidateDeviceX509CertRequestMsg();
    Descriptors.Descriptor descriptorForType5 = validateDeviceX509CertRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType5.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    TransportProtos.ProvisionDeviceCredentialsMsg provisionDeviceCredentialsMsg = actualConvertToProvisionRequestMsgResult
        .getProvisionDeviceCredentialsMsg();
    Descriptors.Descriptor descriptorForType6 = provisionDeviceCredentialsMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType6.toProto();
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult7 = file.toProto();
    assertSame(reservedNameList, toProtoResult7.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult7.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult7.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType6.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(3);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(4);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(descriptorForType3, getResult4.getMessageType());
    assertSame(descriptorForType4, getResult2.getMessageType());
    assertSame(descriptorForType5, getResult3.getMessageType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult6.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToProvisionRequestMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, validateBasicMqttCredRequestMsg.getUnknownFields());
    assertSame(unknownFields, validateDeviceTokenRequestMsg.getUnknownFields());
    assertSame(unknownFields, validateDeviceX509CertRequestMsg.getUnknownFields());
    assertSame(unknownFields, credentialsDataProto.getUnknownFields());
    assertSame(unknownFields, provisionDeviceCredentialsMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(validateBasicMqttCredRequestMsg, credentialsDataProto.getValidateBasicMqttCredRequestMsgOrBuilder());
    assertSame(validateBasicMqttCredRequestMsg, validateBasicMqttCredRequestMsg.getDefaultInstanceForType());
    assertSame(validateDeviceTokenRequestMsg, credentialsDataProto.getValidateDeviceTokenRequestMsgOrBuilder());
    assertSame(validateDeviceTokenRequestMsg, validateDeviceTokenRequestMsg.getDefaultInstanceForType());
    assertSame(validateDeviceX509CertRequestMsg, credentialsDataProto.getValidateDeviceX509CertRequestMsgOrBuilder());
    assertSame(validateDeviceX509CertRequestMsg, validateDeviceX509CertRequestMsg.getDefaultInstanceForType());
    assertSame(credentialsDataProto, credentialsDataProto.getDefaultInstanceForType());
    assertSame(credentialsDataProto, actualConvertToProvisionRequestMsgResult.getCredentialsDataProtoOrBuilder());
    assertSame(provisionDeviceCredentialsMsg, provisionDeviceCredentialsMsg.getDefaultInstanceForType());
    assertSame(provisionDeviceCredentialsMsg,
        actualConvertToProvisionRequestMsgResult.getProvisionDeviceCredentialsMsgOrBuilder());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); given array of byte with 'A' and two")
  void testConvertToProvisionRequestMsg_givenArrayOfByteWithAAndTwo() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>Given array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); given array of byte with minus one and 'X'")
  void testConvertToProvisionRequestMsg_givenArrayOfByteWithMinusOneAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>Given array of {@code byte} with twenty-six and two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); given array of byte with twenty-six and two")
  void testConvertToProvisionRequestMsg_givenArrayOfByteWithTwentySixAndTwo() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{26, 2, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>Given array of {@code byte} with twenty-six and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); given array of byte with twenty-six and 'X'")
  void testConvertToProvisionRequestMsg_givenArrayOfByteWithTwentySixAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>Given array of {@code byte} with twenty-six and {@code X}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); given array of byte with twenty-six and 'X'; when 'null'")
  void testConvertToProvisionRequestMsg_givenArrayOfByteWithTwentySixAndX_whenNull() throws AdaptorException {
    // Arrange
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(null, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>Given array of {@code byte} with twenty-six and zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); given array of byte with twenty-six and zero")
  void testConvertToProvisionRequestMsg_givenArrayOfByteWithTwentySixAndZero() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>Given array of {@code byte} with two and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); given array of byte with two and 'X'")
  void testConvertToProvisionRequestMsg_givenArrayOfByteWithTwoAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); given 'AXAXAXAX' Bytes is 'UTF-8'")
  void testConvertToProvisionRequestMsg_givenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>Given {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); given 'XAXAXAX' Bytes is 'UTF-8'")
  void testConvertToProvisionRequestMsg_givenXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("\nXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>Given {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); given 'XXAXAXAX' Bytes is 'UTF-8'")
  void testConvertToProvisionRequestMsg_givenXxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("XXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>When newDelete.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); when newDelete")
  void testConvertToProvisionRequestMsg_whenNewDelete() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act
    TransportProtos.ProvisionDeviceRequestMsg actualConvertToProvisionRequestMsgResult = protoCoapAdaptor
        .convertToProvisionRequestMsg(sessionId, Request.newDelete());

    // Assert
    TransportProtos.CredentialsDataProto credentialsDataProto = actualConvertToProvisionRequestMsgResult
        .getCredentialsDataProto();
    Descriptors.Descriptor descriptorForType = credentialsDataProto.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    Descriptors.Descriptor descriptorForType2 = actualConvertToProvisionRequestMsgResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(5, fields2.size());
    assertEquals(actualConvertToProvisionRequestMsgResult,
        actualConvertToProvisionRequestMsgResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    TransportProtos.ValidateBasicMqttCredRequestMsg validateBasicMqttCredRequestMsg = credentialsDataProto
        .getValidateBasicMqttCredRequestMsg();
    Descriptors.Descriptor descriptorForType3 = validateBasicMqttCredRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    TransportProtos.ValidateDeviceTokenRequestMsg validateDeviceTokenRequestMsg = credentialsDataProto
        .getValidateDeviceTokenRequestMsg();
    Descriptors.Descriptor descriptorForType4 = validateDeviceTokenRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    TransportProtos.ValidateDeviceX509CertRequestMsg validateDeviceX509CertRequestMsg = credentialsDataProto
        .getValidateDeviceX509CertRequestMsg();
    Descriptors.Descriptor descriptorForType5 = validateDeviceX509CertRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType5.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    TransportProtos.ProvisionDeviceCredentialsMsg provisionDeviceCredentialsMsg = actualConvertToProvisionRequestMsgResult
        .getProvisionDeviceCredentialsMsg();
    Descriptors.Descriptor descriptorForType6 = provisionDeviceCredentialsMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType6.toProto();
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult7 = file.toProto();
    assertSame(reservedNameList, toProtoResult7.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult7.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult7.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType6.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(3);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(4);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(descriptorForType3, getResult4.getMessageType());
    assertSame(descriptorForType4, getResult2.getMessageType());
    assertSame(descriptorForType5, getResult3.getMessageType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult6.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToProvisionRequestMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, validateBasicMqttCredRequestMsg.getUnknownFields());
    assertSame(unknownFields, validateDeviceTokenRequestMsg.getUnknownFields());
    assertSame(unknownFields, validateDeviceX509CertRequestMsg.getUnknownFields());
    assertSame(unknownFields, credentialsDataProto.getUnknownFields());
    assertSame(unknownFields, provisionDeviceCredentialsMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(validateBasicMqttCredRequestMsg, credentialsDataProto.getValidateBasicMqttCredRequestMsgOrBuilder());
    assertSame(validateBasicMqttCredRequestMsg, validateBasicMqttCredRequestMsg.getDefaultInstanceForType());
    assertSame(validateDeviceTokenRequestMsg, credentialsDataProto.getValidateDeviceTokenRequestMsgOrBuilder());
    assertSame(validateDeviceTokenRequestMsg, validateDeviceTokenRequestMsg.getDefaultInstanceForType());
    assertSame(validateDeviceX509CertRequestMsg, credentialsDataProto.getValidateDeviceX509CertRequestMsgOrBuilder());
    assertSame(validateDeviceX509CertRequestMsg, validateDeviceX509CertRequestMsg.getDefaultInstanceForType());
    assertSame(credentialsDataProto, credentialsDataProto.getDefaultInstanceForType());
    assertSame(credentialsDataProto, actualConvertToProvisionRequestMsgResult.getCredentialsDataProtoOrBuilder());
    assertSame(provisionDeviceCredentialsMsg, provisionDeviceCredentialsMsg.getDefaultInstanceForType());
    assertSame(provisionDeviceCredentialsMsg,
        actualConvertToProvisionRequestMsgResult.getProvisionDeviceCredentialsMsgOrBuilder());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); when 'null'")
  void testConvertToProvisionRequestMsg_whenNull() throws AdaptorException {
    // Arrange and Act
    TransportProtos.ProvisionDeviceRequestMsg actualConvertToProvisionRequestMsgResult = protoCoapAdaptor
        .convertToProvisionRequestMsg(null, Request.newDelete());

    // Assert
    TransportProtos.CredentialsDataProto credentialsDataProto = actualConvertToProvisionRequestMsgResult
        .getCredentialsDataProto();
    Descriptors.Descriptor descriptorForType = credentialsDataProto.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    Descriptors.Descriptor descriptorForType2 = actualConvertToProvisionRequestMsgResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(5, fields2.size());
    assertEquals(actualConvertToProvisionRequestMsgResult,
        actualConvertToProvisionRequestMsgResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    TransportProtos.ValidateBasicMqttCredRequestMsg validateBasicMqttCredRequestMsg = credentialsDataProto
        .getValidateBasicMqttCredRequestMsg();
    Descriptors.Descriptor descriptorForType3 = validateBasicMqttCredRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    TransportProtos.ValidateDeviceTokenRequestMsg validateDeviceTokenRequestMsg = credentialsDataProto
        .getValidateDeviceTokenRequestMsg();
    Descriptors.Descriptor descriptorForType4 = validateDeviceTokenRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    TransportProtos.ValidateDeviceX509CertRequestMsg validateDeviceX509CertRequestMsg = credentialsDataProto
        .getValidateDeviceX509CertRequestMsg();
    Descriptors.Descriptor descriptorForType5 = validateDeviceX509CertRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType5.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    TransportProtos.ProvisionDeviceCredentialsMsg provisionDeviceCredentialsMsg = actualConvertToProvisionRequestMsgResult
        .getProvisionDeviceCredentialsMsg();
    Descriptors.Descriptor descriptorForType6 = provisionDeviceCredentialsMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType6.toProto();
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult7 = file.toProto();
    assertSame(reservedNameList, toProtoResult7.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult7.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult7.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType6.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(3);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(4);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(descriptorForType3, getResult4.getMessageType());
    assertSame(descriptorForType4, getResult2.getMessageType());
    assertSame(descriptorForType5, getResult3.getMessageType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult6.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToProvisionRequestMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, validateBasicMqttCredRequestMsg.getUnknownFields());
    assertSame(unknownFields, validateDeviceTokenRequestMsg.getUnknownFields());
    assertSame(unknownFields, validateDeviceX509CertRequestMsg.getUnknownFields());
    assertSame(unknownFields, credentialsDataProto.getUnknownFields());
    assertSame(unknownFields, provisionDeviceCredentialsMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(validateBasicMqttCredRequestMsg, credentialsDataProto.getValidateBasicMqttCredRequestMsgOrBuilder());
    assertSame(validateBasicMqttCredRequestMsg, validateBasicMqttCredRequestMsg.getDefaultInstanceForType());
    assertSame(validateDeviceTokenRequestMsg, credentialsDataProto.getValidateDeviceTokenRequestMsgOrBuilder());
    assertSame(validateDeviceTokenRequestMsg, validateDeviceTokenRequestMsg.getDefaultInstanceForType());
    assertSame(validateDeviceX509CertRequestMsg, credentialsDataProto.getValidateDeviceX509CertRequestMsgOrBuilder());
    assertSame(validateDeviceX509CertRequestMsg, validateDeviceX509CertRequestMsg.getDefaultInstanceForType());
    assertSame(credentialsDataProto, credentialsDataProto.getDefaultInstanceForType());
    assertSame(credentialsDataProto, actualConvertToProvisionRequestMsgResult.getCredentialsDataProtoOrBuilder());
    assertSame(provisionDeviceCredentialsMsg, provisionDeviceCredentialsMsg.getDefaultInstanceForType());
    assertSame(provisionDeviceCredentialsMsg,
        actualConvertToProvisionRequestMsgResult.getProvisionDeviceCredentialsMsgOrBuilder());
  }

  /**
   * Test
   * {@link ProtoCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)}
   * with {@code AttributeUpdateNotificationMsg}.
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPublish(TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(AttributeUpdateNotificationMsg) with 'AttributeUpdateNotificationMsg'")
  void testConvertToPublishWithAttributeUpdateNotificationMsg() throws AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult = protoCoapAdaptor
        .convertToPublish(TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    assertEquals("", actualConvertToPublishResult.getPayloadString());
    OptionSet options = actualConvertToPublishResult.getOptions();
    assertEquals("", options.getLocationPathString());
    assertEquals("", options.getLocationQueryString());
    assertEquals("", options.getUriPathString());
    assertEquals("", options.getUriQueryString());
    assertEquals("/", options.getLocationString());
    assertEquals("/", options.getUriString());
    assertEquals("null", actualConvertToPublishResult.getTokenString());
    assertNull(actualConvertToPublishResult.getBytes());
    assertNull(actualConvertToPublishResult.getTokenBytes());
    assertNull(options.getOscore());
    assertNull(options.getObserve());
    assertNull(options.getSize1());
    assertNull(options.getSize2());
    assertNull(options.getUriPort());
    assertNull(actualConvertToPublishResult.getApplicationRttNanos());
    assertNull(actualConvertToPublishResult.getTransmissionRttNanos());
    assertNull(options.getProxyScheme());
    assertNull(options.getProxyUri());
    assertNull(options.getUriHost());
    assertNull(actualConvertToPublishResult.getSendError());
    assertNull(actualConvertToPublishResult.getLocalAddress());
    assertNull(options.getBlock1());
    assertNull(options.getBlock2());
    assertNull(actualConvertToPublishResult.getType());
    assertNull(actualConvertToPublishResult.getOffloadMode());
    assertNull(options.getNoResponse());
    assertNull(actualConvertToPublishResult.getToken());
    assertNull(actualConvertToPublishResult.getReliabilityLayerParameters());
    assertNull(actualConvertToPublishResult.getDestinationContext());
    assertNull(actualConvertToPublishResult.getEffectiveDestinationContext());
    assertNull(actualConvertToPublishResult.getSourceContext());
    assertEquals(-1, actualConvertToPublishResult.getMID());
    assertEquals(-1, options.getAccept());
    assertEquals(-1, options.getContentFormat());
    assertEquals(0, actualConvertToPublishResult.getMaxResourceBodySize());
    assertEquals(0, actualConvertToPublishResult.getMessageSize());
    assertEquals(0, actualConvertToPublishResult.getPayloadSize());
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getIfMatchCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(0, options.getURIPathCount());
    assertEquals(0, options.getURIQueryCount());
    assertEquals(0, options.getUriQueryParameter().size());
    assertEquals(0, actualConvertToPublishResult.getPayload().length);
    assertEquals(0L, actualConvertToPublishResult.getNanoTimestamp());
    assertEquals(60L, options.getMaxAge().longValue());
    assertEquals(69, actualConvertToPublishResult.getRawCode());
    assertEquals(CoAP.ResponseCode.CONTENT, actualConvertToPublishResult.getCode());
    assertFalse(actualConvertToPublishResult.hasMID());
    assertFalse(actualConvertToPublishResult.isAcknowledged());
    assertFalse(actualConvertToPublishResult.isCanceled());
    assertFalse(actualConvertToPublishResult.isConfirmable());
    assertFalse(actualConvertToPublishResult.isDuplicate());
    assertFalse(actualConvertToPublishResult.isRejected());
    assertFalse(actualConvertToPublishResult.isSent());
    assertFalse(actualConvertToPublishResult.isTimedOut());
    assertFalse(actualConvertToPublishResult.isUnintendedPayload());
    assertFalse(options.hasAccept());
    assertFalse(options.hasBlock1());
    assertFalse(options.hasBlock2());
    assertFalse(options.hasContentFormat());
    assertFalse(options.hasIfNoneMatch());
    assertFalse(options.hasMaxAge());
    assertFalse(options.hasNoResponse());
    assertFalse(options.hasObserve());
    assertFalse(options.hasOscore());
    assertFalse(options.hasProxyScheme());
    assertFalse(options.hasProxyUri());
    assertFalse(options.hasSize1());
    assertFalse(options.hasSize2());
    assertFalse(options.hasUriHost());
    assertFalse(options.hasUriPort());
    assertFalse(actualConvertToPublishResult.hasBlockOption());
    assertFalse(actualConvertToPublishResult.isClientError());
    assertFalse(actualConvertToPublishResult.isError());
    assertFalse(actualConvertToPublishResult.isInternal());
    assertFalse(actualConvertToPublishResult.isNotification());
    assertFalse(actualConvertToPublishResult.isServerError());
    List<MessageObserver> messageObservers = actualConvertToPublishResult.getMessageObservers();
    assertTrue(messageObservers.isEmpty());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getIfMatch().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
    assertTrue(options.getUriPath().isEmpty());
    assertTrue(options.getUriQuery().isEmpty());
    assertTrue(actualConvertToPublishResult.hasEmptyToken());
    assertTrue(actualConvertToPublishResult.isIntendedPayload());
    assertTrue(actualConvertToPublishResult.isSuccess());
    assertSame(messageObservers, options.getOthers());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with
   * {@code GetAttributeResponseMsg}.
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPublish(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'")
  void testConvertToPublishWithGetAttributeResponseMsg() throws AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult = protoCoapAdaptor
        .convertToPublish(TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    assertEquals("", actualConvertToPublishResult.getPayloadString());
    OptionSet options = actualConvertToPublishResult.getOptions();
    assertEquals("", options.getLocationPathString());
    assertEquals("", options.getLocationQueryString());
    assertEquals("", options.getUriPathString());
    assertEquals("", options.getUriQueryString());
    assertEquals("/", options.getLocationString());
    assertEquals("/", options.getUriString());
    assertEquals("null", actualConvertToPublishResult.getTokenString());
    assertNull(actualConvertToPublishResult.getBytes());
    assertNull(actualConvertToPublishResult.getTokenBytes());
    assertNull(options.getOscore());
    assertNull(options.getObserve());
    assertNull(options.getSize1());
    assertNull(options.getSize2());
    assertNull(options.getUriPort());
    assertNull(actualConvertToPublishResult.getApplicationRttNanos());
    assertNull(actualConvertToPublishResult.getTransmissionRttNanos());
    assertNull(options.getProxyScheme());
    assertNull(options.getProxyUri());
    assertNull(options.getUriHost());
    assertNull(actualConvertToPublishResult.getSendError());
    assertNull(actualConvertToPublishResult.getLocalAddress());
    assertNull(options.getBlock1());
    assertNull(options.getBlock2());
    assertNull(actualConvertToPublishResult.getType());
    assertNull(actualConvertToPublishResult.getOffloadMode());
    assertNull(options.getNoResponse());
    assertNull(actualConvertToPublishResult.getToken());
    assertNull(actualConvertToPublishResult.getReliabilityLayerParameters());
    assertNull(actualConvertToPublishResult.getDestinationContext());
    assertNull(actualConvertToPublishResult.getEffectiveDestinationContext());
    assertNull(actualConvertToPublishResult.getSourceContext());
    assertEquals(-1, actualConvertToPublishResult.getMID());
    assertEquals(-1, options.getAccept());
    assertEquals(-1, options.getContentFormat());
    assertEquals(0, actualConvertToPublishResult.getMaxResourceBodySize());
    assertEquals(0, actualConvertToPublishResult.getMessageSize());
    assertEquals(0, actualConvertToPublishResult.getPayloadSize());
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getIfMatchCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(0, options.getURIPathCount());
    assertEquals(0, options.getURIQueryCount());
    assertEquals(0, options.getUriQueryParameter().size());
    assertEquals(0, actualConvertToPublishResult.getPayload().length);
    assertEquals(0L, actualConvertToPublishResult.getNanoTimestamp());
    assertEquals(132, actualConvertToPublishResult.getRawCode());
    assertEquals(60L, options.getMaxAge().longValue());
    assertEquals(CoAP.ResponseCode.NOT_FOUND, actualConvertToPublishResult.getCode());
    assertFalse(actualConvertToPublishResult.hasMID());
    assertFalse(actualConvertToPublishResult.isAcknowledged());
    assertFalse(actualConvertToPublishResult.isCanceled());
    assertFalse(actualConvertToPublishResult.isConfirmable());
    assertFalse(actualConvertToPublishResult.isDuplicate());
    assertFalse(actualConvertToPublishResult.isRejected());
    assertFalse(actualConvertToPublishResult.isSent());
    assertFalse(actualConvertToPublishResult.isTimedOut());
    assertFalse(actualConvertToPublishResult.isUnintendedPayload());
    assertFalse(options.hasAccept());
    assertFalse(options.hasBlock1());
    assertFalse(options.hasBlock2());
    assertFalse(options.hasContentFormat());
    assertFalse(options.hasIfNoneMatch());
    assertFalse(options.hasMaxAge());
    assertFalse(options.hasNoResponse());
    assertFalse(options.hasObserve());
    assertFalse(options.hasOscore());
    assertFalse(options.hasProxyScheme());
    assertFalse(options.hasProxyUri());
    assertFalse(options.hasSize1());
    assertFalse(options.hasSize2());
    assertFalse(options.hasUriHost());
    assertFalse(options.hasUriPort());
    assertFalse(actualConvertToPublishResult.hasBlockOption());
    assertFalse(actualConvertToPublishResult.isInternal());
    assertFalse(actualConvertToPublishResult.isNotification());
    assertFalse(actualConvertToPublishResult.isServerError());
    assertFalse(actualConvertToPublishResult.isSuccess());
    List<MessageObserver> messageObservers = actualConvertToPublishResult.getMessageObservers();
    assertTrue(messageObservers.isEmpty());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getIfMatch().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
    assertTrue(options.getUriPath().isEmpty());
    assertTrue(options.getUriQuery().isEmpty());
    assertTrue(actualConvertToPublishResult.hasEmptyToken());
    assertTrue(actualConvertToPublishResult.isIntendedPayload());
    assertTrue(actualConvertToPublishResult.isClientError());
    assertTrue(actualConvertToPublishResult.isError());
    assertSame(messageObservers, options.getOthers());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToPublish(ToServerRpcResponseMsg)} with
   * {@code ToServerRpcResponseMsg}.
   * <p>
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPublish(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(ToServerRpcResponseMsg) with 'ToServerRpcResponseMsg'")
  void testConvertToPublishWithToServerRpcResponseMsg() throws AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult = protoCoapAdaptor
        .convertToPublish(TransportProtos.ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    assertEquals("", actualConvertToPublishResult.getPayloadString());
    OptionSet options = actualConvertToPublishResult.getOptions();
    assertEquals("", options.getLocationPathString());
    assertEquals("", options.getLocationQueryString());
    assertEquals("", options.getUriPathString());
    assertEquals("", options.getUriQueryString());
    assertEquals("/", options.getLocationString());
    assertEquals("/", options.getUriString());
    assertEquals("null", actualConvertToPublishResult.getTokenString());
    assertNull(actualConvertToPublishResult.getBytes());
    assertNull(actualConvertToPublishResult.getTokenBytes());
    assertNull(options.getOscore());
    assertNull(options.getObserve());
    assertNull(options.getSize1());
    assertNull(options.getSize2());
    assertNull(options.getUriPort());
    assertNull(actualConvertToPublishResult.getApplicationRttNanos());
    assertNull(actualConvertToPublishResult.getTransmissionRttNanos());
    assertNull(options.getProxyScheme());
    assertNull(options.getProxyUri());
    assertNull(options.getUriHost());
    assertNull(actualConvertToPublishResult.getSendError());
    assertNull(actualConvertToPublishResult.getLocalAddress());
    assertNull(options.getBlock1());
    assertNull(options.getBlock2());
    assertNull(actualConvertToPublishResult.getType());
    assertNull(actualConvertToPublishResult.getOffloadMode());
    assertNull(options.getNoResponse());
    assertNull(actualConvertToPublishResult.getToken());
    assertNull(actualConvertToPublishResult.getReliabilityLayerParameters());
    assertNull(actualConvertToPublishResult.getDestinationContext());
    assertNull(actualConvertToPublishResult.getEffectiveDestinationContext());
    assertNull(actualConvertToPublishResult.getSourceContext());
    assertEquals(-1, actualConvertToPublishResult.getMID());
    assertEquals(-1, options.getAccept());
    assertEquals(-1, options.getContentFormat());
    assertEquals(0, actualConvertToPublishResult.getMaxResourceBodySize());
    assertEquals(0, actualConvertToPublishResult.getMessageSize());
    assertEquals(0, actualConvertToPublishResult.getPayloadSize());
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getIfMatchCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(0, options.getURIPathCount());
    assertEquals(0, options.getURIQueryCount());
    assertEquals(0, options.getUriQueryParameter().size());
    assertEquals(0, actualConvertToPublishResult.getPayload().length);
    assertEquals(0L, actualConvertToPublishResult.getNanoTimestamp());
    assertEquals(60L, options.getMaxAge().longValue());
    assertEquals(69, actualConvertToPublishResult.getRawCode());
    assertEquals(CoAP.ResponseCode.CONTENT, actualConvertToPublishResult.getCode());
    assertFalse(actualConvertToPublishResult.hasMID());
    assertFalse(actualConvertToPublishResult.isAcknowledged());
    assertFalse(actualConvertToPublishResult.isCanceled());
    assertFalse(actualConvertToPublishResult.isConfirmable());
    assertFalse(actualConvertToPublishResult.isDuplicate());
    assertFalse(actualConvertToPublishResult.isRejected());
    assertFalse(actualConvertToPublishResult.isSent());
    assertFalse(actualConvertToPublishResult.isTimedOut());
    assertFalse(actualConvertToPublishResult.isUnintendedPayload());
    assertFalse(options.hasAccept());
    assertFalse(options.hasBlock1());
    assertFalse(options.hasBlock2());
    assertFalse(options.hasContentFormat());
    assertFalse(options.hasIfNoneMatch());
    assertFalse(options.hasMaxAge());
    assertFalse(options.hasNoResponse());
    assertFalse(options.hasObserve());
    assertFalse(options.hasOscore());
    assertFalse(options.hasProxyScheme());
    assertFalse(options.hasProxyUri());
    assertFalse(options.hasSize1());
    assertFalse(options.hasSize2());
    assertFalse(options.hasUriHost());
    assertFalse(options.hasUriPort());
    assertFalse(actualConvertToPublishResult.hasBlockOption());
    assertFalse(actualConvertToPublishResult.isClientError());
    assertFalse(actualConvertToPublishResult.isError());
    assertFalse(actualConvertToPublishResult.isInternal());
    assertFalse(actualConvertToPublishResult.isNotification());
    assertFalse(actualConvertToPublishResult.isServerError());
    List<MessageObserver> messageObservers = actualConvertToPublishResult.getMessageObservers();
    assertTrue(messageObservers.isEmpty());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getIfMatch().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
    assertTrue(options.getUriPath().isEmpty());
    assertTrue(options.getUriQuery().isEmpty());
    assertTrue(actualConvertToPublishResult.hasEmptyToken());
    assertTrue(actualConvertToPublishResult.isIntendedPayload());
    assertTrue(actualConvertToPublishResult.isSuccess());
    assertSame(messageObservers, options.getOthers());
  }

  /**
   * Test {@link ProtoCoapAdaptor#getContentFormat()}.
   * <p>
   * Method under test: {@link ProtoCoapAdaptor#getContentFormat()}
   */
  @Test
  @DisplayName("Test getContentFormat()")
  void testGetContentFormat() {
    // Arrange, Act and Assert
    assertEquals(42, protoCoapAdaptor.getContentFormat());
  }
}
