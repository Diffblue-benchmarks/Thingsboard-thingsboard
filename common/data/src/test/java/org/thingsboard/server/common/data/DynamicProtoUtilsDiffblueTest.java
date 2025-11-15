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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.github.os72.protobuf.dynamic.DynamicSchema;
import com.google.protobuf.Any;
import com.google.protobuf.Api;
import com.google.protobuf.BytesValue;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorSet;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.InvalidProtocolBufferException;
import com.squareup.wire.Syntax;
import com.squareup.wire.schema.Field;
import com.squareup.wire.schema.Field.Label;
import com.squareup.wire.schema.internal.parser.EnumElement;
import com.squareup.wire.schema.internal.parser.ExtendElement;
import com.squareup.wire.schema.internal.parser.ExtensionsElement;
import com.squareup.wire.schema.internal.parser.FieldElement;
import com.squareup.wire.schema.internal.parser.GroupElement;
import com.squareup.wire.schema.internal.parser.MessageElement;
import com.squareup.wire.schema.internal.parser.OneOfElement;
import com.squareup.wire.schema.internal.parser.OptionElement;
import com.squareup.wire.schema.internal.parser.ProtoFileElement;
import com.squareup.wire.schema.internal.parser.ReservedElement;
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
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDescriptor(String, String)}
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
   * <ul>
   *   <li>When {@link DataConstants#DEFAULT_SECRET_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDescriptor(String, String)}
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
   * <ul>
   *   <li>When {@code DynamicProtoUtils}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDescriptor(String, String)}
   */
  @Test
  @DisplayName("Test getDescriptor(String, String); when 'org.thingsboard.server.common.data.DynamicProtoUtils'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptor DynamicProtoUtils.getDescriptor(String, String)"})
  void testGetDescriptor_whenOrgThingsboardServerCommonDataDynamicProtoUtils() {
    // Arrange, Act and Assert
    assertNull(DynamicProtoUtils.getDescriptor("org.thingsboard.server.common.data.DynamicProtoUtils", "Schema Name"));
  }

  /**
   * Test {@link DynamicProtoUtils#getDescriptor(String, String)}.
   * <ul>
   *   <li>When {@code Proto Schema}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDescriptor(String, String)}
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
   * <ul>
   *   <li>When {@link DynamicProtoUtils#PROTO_3_SYNTAX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDescriptor(String, String)}
   */
  @Test
  @DisplayName("Test getDescriptor(String, String); when PROTO_3_SYNTAX")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptor DynamicProtoUtils.getDescriptor(String, String)"})
  void testGetDescriptor_whenProto_3_syntax() {
    // Arrange, Act and Assert
    assertNull(DynamicProtoUtils.getDescriptor(DataConstants.DEFAULT_SECRET_KEY, DynamicProtoUtils.PROTO_3_SYNTAX));
  }

  /**
   * Test {@link DynamicProtoUtils#getDynamicMessageBuilder(String, String)}.
   * <ul>
   *   <li>When {@link DataConstants#DEFAULT_SECRET_KEY}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDynamicMessageBuilder(String, String)}
   */
  @Test
  @DisplayName("Test getDynamicMessageBuilder(String, String); when DEFAULT_SECRET_KEY; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.google.protobuf.DynamicMessage.Builder DynamicProtoUtils.getDynamicMessageBuilder(String, String)"})
  void testGetDynamicMessageBuilder_whenDefault_secret_key_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> DynamicProtoUtils.getDynamicMessageBuilder(DataConstants.DEFAULT_SECRET_KEY, "Schema Name"));
  }

  /**
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicSchema DynamicProtoUtils.getDynamicSchema(ProtoFileElement, String)"})
  void testGetDynamicSchema() {
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
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicSchema DynamicProtoUtils.getDynamicSchema(ProtoFileElement, String)"})
  void testGetDynamicSchema2() {
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
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicSchema DynamicProtoUtils.getDynamicSchema(ProtoFileElement, String)"})
  void testGetDynamicSchema3() {
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
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicSchema DynamicProtoUtils.getDynamicSchema(ProtoFileElement, String)"})
  void testGetDynamicSchema4() {
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
    ArrayList<String> imports = new ArrayList<>();
    ArrayList<String> publicImports = new ArrayList<>();
    ArrayList<ServiceElement> services = new ArrayList<>();
    ArrayList<ExtendElement> extendDeclarations = new ArrayList<>();

    // Act
    DynamicSchema actualDynamicSchema = DynamicProtoUtils
        .getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text", Syntax.PROTO_2, imports,
            publicImports, types, services, extendDeclarations, new ArrayList<>()), "Schema Name");

    // Assert
    FileDescriptorSet fileDescriptorSet = actualDynamicSchema.getFileDescriptorSet();
    List<FileDescriptorProto> fileList = fileDescriptorSet.getFileList();
    assertEquals(1, fileList.size());
    FileDescriptorProto getResult = fileList.get(0);
    List<DescriptorProto> messageTypeList = getResult.getMessageTypeList();
    assertEquals(1, messageTypeList.size());
    assertEquals(42, getResult.getSerializedSize());
    assertEquals(44, fileDescriptorSet.getSerializedSize());
    assertEquals(8, messageTypeList.get(0).getSerializedSize());
    assertArrayEquals(new byte[]{'\n', '*', '\n', 11, 'S', 'c', 'h', 'e', 'm', 'a', ' ', 'N', 'a', 'm', 'e', 18, '\t',
        'j', 'a', 'v', 'a', '.', 't', 'e', 'x', 't', '"', '\b', '\n', 6, 'p', 'r', 'o', 't', 'o', '3', 'b', 6, 'p', 'r',
        'o', 't', 'o', '3'}, actualDynamicSchema.toByteArray());
  }

  /**
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicSchema DynamicProtoUtils.getDynamicSchema(ProtoFileElement, String)"})
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
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicSchema DynamicProtoUtils.getDynamicSchema(ProtoFileElement, String)"})
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
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicSchema DynamicProtoUtils.getDynamicSchema(ProtoFileElement, String)"})
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
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicSchema DynamicProtoUtils.getDynamicSchema(ProtoFileElement, String)"})
  void testGetDynamicSchema8() {
    // Arrange
    ArrayList<FieldElement> fields = new ArrayList<>();
    fields.add(new FieldElement(DynamicProtoUtils.LOCATION, Label.OPTIONAL, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, "42", DynamicProtoUtils.PROTO_3_SYNTAX, 1, DynamicProtoUtils.PROTO_3_SYNTAX,
        new ArrayList<>()));
    fields.add(new FieldElement(DynamicProtoUtils.LOCATION, Label.OPTIONAL, DynamicProtoUtils.PROTO_3_SYNTAX,
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
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicSchema DynamicProtoUtils.getDynamicSchema(ProtoFileElement, String)"})
  void testGetDynamicSchema9() {
    // Arrange
    ArrayList<FieldElement> fields = new ArrayList<>();
    fields.add(new FieldElement(DynamicProtoUtils.LOCATION, null, DynamicProtoUtils.PROTO_3_SYNTAX,
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
    assertEquals(66,
        DynamicProtoUtils
            .getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text", Syntax.PROTO_2, imports,
                publicImports, types, services, extendDeclarations, new ArrayList<>()), "Schema Name")
            .toByteArray().length);
  }

  /**
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicSchema DynamicProtoUtils.getDynamicSchema(ProtoFileElement, String)"})
  void testGetDynamicSchema10() {
    // Arrange
    ArrayList<FieldElement> fields = new ArrayList<>();
    fields.add(new FieldElement(DynamicProtoUtils.LOCATION, Label.REPEATED, DynamicProtoUtils.PROTO_3_SYNTAX,
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
    assertEquals(66,
        DynamicProtoUtils
            .getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text", Syntax.PROTO_2, imports,
                publicImports, types, services, extendDeclarations, new ArrayList<>()), "Schema Name")
            .toByteArray().length);
  }

  /**
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicSchema DynamicProtoUtils.getDynamicSchema(ProtoFileElement, String)"})
  void testGetDynamicSchema11() {
    // Arrange
    ArrayList<OneOfElement> oneOfs = new ArrayList<>();
    ArrayList<FieldElement> fields = new ArrayList<>();
    ArrayList<GroupElement> groups = new ArrayList<>();
    oneOfs.add(new OneOfElement(DynamicProtoUtils.PROTO_3_SYNTAX, DynamicProtoUtils.PROTO_3_SYNTAX, fields, groups,
        new ArrayList<>()));
    ArrayList<TypeElement> nestedTypes = new ArrayList<>();
    ArrayList<OptionElement> options = new ArrayList<>();
    ArrayList<ReservedElement> reserveds = new ArrayList<>();
    ArrayList<FieldElement> fields2 = new ArrayList<>();
    ArrayList<ExtensionsElement> extensions = new ArrayList<>();
    MessageElement messageElement = new MessageElement(DynamicProtoUtils.LOCATION, DynamicProtoUtils.PROTO_3_SYNTAX,
        DynamicProtoUtils.PROTO_3_SYNTAX, nestedTypes, options, reserveds, fields2, oneOfs, extensions,
        new ArrayList<>());

    ArrayList<TypeElement> types = new ArrayList<>();
    types.add(messageElement);
    ArrayList<String> imports = new ArrayList<>();
    ArrayList<String> publicImports = new ArrayList<>();
    ArrayList<ServiceElement> services = new ArrayList<>();
    ArrayList<ExtendElement> extendDeclarations = new ArrayList<>();

    // Act
    DynamicSchema actualDynamicSchema = DynamicProtoUtils
        .getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text", Syntax.PROTO_2, imports,
            publicImports, types, services, extendDeclarations, new ArrayList<>()), "Schema Name");

    // Assert
    FileDescriptorSet fileDescriptorSet = actualDynamicSchema.getFileDescriptorSet();
    List<FileDescriptorProto> fileList = fileDescriptorSet.getFileList();
    assertEquals(1, fileList.size());
    FileDescriptorProto getResult = fileList.get(0);
    List<DescriptorProto> messageTypeList = getResult.getMessageTypeList();
    assertEquals(1, messageTypeList.size());
    assertEquals(18, messageTypeList.get(0).getSerializedSize());
    assertEquals(52, getResult.getSerializedSize());
    assertEquals(54, fileDescriptorSet.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', '4', '\n', 11, 'S', 'c', 'h', 'e', 'm', 'a', ' ', 'N', 'a', 'm', 'e', 18, '\t',
        'j', 'a', 'v', 'a', '.', 't', 'e', 'x', 't', '"', 18, '\n', 6, 'p', 'r', 'o', 't', 'o', '3', 'B', '\b', '\n', 6,
        'p', 'r', 'o', 't', 'o', '3', 'b', 6, 'p', 'r', 'o', 't', 'o', '3'}, actualDynamicSchema.toByteArray());
  }

  /**
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicSchema DynamicProtoUtils.getDynamicSchema(ProtoFileElement, String)"})
  void testGetDynamicSchema12() {
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
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicSchema DynamicProtoUtils.getDynamicSchema(ProtoFileElement, String)"})
  void testGetDynamicSchema13() {
    // Arrange
    ArrayList<FieldElement> fields = new ArrayList<>();
    fields.add(new FieldElement(DynamicProtoUtils.LOCATION, Label.OPTIONAL, DynamicProtoUtils.PROTO_3_SYNTAX,
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
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <ul>
   *   <li>Then return array length is eighty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String); then return array length is eighty-one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicSchema DynamicProtoUtils.getDynamicSchema(ProtoFileElement, String)"})
  void testGetDynamicSchema_thenReturnArrayLengthIsEightyOne() {
    // Arrange
    ArrayList<FieldElement> fields = new ArrayList<>();
    fields.add(new FieldElement(DynamicProtoUtils.LOCATION, Label.OPTIONAL, DynamicProtoUtils.PROTO_3_SYNTAX,
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
    assertEquals(81,
        DynamicProtoUtils
            .getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text", Syntax.PROTO_2, imports,
                publicImports, types, services, extendDeclarations, new ArrayList<>()), "Schema Name")
            .toByteArray().length);
  }

  /**
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DynamicSchema DynamicProtoUtils.getDynamicSchema(ProtoFileElement, String)"})
  void testGetDynamicSchema_thenThrowRuntimeException() {
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
   * Test {@link DynamicProtoUtils#getProtoFileElement(String)}.
   * <ul>
   *   <li>When {@link DataConstants#DEFAULT_SECRET_KEY}.</li>
   *   <li>Then return component3 is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#getProtoFileElement(String)}
   */
  @Test
  @DisplayName("Test getProtoFileElement(String); when DEFAULT_SECRET_KEY; then return component3 is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoFileElement DynamicProtoUtils.getProtoFileElement(String)"})
  void testGetProtoFileElement_whenDefault_secret_key_thenReturnComponent3IsNull() {
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
    assertSame(component4Result, actualProtoFileElement.getImports());
    assertSame(component5Result, actualProtoFileElement.getPublicImports());
    assertSame(component6Result, actualProtoFileElement.getTypes());
    assertSame(component7Result, actualProtoFileElement.getServices());
    assertSame(component8Result, actualProtoFileElement.getExtendDeclarations());
    assertSame(component9Result, actualProtoFileElement.getOptions());
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}
   */
  @Test
  @DisplayName("Test dynamicMsgToJson(Descriptor, byte[]); then return '{}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptor, byte[])"})
  void testDynamicMsgToJson_thenReturnLeftCurlyBracketRightCurlyBracket() throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals("{}", DynamicProtoUtils.dynamicMsgToJson(Any.getDescriptor(), new byte[]{}));
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   * <ul>
   *   <li>Then return {@code { "name": "", "methods": [], "options": [], "version": "", "mixins": [], "syntax": "SYNTAX_PROTO2" }}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}
   */
  @Test
  @DisplayName("Test dynamicMsgToJson(Descriptor, byte[]); then return '{ \"name\": \"\", \"methods\": [], \"options\": [], \"version\": \"\", \"mixins\": [], \"syntax\": \"SYNTAX_PROTO2\" }'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptor, byte[])"})
  void testDynamicMsgToJson_thenReturnNameMethodsOptionsVersionMixinsSyntaxSyntaxProto2()
      throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals(
        "{\n" + "  \"name\": \"\",\n" + "  \"methods\": [],\n" + "  \"options\": [],\n" + "  \"version\": \"\",\n"
            + "  \"mixins\": [],\n" + "  \"syntax\": \"SYNTAX_PROTO2\"\n" + "}",
        DynamicProtoUtils.dynamicMsgToJson(Api.getDescriptor(), new byte[]{}));
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code ""}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}
   */
  @Test
  @DisplayName("Test dynamicMsgToJson(Descriptor, byte[]); when empty array of byte; then return '\"\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DynamicProtoUtils.dynamicMsgToJson(Descriptor, byte[])"})
  void testDynamicMsgToJson_whenEmptyArrayOfByte_thenReturnQuotationMarkQuotationMark()
      throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals("\"\"", DynamicProtoUtils.dynamicMsgToJson(BytesValue.getDescriptor(), new byte[]{}));
  }

  /**
   * Test {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}
   */
  @Test
  @DisplayName("Test validateProtoSchema(String, String, String); when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DynamicProtoUtils.validateProtoSchema(String, String, String)"})
  void testValidateProtoSchema_when42() throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> DynamicProtoUtils.validateProtoSchema("42", "Schema Name", "Exception Prefix"));
  }

  /**
   * Test {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}.
   * <ul>
   *   <li>When {@link DataConstants#DEFAULT_SECRET_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}
   */
  @Test
  @DisplayName("Test validateProtoSchema(String, String, String); when DEFAULT_SECRET_KEY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DynamicProtoUtils.validateProtoSchema(String, String, String)"})
  void testValidateProtoSchema_whenDefault_secret_key() throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DynamicProtoUtils
        .validateProtoSchema(DataConstants.DEFAULT_SECRET_KEY, "Schema Name", "Exception Prefix"));
  }

  /**
   * Test {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}.
   * <ul>
   *   <li>When {@code DynamicProtoUtils}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}
   */
  @Test
  @DisplayName("Test validateProtoSchema(String, String, String); when 'org.thingsboard.server.common.data.DynamicProtoUtils'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DynamicProtoUtils.validateProtoSchema(String, String, String)"})
  void testValidateProtoSchema_whenOrgThingsboardServerCommonDataDynamicProtoUtils() throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> DynamicProtoUtils.validateProtoSchema("org.thingsboard.server.common.data.DynamicProtoUtils",
            "Schema Name", "Exception Prefix"));
  }

  /**
   * Test {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}.
   * <ul>
   *   <li>When {@code Schema}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}
   */
  @Test
  @DisplayName("Test validateProtoSchema(String, String, String); when 'Schema'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DynamicProtoUtils.validateProtoSchema(String, String, String)"})
  void testValidateProtoSchema_whenSchema() throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> DynamicProtoUtils.validateProtoSchema("Schema", "Schema Name", "Exception Prefix"));
  }

  /**
   * Test {@link DynamicProtoUtils#invalidSchemaProvidedMessage(String, String)}.
   * <p>
   * Method under test: {@link DynamicProtoUtils#invalidSchemaProvidedMessage(String, String)}
   */
  @Test
  @DisplayName("Test invalidSchemaProvidedMessage(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DynamicProtoUtils.invalidSchemaProvidedMessage(String, String)"})
  void testInvalidSchemaProvidedMessage() {
    // Arrange, Act and Assert
    assertEquals("Exception Prefix invalid Schema Name provided!",
        DynamicProtoUtils.invalidSchemaProvidedMessage("Schema Name", "Exception Prefix"));
  }
}
