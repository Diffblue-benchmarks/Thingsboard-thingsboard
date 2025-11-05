package org.thingsboard.server.transport.mqtt.util.sparkplug;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.MessageOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.UnknownFieldSet;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueProto;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueType;
import org.thingsboard.server.gen.transport.TransportProtos.TsKvProto;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.Metric;
import org.thingsboard.server.transport.mqtt.util.sparkplug.SparkplugMetricUtil.File;

class SparkplugMetricUtilDiffblueTest {
  /**
   * Test File getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link File#File(SparkplugMetricUtil)}
   *   <li>{@link File#setBytes(byte[])}
   *   <li>{@link File#setFileName(String)}
   *   <li>{@link File#toString()}
   *   <li>{@link File#getBytes()}
   *   <li>{@link File#getFileName()}
   * </ul>
   */
  @Test
  @DisplayName("Test File getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void File.<init>(SparkplugMetricUtil)",
    "byte[] File.getBytes()",
    "String File.getFileName()",
    "void File.setBytes(byte[])",
    "void File.setFileName(String)",
    "String File.toString()"
  })
  void testFileGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    File actualFile = new SparkplugMetricUtil().new File();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    actualFile.setBytes(bytes);
    actualFile.setFileName("foo.txt");
    String actualToStringResult = actualFile.toString();
    byte[] actualBytes = actualFile.getBytes();

    // Assert
    assertEquals(
        "File [fileName=foo.txt, bytes=[65, 88, 65, 88, 65, 88, 65, 88]]", actualToStringResult);
    assertEquals("foo.txt", actualFile.getFileName());
    assertSame(bytes, actualBytes);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBytes);
  }

  /**
   * Test File {@link File#File(SparkplugMetricUtil, String, byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return FileName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link File#File(SparkplugMetricUtil, String, byte[])}
   */
  @Test
  @DisplayName(
      "Test File new File(SparkplugMetricUtil, String, byte[]); when 'A'; then return FileName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void File.<init>(SparkplugMetricUtil, String, byte[])"})
  void testFileNewFile_whenA_thenReturnFileNameIsNull() throws UnsupportedEncodingException {
    // Arrange and Act
    File actualFile =
        new SparkplugMetricUtil()
        .new File(null, new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualFile.getFileName());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualFile.getBytes());
  }

  /**
   * Test File {@link File#File(SparkplugMetricUtil, String, byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return FileName is {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link File#File(SparkplugMetricUtil, String, byte[])}
   */
  @Test
  @DisplayName(
      "Test File new File(SparkplugMetricUtil, String, byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return FileName is 'foo.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void File.<init>(SparkplugMetricUtil, String, byte[])"})
  void testFileNewFile_whenAxaxaxaxBytesIsUtf8_thenReturnFileNameIsFooTxt()
      throws UnsupportedEncodingException {
    // Arrange and Act
    File actualFile = new SparkplugMetricUtil().new File("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("foo.txt", actualFile.getFileName());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualFile.getBytes());
  }

  /**
   * Test {@link SparkplugMetricUtil#fromSparkplugBMetricToKeyValueProto(String, Metric)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#fromSparkplugBMetricToKeyValueProto(String,
   * SparkplugBProto.Payload.Metric)}
   */
  @Test
  @DisplayName(
      "Test fromSparkplugBMetricToKeyValueProto(String, Metric); when empty string; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.fromSparkplugBMetricToKeyValueProto(String, SparkplugBProto.Payload.Metric)"
  })
  void testFromSparkplugBMetricToKeyValueProto_whenEmptyString_thenReturnNotPresent()
      throws ThingsboardException {
    // Arrange and Act
    Optional<KeyValueProto> actualFromSparkplugBMetricToKeyValueProtoResult =
        SparkplugMetricUtil.fromSparkplugBMetricToKeyValueProto("", Metric.getDefaultInstance());

    // Assert
    assertFalse(actualFromSparkplugBMetricToKeyValueProtoResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#fromSparkplugBMetricToKeyValueProto(String, Metric)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#fromSparkplugBMetricToKeyValueProto(String,
   * SparkplugBProto.Payload.Metric)}
   */
  @Test
  @DisplayName(
      "Test fromSparkplugBMetricToKeyValueProto(String, Metric); when 'Key'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.fromSparkplugBMetricToKeyValueProto(String, SparkplugBProto.Payload.Metric)"
  })
  void testFromSparkplugBMetricToKeyValueProto_whenKey_thenReturnNotPresent()
      throws ThingsboardException {
    // Arrange and Act
    Optional<KeyValueProto> actualFromSparkplugBMetricToKeyValueProtoResult =
        SparkplugMetricUtil.fromSparkplugBMetricToKeyValueProto("Key", Metric.getDefaultInstance());

    // Assert
    assertFalse(actualFromSparkplugBMetricToKeyValueProtoResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#createMetric(Object, long, String, MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code Int8}.
   *   <li>Then return Datatype is one.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#createMetric(Object, long, String,
   * MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test createMetric(Object, long, String, MetricDataType); when 'Int8'; then return Datatype is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SparkplugBProto.Payload.Metric SparkplugMetricUtil.createMetric(Object, long, String, MetricDataType)"
  })
  void testCreateMetric_whenInt8_thenReturnDatatypeIsOne() throws ThingsboardException {
    // Arrange and Act
    Metric actualCreateMetricResult =
        SparkplugMetricUtil.createMetric((byte) 'A', 1L, "Key", MetricDataType.Int8);

    // Assert
    assertEquals(1, actualCreateMetricResult.getDatatype());
    assertEquals(65, actualCreateMetricResult.getIntValue());
  }

  /**
   * Test {@link SparkplugMetricUtil#createMetric(Object, long, String, MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code Unknown}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#createMetric(Object, long, String,
   * MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test createMetric(Object, long, String, MetricDataType); when 'Unknown'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SparkplugBProto.Payload.Metric SparkplugMetricUtil.createMetric(Object, long, String, MetricDataType)"
  })
  void testCreateMetric_whenUnknown_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> SparkplugMetricUtil.createMetric((byte) 'A', 1L, "Key", MetricDataType.Unknown));
  }

  /**
   * Test {@link SparkplugMetricUtil#createMetric(Object, long, String, MetricDataType)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return IntValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#createMetric(Object, long, String,
   * MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test createMetric(Object, long, String, MetricDataType); when zero; then return IntValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SparkplugBProto.Payload.Metric SparkplugMetricUtil.createMetric(Object, long, String, MetricDataType)"
  })
  void testCreateMetric_whenZero_thenReturnIntValueIsZero() throws ThingsboardException {
    // Arrange and Act
    Metric actualCreateMetricResult =
        SparkplugMetricUtil.createMetric(0, 1L, "Key", MetricDataType.Int32);

    // Assert
    assertEquals(0, actualCreateMetricResult.getIntValue());
    assertEquals(3, actualCreateMetricResult.getDatatype());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto() throws ThingsboardException {
    // Arrange and Act
    TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", new ArrayList<>(), 1L);

    // Assert
    KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals("[]", kv.getJsonVBytes().toStringUtf8());
    assertEquals("[]", kv.getJsonV());
    assertEquals(11, kv.getSerializedSize());
    assertEquals(15, actualTsKvProto.getSerializedSize());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto2() throws ThingsboardException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    ArrayList<Object> objectList2 = new ArrayList<>();
    objectList.add(objectList2);

    // Act
    TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", objectList, 1L);

    // Assert
    Descriptor descriptorForType = actualTsKvProto.getDescriptorForType();
    DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals(objectList2, toProtoResult.getDefaultInstanceForType().findInitializationErrors());
    MessageOptions options = descriptorForType.getOptions();
    assertEquals(objectList2, options.getFeatures().findInitializationErrors());
    assertEquals(
        objectList2,
        actualTsKvProto.getKv().getDescriptorForType().toProto().findInitializationErrors());
    Descriptor descriptorForType2 = options.getDescriptorForType();
    assertEquals(objectList2, descriptorForType2.getEnumTypes());
    Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals(objectList2, descriptorForType3.getEnumTypes());
    assertEquals(objectList2, descriptorForType2.getExtensions());
    assertEquals(objectList2, descriptorForType3.getExtensions());
    assertEquals(objectList2, descriptorForType2.getNestedTypes());
    assertEquals(objectList2, descriptorForType2.getOneofs());
    assertEquals(objectList2, descriptorForType3.getOneofs());
    assertEquals(objectList2, descriptorForType2.getRealOneofs());
    assertEquals(objectList2, descriptorForType3.getRealOneofs());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto3() throws ThingsboardException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    objectList.add(new ArrayNode(nf, 3));

    // Act
    TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", objectList, 1L);

    // Assert
    KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals("[[]]", kv.getJsonVBytes().toStringUtf8());
    assertEquals("[[]]", kv.getJsonV());
    assertEquals(13, kv.getSerializedSize());
    assertEquals(17, actualTsKvProto.getSerializedSize());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto4() throws ThingsboardException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode arrayNode = new ArrayNode(nf);
    arrayNode.addArray();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(arrayNode);

    // Act
    TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", objectList, 1L);

    // Assert
    KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals("[[[]]]", kv.getJsonVBytes().toStringUtf8());
    assertEquals("[[[]]]", kv.getJsonV());
    assertEquals(15, kv.getSerializedSize());
    assertEquals(19, actualTsKvProto.getSerializedSize());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto5() throws ThingsboardException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode arrayNode = new ArrayNode(nf);
    arrayNode.addObject();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(arrayNode);

    // Act
    TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", objectList, 1L);

    // Assert
    KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals("[[{}]]", kv.getJsonVBytes().toStringUtf8());
    assertEquals("[[{}]]", kv.getJsonV());
    assertEquals(15, kv.getSerializedSize());
    assertEquals(19, actualTsKvProto.getSerializedSize());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return Kv JsonVBytes toStringUtf8 is {@code ["42","42"]}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName(
      "Test getTsKvProto(String, Object, long); given '42'; then return Kv JsonVBytes toStringUtf8 is '[\"42\",\"42\"]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto_given42_thenReturnKvJsonVBytesToStringUtf8Is4242()
      throws ThingsboardException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");

    // Act
    TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", objectList, 1L);

    // Assert
    KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals("[\"42\",\"42\"]", kv.getJsonVBytes().toStringUtf8());
    assertEquals("[\"42\",\"42\"]", kv.getJsonV());
    assertEquals(20, kv.getSerializedSize());
    assertEquals(24, actualTsKvProto.getSerializedSize());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName(
      "Test getTsKvProto(String, Object, long); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto_givenArrayNodeWithNfIsWithExactBigDecimalsTrue()
      throws ThingsboardException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    objectList.add(new ArrayNode(nf));

    // Act
    TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", objectList, 1L);

    // Assert
    KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals("[[]]", kv.getJsonVBytes().toStringUtf8());
    assertEquals("[[]]", kv.getJsonV());
    assertEquals(13, kv.getSerializedSize());
    assertEquals(17, actualTsKvProto.getSerializedSize());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <ul>
   *   <li>Then return Kv JsonVBytes toStringUtf8 is {@code [[10.0]]}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName(
      "Test getTsKvProto(String, Object, long); then return Kv JsonVBytes toStringUtf8 is '[[10.0]]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto_thenReturnKvJsonVBytesToStringUtf8Is100() throws ThingsboardException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode arrayNode = new ArrayNode(nf);
    arrayNode.add(DoubleNode.valueOf(10.0d));

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(arrayNode);

    // Act
    TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", objectList, 1L);

    // Assert
    KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals("[[10.0]]", kv.getJsonVBytes().toStringUtf8());
    assertEquals("[[10.0]]", kv.getJsonV());
    assertEquals(17, kv.getSerializedSize());
    assertEquals(21, actualTsKvProto.getSerializedSize());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <ul>
   *   <li>Then return Kv JsonVBytes toStringUtf8 is {@code [["Pojo"]]}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName(
      "Test getTsKvProto(String, Object, long); then return Kv JsonVBytes toStringUtf8 is '[[\"Pojo\"]]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto_thenReturnKvJsonVBytesToStringUtf8IsPojo() throws ThingsboardException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode arrayNode = new ArrayNode(nf);
    arrayNode.addPOJO("Pojo");

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(arrayNode);

    // Act
    TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", objectList, 1L);

    // Assert
    KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals("[[\"Pojo\"]]", kv.getJsonVBytes().toStringUtf8());
    assertEquals("[[\"Pojo\"]]", kv.getJsonV());
    assertEquals(19, kv.getSerializedSize());
    assertEquals(23, actualTsKvProto.getSerializedSize());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName(
      "Test getTsKvProto(String, Object, long); when '42'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto_when42_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class, () -> SparkplugMetricUtil.getTsKvProto(null, "42", 1L));
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <ul>
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long); when forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto_whenFortyTwo() throws ThingsboardException {
    // Arrange and Act
    TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", 42, 1L);

    // Assert
    UnknownFieldSet unknownFields = actualTsKvProto.getUnknownFields();
    TsKvProto defaultInstanceForType = actualTsKvProto.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualTsKvProto.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualTsKvProto.getKvOrBuilder());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <ul>
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long); when forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto_whenFortyTwo2() throws ThingsboardException {
    // Arrange and Act
    TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", 42L, 1L);

    // Assert
    UnknownFieldSet unknownFields = actualTsKvProto.getUnknownFields();
    TsKvProto defaultInstanceForType = actualTsKvProto.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualTsKvProto.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualTsKvProto.getKvOrBuilder());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <ul>
   *   <li>When {@link LinkedList#LinkedList()}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long); when LinkedList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto_whenLinkedList() throws ThingsboardException {
    // Arrange and Act
    TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", new LinkedList<>(), 1L);

    // Assert
    UnknownFieldSet unknownFields = actualTsKvProto.getUnknownFields();
    TsKvProto defaultInstanceForType = actualTsKvProto.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    KeyValueProto kv = actualTsKvProto.getKv();
    assertSame(unknownFields, kv.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualTsKvProto.getKvOrBuilder());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName(
      "Test getTsKvProto(String, Object, long); when 'null'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class, () -> SparkplugMetricUtil.getTsKvProto("Key", null, 1L));
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return Kv DoubleV is ten.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long); when ten; then return Kv DoubleV is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto_whenTen_thenReturnKvDoubleVIsTen() throws ThingsboardException {
    // Arrange and Act
    TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", 10.0d, 1L);

    // Assert
    KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals(10.0d, kv.getDoubleV());
    assertEquals(2, kv.getTypeValue());
    assertEquals(20, actualTsKvProto.getSerializedSize());
    assertEquals(KeyValueType.DOUBLE_V, kv.getType());
    assertEquals(Short.SIZE, kv.getSerializedSize());
    UnknownFieldSet unknownFields = actualTsKvProto.getUnknownFields();
    TsKvProto defaultInstanceForType = actualTsKvProto.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, kv.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualTsKvProto.getKvOrBuilder());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Kv TypeValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName(
      "Test getTsKvProto(String, Object, long); when 'true'; then return Kv TypeValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto_whenTrue_thenReturnKvTypeValueIsZero() throws ThingsboardException {
    // Arrange and Act
    TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", true, 1L);

    // Assert
    KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals(0, kv.getTypeValue());
    assertEquals(11, actualTsKvProto.getSerializedSize());
    assertEquals(2, kv.getAllFields().size());
    assertEquals(7, kv.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, kv.getType());
    assertTrue(kv.getBoolV());
    UnknownFieldSet unknownFields = actualTsKvProto.getUnknownFields();
    TsKvProto defaultInstanceForType = actualTsKvProto.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, kv.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualTsKvProto.getKvOrBuilder());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return Kv StringV is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName(
      "Test getTsKvProto(String, Object, long); when 'Value'; then return Kv StringV is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvProto SparkplugMetricUtil.getTsKvProto(String, Object, long)"})
  void testGetTsKvProto_whenValue_thenReturnKvStringVIsValue() throws ThingsboardException {
    // Arrange and Act
    TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", "Value", 1L);

    // Assert
    KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals("Value", kv.getStringV());
    assertEquals(14, kv.getSerializedSize());
    assertEquals(18, actualTsKvProto.getSerializedSize());
    assertEquals(3, kv.getTypeValue());
    assertEquals(KeyValueType.STRING_V, kv.getType());
    UnknownFieldSet unknownFields = actualTsKvProto.getUnknownFields();
    TsKvProto defaultInstanceForType = actualTsKvProto.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, kv.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kv, actualTsKvProto.getKvOrBuilder());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto, MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code Boolean}.
   *   <li>Then return not {@link Optional#get()}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto,
   * MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test validatedValueByTypeMetric(KeyValueProto, MetricDataType); when 'Boolean'; then return not get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValueByTypeMetric(KeyValueProto, MetricDataType)"
  })
  void testValidatedValueByTypeMetric_whenBoolean_thenReturnNotGet() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult =
        SparkplugMetricUtil.validatedValueByTypeMetric(
            KeyValueProto.getDefaultInstance(), MetricDataType.Boolean);

    // Assert
    assertFalse((Boolean) actualValidatedValueByTypeMetricResult.get());
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto, MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code DataSet}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto,
   * MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test validatedValueByTypeMetric(KeyValueProto, MetricDataType); when 'DataSet'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValueByTypeMetric(KeyValueProto, MetricDataType)"
  })
  void testValidatedValueByTypeMetric_whenDataSet_thenReturnNotPresent()
      throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult =
        SparkplugMetricUtil.validatedValueByTypeMetric(
            KeyValueProto.getDefaultInstance(), MetricDataType.DataSet);

    // Assert
    assertFalse(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto, MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code DateTime}.
   *   <li>Then return {@link Optional#get()} longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto,
   * MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test validatedValueByTypeMetric(KeyValueProto, MetricDataType); when 'DateTime'; then return get() longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValueByTypeMetric(KeyValueProto, MetricDataType)"
  })
  void testValidatedValueByTypeMetric_whenDateTime_thenReturnGetLongValueIsZero()
      throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult =
        SparkplugMetricUtil.validatedValueByTypeMetric(
            KeyValueProto.getDefaultInstance(), MetricDataType.DateTime);

    // Assert
    assertEquals(0L, ((Long) actualValidatedValueByTypeMetricResult.get()).longValue());
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto, MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code Double}.
   *   <li>Then return {@link Optional#get()} doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto,
   * MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test validatedValueByTypeMetric(KeyValueProto, MetricDataType); when 'Double'; then return get() doubleValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValueByTypeMetric(KeyValueProto, MetricDataType)"
  })
  void testValidatedValueByTypeMetric_whenDouble_thenReturnGetDoubleValueIsZero()
      throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult =
        SparkplugMetricUtil.validatedValueByTypeMetric(
            KeyValueProto.getDefaultInstance(), MetricDataType.Double);

    // Assert
    assertEquals(0.0d, ((Double) actualValidatedValueByTypeMetricResult.get()).doubleValue());
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto, MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code Float}.
   *   <li>Then return {@link Optional#get()} floatValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto,
   * MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test validatedValueByTypeMetric(KeyValueProto, MetricDataType); when 'Float'; then return get() floatValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValueByTypeMetric(KeyValueProto, MetricDataType)"
  })
  void testValidatedValueByTypeMetric_whenFloat_thenReturnGetFloatValueIsZero()
      throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult =
        SparkplugMetricUtil.validatedValueByTypeMetric(
            KeyValueProto.getDefaultInstance(), MetricDataType.Float);

    // Assert
    assertEquals(0.0f, ((Float) actualValidatedValueByTypeMetricResult.get()).floatValue());
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto, MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code Int8}.
   *   <li>Then return {@link Optional#get()} intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto,
   * MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test validatedValueByTypeMetric(KeyValueProto, MetricDataType); when 'Int8'; then return get() intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValueByTypeMetric(KeyValueProto, MetricDataType)"
  })
  void testValidatedValueByTypeMetric_whenInt8_thenReturnGetIntValueIsZero()
      throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult =
        SparkplugMetricUtil.validatedValueByTypeMetric(
            KeyValueProto.getDefaultInstance(), MetricDataType.Int8);

    // Assert
    assertEquals(0, ((Integer) actualValidatedValueByTypeMetricResult.get()).intValue());
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto, MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@link Optional#get()} is {@link Boolean#FALSE} toString.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto,
   * MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test validatedValueByTypeMetric(KeyValueProto, MetricDataType); when 'String'; then return get() is FALSE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValueByTypeMetric(KeyValueProto, MetricDataType)"
  })
  void testValidatedValueByTypeMetric_whenString_thenReturnGetIsFalseToString()
      throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult =
        SparkplugMetricUtil.validatedValueByTypeMetric(
            KeyValueProto.getDefaultInstance(), MetricDataType.String);

    // Assert
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
    assertEquals(Boolean.FALSE.toString(), actualValidatedValueByTypeMetricResult.get());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto,
   * MetricDataType)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType); then return get() doubleValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)"
  })
  void testValidatedValuePrimitiveByTypeMetric_thenReturnGetDoubleValueIsZero()
      throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult =
        SparkplugMetricUtil.validatedValuePrimitiveByTypeMetric(
            KeyValueProto.getDefaultInstance(), MetricDataType.Double);

    // Assert
    assertEquals(
        0.0d, ((Double) actualValidatedValuePrimitiveByTypeMetricResult.get()).doubleValue());
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto,
   * MetricDataType)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType); then return get() longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)"
  })
  void testValidatedValuePrimitiveByTypeMetric_thenReturnGetLongValueIsZero()
      throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult =
        SparkplugMetricUtil.validatedValuePrimitiveByTypeMetric(
            KeyValueProto.getDefaultInstance(), MetricDataType.DateTime);

    // Assert
    assertEquals(0L, ((Long) actualValidatedValuePrimitiveByTypeMetricResult.get()).longValue());
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto,
   * MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code Boolean}.
   *   <li>Then return not {@link Optional#get()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType); when 'Boolean'; then return not get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)"
  })
  void testValidatedValuePrimitiveByTypeMetric_whenBoolean_thenReturnNotGet()
      throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult =
        SparkplugMetricUtil.validatedValuePrimitiveByTypeMetric(
            KeyValueProto.getDefaultInstance(), MetricDataType.Boolean);

    // Assert
    assertFalse((Boolean) actualValidatedValuePrimitiveByTypeMetricResult.get());
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto,
   * MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code DataSet}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link
   * SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType); when 'DataSet'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)"
  })
  void testValidatedValuePrimitiveByTypeMetric_whenDataSet_thenReturnNotPresent()
      throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult =
        SparkplugMetricUtil.validatedValuePrimitiveByTypeMetric(
            KeyValueProto.getDefaultInstance(), MetricDataType.DataSet);

    // Assert
    assertFalse(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto,
   * MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code Float}.
   *   <li>Then return {@link Optional#get()} floatValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType); when 'Float'; then return get() floatValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)"
  })
  void testValidatedValuePrimitiveByTypeMetric_whenFloat_thenReturnGetFloatValueIsZero()
      throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult =
        SparkplugMetricUtil.validatedValuePrimitiveByTypeMetric(
            KeyValueProto.getDefaultInstance(), MetricDataType.Float);

    // Assert
    assertEquals(
        0.0f, ((Float) actualValidatedValuePrimitiveByTypeMetricResult.get()).floatValue());
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto,
   * MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code Int8}.
   *   <li>Then return {@link Optional#get()} intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType); when 'Int8'; then return get() intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)"
  })
  void testValidatedValuePrimitiveByTypeMetric_whenInt8_thenReturnGetIntValueIsZero()
      throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult =
        SparkplugMetricUtil.validatedValuePrimitiveByTypeMetric(
            KeyValueProto.getDefaultInstance(), MetricDataType.Int8);

    // Assert
    assertEquals(0, ((Integer) actualValidatedValuePrimitiveByTypeMetricResult.get()).intValue());
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto,
   * MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@link Optional#get()} is {@link Boolean#FALSE} toString.
   * </ul>
   *
   * <p>Method under test: {@link
   * SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName(
      "Test validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType); when 'String'; then return get() is FALSE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)"
  })
  void testValidatedValuePrimitiveByTypeMetric_whenString_thenReturnGetIsFalseToString()
      throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult =
        SparkplugMetricUtil.validatedValuePrimitiveByTypeMetric(
            KeyValueProto.getDefaultInstance(), MetricDataType.String);

    // Assert
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
    assertEquals(Boolean.FALSE.toString(), actualValidatedValuePrimitiveByTypeMetricResult.get());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String,
   * MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when '0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValueJsonByTypeMetric(String, MetricDataType)"
  })
  void testValidatedValueJsonByTypeMetric_when0() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult =
        SparkplugMetricUtil.validatedValueJsonByTypeMetric("0", MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String,
   * MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValueJsonByTypeMetric(String, MetricDataType)"
  })
  void testValidatedValueJsonByTypeMetric_when42() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult =
        SparkplugMetricUtil.validatedValueJsonByTypeMetric("42", MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code Array Node Str}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String,
   * MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when 'Array Node Str'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValueJsonByTypeMetric(String, MetricDataType)"
  })
  void testValidatedValueJsonByTypeMetric_whenArrayNodeStr() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult =
        SparkplugMetricUtil.validatedValueJsonByTypeMetric("Array Node Str", MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code DataSet}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String,
   * MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when 'DataSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValueJsonByTypeMetric(String, MetricDataType)"
  })
  void testValidatedValueJsonByTypeMetric_whenDataSet() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult =
        SparkplugMetricUtil.validatedValueJsonByTypeMetric(
            "Array Node Str", MetricDataType.DataSet);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String,
   * MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValueJsonByTypeMetric(String, MetricDataType)"
  })
  void testValidatedValueJsonByTypeMetric_whenEmptyString() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult =
        SparkplugMetricUtil.validatedValueJsonByTypeMetric("", MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   *
   * <ul>
   *   <li>When {@code Int8}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String,
   * MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when 'Int8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SparkplugMetricUtil.validatedValueJsonByTypeMetric(String, MetricDataType)"
  })
  void testValidatedValueJsonByTypeMetric_whenInt8() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult =
        SparkplugMetricUtil.validatedValueJsonByTypeMetric("Array Node Str", MetricDataType.Int8);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }
}
