package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.os72.protobuf.dynamic.DynamicSchema;
import com.google.protobuf.Any;
import com.google.protobuf.Api;
import com.google.protobuf.BytesValue;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.InvalidProtocolBufferException;
import com.squareup.wire.Syntax;
import com.squareup.wire.schema.Field;
import com.squareup.wire.schema.Location;
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
  void testGetDescriptor_whenDefault_secret_key() {
    // Arrange, Act and Assert
    assertNull(DynamicProtoUtils.getDescriptor(DataConstants.DEFAULT_SECRET_KEY, "Schema Name"));
  }

  /**
   * Test {@link DynamicProtoUtils#getDescriptor(String, String)}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.data.DynamicProtoUtils}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicProtoUtils#getDescriptor(String, String)}
   */
  @Test
  @DisplayName("Test getDescriptor(String, String); when 'org.thingsboard.server.common.data.DynamicProtoUtils'")
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
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicMessageBuilder(String, String)}
   */
  @Test
  @DisplayName("Test getDynamicMessageBuilder(String, String); when DEFAULT_SECRET_KEY; then throw RuntimeException")
  void testGetDynamicMessageBuilder_whenDefault_secret_key_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> DynamicProtoUtils.getDynamicMessageBuilder(DataConstants.DEFAULT_SECRET_KEY, "Schema Name"));
  }

  /**
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
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
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
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
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
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
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
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
    DescriptorProtos.FileDescriptorSet fileDescriptorSet = actualDynamicSchema.getFileDescriptorSet();
    List<DescriptorProtos.FileDescriptorProto> fileList = fileDescriptorSet.getFileList();
    assertEquals(1, fileList.size());
    DescriptorProtos.FileDescriptorProto getResult = fileList.get(0);
    List<DescriptorProtos.DescriptorProto> messageTypeList = getResult.getMessageTypeList();
    assertEquals(1, messageTypeList.size());
    assertEquals(42, getResult.getSerializedSize());
    assertEquals(44, fileDescriptorSet.getSerializedSize());
    byte[] toByteArrayResult = actualDynamicSchema.toByteArray();
    assertEquals(44, toByteArrayResult.length);
    assertEquals((byte) 6, toByteArrayResult[37]);
    assertEquals(8, messageTypeList.get(0).getSerializedSize());
    assertEquals('*', toByteArrayResult[1]);
    assertEquals('3', toByteArrayResult[43]);
    assertEquals('\b', toByteArrayResult[27]);
    assertEquals('b', toByteArrayResult[36]);
    assertEquals('o', toByteArrayResult[40]);
    assertEquals('p', toByteArrayResult[38]);
    assertEquals('r', toByteArrayResult[39]);
    assertEquals('t', toByteArrayResult[41]);
  }

  /**
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
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
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
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
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
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
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
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
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  void testGetDynamicSchema9() {
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
    DescriptorProtos.FileDescriptorSet fileDescriptorSet = actualDynamicSchema.getFileDescriptorSet();
    List<DescriptorProtos.FileDescriptorProto> fileList = fileDescriptorSet.getFileList();
    assertEquals(1, fileList.size());
    DescriptorProtos.FileDescriptorProto getResult = fileList.get(0);
    List<DescriptorProtos.DescriptorProto> messageTypeList = getResult.getMessageTypeList();
    assertEquals(1, messageTypeList.size());
    assertEquals(18, messageTypeList.get(0).getSerializedSize());
    assertEquals(52, getResult.getSerializedSize());
    assertEquals(54, fileDescriptorSet.getSerializedSize());
    byte[] toByteArrayResult = actualDynamicSchema.toByteArray();
    assertEquals(54, toByteArrayResult.length);
    assertEquals((byte) 6, toByteArrayResult[39]);
    assertEquals((byte) 6, toByteArrayResult[47]);
    assertEquals('3', toByteArrayResult[53]);
    assertEquals('4', toByteArrayResult[1]);
    assertEquals('B', toByteArrayResult[36]);
    assertEquals('\b', toByteArrayResult[37]);
    assertEquals('\n', toByteArrayResult[38]);
    assertEquals('b', toByteArrayResult[46]);
    assertEquals('o', toByteArrayResult[50]);
    assertEquals('o', toByteArrayResult[52]);
    assertEquals('p', toByteArrayResult[40]);
    assertEquals('p', toByteArrayResult[48]);
    assertEquals('r', toByteArrayResult[49]);
    assertEquals('t', toByteArrayResult[51]);
  }

  /**
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <p>
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  void testGetDynamicSchema10() {
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
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String)")
  void testGetDynamicSchema11() {
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
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <ul>
   *   <li>Then return fiftieth element is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String); then return fiftieth element is one")
  void testGetDynamicSchema_thenReturnFiftiethElementIsOne() {
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

    // Act
    DynamicSchema actualDynamicSchema = DynamicProtoUtils
        .getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text", Syntax.PROTO_2, imports,
            publicImports, types, services, extendDeclarations, new ArrayList<>()), "Schema Name");

    // Assert
    DescriptorProtos.FileDescriptorSet fileDescriptorSet = actualDynamicSchema.getFileDescriptorSet();
    List<DescriptorProtos.FileDescriptorProto> fileList = fileDescriptorSet.getFileList();
    assertEquals(1, fileList.size());
    DescriptorProtos.FileDescriptorProto getResult = fileList.get(0);
    List<DescriptorProtos.DescriptorProto> messageTypeList = getResult.getMessageTypeList();
    assertEquals(1, messageTypeList.size());
    byte[] toByteArrayResult = actualDynamicSchema.toByteArray();
    assertEquals((byte) 1, toByteArrayResult[47]);
    assertEquals((byte) 1, toByteArrayResult[49]);
    assertEquals((byte) 24, toByteArrayResult[46]);
    assertEquals(30, messageTypeList.get(0).getSerializedSize());
    assertEquals(66, fileDescriptorSet.getSerializedSize());
    assertEquals(66, toByteArrayResult.length);
    assertEquals((byte) 6, toByteArrayResult[51]);
    assertEquals((byte) 6, toByteArrayResult[59]);
    assertEquals(Double.SIZE, getResult.getSerializedSize());
    assertEquals(' ', toByteArrayResult[48]);
    assertEquals('2', toByteArrayResult[50]);
    assertEquals('3', toByteArrayResult[65]);
    assertEquals('@', toByteArrayResult[1]);
    assertEquals('b', toByteArrayResult[58]);
    assertEquals('o', toByteArrayResult[54]);
    assertEquals('o', toByteArrayResult[62]);
    assertEquals('o', toByteArrayResult[Double.SIZE]);
    assertEquals('p', toByteArrayResult[52]);
    assertEquals('p', toByteArrayResult[60]);
    assertEquals('r', toByteArrayResult[53]);
    assertEquals('r', toByteArrayResult[61]);
    assertEquals('t', toByteArrayResult[55]);
    assertEquals('t', toByteArrayResult[63]);
  }

  /**
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <ul>
   *   <li>Then return fiftieth element is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String); then return fiftieth element is three")
  void testGetDynamicSchema_thenReturnFiftiethElementIsThree() {
    // Arrange
    ArrayList<FieldElement> fields = new ArrayList<>();
    fields.add(new FieldElement(DynamicProtoUtils.LOCATION, Field.Label.REPEATED, DynamicProtoUtils.PROTO_3_SYNTAX,
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

    // Act
    DynamicSchema actualDynamicSchema = DynamicProtoUtils
        .getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text", Syntax.PROTO_2, imports,
            publicImports, types, services, extendDeclarations, new ArrayList<>()), "Schema Name");

    // Assert
    DescriptorProtos.FileDescriptorSet fileDescriptorSet = actualDynamicSchema.getFileDescriptorSet();
    List<DescriptorProtos.FileDescriptorProto> fileList = fileDescriptorSet.getFileList();
    assertEquals(1, fileList.size());
    DescriptorProtos.FileDescriptorProto getResult = fileList.get(0);
    List<DescriptorProtos.DescriptorProto> messageTypeList = getResult.getMessageTypeList();
    assertEquals(1, messageTypeList.size());
    byte[] toByteArrayResult = actualDynamicSchema.toByteArray();
    assertEquals((byte) 1, toByteArrayResult[47]);
    assertEquals((byte) 24, toByteArrayResult[46]);
    assertEquals(30, messageTypeList.get(0).getSerializedSize());
    assertEquals((byte) 3, toByteArrayResult[49]);
    assertEquals(66, fileDescriptorSet.getSerializedSize());
    assertEquals(66, toByteArrayResult.length);
    assertEquals((byte) 6, toByteArrayResult[51]);
    assertEquals((byte) 6, toByteArrayResult[59]);
    assertEquals(Double.SIZE, getResult.getSerializedSize());
    assertEquals(' ', toByteArrayResult[48]);
    assertEquals('2', toByteArrayResult[50]);
    assertEquals('3', toByteArrayResult[65]);
    assertEquals('@', toByteArrayResult[1]);
    assertEquals('b', toByteArrayResult[58]);
    assertEquals('o', toByteArrayResult[54]);
    assertEquals('o', toByteArrayResult[62]);
    assertEquals('o', toByteArrayResult[Double.SIZE]);
    assertEquals('p', toByteArrayResult[52]);
    assertEquals('p', toByteArrayResult[60]);
    assertEquals('r', toByteArrayResult[53]);
    assertEquals('r', toByteArrayResult[61]);
    assertEquals('t', toByteArrayResult[55]);
    assertEquals('t', toByteArrayResult[63]);
  }

  /**
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <ul>
   *   <li>Then return sixty-first element is minus one hundred twenty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String); then return sixty-first element is minus one hundred twenty")
  void testGetDynamicSchema_thenReturnSixtyFirstElementIsMinusOneHundredTwenty() {
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
    ArrayList<String> imports = new ArrayList<>();
    ArrayList<String> publicImports = new ArrayList<>();
    ArrayList<ServiceElement> services = new ArrayList<>();
    ArrayList<ExtendElement> extendDeclarations = new ArrayList<>();

    // Act
    DynamicSchema actualDynamicSchema = DynamicProtoUtils
        .getDynamicSchema(new ProtoFileElement(DynamicProtoUtils.LOCATION, "java.text", Syntax.PROTO_2, imports,
            publicImports, types, services, extendDeclarations, new ArrayList<>()), "Schema Name");

    // Assert
    byte[] toByteArrayResult = actualDynamicSchema.toByteArray();
    assertEquals((byte) -120, toByteArrayResult[60]);
    assertEquals((byte) 0, toByteArrayResult[59]);
    DescriptorProtos.FileDescriptorSet fileDescriptorSet = actualDynamicSchema.getFileDescriptorSet();
    List<DescriptorProtos.FileDescriptorProto> fileList = fileDescriptorSet.getFileList();
    assertEquals(1, fileList.size());
    DescriptorProtos.FileDescriptorProto getResult = fileList.get(0);
    List<DescriptorProtos.DescriptorProto> messageTypeList = getResult.getMessageTypeList();
    assertEquals(1, messageTypeList.size());
    assertEquals((byte) 1, toByteArrayResult[61]);
    assertEquals((byte) 1, toByteArrayResult[62]);
    assertEquals(45, messageTypeList.get(0).getSerializedSize());
    assertEquals((byte) 6, toByteArrayResult[66]);
    assertEquals((byte) 6, toByteArrayResult[74]);
    assertEquals(79, getResult.getSerializedSize());
    assertEquals(81, fileDescriptorSet.getSerializedSize());
    assertEquals(81, toByteArrayResult.length);
    assertEquals('3', toByteArrayResult[72]);
    assertEquals('3', toByteArrayResult[80]);
    assertEquals('B', toByteArrayResult[63]);
    assertEquals('H', toByteArrayResult[58]);
    assertEquals('O', toByteArrayResult[1]);
    assertEquals('\b', toByteArrayResult[Double.SIZE]);
    assertEquals('\n', toByteArrayResult[65]);
    assertEquals('b', toByteArrayResult[73]);
    assertEquals('o', toByteArrayResult[69]);
    assertEquals('o', toByteArrayResult[71]);
    assertEquals('o', toByteArrayResult[77]);
    assertEquals('o', toByteArrayResult[79]);
    assertEquals('p', toByteArrayResult[67]);
    assertEquals('p', toByteArrayResult[75]);
    assertEquals('r', toByteArrayResult[68]);
    assertEquals('r', toByteArrayResult[76]);
    assertEquals('t', toByteArrayResult[70]);
    assertEquals('t', toByteArrayResult[78]);
  }

  /**
   * Test {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicProtoUtils#getDynamicSchema(ProtoFileElement, String)}
   */
  @Test
  @DisplayName("Test getDynamicSchema(ProtoFileElement, String); then throw RuntimeException")
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
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicProtoUtils#dynamicMsgToJson(Descriptors.Descriptor, byte[])}
   */
  @Test
  @DisplayName("Test dynamicMsgToJson(Descriptor, byte[]); then return '{}'")
  void testDynamicMsgToJson_thenReturnLeftCurlyBracketRightCurlyBracket() throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals("{}", DynamicProtoUtils.dynamicMsgToJson(Any.getDescriptor(), new byte[]{}));
  }

  /**
   * Test {@link DynamicProtoUtils#dynamicMsgToJson(Descriptor, byte[])}.
   * <ul>
   *   <li>Then return {@code { "name": "", "methods": [], "options": [], "version":
   * "", "mixins": [], "syntax": "SYNTAX_PROTO2" }}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicProtoUtils#dynamicMsgToJson(Descriptors.Descriptor, byte[])}
   */
  @Test
  @DisplayName("Test dynamicMsgToJson(Descriptor, byte[]); then return '{ \"name\": \"\", \"methods\": [], \"options\": [], \"version\": \"\", \"mixins\": [], \"syntax\": \"SYNTAX_PROTO2\" }'")
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
   * Method under test:
   * {@link DynamicProtoUtils#dynamicMsgToJson(Descriptors.Descriptor, byte[])}
   */
  @Test
  @DisplayName("Test dynamicMsgToJson(Descriptor, byte[]); when empty array of byte; then return '\"\"'")
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
   * Method under test:
   * {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}
   */
  @Test
  @DisplayName("Test validateProtoSchema(String, String, String); when '42'")
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
   * Method under test:
   * {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}
   */
  @Test
  @DisplayName("Test validateProtoSchema(String, String, String); when DEFAULT_SECRET_KEY")
  void testValidateProtoSchema_whenDefault_secret_key() throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DynamicProtoUtils
        .validateProtoSchema(DataConstants.DEFAULT_SECRET_KEY, "Schema Name", "Exception Prefix"));
  }

  /**
   * Test {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.data.DynamicProtoUtils}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}
   */
  @Test
  @DisplayName("Test validateProtoSchema(String, String, String); when 'org.thingsboard.server.common.data.DynamicProtoUtils'")
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
   * Method under test:
   * {@link DynamicProtoUtils#validateProtoSchema(String, String, String)}
   */
  @Test
  @DisplayName("Test validateProtoSchema(String, String, String); when 'Schema'")
  void testValidateProtoSchema_whenSchema() throws IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> DynamicProtoUtils.validateProtoSchema("Schema", "Schema Name", "Exception Prefix"));
  }

  /**
   * Test {@link DynamicProtoUtils#invalidSchemaProvidedMessage(String, String)}.
   * <p>
   * Method under test:
   * {@link DynamicProtoUtils#invalidSchemaProvidedMessage(String, String)}
   */
  @Test
  @DisplayName("Test invalidSchemaProvidedMessage(String, String)")
  void testInvalidSchemaProvidedMessage() {
    // Arrange, Act and Assert
    assertEquals("Exception Prefix invalid Schema Name provided!",
        DynamicProtoUtils.invalidSchemaProvidedMessage("Schema Name", "Exception Prefix"));
  }
}
