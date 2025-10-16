/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Any;
import com.google.protobuf.Api;
import com.google.protobuf.BytesValue;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.Descriptors;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Descriptors.Descriptor DynamicProtoUtils.getDescriptor(String, String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Descriptors.Descriptor DynamicProtoUtils.getDescriptor(String, String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Descriptors.Descriptor DynamicProtoUtils.getDescriptor(String, String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Descriptors.Descriptor DynamicProtoUtils.getDescriptor(String, String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Descriptors.Descriptor DynamicProtoUtils.getDescriptor(String, String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Descriptors.Descriptor DynamicProtoUtils.getDescriptor(String, String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

    ProtoFileElement protoFileElement =
        new ProtoFileElement(
            DynamicProtoUtils.LOCATION,
            "java.text",
            Syntax.PROTO_2,
            imports,
            publicImports,
            types,
            services,
            extendDeclarations,
            new ArrayList<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> DynamicProtoUtils.getDynamicSchema(protoFileElement, "Schema Name"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * <p>Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptors.Descriptor,
   * byte[])}
   */
  @Test
  @DisplayName("Test dynamicMsgToJson(Descriptor, byte[]); then return '{}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptors.Descriptor, byte[])"})
  void testDynamicMsgToJson_thenReturnLeftCurlyBracketRightCurlyBracket()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    String actualDynamicMsgToJsonResult =
        DynamicProtoUtils.dynamicMsgToJson(Any.Builder.getDescriptor(), new byte[] {});

    // Assert
    assertEquals("{}", actualDynamicMsgToJsonResult);
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   *
   * <ul>
   *   <li>Then return {@code {}}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptors.Descriptor,
   * byte[])}
   */
  @Test
  @DisplayName("Test dynamicMsgToJson(Descriptor, byte[]); then return '{}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptors.Descriptor, byte[])"})
  void testDynamicMsgToJson_thenReturnLeftCurlyBracketRightCurlyBracket2()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    String actualDynamicMsgToJsonResult =
        DynamicProtoUtils.dynamicMsgToJson(Any.getDescriptor(), new byte[] {});

    // Assert
    assertEquals("{}", actualDynamicMsgToJsonResult);
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   *
   * <ul>
   *   <li>Then return {@code { "name": "", "methods": [], "options": [], "version": "", "mixins":
   *       [], "syntax": "SYNTAX_PROTO2" }}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptors.Descriptor,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test dynamicMsgToJson(Descriptor, byte[]); then return '{ \"name\": \"\", \"methods\": [], \"options\": [], \"version\": \"\", \"mixins\": [], \"syntax\": \"SYNTAX_PROTO2\" }'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptors.Descriptor, byte[])"})
  void testDynamicMsgToJson_thenReturnNameMethodsOptionsVersionMixinsSyntaxSyntaxProto2()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    String actualDynamicMsgToJsonResult =
        DynamicProtoUtils.dynamicMsgToJson(Api.getDescriptor(), new byte[] {});

    // Assert
    assertEquals(
        "{\n"
            + "  \"name\": \"\",\n"
            + "  \"methods\": [],\n"
            + "  \"options\": [],\n"
            + "  \"version\": \"\",\n"
            + "  \"mixins\": [],\n"
            + "  \"syntax\": \"SYNTAX_PROTO2\"\n"
            + "}",
        actualDynamicMsgToJsonResult);
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   *
   * <ul>
   *   <li>Then return {@code { "name": "", "methods": [], "options": [], "version": "", "mixins":
   *       [], "syntax": "SYNTAX_PROTO2" }}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptors.Descriptor,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test dynamicMsgToJson(Descriptor, byte[]); then return '{ \"name\": \"\", \"methods\": [], \"options\": [], \"version\": \"\", \"mixins\": [], \"syntax\": \"SYNTAX_PROTO2\" }'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptors.Descriptor, byte[])"})
  void testDynamicMsgToJson_thenReturnNameMethodsOptionsVersionMixinsSyntaxSyntaxProto22()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    String actualDynamicMsgToJsonResult =
        DynamicProtoUtils.dynamicMsgToJson(
            Api.getDescriptor(),
            new byte[] {
              'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'
            });

    // Assert
    assertEquals(
        "{\n"
            + "  \"name\": \"\",\n"
            + "  \"methods\": [],\n"
            + "  \"options\": [],\n"
            + "  \"version\": \"\",\n"
            + "  \"mixins\": [],\n"
            + "  \"syntax\": \"SYNTAX_PROTO2\"\n"
            + "}",
        actualDynamicMsgToJsonResult);
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@code X}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptors.Descriptor,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test dynamicMsgToJson(Descriptor, byte[]); when array of byte with 'A' and 'X'; then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptors.Descriptor, byte[])"})
  void testDynamicMsgToJson_whenArrayOfByteWithAAndX_thenReturnAString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    String actualDynamicMsgToJsonResult =
        DynamicProtoUtils.dynamicMsgToJson(
            DescriptorProto.getDescriptor(),
            new byte[] {
              'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'
            });

    // Assert
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
        actualDynamicMsgToJsonResult);
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code ""}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptors.Descriptor,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test dynamicMsgToJson(Descriptor, byte[]); when empty array of byte; then return '\"\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptors.Descriptor, byte[])"})
  void testDynamicMsgToJson_whenEmptyArrayOfByte_thenReturnQuotationMarkQuotationMark()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    String actualDynamicMsgToJsonResult =
        DynamicProtoUtils.dynamicMsgToJson(BytesValue.getDescriptor(), new byte[] {});

    // Assert
    assertEquals("\"\"", actualDynamicMsgToJsonResult);
  }

  /**
   * Test {@link DynamicProtoUtils#jsonToDynamicMessage(Builder, String)}.
   *
   * <ul>
   *   <li>Given newBuilder build.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#jsonToDynamicMessage(Builder, String)}
   */
  @Test
  @DisplayName("Test jsonToDynamicMessage(Builder, String); given newBuilder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DynamicMessage DynamicProtoUtils.jsonToDynamicMessage(Builder, String)"})
  void testJsonToDynamicMessage_givenNewBuilderBuild() throws InvalidProtocolBufferException {
    // Arrange
    Descriptor type = BytesValue.getDescriptor();

    Builder builder = DynamicMessage.newBuilder(type);
    builder.setUnknownFields(UnknownFieldSet.newBuilder().build());

    // Act
    DynamicMessage actualJsonToDynamicMessageResult =
        DynamicProtoUtils.jsonToDynamicMessage(builder, "Payload");

    // Assert
    assertEquals(1, actualJsonToDynamicMessageResult.getAllFields().size());
    assertEquals(7, actualJsonToDynamicMessageResult.getSerializedSize());
    assertTrue(actualJsonToDynamicMessageResult.isInitialized());
    assertTrue(actualJsonToDynamicMessageResult.findInitializationErrors().isEmpty());
    assertEquals(
        DataConstants.DEFAULT_SECRET_KEY,
        actualJsonToDynamicMessageResult.getInitializationErrorString());
    assertSame(type, actualJsonToDynamicMessageResult.getDescriptorForType());
  }

  /**
   * Test {@link DynamicProtoUtils#jsonToDynamicMessage(Builder, String)}.
   *
   * <ul>
   *   <li>When newBuilder Descriptor.
   *   <li>Then return AllFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicProtoUtils#jsonToDynamicMessage(Builder, String)}
   */
  @Test
  @DisplayName(
      "Test jsonToDynamicMessage(Builder, String); when newBuilder Descriptor; then return AllFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DynamicMessage DynamicProtoUtils.jsonToDynamicMessage(Builder, String)"})
  void testJsonToDynamicMessage_whenNewBuilderDescriptor_thenReturnAllFieldsSizeIsOne()
      throws InvalidProtocolBufferException {
    // Arrange
    Descriptor type = BytesValue.getDescriptor();

    // Act
    DynamicMessage actualJsonToDynamicMessageResult =
        DynamicProtoUtils.jsonToDynamicMessage(DynamicMessage.newBuilder(type), "Payload");

    // Assert
    assertEquals(1, actualJsonToDynamicMessageResult.getAllFields().size());
    assertEquals(7, actualJsonToDynamicMessageResult.getSerializedSize());
    assertTrue(actualJsonToDynamicMessageResult.isInitialized());
    assertTrue(actualJsonToDynamicMessageResult.findInitializationErrors().isEmpty());
    assertEquals(
        DataConstants.DEFAULT_SECRET_KEY,
        actualJsonToDynamicMessageResult.getInitializationErrorString());
    assertSame(type, actualJsonToDynamicMessageResult.getDescriptorForType());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DynamicProtoUtils.invalidSchemaProvidedMessage(String, String)"})
  void testInvalidSchemaProvidedMessage() {
    // Arrange, Act and Assert
    assertEquals(
        "Exception Prefix invalid Schema Name provided!",
        DynamicProtoUtils.invalidSchemaProvidedMessage("Schema Name", "Exception Prefix"));
  }
}
