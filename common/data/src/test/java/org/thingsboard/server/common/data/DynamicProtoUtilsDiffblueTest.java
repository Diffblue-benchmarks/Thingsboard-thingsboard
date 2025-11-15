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
import com.google.protobuf.Any;
import com.google.protobuf.Api;
import com.google.protobuf.BytesValue;
import com.google.protobuf.Descriptors;
import com.google.protobuf.InvalidProtocolBufferException;
import com.squareup.wire.Syntax;
import com.squareup.wire.schema.Field;
import com.squareup.wire.schema.Location;
import com.squareup.wire.schema.internal.parser.EnumElement;
import com.squareup.wire.schema.internal.parser.ExtendElement;
import com.squareup.wire.schema.internal.parser.ExtensionsElement;
import com.squareup.wire.schema.internal.parser.FieldElement;
import com.squareup.wire.schema.internal.parser.MessageElement;
import com.squareup.wire.schema.internal.parser.OneOfElement;
import com.squareup.wire.schema.internal.parser.OptionElement;
import com.squareup.wire.schema.internal.parser.ProtoFileElement;
import com.squareup.wire.schema.internal.parser.ReservedElement;
import com.squareup.wire.schema.internal.parser.ServiceElement;
import com.squareup.wire.schema.internal.parser.TypeElement;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class DynamicProtoUtilsDiffblueTest {
  /**
   * Method under test: {@link DynamicProtoUtils#getDescriptor(String, String)}
   */
  @Test
  void testGetDescriptor() {
    // Arrange, Act and Assert
    assertNull(DynamicProtoUtils.getDescriptor("Proto Schema", "Schema Name"));
    assertNull(DynamicProtoUtils.getDescriptor(DataConstants.DEFAULT_SECRET_KEY, "Schema Name"));
    assertNull(DynamicProtoUtils.getDescriptor("42", "Schema Name"));
    assertNull(DynamicProtoUtils.getDescriptor("org.thingsboard.server.common.data.DynamicProtoUtils", "Schema Name"));
    assertNull(DynamicProtoUtils.getDescriptor(DataConstants.DEFAULT_SECRET_KEY, DynamicProtoUtils.PROTO_3_SYNTAX));
  }

  /**
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicMessageBuilder(String, String)}
   */
  @Test
  void testGetDynamicMessageBuilder() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> DynamicProtoUtils.getDynamicMessageBuilder(DataConstants.DEFAULT_SECRET_KEY, "Schema Name"));
  }

  /**
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  void testGetDynamicSchema() {
    // Arrange
    ArrayList<String> imports = new ArrayList<>();
    ArrayList<String> publicImports = new ArrayList<>();
    ArrayList<TypeElement> types = new ArrayList<>();
    ArrayList<ServiceElement> services = new ArrayList<>();
    ArrayList<ExtendElement> extendDeclarations = new ArrayList<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> DynamicProtoUtils.getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text",
            Syntax.PROTO_2, imports, publicImports, types, services, extendDeclarations, new ArrayList<>()),
            "Schema Name"));
  }

  /**
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  void testGetDynamicSchema2() {
    // Arrange
    ArrayList<String> imports = new ArrayList<>();
    ArrayList<String> publicImports = new ArrayList<>();
    ArrayList<TypeElement> types = new ArrayList<>();
    ArrayList<ServiceElement> services = new ArrayList<>();
    ArrayList<ExtendElement> extendDeclarations = new ArrayList<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> DynamicProtoUtils.getDynamicSchema(
            new ProtoFileElement(DynamicProtoUtils.LOCATION, DataConstants.DEFAULT_SECRET_KEY, Syntax.PROTO_2, imports,
                publicImports, types, services, extendDeclarations, new ArrayList<>()),
            "Schema Name"));
  }

  /**
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  void testGetDynamicSchema3() {
    // Arrange
    ArrayList<TypeElement> types = new ArrayList<>();
    ArrayList<OptionElement> options = new ArrayList<>();
    types.add(new EnumElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, options, new ArrayList<>()));
    ArrayList<String> imports = new ArrayList<>();
    ArrayList<String> publicImports = new ArrayList<>();
    ArrayList<ServiceElement> services = new ArrayList<>();
    ArrayList<ExtendElement> extendDeclarations = new ArrayList<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> DynamicProtoUtils.getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text",
            Syntax.PROTO_2, imports, publicImports, types, services, extendDeclarations, new ArrayList<>()),
            "Schema Name"));
  }

  /**
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  void testGetDynamicSchema4() {
    // Arrange
    ArrayList<TypeElement> types = new ArrayList<>();
    ArrayList<OptionElement> options = new ArrayList<>();
    types.add(new EnumElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, options, new ArrayList<>()));
    ArrayList<OptionElement> options2 = new ArrayList<>();
    types.add(new EnumElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, options2, new ArrayList<>()));
    ArrayList<String> imports = new ArrayList<>();
    ArrayList<String> publicImports = new ArrayList<>();
    ArrayList<ServiceElement> services = new ArrayList<>();
    ArrayList<ExtendElement> extendDeclarations = new ArrayList<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> DynamicProtoUtils.getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text",
            Syntax.PROTO_2, imports, publicImports, types, services, extendDeclarations, new ArrayList<>()),
            "Schema Name"));
  }

  /**
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  void testGetDynamicSchema5() {
    // Arrange
    ArrayList<TypeElement> types = new ArrayList<>();
    ArrayList<TypeElement> nestedTypes = new ArrayList<>();
    ArrayList<OptionElement> options = new ArrayList<>();
    ArrayList<ReservedElement> reserveds = new ArrayList<>();
    ArrayList<FieldElement> fields = new ArrayList<>();
    ArrayList<OneOfElement> oneOfs = new ArrayList<>();
    ArrayList<ExtensionsElement> extensions = new ArrayList<>();
    types.add(new MessageElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, nestedTypes, options, reserveds, fields, oneOfs, extensions,
        new ArrayList<>()));
    ArrayList<OptionElement> options2 = new ArrayList<>();
    types.add(new EnumElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, options2, new ArrayList<>()));
    ArrayList<String> imports = new ArrayList<>();
    ArrayList<String> publicImports = new ArrayList<>();
    ArrayList<ServiceElement> services = new ArrayList<>();
    ArrayList<ExtendElement> extendDeclarations = new ArrayList<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> DynamicProtoUtils.getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text",
            Syntax.PROTO_2, imports, publicImports, types, services, extendDeclarations, new ArrayList<>()),
            "Schema Name"));
  }

  /**
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  void testGetDynamicSchema6() {
    // Arrange
    ArrayList<TypeElement> nestedTypes = new ArrayList<>();
    ArrayList<OptionElement> options = new ArrayList<>();
    nestedTypes.add(new EnumElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, options, new ArrayList<>()));
    ArrayList<OptionElement> options2 = new ArrayList<>();
    ArrayList<ReservedElement> reserveds = new ArrayList<>();
    ArrayList<FieldElement> fields = new ArrayList<>();
    ArrayList<OneOfElement> oneOfs = new ArrayList<>();
    ArrayList<ExtensionsElement> extensions = new ArrayList<>();
    MessageElement messageElement = new MessageElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, nestedTypes, options2, reserveds, fields, oneOfs, extensions,
        new ArrayList<>());

    ArrayList<TypeElement> types = new ArrayList<>();
    types.add(messageElement);
    ArrayList<String> imports = new ArrayList<>();
    ArrayList<String> publicImports = new ArrayList<>();
    ArrayList<ServiceElement> services = new ArrayList<>();
    ArrayList<ExtendElement> extendDeclarations = new ArrayList<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> DynamicProtoUtils.getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text",
            Syntax.PROTO_2, imports, publicImports, types, services, extendDeclarations, new ArrayList<>()),
            "Schema Name"));
  }

  /**
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  void testGetDynamicSchema7() {
    // Arrange
    ArrayList<TypeElement> nestedTypes = new ArrayList<>();
    ArrayList<OptionElement> options = new ArrayList<>();
    nestedTypes.add(new EnumElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, options, new ArrayList<>()));
    ArrayList<OptionElement> options2 = new ArrayList<>();
    nestedTypes.add(new EnumElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, options2, new ArrayList<>()));
    ArrayList<OptionElement> options3 = new ArrayList<>();
    ArrayList<ReservedElement> reserveds = new ArrayList<>();
    ArrayList<FieldElement> fields = new ArrayList<>();
    ArrayList<OneOfElement> oneOfs = new ArrayList<>();
    ArrayList<ExtensionsElement> extensions = new ArrayList<>();
    MessageElement messageElement = new MessageElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, nestedTypes, options3, reserveds, fields, oneOfs, extensions,
        new ArrayList<>());

    ArrayList<TypeElement> types = new ArrayList<>();
    types.add(messageElement);
    ArrayList<String> imports = new ArrayList<>();
    ArrayList<String> publicImports = new ArrayList<>();
    ArrayList<ServiceElement> services = new ArrayList<>();
    ArrayList<ExtendElement> extendDeclarations = new ArrayList<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> DynamicProtoUtils.getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text",
            Syntax.PROTO_2, imports, publicImports, types, services, extendDeclarations, new ArrayList<>()),
            "Schema Name"));
  }

  /**
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  void testGetDynamicSchema8() {
    // Arrange
    ArrayList<FieldElement> fields = new ArrayList<>();
    fields.add(new FieldElement(DynamicProtoUtils.LOCATION, Field.Label.OPTIONAL, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, "42", DynamicProtoUtils.PROTO_3_SYNTAX, 1, DynamicProtoUtils.PROTO_3_SYNTAX,
        new ArrayList<>()));
    fields.add(new FieldElement(DynamicProtoUtils.LOCATION, Field.Label.OPTIONAL, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, "42", DynamicProtoUtils.PROTO_3_SYNTAX, 1, DynamicProtoUtils.PROTO_3_SYNTAX,
        new ArrayList<>()));
    ArrayList<TypeElement> nestedTypes = new ArrayList<>();
    ArrayList<OptionElement> options = new ArrayList<>();
    ArrayList<ReservedElement> reserveds = new ArrayList<>();
    ArrayList<OneOfElement> oneOfs = new ArrayList<>();
    ArrayList<ExtensionsElement> extensions = new ArrayList<>();
    MessageElement messageElement = new MessageElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, nestedTypes, options, reserveds, fields, oneOfs, extensions,
        new ArrayList<>());

    ArrayList<TypeElement> types = new ArrayList<>();
    types.add(messageElement);
    ArrayList<String> imports = new ArrayList<>();
    ArrayList<String> publicImports = new ArrayList<>();
    ArrayList<ServiceElement> services = new ArrayList<>();
    ArrayList<ExtendElement> extendDeclarations = new ArrayList<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> DynamicProtoUtils.getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text",
            Syntax.PROTO_2, imports, publicImports, types, services, extendDeclarations, new ArrayList<>()),
            "Schema Name"));
  }

  /**
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  void testGetDynamicSchema9() {
    // Arrange
    ArrayList<TypeElement> types = new ArrayList<>();
    ArrayList<OptionElement> options = new ArrayList<>();
    types.add(new EnumElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, options, new ArrayList<>()));
    ArrayList<TypeElement> nestedTypes = new ArrayList<>();
    ArrayList<OptionElement> options2 = new ArrayList<>();
    ArrayList<ReservedElement> reserveds = new ArrayList<>();
    ArrayList<FieldElement> fields = new ArrayList<>();
    ArrayList<OneOfElement> oneOfs = new ArrayList<>();
    ArrayList<ExtensionsElement> extensions = new ArrayList<>();
    types.add(new MessageElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, nestedTypes, options2, reserveds, fields, oneOfs, extensions,
        new ArrayList<>()));
    ArrayList<OptionElement> options3 = new ArrayList<>();
    types.add(new EnumElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, options3, new ArrayList<>()));
    ArrayList<String> imports = new ArrayList<>();
    ArrayList<String> publicImports = new ArrayList<>();
    ArrayList<ServiceElement> services = new ArrayList<>();
    ArrayList<ExtendElement> extendDeclarations = new ArrayList<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> DynamicProtoUtils.getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text",
            Syntax.PROTO_2, imports, publicImports, types, services, extendDeclarations, new ArrayList<>()),
            "Schema Name"));
  }

  /**
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  void testGetDynamicSchema10() {
    // Arrange
    ArrayList<FieldElement> fields = new ArrayList<>();
    fields.add(new FieldElement(DynamicProtoUtils.LOCATION, Field.Label.OPTIONAL, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, "42", DynamicProtoUtils.PROTO_3_SYNTAX, 1, DynamicProtoUtils.PROTO_3_SYNTAX,
        new ArrayList<>()));
    ArrayList<TypeElement> nestedTypes = new ArrayList<>();
    ArrayList<OptionElement> options = new ArrayList<>();
    ArrayList<ReservedElement> reserveds = new ArrayList<>();
    ArrayList<OneOfElement> oneOfs = new ArrayList<>();
    ArrayList<ExtensionsElement> extensions = new ArrayList<>();
    MessageElement messageElement = new MessageElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, nestedTypes, options, reserveds, fields, oneOfs, extensions,
        new ArrayList<>());

    ArrayList<TypeElement> types = new ArrayList<>();
    types.add(messageElement);
    ArrayList<OptionElement> options2 = new ArrayList<>();
    types.add(new EnumElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, options2, new ArrayList<>()));
    ArrayList<String> imports = new ArrayList<>();
    ArrayList<String> publicImports = new ArrayList<>();
    ArrayList<ServiceElement> services = new ArrayList<>();
    ArrayList<ExtendElement> extendDeclarations = new ArrayList<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> DynamicProtoUtils.getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text",
            Syntax.PROTO_2, imports, publicImports, types, services, extendDeclarations, new ArrayList<>()),
            "Schema Name"));
  }

  /**
   * Method under test: {@link DynamicProtoUtils#getProtoFileElement(String)}
   */
  @Test
  void testGetProtoFileElement() {
    // Arrange and Act
    ProtoFileElement actualProtoFileElement = DynamicProtoUtils.getProtoFileElement(DataConstants.DEFAULT_SECRET_KEY);

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
    Location component1Result = actualProtoFileElement.component1();
    assertEquals(DataConstants.DEFAULT_SECRET_KEY, component1Result.component1());
    assertEquals(DataConstants.DEFAULT_SECRET_KEY, component1Result.component2());
    assertEquals(DataConstants.DEFAULT_SECRET_KEY, component1Result.getBase());
    assertEquals(DataConstants.DEFAULT_SECRET_KEY, component1Result.getPath());
    assertEquals(StringUtils.INDEX_NOT_FOUND, component1Result.component3());
    assertEquals(StringUtils.INDEX_NOT_FOUND, component1Result.component4());
    assertEquals(StringUtils.INDEX_NOT_FOUND, component1Result.getColumn());
    assertEquals(StringUtils.INDEX_NOT_FOUND, component1Result.getLine());
    assertSame(component1Result, actualProtoFileElement.getLocation());
    assertSame(component4Result, actualProtoFileElement.getImports());
    assertSame(component5Result, actualProtoFileElement.getPublicImports());
    assertSame(component6Result, actualProtoFileElement.getTypes());
    assertSame(component7Result, actualProtoFileElement.getServices());
    assertSame(component8Result, actualProtoFileElement.getExtendDeclarations());
    assertSame(component9Result, actualProtoFileElement.getOptions());
  }

  /**
   * Method under test:
   * {@link DynamicProtoUtils#dynamicMsgToJson(Descriptors.Descriptor, byte[])}
   */
  @Test
  void testDynamicMsgToJson() throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals("{}", DynamicProtoUtils.dynamicMsgToJson(Any.getDescriptor(), new byte[]{}));
    assertEquals(
        "{\n" + "  \"name\": \"\",\n" + "  \"methods\": [],\n" + "  \"options\": [],\n" + "  \"version\": \"\",\n"
            + "  \"mixins\": [],\n" + "  \"syntax\": \"SYNTAX_PROTO2\"\n" + "}",
        DynamicProtoUtils.dynamicMsgToJson(Api.getDescriptor(), new byte[]{}));
    assertEquals("\"\"", DynamicProtoUtils.dynamicMsgToJson(BytesValue.getDescriptor(), new byte[]{}));
  }

  /**
   * Method under test:
   * {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}
   */
  @Test
  void testValidateProtoSchema() throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> DynamicProtoUtils.validateProtoSchema("Schema", "Schema Name", "Exception Prefix"));
    assertThrows(IllegalArgumentException.class, () -> DynamicProtoUtils
        .validateProtoSchema(DataConstants.DEFAULT_SECRET_KEY, "Schema Name", "Exception Prefix"));
    assertThrows(IllegalArgumentException.class,
        () -> DynamicProtoUtils.validateProtoSchema("42", "Schema Name", "Exception Prefix"));
    assertThrows(IllegalArgumentException.class,
        () -> DynamicProtoUtils.validateProtoSchema("org.thingsboard.server.common.data.DynamicProtoUtils",
            "Schema Name", "Exception Prefix"));
  }

  /**
   * Method under test:
   * {@link DynamicProtoUtils#invalidSchemaProvidedMessage(String, String)}
   */
  @Test
  void testInvalidSchemaProvidedMessage() {
    // Arrange, Act and Assert
    assertEquals("Exception Prefix invalid Schema Name provided!",
        DynamicProtoUtils.invalidSchemaProvidedMessage("Schema Name", "Exception Prefix"));
  }
}
