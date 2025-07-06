package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Any;
import com.google.protobuf.BytesValue;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import com.squareup.wire.Syntax;
import com.squareup.wire.schema.internal.parser.ExtendElement;
import com.squareup.wire.schema.internal.parser.OptionElement;
import com.squareup.wire.schema.internal.parser.ProtoFileElement;
import com.squareup.wire.schema.internal.parser.ServiceElement;
import com.squareup.wire.schema.internal.parser.TypeElement;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DynamicProtoUtilsDiffblueTest {
  /**
   * Test {@link DynamicProtoUtils#getDescriptor(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#getDescriptor(String, String)}
   */
  @Test
  @DisplayName("Test getDescriptor(String, String); when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptor DynamicProtoUtils.getDescriptor(String, String)"})
  void testGetDescriptor_when42() {
    // Arrange, Act and Assert
    assertNull(DynamicProtoUtils.getDescriptor("42", "Schema Name"));
  }

  /**
   * Test {@link DynamicProtoUtils#getDescriptor(String, String)}.
   *
   * <ul>
   *   <li>When {@link DataConstants#DEFAULT_SECRET_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#getDescriptor(String, String)}
   */
  @Test
  @DisplayName("Test getDescriptor(String, String); when DEFAULT_SECRET_KEY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptor DynamicProtoUtils.getDescriptor(String, String)"})
  void testGetDescriptor_whenDefault_secret_key() {
    // Arrange, Act and Assert
    assertNull(DynamicProtoUtils.getDescriptor(DataConstants.DEFAULT_SECRET_KEY, "Schema Name"));
  }

  /**
   * Test {@link DynamicProtoUtils#getDescriptor(String, String)}.
   *
   * <ul>
   *   <li>When {@code Failed to get Message Descriptor due to {}}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#getDescriptor(String, String)}
   */
  @Test
  @DisplayName(
      "Test getDescriptor(String, String); when 'Failed to get Message Descriptor due to {}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptor DynamicProtoUtils.getDescriptor(String, String)"})
  void testGetDescriptor_whenFailedToGetMessageDescriptorDueTo() {
    // Arrange, Act and Assert
    assertNull(
        DynamicProtoUtils.getDescriptor(
            "Failed to get Message Descriptor due to {}", "Schema Name"));
  }

  /**
   * Test {@link DynamicProtoUtils#getDescriptor(String, String)}.
   *
   * <ul>
   *   <li>When {@code DynamicProtoUtils}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#getDescriptor(String, String)}
   */
  @Test
  @DisplayName(
      "Test getDescriptor(String, String); when 'org.thingsboard.server.common.data.DynamicProtoUtils'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptor DynamicProtoUtils.getDescriptor(String, String)"})
  void testGetDescriptor_whenOrgThingsboardServerCommonDataDynamicProtoUtils() {
    // Arrange, Act and Assert
    assertNull(
        DynamicProtoUtils.getDescriptor(
            "org.thingsboard.server.common.data.DynamicProtoUtils", "Schema Name"));
  }

  /**
   * Test {@link DynamicProtoUtils#getDescriptor(String, String)}.
   *
   * <ul>
   *   <li>When {@code Proto Schema}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#getDescriptor(String, String)}
   */
  @Test
  @DisplayName("Test getDescriptor(String, String); when 'Proto Schema'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptor DynamicProtoUtils.getDescriptor(String, String)"})
  void testGetDescriptor_whenProtoSchema() {
    // Arrange, Act and Assert
    assertNull(DynamicProtoUtils.getDescriptor("Proto Schema", "Schema Name"));
  }

  /**
   * Test {@link DynamicProtoUtils#getDescriptor(String, String)}.
   *
   * <ul>
   *   <li>When {@link DynamicProtoUtils#PROTO_3_SYNTAX}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#getDescriptor(String, String)}
   */
  @Test
  @DisplayName("Test getDescriptor(String, String); when PROTO_3_SYNTAX")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptor DynamicProtoUtils.getDescriptor(String, String)"})
  void testGetDescriptor_whenProto_3_syntax() {
    // Arrange, Act and Assert
    assertNull(
        DynamicProtoUtils.getDescriptor(
            DataConstants.DEFAULT_SECRET_KEY, DynamicProtoUtils.PROTO_3_SYNTAX));
  }

  /**
   * Test {@link DynamicProtoUtils#getDynamicMessageBuilder(String, String)}.
   *
   * <ul>
   *   <li>When {@link DataConstants#DEFAULT_SECRET_KEY}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#getDynamicMessageBuilder(String, String)}
   */
  @Test
  @DisplayName(
      "Test getDynamicMessageBuilder(String, String); when DEFAULT_SECRET_KEY; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder DynamicProtoUtils.getDynamicMessageBuilder(String, String)"})
  void testGetDynamicMessageBuilder_whenDefault_secret_key_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            DynamicProtoUtils.getDynamicMessageBuilder(
                DataConstants.DEFAULT_SECRET_KEY, "Schema Name"));
  }

  /**
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   *
   * <p>Method under test: {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "com.github.os72.protobuf.dynamic.DynamicSchema DynamicProtoUtils.getDynamicSchema(ProtoFileElement, String)"
  })
  void testGetDynamicSchema() {
    // Arrange
    ArrayList<String> imports = new ArrayList<>();
    ArrayList<String> publicImports = new ArrayList<>();
    ArrayList<TypeElement> types = new ArrayList<>();
    ArrayList<ServiceElement> services = new ArrayList<>();
    ArrayList<ExtendElement> extendDeclarations = new ArrayList<>();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            DynamicProtoUtils.getDynamicSchema(
                new ProtoFileElement(
                    DynamicProtoUtils.LOCATION,
                    "java.text",
                    Syntax.PROTO_2,
                    imports,
                    publicImports,
                    types,
                    services,
                    extendDeclarations,
                    new ArrayList<>()),
                "Schema Name"));
  }

  /**
   * Test {@link DynamicProtoUtils#getProtoFileElement(String)}.
   *
   * <ul>
   *   <li>When {@link DataConstants#DEFAULT_SECRET_KEY}.
   *   <li>Then return component3 is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#getProtoFileElement(String)}
   */
  @Test
  @DisplayName(
      "Test getProtoFileElement(String); when DEFAULT_SECRET_KEY; then return component3 is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoFileElement DynamicProtoUtils.getProtoFileElement(String)"})
  void testGetProtoFileElement_whenDefault_secret_key_thenReturnComponent3IsNull() {
    // Arrange and Act
    ProtoFileElement actualProtoFileElement =
        DynamicProtoUtils.getProtoFileElement(DataConstants.DEFAULT_SECRET_KEY);

    // Assert
    assertNull(actualProtoFileElement.component3());
    assertNull(actualProtoFileElement.getSyntax());
    assertNull(actualProtoFileElement.component2());
    assertNull(actualProtoFileElement.getPackageName());
    List<String> component4Result = actualProtoFileElement.component4();
    assertTrue(component4Result.isEmpty());
    List<String> component5Result = actualProtoFileElement.component5();
    assertTrue(component5Result.isEmpty());
    List<TypeElement> component6Result = actualProtoFileElement.component6();
    assertTrue(component6Result.isEmpty());
    List<ServiceElement> component7Result = actualProtoFileElement.component7();
    assertTrue(component7Result.isEmpty());
    List<ExtendElement> component8Result = actualProtoFileElement.component8();
    assertTrue(component8Result.isEmpty());
    List<OptionElement> component9Result = actualProtoFileElement.component9();
    assertTrue(component9Result.isEmpty());
    assertSame(component4Result, actualProtoFileElement.getImports());
    assertSame(component5Result, actualProtoFileElement.getPublicImports());
    assertSame(component6Result, actualProtoFileElement.getTypes());
    assertSame(component7Result, actualProtoFileElement.getServices());
    assertSame(component8Result, actualProtoFileElement.getExtendDeclarations());
    assertSame(component9Result, actualProtoFileElement.getOptions());
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   *
   * <ul>
   *   <li>Then return {@code {}}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}
   */
  @Test
  @DisplayName("Test dynamicMsgToJson(Descriptor, byte[]); then return '{}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptor, byte[])"})
  void testDynamicMsgToJson_thenReturnLeftCurlyBracketRightCurlyBracket()
      throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals("{}", DynamicProtoUtils.dynamicMsgToJson(Any.getDescriptor(), new byte[] {}));
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@code X}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}
   */
  @Test
  @DisplayName(
      "Test dynamicMsgToJson(Descriptor, byte[]); when array of byte with 'A' and 'X'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptor, byte[])"})
  void testDynamicMsgToJson_whenArrayOfByteWithAAndX_thenReturnAString()
      throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals(
        "{\n"
            + "  \"name\": \"\",\n"
            + "  \"field\": [],\n"
            + "  \"nestedType\": [],\n"
            + "  \"enumType\": [],\n"
            + "  \"extensionRange\": [],\n"
            + "  \"extension\": [],\n"
            + "  \"oneofDecl\": [],\n"
            + "  \"reservedRange\": [],\n"
            + "  \"reservedName\": []\n"
            + "}",
        DynamicProtoUtils.dynamicMsgToJson(
            DescriptorProto.getDescriptor(),
            new byte[] {
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              Byte.MIN_VALUE,
              'A',
              'X'
            }));
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}
   */
  @Test
  @DisplayName(
      "Test dynamicMsgToJson(Descriptor, byte[]); when array of byte with MIN_VALUE and 'X'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptor, byte[])"})
  void testDynamicMsgToJson_whenArrayOfByteWithMin_valueAndX_thenReturnAString()
      throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals(
        "{\n"
            + "  \"name\": \"\",\n"
            + "  \"field\": [],\n"
            + "  \"nestedType\": [],\n"
            + "  \"enumType\": [],\n"
            + "  \"extensionRange\": [],\n"
            + "  \"extension\": [],\n"
            + "  \"oneofDecl\": [],\n"
            + "  \"reservedRange\": [],\n"
            + "  \"reservedName\": []\n"
            + "}",
        DynamicProtoUtils.dynamicMsgToJson(
            DescriptorProto.getDescriptor(),
            new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}
   */
  @Test
  @DisplayName(
      "Test dynamicMsgToJson(Descriptor, byte[]); when array of byte with MIN_VALUE and 'X'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptor, byte[])"})
  void testDynamicMsgToJson_whenArrayOfByteWithMin_valueAndX_thenReturnAString2()
      throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals(
        "{\n"
            + "  \"name\": \"\",\n"
            + "  \"field\": [],\n"
            + "  \"nestedType\": [],\n"
            + "  \"enumType\": [],\n"
            + "  \"extensionRange\": [],\n"
            + "  \"extension\": [],\n"
            + "  \"oneofDecl\": [],\n"
            + "  \"reservedRange\": [],\n"
            + "  \"reservedName\": []\n"
            + "}",
        DynamicProtoUtils.dynamicMsgToJson(
            DescriptorProto.getDescriptor(),
            new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', -1, 'X'}));
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}
   */
  @Test
  @DisplayName(
      "Test dynamicMsgToJson(Descriptor, byte[]); when array of byte with MIN_VALUE and 'X'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptor, byte[])"})
  void testDynamicMsgToJson_whenArrayOfByteWithMin_valueAndX_thenReturnAString3()
      throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals(
        "{\n"
            + "  \"name\": \"\",\n"
            + "  \"package\": \"\",\n"
            + "  \"dependency\": [],\n"
            + "  \"messageType\": [],\n"
            + "  \"enumType\": [],\n"
            + "  \"service\": [],\n"
            + "  \"extension\": [],\n"
            + "  \"publicDependency\": [],\n"
            + "  \"weakDependency\": [65],\n"
            + "  \"syntax\": \"\",\n"
            + "  \"edition\": \"EDITION_UNKNOWN\"\n"
            + "}",
        DynamicProtoUtils.dynamicMsgToJson(
            FileDescriptorProto.getDescriptor(),
            new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}));
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}
   */
  @Test
  @DisplayName(
      "Test dynamicMsgToJson(Descriptor, byte[]); when array of byte with MIN_VALUE and 'X'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptor, byte[])"})
  void testDynamicMsgToJson_whenArrayOfByteWithMin_valueAndX_thenReturnAString4()
      throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals(
        "{\n"
            + "  \"name\": \"\",\n"
            + "  \"package\": \"\",\n"
            + "  \"dependency\": [],\n"
            + "  \"messageType\": [],\n"
            + "  \"enumType\": [],\n"
            + "  \"service\": [],\n"
            + "  \"extension\": [],\n"
            + "  \"publicDependency\": [],\n"
            + "  \"weakDependency\": [65, 11391],\n"
            + "  \"syntax\": \"\",\n"
            + "  \"edition\": \"EDITION_UNKNOWN\"\n"
            + "}",
        DynamicProtoUtils.dynamicMsgToJson(
            FileDescriptorProto.getDescriptor(),
            new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', -1, 'X'}));
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}
   */
  @Test
  @DisplayName(
      "Test dynamicMsgToJson(Descriptor, byte[]); when empty array of byte; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptor, byte[])"})
  void testDynamicMsgToJson_whenEmptyArrayOfByte_thenReturnAString()
      throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals(
        "{\n"
            + "  \"name\": \"\",\n"
            + "  \"field\": [],\n"
            + "  \"nestedType\": [],\n"
            + "  \"enumType\": [],\n"
            + "  \"extensionRange\": [],\n"
            + "  \"extension\": [],\n"
            + "  \"oneofDecl\": [],\n"
            + "  \"reservedRange\": [],\n"
            + "  \"reservedName\": []\n"
            + "}",
        DynamicProtoUtils.dynamicMsgToJson(DescriptorProto.getDescriptor(), new byte[] {}));
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code ""}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}
   */
  @Test
  @DisplayName(
      "Test dynamicMsgToJson(Descriptor, byte[]); when empty array of byte; then return '\"\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptor, byte[])"})
  void testDynamicMsgToJson_whenEmptyArrayOfByte_thenReturnQuotationMarkQuotationMark()
      throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals(
        "\"\"", DynamicProtoUtils.dynamicMsgToJson(BytesValue.getDescriptor(), new byte[] {}));
  }

  /**
   * Test {@link DynamicProtoUtils#jsonToDynamicMessage(Builder, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return SerializedSize is three.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#jsonToDynamicMessage(Builder, String)}
   */
  @Test
  @DisplayName(
      "Test jsonToDynamicMessage(Builder, String); when '42'; then return SerializedSize is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicMessage DynamicProtoUtils.jsonToDynamicMessage(Builder, String)"})
  void testJsonToDynamicMessage_when42_thenReturnSerializedSizeIsThree()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    DynamicMessage actualJsonToDynamicMessageResult =
        DynamicProtoUtils.jsonToDynamicMessage(
            DynamicMessage.newBuilder(BytesValue.getDescriptor()), "42");

    // Assert
    assertEquals(3, actualJsonToDynamicMessageResult.getSerializedSize());
    DynamicMessage defaultInstanceForType =
        actualJsonToDynamicMessageResult.getDefaultInstanceForType();
    assertEquals(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualJsonToDynamicMessageResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link DynamicProtoUtils#jsonToDynamicMessage(Builder, String)}.
   *
   * <ul>
   *   <li>When {@code Payload}.
   *   <li>Then return SerializedSize is seven.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#jsonToDynamicMessage(Builder, String)}
   */
  @Test
  @DisplayName(
      "Test jsonToDynamicMessage(Builder, String); when 'Payload'; then return SerializedSize is seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicMessage DynamicProtoUtils.jsonToDynamicMessage(Builder, String)"})
  void testJsonToDynamicMessage_whenPayload_thenReturnSerializedSizeIsSeven()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    DynamicMessage actualJsonToDynamicMessageResult =
        DynamicProtoUtils.jsonToDynamicMessage(
            DynamicMessage.newBuilder(BytesValue.getDescriptor()), "Payload");

    // Assert
    assertEquals(7, actualJsonToDynamicMessageResult.getSerializedSize());
    DynamicMessage defaultInstanceForType =
        actualJsonToDynamicMessageResult.getDefaultInstanceForType();
    assertEquals(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualJsonToDynamicMessageResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}
   */
  @Test
  @DisplayName("Test validateProtoSchema(String, String, String); when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DynamicProtoUtils.validateProtoSchema(String, String, String)"})
  void testValidateProtoSchema_when42() throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> DynamicProtoUtils.validateProtoSchema("42", "Schema Name", "Exception Prefix"));
  }

  /**
   * Test {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}.
   *
   * <ul>
   *   <li>When {@link DataConstants#DEFAULT_SECRET_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}
   */
  @Test
  @DisplayName("Test validateProtoSchema(String, String, String); when DEFAULT_SECRET_KEY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DynamicProtoUtils.validateProtoSchema(String, String, String)"})
  void testValidateProtoSchema_whenDefault_secret_key() throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            DynamicProtoUtils.validateProtoSchema(
                DataConstants.DEFAULT_SECRET_KEY, "Schema Name", "Exception Prefix"));
  }

  /**
   * Test {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code DynamicProtoUtils}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test validateProtoSchema(String, String, String); when 'org.thingsboard.server.common.data.DynamicProtoUtils'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DynamicProtoUtils.validateProtoSchema(String, String, String)"})
  void testValidateProtoSchema_whenOrgThingsboardServerCommonDataDynamicProtoUtils()
      throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            DynamicProtoUtils.validateProtoSchema(
                "org.thingsboard.server.common.data.DynamicProtoUtils",
                "Schema Name",
                "Exception Prefix"));
  }

  /**
   * Test {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Schema}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}
   */
  @Test
  @DisplayName("Test validateProtoSchema(String, String, String); when 'Schema'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DynamicProtoUtils.validateProtoSchema(String, String, String)"})
  void testValidateProtoSchema_whenSchema() throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> DynamicProtoUtils.validateProtoSchema("Schema", "Schema Name", "Exception Prefix"));
  }

  /**
   * Test {@link DynamicProtoUtils#invalidSchemaProvidedMessage(String, String)}.
   *
   * <p>Method under test: {@link DynamicProtoUtils#invalidSchemaProvidedMessage(String, String)}
   */
  @Test
  @DisplayName("Test invalidSchemaProvidedMessage(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DynamicProtoUtils.invalidSchemaProvidedMessage(String, String)"})
  void testInvalidSchemaProvidedMessage() {
    // Arrange, Act and Assert
    assertEquals(
        "Exception Prefix invalid Schema Name provided!",
        DynamicProtoUtils.invalidSchemaProvidedMessage("Schema Name", "Exception Prefix"));
  }
}
