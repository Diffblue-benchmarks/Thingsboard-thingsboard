package org.thingsboard.server.transport.coap.adaptors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;
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

@ContextConfiguration(classes = {JsonCoapAdaptor.class})
@ExtendWith(SpringExtension.class)
class JsonCoapAdaptorDiffblueTest {
  @Autowired
  private JsonCoapAdaptor jsonCoapAdaptor;

  /**
   * Test
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link Request} {@link Message#getPayloadString()} return
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, Request, Descriptor); given '42'; when Request getPayloadString() return '42'")
  void testConvertToPostTelemetry_given42_whenRequestGetPayloadStringReturn42() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("42");

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostTelemetry(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link Request} {@link Message#getPayloadString()} return
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, Request, Descriptor); given 'foo'; when Request getPayloadString() return 'foo'")
  void testConvertToPostTelemetry_givenFoo_whenRequestGetPayloadStringReturnFoo() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("foo");

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostTelemetry(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Request} {@link Message#getPayloadString()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, Request, Descriptor); given 'null'; when Request getPayloadString() return 'null'")
  void testConvertToPostTelemetry_givenNull_whenRequestGetPayloadStringReturnNull() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostTelemetry(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Given {@code Payload String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, Request, Descriptor); given 'Payload String'")
  void testConvertToPostTelemetry_givenPayloadString() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("Payload String");

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostTelemetry(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>When newDelete.</li>
   *   <li>Then throw {@link AdaptorException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, Request, Descriptor); when newDelete; then throw AdaptorException")
  void testConvertToPostTelemetry_whenNewDelete_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = Request.newDelete();

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostTelemetry(sessionId, inbound, Any.getDescriptor()));
  }

  /**
   * Test
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link AdaptorException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, Request, Descriptor); when 'null'; then throw AdaptorException")
  void testConvertToPostTelemetry_whenNull_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    Request inbound = Request.newDelete();

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostTelemetry(null, inbound, Any.getDescriptor()));
  }

  /**
   * Test
   * {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link Request} {@link Message#getPayloadString()} return
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, Request, Descriptor); given '42'; when Request getPayloadString() return '42'")
  void testConvertToPostAttributes_given42_whenRequestGetPayloadStringReturn42() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("42");

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostAttributes(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test
   * {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link Request} {@link Message#getPayloadString()} return
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, Request, Descriptor); given 'foo'; when Request getPayloadString() return 'foo'")
  void testConvertToPostAttributes_givenFoo_whenRequestGetPayloadStringReturnFoo() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("foo");

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostAttributes(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test
   * {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Request} {@link Message#getPayloadString()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, Request, Descriptor); given 'null'; when Request getPayloadString() return 'null'")
  void testConvertToPostAttributes_givenNull_whenRequestGetPayloadStringReturnNull() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostAttributes(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test
   * {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Given {@code Payload String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, Request, Descriptor); given 'Payload String'")
  void testConvertToPostAttributes_givenPayloadString() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("Payload String");

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostAttributes(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test
   * {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>When newDelete.</li>
   *   <li>Then throw {@link AdaptorException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, Request, Descriptor); when newDelete; then throw AdaptorException")
  void testConvertToPostAttributes_whenNewDelete_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = Request.newDelete();

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostAttributes(sessionId, inbound, Any.getDescriptor()));
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToGetAttributes(UUID, Request)}.
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()} addUriQuery {@code Argument}.</li>
   *   <li>Then calls {@link Message#getOptions()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToGetAttributes(UUID, Request)}
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
    TransportProtos.GetAttributeRequestMsg actualConvertToGetAttributesResult = jsonCoapAdaptor
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
   * Test {@link JsonCoapAdaptor#convertToGetAttributes(UUID, Request)}.
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()}.</li>
   *   <li>Then calls {@link Message#getOptions()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToGetAttributes(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToGetAttributes(UUID, Request); given OptionSet(); then calls getOptions()")
  void testConvertToGetAttributes_givenOptionSet_thenCallsGetOptions() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getOptions()).thenReturn(new OptionSet());

    // Act
    TransportProtos.GetAttributeRequestMsg actualConvertToGetAttributesResult = jsonCoapAdaptor
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
   * Test {@link JsonCoapAdaptor#convertToGetAttributes(UUID, Request)}.
   * <ul>
   *   <li>When newDelete.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToGetAttributes(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToGetAttributes(UUID, Request); when newDelete")
  void testConvertToGetAttributes_whenNewDelete() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act
    TransportProtos.GetAttributeRequestMsg actualConvertToGetAttributesResult = jsonCoapAdaptor
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
   * {@link JsonCoapAdaptor#convertToDeviceRpcResponse(UUID, Request, Descriptor)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then throw {@link AdaptorException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToDeviceRpcResponse(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test convertToDeviceRpcResponse(UUID, Request, Descriptor); given 'null'; then throw AdaptorException")
  void testConvertToDeviceRpcResponse_givenNull_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);
    when(inbound.getOptions()).thenReturn(new OptionSet());

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToDeviceRpcResponse(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getOptions();
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then throw {@link AdaptorException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request); given 'null'; then throw AdaptorException")
  void testConvertToServerRpcRequest_givenNull_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayloadString();
  }

  /**
   * Test
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link Request} {@link Message#getPayloadString()} return
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); given '42'; when Request getPayloadString() return '42'")
  void testConvertToClaimDevice_given42_whenRequestGetPayloadStringReturn42() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("42");

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link Request} {@link Message#getPayloadString()} return
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); given 'foo'; when Request getPayloadString() return 'foo'")
  void testConvertToClaimDevice_givenFoo_whenRequestGetPayloadStringReturnFoo() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("foo");

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Request} {@link Message#getPayloadString()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); given 'null'; when Request getPayloadString() return 'null'")
  void testConvertToClaimDevice_givenNull_whenRequestGetPayloadStringReturnNull() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);

    // Act
    TransportProtos.ClaimDeviceMsg actualConvertToClaimDeviceResult = jsonCoapAdaptor.convertToClaimDevice(sessionId,
        inbound, TransportProtos.SessionInfoProto.getDefaultInstance());

    // Assert
    verify(inbound).getPayloadString();
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
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <ul>
   *   <li>Given {@code Payload String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); given 'Payload String'")
  void testConvertToClaimDevice_givenPayloadString() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("Payload String");

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <ul>
   *   <li>Given {@code Payload String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); given 'Payload String'")
  void testConvertToClaimDevice_givenPayloadString2() throws AdaptorException {
    // Arrange
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("Payload String");

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToClaimDevice(null, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <ul>
   *   <li>When newDelete.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); when newDelete")
  void testConvertToClaimDevice_whenNewDelete() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = Request.newDelete();

    // Act
    TransportProtos.ClaimDeviceMsg actualConvertToClaimDeviceResult = jsonCoapAdaptor.convertToClaimDevice(sessionId,
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
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   * <ul>
   *   <li>When newDelete.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); when newDelete")
  void testConvertToClaimDevice_whenNewDelete2() throws AdaptorException {
    // Arrange
    Request inbound = Request.newDelete();

    // Act
    TransportProtos.ClaimDeviceMsg actualConvertToClaimDeviceResult = jsonCoapAdaptor.convertToClaimDevice(null,
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
   * Test {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)}
   * with {@code AttributeUpdateNotificationMsg}.
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPublish(TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(AttributeUpdateNotificationMsg) with 'AttributeUpdateNotificationMsg'")
  void testConvertToPublishWithAttributeUpdateNotificationMsg() throws AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult = jsonCoapAdaptor
        .convertToPublish(TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    OptionSet options = actualConvertToPublishResult.getOptions();
    assertEquals("", options.getLocationPathString());
    assertEquals("", options.getLocationQueryString());
    assertEquals("", options.getUriPathString());
    assertEquals("", options.getUriQueryString());
    assertEquals("/", options.getLocationString());
    assertEquals("/", options.getUriString());
    assertEquals("null", actualConvertToPublishResult.getTokenString());
    assertEquals("{}", actualConvertToPublishResult.getPayloadString());
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
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getIfMatchCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(0, options.getURIPathCount());
    assertEquals(0, options.getURIQueryCount());
    assertEquals(0, options.getUriQueryParameter().size());
    assertEquals(0L, actualConvertToPublishResult.getNanoTimestamp());
    assertEquals(2, actualConvertToPublishResult.getPayloadSize());
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
    assertArrayEquals(new byte[]{'{', '}'}, actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with
   * {@code GetAttributeResponseMsg}.
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPublish(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'")
  void testConvertToPublishWithGetAttributeResponseMsg() throws AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult = jsonCoapAdaptor
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
   * Test {@link JsonCoapAdaptor#convertToPublish(ToDeviceRpcRequestMsg, Builder)}
   * with {@code ToDeviceRpcRequestMsg}, {@code Builder}.
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPublish(TransportProtos.ToDeviceRpcRequestMsg, DynamicMessage.Builder)}
   */
  @Test
  @DisplayName("Test convertToPublish(ToDeviceRpcRequestMsg, Builder) with 'ToDeviceRpcRequestMsg', 'Builder'")
  void testConvertToPublishWithToDeviceRpcRequestMsgBuilder() throws UnsupportedEncodingException, AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult = jsonCoapAdaptor
        .convertToPublish(TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), null);

    // Assert
    OptionSet options = actualConvertToPublishResult.getOptions();
    assertEquals("", options.getLocationPathString());
    assertEquals("", options.getLocationQueryString());
    assertEquals("", options.getUriPathString());
    assertEquals("", options.getUriQueryString());
    assertEquals("/", options.getLocationString());
    assertEquals("/", options.getUriString());
    assertEquals("null", actualConvertToPublishResult.getTokenString());
    assertEquals("{\"id\":0,\"method\":\"\",\"params\":null}", actualConvertToPublishResult.getPayloadString());
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
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getIfMatchCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(0, options.getURIPathCount());
    assertEquals(0, options.getURIQueryCount());
    assertEquals(0, options.getUriQueryParameter().size());
    assertEquals(0L, actualConvertToPublishResult.getNanoTimestamp());
    assertEquals(34, actualConvertToPublishResult.getPayloadSize());
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
    byte[] expectedPayload = "{\"id\":0,\"method\":\"\",\"params\":null}".getBytes("UTF-8");
    assertArrayEquals(expectedPayload, actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(ToServerRpcResponseMsg)} with
   * {@code ToServerRpcResponseMsg}.
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPublish(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(ToServerRpcResponseMsg) with 'ToServerRpcResponseMsg'")
  void testConvertToPublishWithToServerRpcResponseMsg() throws UnsupportedEncodingException, AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult = jsonCoapAdaptor
        .convertToPublish(TransportProtos.ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    OptionSet options = actualConvertToPublishResult.getOptions();
    assertEquals("", options.getLocationPathString());
    assertEquals("", options.getLocationQueryString());
    assertEquals("", options.getUriPathString());
    assertEquals("", options.getUriQueryString());
    assertEquals("/", options.getLocationString());
    assertEquals("/", options.getUriString());
    assertEquals("null", actualConvertToPublishResult.getPayloadString());
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
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getIfMatchCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(0, options.getURIPathCount());
    assertEquals(0, options.getURIQueryCount());
    assertEquals(0, options.getUriQueryParameter().size());
    assertEquals(0L, actualConvertToPublishResult.getNanoTimestamp());
    assertEquals(4, actualConvertToPublishResult.getPayloadSize());
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
    byte[] expectedPayload = "null".getBytes("UTF-8");
    assertArrayEquals(expectedPayload, actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#getContentFormat()}.
   * <p>
   * Method under test: {@link JsonCoapAdaptor#getContentFormat()}
   */
  @Test
  @DisplayName("Test getContentFormat()")
  void testGetContentFormat() {
    // Arrange, Act and Assert
    assertEquals(50, jsonCoapAdaptor.getContentFormat());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link Request} {@link Message#getPayloadString()} return
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); given '42'; when Request getPayloadString() return '42'")
  void testConvertToProvisionRequestMsg_given42_whenRequestGetPayloadStringReturn42() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("42");

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link Request} {@link Message#getPayloadString()} return
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); given 'foo'; when Request getPayloadString() return 'foo'")
  void testConvertToProvisionRequestMsg_givenFoo_whenRequestGetPayloadStringReturnFoo() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("foo");

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Request} {@link Message#getPayloadString()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); given 'null'; when Request getPayloadString() return 'null'")
  void testConvertToProvisionRequestMsg_givenNull_whenRequestGetPayloadStringReturnNull() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>Given {@code Payload String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); given 'Payload String'")
  void testConvertToProvisionRequestMsg_givenPayloadString() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("Payload String");

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   * <ul>
   *   <li>When newDelete.</li>
   *   <li>Then throw {@link AdaptorException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); when newDelete; then throw AdaptorException")
  void testConvertToProvisionRequestMsg_whenNewDelete_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToProvisionRequestMsg(sessionId, Request.newDelete()));
  }
}
