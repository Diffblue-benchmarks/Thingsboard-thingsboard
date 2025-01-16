package org.thingsboard.server.transport.coap.efento.adaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.transport.coap.efento.CoapEfentoTransportResource;
import org.thingsboard.server.transport.coap.efento.CoapEfentoTransportResource.EfentoTelemetry;

@ContextConfiguration(classes = {EfentoCoapAdaptor.class})
@ExtendWith(SpringExtension.class)
class EfentoCoapAdaptorDiffblueTest {
  @Autowired
  private EfentoCoapAdaptor efentoCoapAdaptor;

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List)")
  void testConvertToPostTelemetry() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToPostTelemetryResult = efentoCoapAdaptor
        .convertToPostTelemetry(sessionId, new ArrayList<>());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToPostTelemetryResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    assertEquals(actualConvertToPostTelemetryResult, actualConvertToPostTelemetryResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto expectedDefaultInstanceForType = descriptorForType.toProto()
        .getDefaultInstanceForType();
    Descriptors.Descriptor messageType = fields.get(0).getMessageType();
    assertSame(expectedDefaultInstanceForType, messageType.toProto().getDefaultInstanceForType());
    Descriptors.FileDescriptor expectedFile = descriptorForType.getFile();
    assertSame(expectedFile, messageType.getFile());
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List)")
  void testConvertToPostTelemetry2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = new JsonArray(3);
    values.add(new JsonArray(3));
    values.add(true);
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(-1L,
        values);

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   * <ul>
   *   <li>Given {@link EfentoTelemetry#EfentoTelemetry(long, JsonElement)} with ts
   * is one and values is {@link JsonArray#JsonArray(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); given EfentoTelemetry(long, JsonElement) with ts is one and values is JsonArray(int)")
  void testConvertToPostTelemetry_givenEfentoTelemetryWithTsIsOneAndValuesIsJsonArray() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(new CoapEfentoTransportResource.EfentoTelemetry(1L, new JsonArray(3)));
    telemetryList.add(new CoapEfentoTransportResource.EfentoTelemetry(-1L, new JsonArray(3)));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); given JsonArray(int) with capacity is three")
  void testConvertToPostTelemetry_givenJsonArrayWithCapacityIsThree() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(new CoapEfentoTransportResource.EfentoTelemetry(-1L, new JsonArray(3)));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); given JsonArray(int) with capacity is three add 'A'")
  void testConvertToPostTelemetry_givenJsonArrayWithCapacityIsThreeAddA() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = new JsonArray(3);
    values.add('A');
    values.add(true);
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(-1L,
        values);

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); given JsonArray(int) with capacity is three add 'false'")
  void testConvertToPostTelemetry_givenJsonArrayWithCapacityIsThreeAddFalse() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = new JsonArray(3);
    values.add(false);
    values.add(true);
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(-1L,
        values);

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); given JsonArray(int) with capacity is three add 'true'")
  void testConvertToPostTelemetry_givenJsonArrayWithCapacityIsThreeAddTrue() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = new JsonArray(3);
    values.add(true);
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(-1L,
        values);

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add valueOf
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); given JsonArray(int) with capacity is three add valueOf one")
  void testConvertToPostTelemetry_givenJsonArrayWithCapacityIsThreeAddValueOfOne() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = new JsonArray(3);
    values.add(Integer.valueOf(1));
    values.add(true);
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(-1L,
        values);

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   * <ul>
   *   <li>Given {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); given JsonPrimitive(Boolean) with bool is 'true'")
  void testConvertToPostTelemetry_givenJsonPrimitiveWithBoolIsTrue() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(new CoapEfentoTransportResource.EfentoTelemetry(-1L, new JsonPrimitive(true)));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   * <ul>
   *   <li>Given {@link JsonPrimitive#JsonPrimitive(Character)} with c is start of
   * heading.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); given JsonPrimitive(Character) with c is start of heading")
  void testConvertToPostTelemetry_givenJsonPrimitiveWithCIsStartOfHeading() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(new CoapEfentoTransportResource.EfentoTelemetry(-1L, new JsonPrimitive('\u0001')));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   * <ul>
   *   <li>Given {@link JsonPrimitive#JsonPrimitive(String)} with string is
   * {@code ts}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); given JsonPrimitive(String) with string is 'ts'")
  void testConvertToPostTelemetry_givenJsonPrimitiveWithStringIsTs() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(new CoapEfentoTransportResource.EfentoTelemetry(-1L, new JsonPrimitive("ts")));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); given 'null'; when ArrayList() add 'null'")
  void testConvertToPostTelemetry_givenNull_whenArrayListAddNull() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(null);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   * <ul>
   *   <li>Then return DescriptorForType toProto FieldList size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); then return DescriptorForType toProto FieldList size is one")
  void testConvertToPostTelemetry_thenReturnDescriptorForTypeToProtoFieldListSizeIsOne() throws AdaptorException {
    // Arrange and Act
    TransportProtos.PostTelemetryMsg actualConvertToPostTelemetryResult = efentoCoapAdaptor.convertToPostTelemetry(null,
        new ArrayList<>());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToPostTelemetryResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
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
    assertEquals(actualConvertToPostTelemetryResult, actualConvertToPostTelemetryResult.getDefaultInstanceForType());
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
    ProtocolStringList reservedNameList = toProtoResult3.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    assertSame(reservedNameList, reservedNameList);
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
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
    UnknownFieldSet unknownFields = actualConvertToPostTelemetryResult.getUnknownFields();
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
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   * <ul>
   *   <li>Then return TsKvListList first KvList size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); then return TsKvListList first KvList size is one")
  void testConvertToPostTelemetry_thenReturnTsKvListListFirstKvListSizeIsOne() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(new CoapEfentoTransportResource.EfentoTelemetry(-1L, null));

    // Act and Assert
    List<TransportProtos.TsKvListProto> tsKvListList = efentoCoapAdaptor
        .convertToPostTelemetry(sessionId, telemetryList)
        .getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    List<TransportProtos.KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult2 = kvList.get(0);
    assertEquals("", getResult2.getInitializationErrorString());
    assertEquals("", getResult2.getJsonV());
    assertEquals("", getResult2.getStringV());
    assertEquals("ts", getResult2.getKey());
    assertEquals(-1L, getResult2.getLongV());
    assertEquals(0.0d, getResult2.getDoubleV());
    assertEquals(1, getResult2.getTypeValue());
    assertEquals(1, getResult.getKvCount());
    assertEquals(17, getResult2.getSerializedSize());
    assertEquals(TransportProtos.KeyValueType.LONG_V, getResult2.getType());
    assertFalse(getResult2.getBoolV());
    assertTrue(getResult2.isInitialized());
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   * <ul>
   *   <li>Then return TsKvListList first Ts is minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); then return TsKvListList first Ts is minus one")
  void testConvertToPostTelemetry_thenReturnTsKvListListFirstTsIsMinusOne() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(new CoapEfentoTransportResource.EfentoTelemetry(-1L, new JsonObject()));

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToPostTelemetryResult = efentoCoapAdaptor
        .convertToPostTelemetry(sessionId, telemetryList);

    // Assert
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(-1L, getResult.getTs());
    assertEquals(0, getResult.getKvCount());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(13, actualConvertToPostTelemetryResult.getSerializedSize());
    assertTrue(getResult.getKvList().isEmpty());
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement)")
  void testConvertToPostAttributes() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostAttributes(sessionId,
        new JsonPrimitive("[{}] Failed to convert JsonObject to PostTelemetry request!")));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement); given 'false'; when JsonArray(int) with capacity is three add 'false'")
  void testConvertToPostAttributes_givenFalse_whenJsonArrayWithCapacityIsThreeAddFalse() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray deviceInfo = new JsonArray(3);
    deviceInfo.add(false);
    deviceInfo.add(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement); given JsonArray(int) with capacity is three")
  void testConvertToPostAttributes_givenJsonArrayWithCapacityIsThree() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray deviceInfo = new JsonArray(3);
    deviceInfo.add(new JsonArray(3));
    deviceInfo.add(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   * <ul>
   *   <li>Given null.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * null.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement); given null; when JsonArray(int) with capacity is three add null")
  void testConvertToPostAttributes_givenNull_whenJsonArrayWithCapacityIsThreeAddNull() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray deviceInfo = new JsonArray(3);
    deviceInfo.add('\u0000');
    deviceInfo.add(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement); given 'true'; when JsonArray(int) with capacity is three add 'true'")
  void testConvertToPostAttributes_givenTrue_whenJsonArrayWithCapacityIsThreeAddTrue() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray deviceInfo = new JsonArray(3);
    deviceInfo.add(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement); given valueOf one")
  void testConvertToPostAttributes_givenValueOfOne() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray deviceInfo = new JsonArray(3);
    deviceInfo.add(Integer.valueOf(1));
    deviceInfo.add(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement); when JsonArray(int) with capacity is three")
  void testConvertToPostAttributes_whenJsonArrayWithCapacityIsThree() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, new JsonArray(3)));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   *   <li>Then throw {@link AdaptorException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement); when JsonNull (default constructor); then throw AdaptorException")
  void testConvertToPostAttributes_whenJsonNull_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, new JsonNull()));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement); when JsonPrimitive(Boolean) with bool is 'true'")
  void testConvertToPostAttributes_whenJsonPrimitiveWithBoolIsTrue() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, new JsonPrimitive(true)));
  }
}
