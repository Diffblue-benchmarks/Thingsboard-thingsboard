package org.thingsboard.server.common.adaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.primitives.UnsignedInteger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.MessageOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.UnknownFieldSet;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.gateway.metrics.GatewayMetadata;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.AttributeUpdateNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ClaimDeviceMsg;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueProto;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueType;
import org.thingsboard.server.gen.transport.TransportProtos.PostAttributeMsg;
import org.thingsboard.server.gen.transport.TransportProtos.PostTelemetryMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ProvisionDeviceResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToServerRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToServerRpcResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.TsKvListProto;

class JsonConverterDiffblueTest {
  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement() throws JsonSyntaxException {
    // Arrange and Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(
            JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1));

    // Assert
    UnknownFieldSet unknownFields = actualConvertToTelemetryProtoResult.getUnknownFields();
    PostTelemetryMsg defaultInstanceForType =
        actualConvertToTelemetryProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement2() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive('\u0001')));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement3() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement4() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement5() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray(3));

    // Act and Assert
    List<TsKvListProto> tsKvListList =
        JsonConverter.convertToTelemetryProto(jsonElement).getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals("[]", getResult.getJsonV());
    assertEquals(10, getResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement6() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");

    // Act and Assert
    List<TsKvListProto> tsKvListList =
        JsonConverter.convertToTelemetryProto(jsonElement).getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(1, getResult.getTypeValue());
    assertEquals(42L, getResult.getLongV());
    assertEquals(8, getResult.getSerializedSize());
    assertEquals(KeyValueType.LONG_V, getResult.getType());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement7() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", true);

    // Act and Assert
    List<TsKvListProto> tsKvListList =
        JsonConverter.convertToTelemetryProto(jsonElement).getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(0, getResult.getTypeValue());
    assertEquals(6, getResult.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, getResult.getType());
    assertTrue(getResult.getBoolV());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement8() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("values", new JsonArray(3));

    // Act and Assert
    List<TsKvListProto> tsKvListList =
        JsonConverter.convertToTelemetryProto(jsonElement).getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals("values", getResult.getKey());
    assertEquals(14, getResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement9() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");

    // Act and Assert
    List<TsKvListProto> tsKvListList =
        JsonConverter.convertToTelemetryProto(jsonElement).getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(".", getResult.getStringV());
    assertEquals(9, getResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement10() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "");

    // Act and Assert
    List<TsKvListProto> tsKvListList =
        JsonConverter.convertToTelemetryProto(jsonElement).getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(3, getResult.getTypeValue());
    assertEquals(6, getResult.getSerializedSize());
    assertEquals(KeyValueType.STRING_V, getResult.getType());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement11() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement12() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement13() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement14() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonObject());

    // Act and Assert
    List<TsKvListProto> tsKvListList =
        JsonConverter.convertToTelemetryProto(jsonElement).getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals("{}", getResult.getJsonV());
    assertEquals(10, getResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement15() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", JsonConverter.toGatewayDeviceDisconnectJson("ts", 1));

    // Act and Assert
    List<TsKvListProto> tsKvListList =
        JsonConverter.convertToTelemetryProto(jsonElement).getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals("{\"device\":\"ts\",\"reason\":1}", getResult.getJsonV());
    assertEquals(34, getResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs() throws JsonSyntaxException {
    // Arrange and Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(
            JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1), 1L);

    // Assert
    assertEquals(43, actualConvertToTelemetryProtoResult.getSerializedSize());
    UnknownFieldSet unknownFields = actualConvertToTelemetryProtoResult.getUnknownFields();
    PostTelemetryMsg defaultInstanceForType =
        actualConvertToTelemetryProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs2() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive('\u0001'), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs3() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs4() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs5() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray(3));

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    List<KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult2 = kvList.get(0);
    assertEquals("[]", getResult2.getJsonV());
    assertEquals(10, getResult2.getSerializedSize());
    assertEquals(14, getResult.getSerializedSize());
    assertEquals(Short.SIZE, actualConvertToTelemetryProtoResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs6() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    List<KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult2 = kvList.get(0);
    assertEquals(1, getResult2.getTypeValue());
    assertEquals(12, getResult.getSerializedSize());
    assertEquals(14, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertEquals(42L, getResult2.getLongV());
    assertEquals(8, getResult2.getSerializedSize());
    assertEquals(KeyValueType.LONG_V, getResult2.getType());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs7() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", true);

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    List<KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult2 = kvList.get(0);
    assertEquals(0, getResult2.getTypeValue());
    assertEquals(10, getResult.getSerializedSize());
    assertEquals(12, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertEquals(6, getResult2.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, getResult2.getType());
    assertTrue(getResult2.getBoolV());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs8() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("values", new JsonArray(3));

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    List<KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult2 = kvList.get(0);
    assertEquals("values", getResult2.getKey());
    assertEquals(14, getResult2.getSerializedSize());
    assertEquals(18, getResult.getSerializedSize());
    assertEquals(20, actualConvertToTelemetryProtoResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs9() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    List<KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult2 = kvList.get(0);
    assertEquals(".", getResult2.getStringV());
    assertEquals(13, getResult.getSerializedSize());
    assertEquals(15, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertEquals(9, getResult2.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs10() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "");

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    List<KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    assertEquals(10, getResult.getSerializedSize());
    assertEquals(12, actualConvertToTelemetryProtoResult.getSerializedSize());
    KeyValueProto getResult2 = kvList.get(0);
    assertEquals(3, getResult2.getTypeValue());
    assertEquals(6, getResult2.getSerializedSize());
    assertEquals(KeyValueType.STRING_V, getResult2.getType());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs11() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs12() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs13() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs14() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonObject());

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    List<KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult2 = kvList.get(0);
    assertEquals("{}", getResult2.getJsonV());
    assertEquals(10, getResult2.getSerializedSize());
    assertEquals(14, getResult.getSerializedSize());
    assertEquals(Short.SIZE, actualConvertToTelemetryProtoResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs15() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", JsonConverter.toGatewayDeviceDisconnectJson("ts", 1));

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    List<KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult2 = kvList.get(0);
    assertEquals("{\"device\":\"ts\",\"reason\":1}", getResult2.getJsonV());
    assertEquals(34, getResult2.getSerializedSize());
    assertEquals(38, getResult.getSerializedSize());
    assertEquals(40, actualConvertToTelemetryProtoResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_givenA() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_givenFalse() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>Given fromIntBits one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given fromIntBits one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_givenFromIntBitsOne()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>Given {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_givenNaN() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_givenOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_givenOne2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>Given ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_givenTen() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>Given ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_givenTen2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>Given valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_givenValueOfOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>Then return SerializedSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_thenReturnSerializedSizeIsZero()
      throws JsonSyntaxException {
    // Arrange and Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(new JsonArray(3), 1L);

    // Assert
    assertEquals(0, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertEquals(0, actualConvertToTelemetryProtoResult.getTsKvListCount());
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertTrue(tsKvListList.isEmpty());
    assertTrue(actualConvertToTelemetryProtoResult.getAllFields().isEmpty());
    assertEquals(
        actualConvertToTelemetryProtoResult,
        actualConvertToTelemetryProtoResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualConvertToTelemetryProtoResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(tsKvListList, actualConvertToTelemetryProtoResult.getTsKvListOrBuilderList());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; when JsonNull (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_whenJsonNull() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(new JsonNull(), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; when JsonObject (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_whenJsonObject() throws JsonSyntaxException {
    // Arrange and Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(new JsonObject(), 1L);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    assertEquals(1, actualConvertToTelemetryProtoResult.getDescriptorForType().getFields().size());
    assertEquals(1, getResult.getAllFields().size());
    assertEquals(2, getResult.getSerializedSize());
    assertEquals(4, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertTrue(getResult.getKvList().isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor) addProperty {@code ts} and {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; when JsonObject (default constructor) addProperty 'ts' and 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_whenJsonObjectAddPropertyTsAndNull()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", (String) null);

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    assertEquals(1, actualConvertToTelemetryProtoResult.getDescriptorForType().getFields().size());
    assertEquals(1, getResult.getAllFields().size());
    assertEquals(2, getResult.getSerializedSize());
    assertEquals(4, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertTrue(getResult.getKvList().isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; when JsonPrimitive(Boolean) with bool is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_whenJsonPrimitiveWithBoolIsTrue()
      throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive(true), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; when JsonPrimitive(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_whenJsonPrimitiveWithString()
      throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive("String"), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_givenA() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_givenFalse() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>Given fromIntBits one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given fromIntBits one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_givenFromIntBitsOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>Given {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_givenNaN() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_givenOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_givenOne2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>Given ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_givenTen() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>Given ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_givenTen2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>Given valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_givenValueOfOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>Then return SerializedSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement) with 'jsonElement'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_thenReturnSerializedSizeIsZero()
      throws JsonSyntaxException {
    // Arrange and Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(new JsonArray(3));

    // Assert
    assertEquals(0, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertEquals(0, actualConvertToTelemetryProtoResult.getTsKvListCount());
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertTrue(tsKvListList.isEmpty());
    assertTrue(actualConvertToTelemetryProtoResult.getAllFields().isEmpty());
    assertEquals(
        actualConvertToTelemetryProtoResult,
        actualConvertToTelemetryProtoResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualConvertToTelemetryProtoResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(tsKvListList, actualConvertToTelemetryProtoResult.getTsKvListOrBuilderList());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement) with 'jsonElement'; when JsonNull (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_whenJsonNull() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(new JsonNull()));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement) with 'jsonElement'; when JsonObject (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_whenJsonObject() throws JsonSyntaxException {
    // Arrange, Act and Assert
    List<TsKvListProto> tsKvListList =
        JsonConverter.convertToTelemetryProto(new JsonObject()).getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    assertTrue(getResult.getKvList().isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor) addProperty {@code ts} and {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement) with 'jsonElement'; when JsonObject (default constructor) addProperty 'ts' and 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_whenJsonObjectAddPropertyTsAndNull()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", (String) null);

    // Act and Assert
    List<TsKvListProto> tsKvListList =
        JsonConverter.convertToTelemetryProto(jsonElement).getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    assertTrue(getResult.getKvList().isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement) with 'jsonElement'; when JsonPrimitive(Boolean) with bool is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_whenJsonPrimitiveWithBoolIsTrue()
      throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive(true)));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement) with 'jsonElement'; when JsonPrimitive(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_whenJsonPrimitiveWithString()
      throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive("String")));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () ->
            JsonConverter.convertToGatewayTelemetry(
                JsonConverter.toGatewayDeviceDisconnectJson("Device Name", -1), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry2() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("ts", new JsonArray(3));

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry3() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("metadata", new JsonArray(3));

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry4() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("metadata", new JsonArray(3));
    element.addProperty("ts", true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry5() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("metadata", new JsonArray(3));
    element.addProperty("ts", true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry6() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("42", new JsonArray(3));
    element.add("metadata", new JsonArray(3));
    element.addProperty("ts", true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry7() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("42", new JsonArray(3));
    element.add("metadata", new JsonArray(3));
    element.addProperty("ts", true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenEmptyString() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add("");
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenFalse() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonArray(int) with capacity is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonArray(int) with capacity is three add 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonArrayWithCapacityIsThreeAddFalse() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonArray(int) with capacity is three add 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonArrayWithCapacityIsThreeAddTrue() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonObject() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code ts} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) addProperty 'ts' and '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonObjectAddPropertyTsAnd42() {
    // Arrange
    JsonObject element = new JsonObject();
    element.addProperty("ts", "42");

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code ts} and empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) addProperty 'ts' and empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonObjectAddPropertyTsAndEmptyString() {
    // Arrange
    JsonObject element = new JsonObject();
    element.addProperty("ts", "");

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code ts} and {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) addProperty 'ts' and 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonObjectAddPropertyTsAndNull() {
    // Arrange
    JsonObject element = new JsonObject();
    element.addProperty("ts", (Boolean) null);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code ts} and {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) addProperty 'ts' and 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonObjectAddPropertyTsAndTrue() {
    // Arrange
    JsonObject element = new JsonObject();
    element.addProperty("ts", true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given start of heading.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); given start of heading")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenStartOfHeading() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add('\u0001');
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given toGatewayDeviceDisconnectJson {@code Device Name} and one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given toGatewayDeviceDisconnectJson 'Device Name' and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenToGatewayDeviceDisconnectJsonDeviceNameAndOne() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given 'true'; when JsonArray(int) with capacity is three add 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenTrue_whenJsonArrayWithCapacityIsThreeAddTrue() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); when JsonArray(int) with capacity is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_whenJsonArrayWithCapacityIsOne() {
    // Arrange and Act
    TbPair<PostTelemetryMsg, List<GatewayMetadata>> actualConvertToGatewayTelemetryResult =
        JsonConverter.convertToGatewayTelemetry(new JsonArray(1), 1L);

    // Assert
    PostTelemetryMsg first = actualConvertToGatewayTelemetryResult.getFirst();
    assertEquals(1, first.getDescriptorForType().getFields().size());
    assertEquals(first, first.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = first.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); when JsonArray(int) with capacity is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_whenJsonArrayWithCapacityIsThree() {
    // Arrange and Act
    TbPair<PostTelemetryMsg, List<GatewayMetadata>> actualConvertToGatewayTelemetryResult =
        JsonConverter.convertToGatewayTelemetry(new JsonArray(3), 1L);

    // Assert
    PostTelemetryMsg first = actualConvertToGatewayTelemetryResult.getFirst();
    assertEquals(1, first.getDescriptorForType().getFields().size());
    assertEquals(first, first.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = first.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).
   *   <li>Then throw {@link JsonSyntaxException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); when JsonNull (default constructor); then throw JsonSyntaxException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_whenJsonNull_thenThrowJsonSyntaxException() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToGatewayTelemetry(new JsonNull(), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then throw {@link JsonSyntaxException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); when JsonObject (default constructor); then throw JsonSyntaxException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_whenJsonObject_thenThrowJsonSyntaxException() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToGatewayTelemetry(new JsonObject(), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); when JsonPrimitive(Boolean) with bool is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_whenJsonPrimitiveWithBoolIsTrue() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToGatewayTelemetry(new JsonPrimitive(true), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetry(new JsonPrimitive('\u0001'), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs3() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs4() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray(3));

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("[]", jsonValue.get());
    assertEquals("[]", getResult2.getValueAsString());
    assertEquals("[]", getResult2.getValue());
    assertEquals(DataType.JSON, getResult2.getDataType());
    assertTrue(jsonValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs5() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof StringDataEntry);
    Optional<String> strValue = getResult2.getStrValue();
    assertEquals("", strValue.get());
    assertEquals("", getResult2.getValueAsString());
    assertEquals("", getResult2.getValue());
    assertEquals(DataType.STRING, getResult2.getDataType());
    assertTrue(strValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs6() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs7() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs8() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs9() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonObject());

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("{}", jsonValue.get());
    assertEquals("{}", getResult2.getValueAsString());
    assertEquals("{}", getResult2.getValue());
    assertEquals(DataType.JSON, getResult2.getDataType());
    assertTrue(jsonValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs10() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", JsonConverter.toGatewayDeviceDisconnectJson("ts", 1));

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("{\"device\":\"ts\",\"reason\":1}", jsonValue.get());
    assertEquals("{\"device\":\"ts\",\"reason\":1}", getResult2.getValueAsString());
    assertEquals("{\"device\":\"ts\",\"reason\":1}", getResult2.getValue());
    assertEquals(DataType.JSON, getResult2.getDataType());
    assertTrue(jsonValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(new JsonArray(3), 1L, true);

    // Assert
    assertTrue(actualConvertToTelemetryResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted2() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetry(new JsonPrimitive(true), 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted3() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetry(new JsonPrimitive('\u0001'), 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted4() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted5() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted6() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray(3));

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("[]", jsonValue.get());
    assertEquals("[]", getResult2.getValueAsString());
    assertEquals("[]", getResult2.getValue());
    assertEquals(DataType.JSON, getResult2.getDataType());
    assertTrue(jsonValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted7() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof LongDataEntry);
    assertEquals("42", getResult2.getValueAsString());
    Optional<Long> longValue = getResult2.getLongValue();
    assertEquals(42L, longValue.get().longValue());
    assertEquals(42L, ((Long) getResult2.getValue()).longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
    assertTrue(longValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted8() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", true);

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof BooleanDataEntry);
    assertEquals(DataType.BOOLEAN, getResult2.getDataType());
    Optional<Double> doubleValue = getResult2.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertTrue(booleanValue.get());
    assertTrue(booleanValue.isPresent());
    assertTrue((Boolean) getResult2.getValue());
    String expectedValueAsString = Boolean.TRUE.toString();
    assertEquals(expectedValueAsString, getResult2.getValueAsString());
    assertSame(doubleValue, getResult2.getJsonValue());
    assertSame(doubleValue, getResult2.getLongValue());
    assertSame(doubleValue, getResult2.getStrValue());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted9() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("values", new JsonArray(3));

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    assertEquals("[]", getResult2.getJsonValue().get());
    assertEquals("[]", getResult2.getValueAsString());
    assertEquals("[]", getResult2.getValue());
    assertEquals("values", getResult2.getKey());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted10() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof StringDataEntry);
    Optional<String> strValue = getResult2.getStrValue();
    assertEquals(".", strValue.get());
    assertEquals(".", getResult2.getValueAsString());
    assertEquals(".", getResult2.getValue());
    assertEquals(DataType.STRING, getResult2.getDataType());
    assertTrue(strValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted11() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", (String) null);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted12() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof StringDataEntry);
    Optional<String> strValue = getResult2.getStrValue();
    assertEquals("", strValue.get());
    assertEquals("", getResult2.getValueAsString());
    assertEquals("", getResult2.getValue());
    assertEquals(DataType.STRING, getResult2.getDataType());
    assertTrue(strValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted13() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted14() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted15() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted16() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonObject());

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("{}", jsonValue.get());
    assertEquals("{}", getResult2.getValueAsString());
    assertEquals("{}", getResult2.getValue());
    assertEquals(DataType.JSON, getResult2.getDataType());
    assertTrue(jsonValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted17() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", JsonConverter.toGatewayDeviceDisconnectJson("ts", 1));

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("{\"device\":\"ts\",\"reason\":1}", jsonValue.get());
    assertEquals("{\"device\":\"ts\",\"reason\":1}", getResult2.getValueAsString());
    assertEquals("{\"device\":\"ts\",\"reason\":1}", getResult2.getValue());
    assertEquals(DataType.JSON, getResult2.getDataType());
    assertTrue(jsonValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenA() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenFalse() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>Given fromIntBits one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given fromIntBits one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenFromIntBitsOne()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>Given {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenNaN() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenOne2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>Given ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenTen() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>Given ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenTen2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>Given valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenValueOfOne()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>Then return one size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; then return one size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_thenReturnOneSizeIsTwo()
      throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(
            JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1), 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(1);
    assertTrue(getResult2 instanceof LongDataEntry);
    KvEntry getResult3 = getResult.get(0);
    assertTrue(getResult3 instanceof StringDataEntry);
    assertEquals("1", getResult2.getValueAsString());
    assertEquals("Device Name", getResult3.getValueAsString());
    assertEquals("Device Name", getResult3.getValue());
    assertEquals("device", getResult3.getKey());
    assertEquals("reason", getResult2.getKey());
    assertEquals(1L, ((Long) getResult2.getValue()).longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; when 'false'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_whenFalse_thenReturnEmpty()
      throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(new JsonArray(3), 1L, false);

    // Assert
    assertTrue(actualConvertToTelemetryResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; when JsonNull (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_whenJsonNull()
      throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetry(new JsonNull(), 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; when JsonObject (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_whenJsonObject()
      throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(new JsonObject(), 1L, true);

    // Assert
    assertTrue(actualConvertToTelemetryResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; when JsonPrimitive(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_whenJsonPrimitiveWithString()
      throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetry(new JsonPrimitive("String"), 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_givenA() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_givenFalse() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>Given fromIntBits one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given fromIntBits one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_givenFromIntBitsOne()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>Given {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_givenNaN() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_givenOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_givenOne2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>Given ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_givenTen() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>Given ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_givenTen2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>Given valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_givenValueOfOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>Then one first return {@link BooleanDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; then one first return BooleanDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_thenOneFirstReturnBooleanDataEntry()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", true);

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof BooleanDataEntry);
    assertEquals(DataType.BOOLEAN, getResult2.getDataType());
    Optional<Double> doubleValue = getResult2.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertTrue(booleanValue.get());
    assertTrue(booleanValue.isPresent());
    assertTrue((Boolean) getResult2.getValue());
    String expectedValueAsString = Boolean.TRUE.toString();
    assertEquals(expectedValueAsString, getResult2.getValueAsString());
    assertSame(doubleValue, getResult2.getJsonValue());
    assertSame(doubleValue, getResult2.getLongValue());
    assertSame(doubleValue, getResult2.getStrValue());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>Then one first return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; then one first return LongDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_thenOneFirstReturnLongDataEntry()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof LongDataEntry);
    assertEquals("42", getResult2.getValueAsString());
    Optional<Long> longValue = getResult2.getLongValue();
    assertEquals(42L, longValue.get().longValue());
    assertEquals(42L, ((Long) getResult2.getValue()).longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
    assertTrue(longValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>Then return one first Key is {@code values}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; then return one first Key is 'values'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_thenReturnOneFirstKeyIsValues()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("values", new JsonArray(3));

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    assertEquals("[]", getResult2.getJsonValue().get());
    assertEquals("[]", getResult2.getValueAsString());
    assertEquals("[]", getResult2.getValue());
    assertEquals("values", getResult2.getKey());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>Then return one first StrValue is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; then return one first StrValue is '.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_thenReturnOneFirstStrValueIsDot()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof StringDataEntry);
    Optional<String> strValue = getResult2.getStrValue();
    assertEquals(".", strValue.get());
    assertEquals(".", getResult2.getValueAsString());
    assertEquals(".", getResult2.getValue());
    assertEquals(DataType.STRING, getResult2.getDataType());
    assertTrue(strValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>Then return one size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; then return one size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_thenReturnOneSizeIsTwo()
      throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(
            JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1), 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(1);
    assertTrue(getResult2 instanceof LongDataEntry);
    KvEntry getResult3 = getResult.get(0);
    assertTrue(getResult3 instanceof StringDataEntry);
    assertEquals("1", getResult2.getValueAsString());
    assertEquals("Device Name", getResult3.getValueAsString());
    assertEquals("Device Name", getResult3.getValue());
    assertEquals("device", getResult3.getKey());
    assertEquals("reason", getResult2.getKey());
    assertEquals(1L, ((Long) getResult2.getValue()).longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; when JsonArray(int) with capacity is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_whenJsonArrayWithCapacityIsThree()
      throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(new JsonArray(3), 1L);

    // Assert
    assertTrue(actualConvertToTelemetryResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; when JsonNull (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_whenJsonNull() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(new JsonNull(), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor) addProperty {@code ts} and {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; when JsonObject (default constructor) addProperty 'ts' and 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_whenJsonObjectAddPropertyTsAndNull()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", (String) null);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; when JsonObject (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_whenJsonObject_thenReturnEmpty()
      throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(new JsonObject(), 1L);

    // Assert
    assertTrue(actualConvertToTelemetryResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; when JsonPrimitive(Boolean) with bool is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_whenJsonPrimitiveWithBoolIsTrue()
      throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetry(new JsonPrimitive(true), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; when JsonPrimitive(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_whenJsonPrimitiveWithString()
      throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetry(new JsonPrimitive("String"), 1L));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code client}.
   *   <li>Then return {@code client}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when 'client'; then return 'client'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenClient_thenReturnClient() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("client", JsonConverter.parse("client", clazz));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code JsonElement}.
   *   <li>Then return {@link JsonPrimitive}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when 'com.google.gson.JsonElement'; then return JsonPrimitive")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenComGoogleGsonJsonElement_thenReturnJsonPrimitive() {
    // Arrange
    Class<JsonElement> clazz = JsonElement.class;

    // Act
    Object actualParseResult = JsonConverter.parse("Json", clazz);

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    assertTrue(((JsonPrimitive) actualParseResult).getAsNumber() instanceof LazilyParsedNumber);
    assertEquals("Json", ((JsonPrimitive) actualParseResult).getAsString());
    assertEquals('J', ((JsonPrimitive) actualParseResult).getAsCharacter());
    assertFalse(((JsonPrimitive) actualParseResult).isJsonArray());
    assertFalse(((JsonPrimitive) actualParseResult).isJsonNull());
    assertFalse(((JsonPrimitive) actualParseResult).isJsonObject());
    assertFalse(((JsonPrimitive) actualParseResult).getAsBoolean());
    assertFalse(((JsonPrimitive) actualParseResult).isBoolean());
    assertFalse(((JsonPrimitive) actualParseResult).isNumber());
    assertTrue(((JsonPrimitive) actualParseResult).isJsonPrimitive());
    assertTrue(((JsonPrimitive) actualParseResult).isString());
    assertSame(actualParseResult, ((JsonPrimitive) actualParseResult).getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return charValue is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when '.'; then return charValue is '.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenDot_thenReturnCharValueIsDot() {
    // Arrange, Act and Assert
    assertEquals('.', ((Character) JsonConverter.parse(".", Character.TYPE)).charValue());
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when '.'; then return '.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenDot_thenReturnDot() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(".", JsonConverter.parse(".", clazz));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code E}.
   *   <li>Then return {@code E}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when 'E'; then return 'E'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenE_thenReturnE() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("E", JsonConverter.parse("E", clazz));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code Boolean}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when 'java.lang.Boolean'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenJavaLangBoolean_thenReturnFalse() {
    // Arrange
    Class<Boolean> clazz = Boolean.class;

    // Act and Assert
    assertFalse((Boolean) JsonConverter.parse("Json", clazz));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code Number}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when 'java.lang.Number'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenJavaLangNumber_thenReturnNull() {
    // Arrange
    Class<Number> clazz = Number.class;

    // Act and Assert
    assertNull(JsonConverter.parse("", clazz));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code Number}.
   *   <li>Then return toString is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when 'java.lang.Number'; then return toString is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenJavaLangNumber_thenReturnToStringIs42() {
    // Arrange
    Class<Number> clazz = Number.class;

    // Act
    Object actualParseResult = JsonConverter.parse("42", clazz);

    // Assert
    assertTrue(actualParseResult instanceof LazilyParsedNumber);
    assertEquals("42", actualParseResult.toString());
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code Number}.
   *   <li>Then return toString is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when 'java.lang.Number'; then return toString is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenJavaLangNumber_thenReturnToStringIsJson() {
    // Arrange
    Class<Number> clazz = Number.class;

    // Act
    Object actualParseResult = JsonConverter.parse("Json", clazz);

    // Assert
    assertTrue(actualParseResult instanceof LazilyParsedNumber);
    assertEquals("Json", actualParseResult.toString());
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return doubleValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when 'java.lang.Object'; then return doubleValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenJavaLangObject_thenReturnDoubleValueIsFortyTwo() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(42.0d, ((Double) JsonConverter.parse("42", clazz)).doubleValue());
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when 'java.lang.Object'; then return 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenJavaLangObject_thenReturnJson() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("Json", JsonConverter.parse("Json", clazz));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when 'java.lang.Object'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenJavaLangObject_thenReturnNull() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(JsonConverter.parse("", clazz));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when 'java.lang.String'; then return 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenJavaLangString_thenReturnJson() {
    // Arrange
    Class<String> clazz = String.class;

    // Act and Assert
    assertEquals("Json", JsonConverter.parse("Json", clazz));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when 'java.lang.String'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenJavaLangString_thenReturnNull() {
    // Arrange
    Class<String> clazz = String.class;

    // Act and Assert
    assertNull(JsonConverter.parse("", clazz));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code Collection}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when 'java.util.Collection'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenJavaUtilCollection_thenReturnNull() {
    // Arrange
    Class<Collection> clazz = Collection.class;

    // Act and Assert
    assertNull(JsonConverter.parse("", clazz));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@link Byte#TYPE}.
   *   <li>Then return byteValue is {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return byteValue is '*'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenType_thenReturnByteValueIsAsterisk() {
    // Arrange, Act and Assert
    assertEquals('*', ((Byte) JsonConverter.parse("42", Byte.TYPE)).byteValue());
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@link Double#TYPE}.
   *   <li>Then return doubleValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return doubleValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenType_thenReturnDoubleValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0d, ((Double) JsonConverter.parse("42", Double.TYPE)).doubleValue());
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@link Boolean#TYPE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenType_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((Boolean) JsonConverter.parse("Json", Boolean.TYPE));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@link Float#TYPE}.
   *   <li>Then return floatValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return floatValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenType_thenReturnFloatValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0f, ((Float) JsonConverter.parse("42", Float.TYPE)).floatValue());
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@link Integer#TYPE}.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return intValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenType_thenReturnIntValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, ((Integer) JsonConverter.parse("42", Integer.TYPE)).intValue());
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@link Long#TYPE}.
   *   <li>Then return longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return longValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenType_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L, ((Long) JsonConverter.parse("42", Long.TYPE)).longValue());
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@link Integer#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.parse("", Integer.TYPE));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@link Float#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenType_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.parse("", Float.TYPE));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@link Byte#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenType_thenReturnNull3() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.parse("", Byte.TYPE));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@link Double#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenType_thenReturnNull4() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.parse("", Double.TYPE));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@link Long#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenType_thenReturnNull5() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.parse("", Long.TYPE));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@link Character#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenType_thenReturnNull6() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.parse("", Character.TYPE));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@link Boolean#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenType_thenReturnNull7() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.parse("", Boolean.TYPE));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@link Short#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenType_thenReturnNull8() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.parse("", Short.TYPE));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@link Short#TYPE}.
   *   <li>Then return shortValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName(
      "Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return shortValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.parse(String, Class)"})
  void testParseWithJsonClazz_whenType_thenReturnShortValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals((short) 42, ((Short) JsonConverter.parse("42", Short.TYPE)).shortValue());
  }

  /**
   * Test {@link JsonConverter#parse(String)} with {@code json}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return AsString is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'json'; when '42'; then return AsString is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonConverter.parse(String)"})
  void testParseWithJson_when42_thenReturnAsStringIs42() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("42");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    assertEquals("42", actualParseResult.getAsString());
    assertEquals(42, actualParseResult.getAsInt());
    assertEquals(42L, actualParseResult.getAsLong());
    assertEquals((short) 42, actualParseResult.getAsShort());
    assertFalse(((JsonPrimitive) actualParseResult).isString());
    assertTrue(((JsonPrimitive) actualParseResult).isNumber());
    assertEquals('*', actualParseResult.getAsByte());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonConverter#parse(String)} with {@code json}.
   *
   * <ul>
   *   <li>When {@code 42.}.
   *   <li>Then return AsString is {@code 42.}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'json'; when '42.'; then return AsString is '42.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonConverter.parse(String)"})
  void testParseWithJson_when42_thenReturnAsStringIs422() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("42.");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("42.", actualParseResult.getAsString());
    assertEquals("42.", asNumber.toString());
    assertEquals(42.0d, actualParseResult.getAsDouble());
    assertEquals(42.0f, actualParseResult.getAsFloat());
    BigDecimal expectedAsBigDecimal = new BigDecimal("42");
    assertEquals(expectedAsBigDecimal, actualParseResult.getAsBigDecimal());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonConverter#parse(String)} with {@code json}.
   *
   * <ul>
   *   <li>When {@code 42E}.
   *   <li>Then return AsString is {@code 42E}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'json'; when '42E'; then return AsString is '42E'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonConverter.parse(String)"})
  void testParseWithJson_when42e_thenReturnAsStringIs42e() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("42E");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("42E", actualParseResult.getAsString());
    assertEquals("42E", asNumber.toString());
    assertEquals('4', actualParseResult.getAsCharacter());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonConverter#parse(String)} with {@code json}.
   *
   * <ul>
   *   <li>When {@code client}.
   *   <li>Then return AsString is {@code client}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'json'; when 'client'; then return AsString is 'client'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonConverter.parse(String)"})
  void testParseWithJson_whenClient_thenReturnAsStringIsClient() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("client");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("client", actualParseResult.getAsString());
    assertEquals("client", asNumber.toString());
    assertEquals('c', actualParseResult.getAsCharacter());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonConverter#parse(String)} with {@code json}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return AsString is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'json'; when '.'; then return AsString is '.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonConverter.parse(String)"})
  void testParseWithJson_whenDot_thenReturnAsStringIsDot() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse(".");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals(".", actualParseResult.getAsString());
    assertEquals(".", asNumber.toString());
    assertEquals('.', actualParseResult.getAsCharacter());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonConverter#parse(String)} with {@code json}.
   *
   * <ul>
   *   <li>When {@code E}.
   *   <li>Then return AsString is {@code E}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'json'; when 'E'; then return AsString is 'E'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonConverter.parse(String)"})
  void testParseWithJson_whenE_thenReturnAsStringIsE() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("E");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("E", actualParseResult.getAsString());
    assertEquals("E", asNumber.toString());
    assertEquals('E', actualParseResult.getAsCharacter());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonConverter#parse(String)} with {@code json}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@link JsonNull}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'json'; when empty string; then return JsonNull")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonConverter.parse(String)"})
  void testParseWithJson_whenEmptyString_thenReturnJsonNull() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("");

    // Assert
    assertTrue(actualParseResult instanceof JsonNull);
    assertFalse(actualParseResult.isJsonPrimitive());
    assertTrue(actualParseResult.isJsonNull());
    JsonNull expectedAsJsonNull = ((JsonNull) actualParseResult).INSTANCE;
    assertSame(expectedAsJsonNull, actualParseResult.getAsJsonNull());
  }

  /**
   * Test {@link JsonConverter#parse(String)} with {@code json}.
   *
   * <ul>
   *   <li>When {@code Json}.
   *   <li>Then return AsString is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'json'; when 'Json'; then return AsString is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonConverter.parse(String)"})
  void testParseWithJson_whenJson_thenReturnAsStringIsJson() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("Json");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("Json", actualParseResult.getAsString());
    assertEquals("Json", asNumber.toString());
    assertEquals('J', actualParseResult.getAsCharacter());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).
   *   <li>Then first return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); given JsonObject (default constructor); then first return Map")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_givenJsonObject_thenFirstReturnMap() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(new JsonObject());
    element.add(true);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertEquals(2, ((List<Object>) actualFromJsonResult).size());
    Object getResult = ((List<Object>) actualFromJsonResult).get(0);
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
    assertTrue((Boolean) ((List<Object>) actualFromJsonResult).get(1));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); given 'true'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_givenTrue_thenReturnSizeIsOne() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertEquals(1, ((List<Boolean>) actualFromJsonResult).size());
    assertTrue(((List<Boolean>) actualFromJsonResult).get(0));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>Then empty string return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); then empty string return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_thenEmptyStringReturnList() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("", new JsonArray(3));
    element.add("42", new JsonArray(3));
    element.add("Property", new JsonArray(3));
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertEquals(5, ((Map<String, Object>) actualFromJsonResult).size());
    Object getResult = ((Map<String, Object>) actualFromJsonResult).get("");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromJsonResult instanceof Map);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("device"));
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("reason"));
    assertEquals(getResult, ((Map<String, Object>) actualFromJsonResult).get("42"));
    assertEquals(getResult, ((Map<String, Object>) actualFromJsonResult).get("Property"));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>Then empty string return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); then empty string return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_thenEmptyStringReturnList2() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("", new JsonArray(3));
    element.add("Property", new JsonArray(3));
    element.add("", new JsonArray(3));
    element.add("42", new JsonArray(3));
    element.add("Property", new JsonArray(3));
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertEquals(5, ((Map<String, Object>) actualFromJsonResult).size());
    Object getResult = ((Map<String, Object>) actualFromJsonResult).get("");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromJsonResult instanceof Map);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("device"));
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("reason"));
    assertEquals(getResult, ((Map<String, Object>) actualFromJsonResult).get("42"));
    assertEquals(getResult, ((Map<String, Object>) actualFromJsonResult).get("Property"));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>Then first return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); then first return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_thenFirstReturnList() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(new JsonArray(3));
    element.add(true);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertEquals(2, ((List<Object>) actualFromJsonResult).size());
    Object getResult = ((List<Object>) actualFromJsonResult).get(0);
    assertTrue(getResult instanceof List);
    assertTrue(actualFromJsonResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue((Boolean) ((List<Object>) actualFromJsonResult).get(1));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>Then {@code Property} return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); then 'Property' return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_thenPropertyReturnList() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("Property", new JsonArray(3));
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertEquals(3, ((Map<String, Object>) actualFromJsonResult).size());
    Object getResult = ((Map<String, Object>) actualFromJsonResult).get("Property");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals("Device Name", ((Map<String, Object>) actualFromJsonResult).get("device"));
    assertEquals(
        1.0d, ((Double) ((Map<String, Object>) actualFromJsonResult).get("reason")).doubleValue());
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>Then return empty string is {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); then return empty string is 'Property'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_thenReturnEmptyStringIsProperty() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("Property", new JsonArray(3));
    element.add("", new JsonArray(3));
    element.add("42", new JsonArray(3));
    element.add("Property", new JsonArray(3));
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertEquals(5, ((Map<String, Object>) actualFromJsonResult).size());
    Object getResult = ((Map<String, Object>) actualFromJsonResult).get("Property");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromJsonResult instanceof Map);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("device"));
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("reason"));
    assertEquals(getResult, ((Map<String, Object>) actualFromJsonResult).get(""));
    assertEquals(getResult, ((Map<String, Object>) actualFromJsonResult).get("42"));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>Then return {@code Property} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); then return 'Property' is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_thenReturnPropertyIsNull() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("Property", null);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals(3, ((Map<String, Object>) actualFromJsonResult).size());
    assertEquals("Device Name", ((Map<String, Object>) actualFromJsonResult).get("device"));
    assertNull(((Map<String, Object>) actualFromJsonResult).get("Property"));
    assertEquals(
        1.0d, ((Double) ((Map<String, Object>) actualFromJsonResult).get("reason")).doubleValue());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); then return size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_thenReturnSizeIsFour() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("42", new JsonArray(3));
    element.add("Property", new JsonArray(3));
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertEquals(4, ((Map<String, Object>) actualFromJsonResult).size());
    Object getResult = ((Map<String, Object>) actualFromJsonResult).get("42");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromJsonResult instanceof Map);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("device"));
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("reason"));
    assertEquals(getResult, ((Map<String, Object>) actualFromJsonResult).get("Property"));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonArray(int) with capacity is one; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonArrayWithCapacityIsOne_thenReturnEmpty() {
    // Arrange
    JsonArray element = new JsonArray(1);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertTrue(((List<Object>) actualFromJsonResult).isEmpty());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add {@code null}.
   *   <li>Then return first is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonArray(int) with capacity is three add 'null'; then return first is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonArrayWithCapacityIsThreeAddNull_thenReturnFirstIsNull() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add((JsonElement) null);
    element.add(true);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertEquals(2, ((List<Boolean>) actualFromJsonResult).size());
    assertNull(((List<Boolean>) actualFromJsonResult).get(0));
    assertTrue(((List<Boolean>) actualFromJsonResult).get(1));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonArray(int) with capacity is three; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonArrayWithCapacityIsThree_thenReturnEmpty() {
    // Arrange
    JsonArray element = new JsonArray(3);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertTrue(((List<Object>) actualFromJsonResult).isEmpty());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonNull (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonNull_thenReturnNull() {
    // Arrange
    JsonNull element = new JsonNull();
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(JsonConverter.fromJson(element, type));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor) add empty string and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("", new JsonArray(3));
    element.add("42", new JsonArray(3));
    element.add("Property", new JsonArray(3));
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals(3, ((Map<String, ArrayList>) actualFromJsonResult).size());
    ArrayList getResult = ((Map<String, ArrayList>) actualFromJsonResult).get("");
    assertTrue(getResult.isEmpty());
    assertEquals(getResult, ((Map<String, ArrayList>) actualFromJsonResult).get("42"));
    assertEquals(getResult, ((Map<String, ArrayList>) actualFromJsonResult).get("Property"));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonObject (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonObject_thenReturnEmpty() {
    // Arrange
    JsonObject element = new JsonObject();
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof Map);
    assertTrue(((Map<Object, Object>) actualFromJsonResult).isEmpty());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonPrimitive(Boolean) with bool is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonPrimitiveWithBoolIsTrue_thenReturnTrue() {
    // Arrange
    JsonPrimitive element = new JsonPrimitive(true);
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue((Boolean) JsonConverter.fromJson(element, type));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonPrimitive(Boolean) with bool is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonPrimitiveWithBoolIsTrue_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue((Boolean) JsonConverter.fromJson(new JsonPrimitive(true), Boolean.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Character)} with c is {@code A}.
   *   <li>Then return charValue is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonPrimitive(Character) with c is 'A'; then return charValue is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonPrimitiveWithCIsA_thenReturnCharValueIsA() {
    // Arrange, Act and Assert
    assertEquals(
        'A',
        ((Character) JsonConverter.fromJson(new JsonPrimitive('A'), Character.TYPE)).charValue());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonPrimitive(String) with 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonPrimitiveWithString_thenReturnString() {
    // Arrange
    JsonPrimitive element = new JsonPrimitive("String");
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals("String", JsonConverter.fromJson(element, type));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When toGatewayDeviceDisconnectJson {@code Device Name} and one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when toGatewayDeviceDisconnectJson 'Device Name' and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenToGatewayDeviceDisconnectJsonDeviceNameAndOne() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals(2, ((Map<String, Object>) actualFromJsonResult).size());
    assertEquals("Device Name", ((Map<String, Object>) actualFromJsonResult).get("device"));
    assertEquals(
        1.0d, ((Double) ((Map<String, Object>) actualFromJsonResult).get("reason")).doubleValue());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Boolean#TYPE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((Boolean) JsonConverter.fromJson(new JsonPrimitive("String"), Boolean.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Integer#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Integer.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Float#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Float.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Byte#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull3() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Byte.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Double#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull4() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Double.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Long#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull5() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Long.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Character#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull6() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Character.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Boolean#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull7() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Boolean.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Short#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull8() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Short.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Void#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull9() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Void.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Integer#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull10() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(new JsonNull(), Integer.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Float#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull11() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(new JsonNull(), Float.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Byte#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull12() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(new JsonNull(), Byte.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Double#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull13() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(new JsonNull(), Double.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Long#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull14() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(new JsonNull(), Long.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Character#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull15() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(new JsonNull(), Character.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Boolean#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull16() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(new JsonNull(), Boolean.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link Short#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenType_thenReturnNull17() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(new JsonNull(), Short.TYPE));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)} with {@code deviceId},
   * {@code json}.
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, String) with 'deviceId', 'json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, String)"})
  void testConvertToClaimDeviceProtoWithDeviceIdJson() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () ->
            JsonConverter.convertToClaimDeviceProto(
                new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Json"));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)} with {@code deviceId},
   * {@code json}.
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, String) with 'deviceId', 'json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, String)"})
  void testConvertToClaimDeviceProtoWithDeviceIdJson2() {
    // Arrange and Act
    ClaimDeviceMsg actualConvertToClaimDeviceProtoResult =
        JsonConverter.convertToClaimDeviceProto(
            new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "");

    // Assert
    UnknownFieldSet unknownFields = actualConvertToClaimDeviceProtoResult.getUnknownFields();
    ClaimDeviceMsg defaultInstanceForType =
        actualConvertToClaimDeviceProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)} with {@code deviceId},
   * {@code json}.
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, String) with 'deviceId', 'json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, String)"})
  void testConvertToClaimDeviceProtoWithDeviceIdJson3() {
    // Arrange and Act
    ClaimDeviceMsg actualConvertToClaimDeviceProtoResult =
        JsonConverter.convertToClaimDeviceProto(
            new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), (String) null);

    // Assert
    UnknownFieldSet unknownFields = actualConvertToClaimDeviceProtoResult.getUnknownFields();
    ClaimDeviceMsg defaultInstanceForType =
        actualConvertToClaimDeviceProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, new JsonArray(3)));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement2() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, new JsonPrimitive(true)));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement3() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement4() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenA() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <ul>
   *   <li>Given fromIntBits one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given fromIntBits one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenFromIntBitsOne() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <ul>
   *   <li>Given {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenNaN() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <ul>
   *   <li>Given null.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given null")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenNull() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add('\u0000');

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenOne() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenOne2() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <ul>
   *   <li>Given ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenTen() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <ul>
   *   <li>Given ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenTen2() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenTrue() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);
    jsonElement.add(false);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; when JsonNull (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_whenJsonNull() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, new JsonNull()));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; when JsonPrimitive(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_whenJsonPrimitiveWithString() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, new JsonPrimitive("String")));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)} with {@code deviceId},
   * {@code json}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, String) with 'deviceId', 'json'; when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, String)"})
  void testConvertToClaimDeviceProtoWithDeviceIdJson_when42() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, "42"));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)} with {@code deviceId},
   * {@code json}.
   *
   * <ul>
   *   <li>When {@code client}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, String) with 'deviceId', 'json'; when 'client'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, String)"})
  void testConvertToClaimDeviceProtoWithDeviceIdJson_whenClient() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, "client"));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)} with {@code deviceId},
   * {@code json}.
   *
   * <ul>
   *   <li>When {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, String) with 'deviceId', 'json'; when '.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, String)"})
  void testConvertToClaimDeviceProtoWithDeviceIdJson_whenDot() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, "."));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)} with {@code deviceId},
   * {@code json}.
   *
   * <ul>
   *   <li>When {@code E}.
   *   <li>Then throw {@link JsonSyntaxException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, String) with 'deviceId', 'json'; when 'E'; then throw JsonSyntaxException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, String)"})
  void testConvertToClaimDeviceProtoWithDeviceIdJson_whenE_thenThrowJsonSyntaxException() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, "E"));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)} with {@code deviceId},
   * {@code json}.
   *
   * <ul>
   *   <li>When {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, String) with 'deviceId', 'json'; when 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, String)"})
  void testConvertToClaimDeviceProtoWithDeviceIdJson_whenJson() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, "Json"));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonObject = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    jsonObject.add(".", new JsonArray(3));

    // Act and Assert
    List<KeyValueProto> kvList = JsonConverter.convertToAttributesProto(jsonObject).getKvList();
    assertEquals(3, kvList.size());
    KeyValueProto getResult = kvList.get(2);
    assertEquals("[]", getResult.getJsonV());
    ByteString jsonVBytes = getResult.getJsonVBytes();
    ByteIterator iteratorResult = jsonVBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('[', nextResult.byteValue());
    assertEquals(']', nextResult2.byteValue());
    assertEquals("[]", jsonVBytes.toStringUtf8());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto2() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonObject = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    jsonObject.add(".", new JsonObject());

    // Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(jsonObject);

    // Assert
    List<KeyValueProto> kvList = actualConvertToAttributesProtoResult.getKvList();
    assertEquals(3, kvList.size());
    KeyValueProto getResult = kvList.get(2);
    assertEquals("{}", getResult.getJsonV());
    ByteString jsonVBytes = getResult.getJsonVBytes();
    ByteIterator iteratorResult = jsonVBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('{', nextResult.byteValue());
    assertEquals('}', nextResult2.byteValue());
    assertEquals("{}", jsonVBytes.toStringUtf8());
    assertEquals(9, getResult.getSerializedSize());
    assertEquals(50, actualConvertToAttributesProtoResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); given 'A'; when JsonArray(int) with capacity is three add 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_givenA_whenJsonArrayWithCapacityIsThreeAddA()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add((byte) 'A');
    jsonObject.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); given 'false'; when JsonArray(int) with capacity is three add 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_givenFalse_whenJsonArrayWithCapacityIsThreeAddFalse()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(false);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Given fromIntBits one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); given fromIntBits one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_givenFromIntBitsOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(UnsignedInteger.fromIntBits(1));
    jsonObject.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link Double#NaN}.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); given NaN; when JsonArray(int) with capacity is three add NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_givenNaN_whenJsonArrayWithCapacityIsThreeAddNaN()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(Double.NaN);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_givenNull() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonObject = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    jsonObject.add(".", null);

    // Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(jsonObject);

    // Assert
    assertEquals(39, actualConvertToAttributesProtoResult.getSerializedSize());
    Descriptor descriptorForType = actualConvertToAttributesProtoResult.getDescriptorForType();
    assertSame(
        descriptorForType.toProto().getDescriptorForType().toProto().getDefaultInstanceForType(),
        descriptorForType.toProto().getDescriptorForType().toProto().getDefaultInstanceForType());
    MessageOptions options = descriptorForType.getOptions();
    assertSame(options, options.getFeatures().getDescriptorForType().getOptions());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Given null.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add null.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); given null; when JsonArray(int) with capacity is three add null")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_givenNull_whenJsonArrayWithCapacityIsThreeAddNull()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add('\u0000');
    jsonObject.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); given one; when JsonArray(int) with capacity is three add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_givenOne_whenJsonArrayWithCapacityIsThreeAddOne()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(1L);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); given one; when JsonArray(int) with capacity is three add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_givenOne_whenJsonArrayWithCapacityIsThreeAddOne2()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add((short) 1);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); given ten; when JsonArray(int) with capacity is three add ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_givenTen_whenJsonArrayWithCapacityIsThreeAddTen()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(10.0d);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); given ten; when JsonArray(int) with capacity is three add ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_givenTen_whenJsonArrayWithCapacityIsThreeAddTen2()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(10.0f);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); given 'true'; when JsonArray(int) with capacity is three add 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_givenTrue_whenJsonArrayWithCapacityIsThreeAddTrue()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Given valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); given valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_givenValueOfOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(Integer.valueOf(1));
    jsonObject.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList third JsonV is empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); then return KvList third JsonV is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_thenReturnKvListThirdJsonVIsEmptyString()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonObject = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    jsonObject.addProperty(".", true);

    // Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(jsonObject);

    // Assert
    List<KeyValueProto> kvList = actualConvertToAttributesProtoResult.getKvList();
    assertEquals(3, kvList.size());
    KeyValueProto getResult = kvList.get(2);
    assertEquals("", getResult.getJsonV());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(46, actualConvertToAttributesProtoResult.getSerializedSize());
    assertEquals(5, getResult.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, getResult.getType());
    assertTrue(getResult.getBoolV());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); then return SerializedSize is twenty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_thenReturnSerializedSizeIsTwentyEight()
      throws JsonSyntaxException {
    // Arrange and Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(
            JsonConverter.toGatewayDeviceDisconnectJson("42", 1));

    // Assert
    assertEquals(28, actualConvertToAttributesProtoResult.getSerializedSize());
    UnknownFieldSet unknownFields = actualConvertToAttributesProtoResult.getUnknownFields();
    PostAttributeMsg defaultInstanceForType =
        actualConvertToAttributesProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); then return SerializedSize is twenty-nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_thenReturnSerializedSizeIsTwentyNine()
      throws JsonSyntaxException {
    // Arrange and Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(JsonConverter.toGatewayDeviceDisconnectJson(".", 1));

    // Assert
    assertEquals(29, actualConvertToAttributesProtoResult.getSerializedSize());
    UnknownFieldSet unknownFields = actualConvertToAttributesProtoResult.getUnknownFields();
    PostAttributeMsg defaultInstanceForType =
        actualConvertToAttributesProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is twenty-six.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); then return SerializedSize is twenty-six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_thenReturnSerializedSizeIsTwentySix()
      throws JsonSyntaxException {
    // Arrange and Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(JsonConverter.toGatewayDeviceDisconnectJson("", 1));

    // Assert
    assertEquals(26, actualConvertToAttributesProtoResult.getSerializedSize());
    UnknownFieldSet unknownFields = actualConvertToAttributesProtoResult.getUnknownFields();
    PostAttributeMsg defaultInstanceForType =
        actualConvertToAttributesProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); when JsonArray(int) with capacity is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_whenJsonArrayWithCapacityIsThree() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(new JsonArray(3)));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).
   *   <li>Then throw {@link JsonSyntaxException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); when JsonNull (default constructor); then throw JsonSyntaxException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_whenJsonNull_thenThrowJsonSyntaxException()
      throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(new JsonNull()));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then return KvCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); when JsonObject (default constructor); then return KvCount is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_whenJsonObject_thenReturnKvCountIsZero()
      throws JsonSyntaxException {
    // Arrange and Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(new JsonObject());

    // Assert
    assertEquals(0, actualConvertToAttributesProtoResult.getKvCount());
    assertEquals(0, actualConvertToAttributesProtoResult.getSerializedSize());
    List<KeyValueProto> kvList = actualConvertToAttributesProtoResult.getKvList();
    assertTrue(kvList.isEmpty());
    assertTrue(actualConvertToAttributesProtoResult.getAllFields().isEmpty());
    UnknownFieldSet unknownFields = actualConvertToAttributesProtoResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(kvList, actualConvertToAttributesProtoResult.getKvOrBuilderList());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); when JsonPrimitive(Boolean) with bool is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_whenJsonPrimitiveWithBoolIsTrue() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToAttributesProto(new JsonPrimitive(true)));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); when JsonPrimitive(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_whenJsonPrimitiveWithString() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToAttributesProto(new JsonPrimitive("String")));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>When toGatewayDeviceDisconnectJson {@code Device Name} and one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); when toGatewayDeviceDisconnectJson 'Device Name' and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_whenToGatewayDeviceDisconnectJsonDeviceNameAndOne()
      throws JsonSyntaxException {
    // Arrange and Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(
            JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1));

    // Assert
    assertEquals(39, actualConvertToAttributesProtoResult.getSerializedSize());
    Descriptor descriptorForType = actualConvertToAttributesProtoResult.getDescriptorForType();
    assertSame(
        descriptorForType.toProto().getDescriptorForType().toProto().getDefaultInstanceForType(),
        descriptorForType.toProto().getDescriptorForType().toProto().getDefaultInstanceForType());
    MessageOptions options = descriptorForType.getOptions();
    assertSame(options, options.getFeatures().getDescriptorForType().getOptions());
  }

  /**
   * Test {@link JsonConverter#toJson(AttributeUpdateNotificationMsg)} with {@code
   * AttributeUpdateNotificationMsg}.
   *
   * <ul>
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test toJson(AttributeUpdateNotificationMsg) with 'AttributeUpdateNotificationMsg'; then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonConverter.toJson(AttributeUpdateNotificationMsg)"})
  void testToJsonWithAttributeUpdateNotificationMsg_thenReturnSizeIsZero() {
    // Arrange and Act
    JsonObject actualToJsonResult =
        JsonConverter.toJson(AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    assertEquals(0, actualToJsonResult.size());
    assertFalse(actualToJsonResult.isJsonArray());
    assertFalse(actualToJsonResult.isJsonNull());
    assertFalse(actualToJsonResult.isJsonPrimitive());
    assertTrue(actualToJsonResult.isJsonObject());
    assertTrue(actualToJsonResult.isEmpty());
    assertSame(actualToJsonResult, actualToJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toJson(GetAttributeResponseMsg)} with {@code
   * GetAttributeResponseMsg}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test toJson(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'; when DefaultInstance; then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonConverter.toJson(GetAttributeResponseMsg)"})
  void testToJsonWithGetAttributeResponseMsg_whenDefaultInstance_thenReturnSizeIsZero() {
    // Arrange and Act
    JsonObject actualToJsonResult =
        JsonConverter.toJson(GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    assertEquals(0, actualToJsonResult.size());
    assertFalse(actualToJsonResult.isJsonArray());
    assertFalse(actualToJsonResult.isJsonNull());
    assertFalse(actualToJsonResult.isJsonPrimitive());
    assertTrue(actualToJsonResult.isJsonObject());
    assertTrue(actualToJsonResult.isEmpty());
    assertSame(actualToJsonResult, actualToJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code [false,true]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test toJson(JsonElement) with 'JsonElement'; given 'false'; then return '[false,true]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonConverter.toJson(JsonElement)"})
  void testToJsonWithJsonElement_givenFalse_thenReturnFalseTrue() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    // Act and Assert
    assertEquals("[false,true]", JsonConverter.toJson(element));
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   *
   * <ul>
   *   <li>Given null.
   *   <li>Then return {@code ["\u0000",true]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test toJson(JsonElement) with 'JsonElement'; given null; then return '[\"\\u0000\",true]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonConverter.toJson(JsonElement)"})
  void testToJsonWithJsonElement_givenNull_thenReturnU0000True() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add('\u0000');
    element.add(true);

    // Act and Assert
    assertEquals("[\"\\u0000\",true]", JsonConverter.toJson(element));
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code [true]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName("Test toJson(JsonElement) with 'JsonElement'; given 'true'; then return '[true]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonConverter.toJson(JsonElement)"})
  void testToJsonWithJsonElement_givenTrue_thenReturnTrue() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    // Act and Assert
    assertEquals("[true]", JsonConverter.toJson(element));
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   *
   * <ul>
   *   <li>Then return {@code {"device":"Device Name","reason":1}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test toJson(JsonElement) with 'JsonElement'; then return '{\"device\":\"Device Name\",\"reason\":1}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonConverter.toJson(JsonElement)"})
  void testToJsonWithJsonElement_thenReturnDeviceDeviceNameReason1() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"device\":\"Device Name\",\"reason\":1}",
        JsonConverter.toJson(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1)));
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   *
   * <ul>
   *   <li>Then return {@code {}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName("Test toJson(JsonElement) with 'JsonElement'; then return '{}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonConverter.toJson(JsonElement)"})
  void testToJsonWithJsonElement_thenReturnLeftCurlyBracketRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("{}", JsonConverter.toJson(new JsonObject()));
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   *
   * <ul>
   *   <li>Then return {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName("Test toJson(JsonElement) with 'JsonElement'; then return '[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonConverter.toJson(JsonElement)"})
  void testToJsonWithJsonElement_thenReturnLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("[]", JsonConverter.toJson(new JsonArray(3)));
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   *
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test toJson(JsonElement) with 'JsonElement'; when JsonNull (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonConverter.toJson(JsonElement)"})
  void testToJsonWithJsonElement_whenJsonNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", JsonConverter.toJson(new JsonNull()));
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   *   <li>Then return {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test toJson(JsonElement) with 'JsonElement'; when JsonPrimitive(Boolean) with bool is 'true'; then return TRUE toString")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonConverter.toJson(JsonElement)"})
  void testToJsonWithJsonElement_whenJsonPrimitiveWithBoolIsTrue_thenReturnTrueToString() {
    // Arrange and Act
    String actualToJsonResult = JsonConverter.toJson(new JsonPrimitive(true));

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualToJsonResult);
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName("Test toJson(JsonElement) with 'JsonElement'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonConverter.toJson(JsonElement)"})
  void testToJsonWithJsonElement_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", JsonConverter.toJson((JsonElement) null));
  }

  /**
   * Test {@link JsonConverter#toJson(ProvisionDeviceResponseMsg, int)} with {@code
   * ProvisionDeviceResponseMsg}, {@code int}.
   *
   * <ul>
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(ProvisionDeviceResponseMsg, int)}
   */
  @Test
  @DisplayName(
      "Test toJson(ProvisionDeviceResponseMsg, int) with 'ProvisionDeviceResponseMsg', 'int'; then return size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonConverter.toJson(ProvisionDeviceResponseMsg, int)"})
  void testToJsonWithProvisionDeviceResponseMsgInt_thenReturnSizeIsFour() {
    // Arrange and Act
    JsonObject actualToJsonResult =
        JsonConverter.toJson(ProvisionDeviceResponseMsg.getDefaultInstance(), 1);

    // Assert
    assertEquals(4, actualToJsonResult.size());
    assertFalse(actualToJsonResult.isJsonArray());
    assertFalse(actualToJsonResult.isJsonNull());
    assertFalse(actualToJsonResult.isJsonPrimitive());
    assertFalse(actualToJsonResult.isEmpty());
    assertTrue(actualToJsonResult.isJsonObject());
    assertSame(actualToJsonResult, actualToJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toJson(ProvisionDeviceResponseMsg)} with {@code
   * ProvisionDeviceResponseMsg}.
   *
   * <ul>
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test toJson(ProvisionDeviceResponseMsg) with 'ProvisionDeviceResponseMsg'; then return size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonConverter.toJson(ProvisionDeviceResponseMsg)"})
  void testToJsonWithProvisionDeviceResponseMsg_thenReturnSizeIsThree() {
    // Arrange and Act
    JsonObject actualToJsonResult =
        JsonConverter.toJson(ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    assertEquals(3, actualToJsonResult.size());
    assertFalse(actualToJsonResult.isJsonArray());
    assertFalse(actualToJsonResult.isJsonNull());
    assertFalse(actualToJsonResult.isJsonPrimitive());
    assertFalse(actualToJsonResult.isEmpty());
    assertTrue(actualToJsonResult.isJsonObject());
    assertSame(actualToJsonResult, actualToJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toJson(ToDeviceRpcRequestMsg, boolean)} with {@code
   * ToDeviceRpcRequestMsg}, {@code boolean}.
   *
   * <ul>
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(TransportProtos.ToDeviceRpcRequestMsg,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test toJson(ToDeviceRpcRequestMsg, boolean) with 'ToDeviceRpcRequestMsg', 'boolean'; then return size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "JsonElement JsonConverter.toJson(TransportProtos.ToDeviceRpcRequestMsg, boolean)"
  })
  void testToJsonWithToDeviceRpcRequestMsgBoolean_thenReturnSizeIsThree() {
    // Arrange and Act
    JsonElement actualToJsonResult =
        JsonConverter.toJson(ToDeviceRpcRequestMsg.getDefaultInstance(), true);

    // Assert
    assertTrue(actualToJsonResult instanceof JsonObject);
    assertEquals(3, ((JsonObject) actualToJsonResult).size());
    assertFalse(actualToJsonResult.isJsonArray());
    assertFalse(actualToJsonResult.isJsonNull());
    assertFalse(actualToJsonResult.isJsonPrimitive());
    assertFalse(((JsonObject) actualToJsonResult).isEmpty());
    assertTrue(actualToJsonResult.isJsonObject());
    assertSame(actualToJsonResult, actualToJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toJson(ToDeviceRpcRequestMsg, boolean)} with {@code
   * ToDeviceRpcRequestMsg}, {@code boolean}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(TransportProtos.ToDeviceRpcRequestMsg,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test toJson(ToDeviceRpcRequestMsg, boolean) with 'ToDeviceRpcRequestMsg', 'boolean'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "JsonElement JsonConverter.toJson(TransportProtos.ToDeviceRpcRequestMsg, boolean)"
  })
  void testToJsonWithToDeviceRpcRequestMsgBoolean_thenReturnSizeIsTwo() {
    // Arrange and Act
    JsonElement actualToJsonResult =
        JsonConverter.toJson(ToDeviceRpcRequestMsg.getDefaultInstance(), false);

    // Assert
    assertTrue(actualToJsonResult instanceof JsonObject);
    assertEquals(2, ((JsonObject) actualToJsonResult).size());
    assertFalse(actualToJsonResult.isJsonArray());
    assertFalse(actualToJsonResult.isJsonNull());
    assertFalse(actualToJsonResult.isJsonPrimitive());
    assertFalse(((JsonObject) actualToJsonResult).isEmpty());
    assertTrue(actualToJsonResult.isJsonObject());
    assertSame(actualToJsonResult, actualToJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toJson(ToServerRpcResponseMsg)} with {@code ToServerRpcResponseMsg}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return {@link JsonNull}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test toJson(ToServerRpcResponseMsg) with 'ToServerRpcResponseMsg'; when DefaultInstance; then return JsonNull")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonConverter.toJson(TransportProtos.ToServerRpcResponseMsg)"})
  void testToJsonWithToServerRpcResponseMsg_whenDefaultInstance_thenReturnJsonNull() {
    // Arrange and Act
    JsonElement actualToJsonResult =
        JsonConverter.toJson(ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    assertTrue(actualToJsonResult instanceof JsonNull);
    assertFalse(actualToJsonResult.isJsonArray());
    assertFalse(actualToJsonResult.isJsonObject());
    assertFalse(actualToJsonResult.isJsonPrimitive());
    assertTrue(actualToJsonResult.isJsonNull());
    JsonNull expectedAsJsonNull = ((JsonNull) actualToJsonResult).INSTANCE;
    assertSame(expectedAsJsonNull, actualToJsonResult.getAsJsonNull());
  }

  /**
   * Test {@link JsonConverter#toJsonObject(Object)}.
   *
   * <p>Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  @DisplayName("Test toJsonObject(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonConverter.toJsonObject(Object)"})
  void testToJsonObject() {
    // Arrange
    JsonObject toGatewayDeviceDisconnectJsonResult =
        JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    toGatewayDeviceDisconnectJsonResult.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(
        toGatewayDeviceDisconnectJsonResult,
        JsonConverter.toJsonObject(toGatewayDeviceDisconnectJsonResult));
  }

  /**
   * Test {@link JsonConverter#toJsonObject(Object)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  @DisplayName("Test toJsonObject(Object); given '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonConverter.toJsonObject(Object)"})
  void testToJsonObject_given42() {
    // Arrange
    JsonObject toGatewayDeviceDisconnectJsonResult =
        JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    toGatewayDeviceDisconnectJsonResult.add("42", new JsonArray(3));
    toGatewayDeviceDisconnectJsonResult.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(
        toGatewayDeviceDisconnectJsonResult,
        JsonConverter.toJsonObject(toGatewayDeviceDisconnectJsonResult));
  }

  /**
   * Test {@link JsonConverter#toJsonObject(Object)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link JsonObject} (default constructor) addProperty {@code Property} and {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  @DisplayName(
      "Test toJsonObject(Object); given 'true'; when JsonObject (default constructor) addProperty 'Property' and 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonConverter.toJsonObject(Object)"})
  void testToJsonObject_givenTrue_whenJsonObjectAddPropertyPropertyAndTrue() {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("Property", true);

    // Act and Assert
    assertEquals(jsonObject, JsonConverter.toJsonObject(jsonObject));
  }

  /**
   * Test {@link JsonConverter#toJsonObject(Object)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor) add {@code Property} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  @DisplayName(
      "Test toJsonObject(Object); when JsonObject (default constructor) add 'Property' and JsonArray(int) with capacity is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonConverter.toJsonObject(Object)"})
  void testToJsonObject_whenJsonObjectAddPropertyAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(jsonObject, JsonConverter.toJsonObject(jsonObject));
  }

  /**
   * Test {@link JsonConverter#toJsonObject(Object)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then return {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  @DisplayName(
      "Test toJsonObject(Object); when JsonObject (default constructor); then return JsonObject (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonConverter.toJsonObject(Object)"})
  void testToJsonObject_whenJsonObject_thenReturnJsonObject() {
    // Arrange
    JsonObject jsonObject = new JsonObject();

    // Act and Assert
    assertEquals(jsonObject, JsonConverter.toJsonObject(jsonObject));
  }

  /**
   * Test {@link JsonConverter#toJsonObject(Object)}.
   *
   * <ul>
   *   <li>When toGatewayDeviceDisconnectJson {@code Device Name} and one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  @DisplayName(
      "Test toJsonObject(Object); when toGatewayDeviceDisconnectJson 'Device Name' and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonConverter.toJsonObject(Object)"})
  void testToJsonObject_whenToGatewayDeviceDisconnectJsonDeviceNameAndOne() {
    // Arrange
    JsonObject toGatewayDeviceDisconnectJsonResult =
        JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);

    // Act and Assert
    assertEquals(
        toGatewayDeviceDisconnectJsonResult,
        JsonConverter.toJsonObject(toGatewayDeviceDisconnectJsonResult));
  }

  /**
   * Test {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(JsonElement, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest() throws JsonSyntaxException {
    // Arrange
    JsonObject json = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    json.addProperty("method", "42");

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    UnknownFieldSet unknownFields = actualConvertToServerRpcRequestResult.getUnknownFields();
    ToServerRpcRequestMsg defaultInstanceForType =
        actualConvertToServerRpcRequestResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(JsonElement, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest2() throws JsonSyntaxException {
    // Arrange
    JsonArray value = new JsonArray(3);

    JsonObject json = new JsonObject();
    json.add("params", value);
    json.addProperty("method", true);

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    assertEquals("[]", actualConvertToServerRpcRequestResult.getParams());
    ByteString paramsBytes = actualConvertToServerRpcRequestResult.getParamsBytes();
    ByteIterator iteratorResult = paramsBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('[', nextResult.byteValue());
    assertEquals(']', nextResult2.byteValue());
    assertEquals("[]", paramsBytes.toStringUtf8());
  }

  /**
   * Test {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}
   */
  @Test
  @DisplayName(
      "Test convertToServerRpcRequest(JsonElement, int); given JsonArray(int) with capacity is three add 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest_givenJsonArrayWithCapacityIsThreeAddTrue()
      throws JsonSyntaxException {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add(true);

    JsonObject json = new JsonObject();
    json.add("method", value);

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    ByteString paramsBytes = actualConvertToServerRpcRequestResult.getParamsBytes();
    assertEquals("null", paramsBytes.toStringUtf8());
    assertEquals("null", actualConvertToServerRpcRequestResult.getParams());
    ByteIterator iteratorResult = paramsBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('n', iteratorResult.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}.
   *
   * <ul>
   *   <li>Given valueOf minus one.
   *   <li>Then return MethodName is {@code -1}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}
   */
  @Test
  @DisplayName(
      "Test convertToServerRpcRequest(JsonElement, int); given valueOf minus one; then return MethodName is '-1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest_givenValueOfMinusOne_thenReturnMethodNameIs1()
      throws JsonSyntaxException {
    // Arrange
    Integer value = Integer.valueOf(-1);

    JsonObject json = new JsonObject();
    json.addProperty("method", value);

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    assertEquals("-1", actualConvertToServerRpcRequestResult.getMethodName());
    ByteString methodNameBytes = actualConvertToServerRpcRequestResult.getMethodNameBytes();
    ByteIterator iteratorResult = methodNameBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('-', nextResult.byteValue());
    assertEquals('1', nextResult2.byteValue());
    assertEquals("-1", methodNameBytes.toStringUtf8());
  }

  /**
   * Test {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}.
   *
   * <ul>
   *   <li>Then return DescriptorForType Fields size is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}
   */
  @Test
  @DisplayName(
      "Test convertToServerRpcRequest(JsonElement, int); then return DescriptorForType Fields size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest_thenReturnDescriptorForTypeFieldsSizeIsThree()
      throws JsonSyntaxException {
    // Arrange
    Integer value = Integer.valueOf(1);

    JsonObject json = new JsonObject();
    json.addProperty("params", value);
    json.addProperty("method", true);

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    Descriptor descriptorForType = actualConvertToServerRpcRequestResult.getDescriptorForType();
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    FieldDescriptor getResult = fields.get(1);
    assertSame(value, fields.get(0).getNumber());
    assertSame(value, getResult.getIndex());
    FileDescriptor file = descriptorForType.getFile();
    assertEquals(10, file.getEnumTypes().size());
    assertEquals(180, file.getMessageTypes().size());
    assertEquals("1", actualConvertToServerRpcRequestResult.getParams());
    ByteString paramsBytes = actualConvertToServerRpcRequestResult.getParamsBytes();
    ByteIterator iteratorResult = paramsBytes.iterator();
    Byte nextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('1', nextResult.byteValue());
    assertEquals("1", paramsBytes.toStringUtf8());
    assertEquals(11, actualConvertToServerRpcRequestResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}.
   *
   * <ul>
   *   <li>Then return MethodName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(JsonElement, int); then return MethodName is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest_thenReturnMethodNameIs42() throws JsonSyntaxException {
    // Arrange
    JsonObject json = new JsonObject();
    json.addProperty("method", "42");

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    assertEquals("42", actualConvertToServerRpcRequestResult.getMethodName());
    ByteString methodNameBytes = actualConvertToServerRpcRequestResult.getMethodNameBytes();
    ByteIterator iteratorResult = methodNameBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('4', nextResult.byteValue());
    assertEquals('2', nextResult2.byteValue());
    assertEquals("42", methodNameBytes.toStringUtf8());
  }

  /**
   * Test {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}.
   *
   * <ul>
   *   <li>Then return MethodName is {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}
   */
  @Test
  @DisplayName(
      "Test convertToServerRpcRequest(JsonElement, int); then return MethodName is TRUE toString")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest_thenReturnMethodNameIsTrueToString()
      throws JsonSyntaxException {
    // Arrange
    JsonObject json = new JsonObject();
    json.addProperty("params", true);
    json.addProperty("method", true);

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    String expectedMethodName = Boolean.TRUE.toString();
    assertEquals(expectedMethodName, actualConvertToServerRpcRequestResult.getMethodName());
    ByteString methodNameBytes = actualConvertToServerRpcRequestResult.getMethodNameBytes();
    ByteIterator iteratorResult = methodNameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    String expectedToStringUtf8Result = Boolean.TRUE.toString();
    assertEquals(expectedToStringUtf8Result, methodNameBytes.toStringUtf8());
    String expectedParams = Boolean.TRUE.toString();
    assertEquals(expectedParams, actualConvertToServerRpcRequestResult.getParams());
    assertEquals(methodNameBytes, actualConvertToServerRpcRequestResult.getParamsBytes());
  }

  /**
   * Test {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}.
   *
   * <ul>
   *   <li>Then return ParamsBytes toStringUtf8 is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}
   */
  @Test
  @DisplayName(
      "Test convertToServerRpcRequest(JsonElement, int); then return ParamsBytes toStringUtf8 is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest_thenReturnParamsBytesToStringUtf8IsNull()
      throws JsonSyntaxException {
    // Arrange
    JsonObject json = new JsonObject();
    json.addProperty("method", true);

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    ByteString paramsBytes = actualConvertToServerRpcRequestResult.getParamsBytes();
    assertEquals("null", paramsBytes.toStringUtf8());
    assertEquals("null", actualConvertToServerRpcRequestResult.getParams());
    ByteIterator iteratorResult = paramsBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('n', iteratorResult.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}.
   *
   * <ul>
   *   <li>Then return Params is {@link Boolean#FALSE} toString.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}
   */
  @Test
  @DisplayName(
      "Test convertToServerRpcRequest(JsonElement, int); then return Params is FALSE toString")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest_thenReturnParamsIsFalseToString() throws JsonSyntaxException {
    // Arrange
    JsonObject json = new JsonObject();
    json.addProperty("params", false);
    json.addProperty("method", true);

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    String expectedParams = Boolean.FALSE.toString();
    assertEquals(expectedParams, actualConvertToServerRpcRequestResult.getParams());
    ByteString paramsBytes = actualConvertToServerRpcRequestResult.getParamsBytes();
    ByteIterator iteratorResult = paramsBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('f', iteratorResult.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    String expectedToStringUtf8Result = Boolean.FALSE.toString();
    assertEquals(expectedToStringUtf8Result, paramsBytes.toStringUtf8());
  }

  /**
   * Test {@link JsonConverter#getJsonObjectForGateway(String, AttributeUpdateNotificationMsg)} with
   * {@code deviceName}, {@code notificationMsg}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#getJsonObjectForGateway(String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test getJsonObjectForGateway(String, AttributeUpdateNotificationMsg) with 'deviceName', 'notificationMsg'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "JsonObject JsonConverter.getJsonObjectForGateway(String, AttributeUpdateNotificationMsg)"
  })
  void testGetJsonObjectForGatewayWithDeviceNameNotificationMsg_thenReturnSizeIsTwo() {
    // Arrange and Act
    JsonObject actualJsonObjectForGateway =
        JsonConverter.getJsonObjectForGateway(
            "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    assertEquals(2, actualJsonObjectForGateway.size());
    assertFalse(actualJsonObjectForGateway.isJsonArray());
    assertFalse(actualJsonObjectForGateway.isJsonNull());
    assertFalse(actualJsonObjectForGateway.isJsonPrimitive());
    assertFalse(actualJsonObjectForGateway.isEmpty());
    assertTrue(actualJsonObjectForGateway.isJsonObject());
    assertSame(actualJsonObjectForGateway, actualJsonObjectForGateway.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#getJsonObjectForGateway(String, GetAttributeResponseMsg)} with {@code
   * deviceName}, {@code responseMsg}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#getJsonObjectForGateway(String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test getJsonObjectForGateway(String, GetAttributeResponseMsg) with 'deviceName', 'responseMsg'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "JsonObject JsonConverter.getJsonObjectForGateway(String, GetAttributeResponseMsg)"
  })
  void testGetJsonObjectForGatewayWithDeviceNameResponseMsg_thenReturnSizeIsTwo() {
    // Arrange and Act
    JsonObject actualJsonObjectForGateway =
        JsonConverter.getJsonObjectForGateway(
            "Device Name", GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    assertEquals(2, actualJsonObjectForGateway.size());
    assertFalse(actualJsonObjectForGateway.isJsonArray());
    assertFalse(actualJsonObjectForGateway.isJsonNull());
    assertFalse(actualJsonObjectForGateway.isJsonPrimitive());
    assertFalse(actualJsonObjectForGateway.isEmpty());
    assertTrue(actualJsonObjectForGateway.isJsonObject());
    assertSame(actualJsonObjectForGateway, actualJsonObjectForGateway.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toGatewayDeviceDisconnectJson(String, int)}.
   *
   * <ul>
   *   <li>When {@code Device Name}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toGatewayDeviceDisconnectJson(String, int)}
   */
  @Test
  @DisplayName("Test toGatewayDeviceDisconnectJson(String, int); when 'Device Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonConverter.toGatewayDeviceDisconnectJson(String, int)"})
  void testToGatewayDeviceDisconnectJson_whenDeviceName() {
    // Arrange and Act
    JsonObject actualToGatewayDeviceDisconnectJsonResult =
        JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);

    // Assert
    assertEquals(2, actualToGatewayDeviceDisconnectJsonResult.size());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonArray());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonNull());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonPrimitive());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isEmpty());
    assertTrue(actualToGatewayDeviceDisconnectJsonResult.isJsonObject());
    assertSame(
        actualToGatewayDeviceDisconnectJsonResult,
        actualToGatewayDeviceDisconnectJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toGatewayDeviceDisconnectJson(String, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toGatewayDeviceDisconnectJson(String, int)}
   */
  @Test
  @DisplayName("Test toGatewayDeviceDisconnectJson(String, int); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonConverter.toGatewayDeviceDisconnectJson(String, int)"})
  void testToGatewayDeviceDisconnectJson_whenNull() {
    // Arrange and Act
    JsonObject actualToGatewayDeviceDisconnectJsonResult =
        JsonConverter.toGatewayDeviceDisconnectJson(null, 1);

    // Assert
    assertEquals(2, actualToGatewayDeviceDisconnectJsonResult.size());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonArray());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonNull());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonPrimitive());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isEmpty());
    assertTrue(actualToGatewayDeviceDisconnectJsonResult.isJsonObject());
    assertSame(
        actualToGatewayDeviceDisconnectJsonResult,
        actualToGatewayDeviceDisconnectJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toErrorJson(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toErrorJson(String)}
   */
  @Test
  @DisplayName("Test toErrorJson(String); when 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonConverter.toErrorJson(String)"})
  void testToErrorJson_whenAnErrorOccurred() {
    // Arrange and Act
    JsonElement actualToErrorJsonResult = JsonConverter.toErrorJson("An error occurred");

    // Assert
    assertTrue(actualToErrorJsonResult instanceof JsonObject);
    assertEquals(1, ((JsonObject) actualToErrorJsonResult).size());
    assertFalse(actualToErrorJsonResult.isJsonArray());
    assertFalse(actualToErrorJsonResult.isJsonNull());
    assertFalse(actualToErrorJsonResult.isJsonPrimitive());
    assertFalse(((JsonObject) actualToErrorJsonResult).isEmpty());
    assertTrue(actualToErrorJsonResult.isJsonObject());
    assertSame(actualToErrorJsonResult, actualToErrorJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toErrorJson(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toErrorJson(String)}
   */
  @Test
  @DisplayName("Test toErrorJson(String); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonConverter.toErrorJson(String)"})
  void testToErrorJson_whenNull() {
    // Arrange and Act
    JsonElement actualToErrorJsonResult = JsonConverter.toErrorJson(null);

    // Assert
    assertTrue(actualToErrorJsonResult instanceof JsonObject);
    assertEquals(1, ((JsonObject) actualToErrorJsonResult).size());
    assertFalse(actualToErrorJsonResult.isJsonArray());
    assertFalse(actualToErrorJsonResult.isJsonNull());
    assertFalse(actualToErrorJsonResult.isJsonPrimitive());
    assertFalse(((JsonObject) actualToErrorJsonResult).isEmpty());
    assertTrue(actualToErrorJsonResult.isJsonObject());
    assertSame(actualToErrorJsonResult, actualToErrorJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toGatewayJson(String, ProvisionDeviceResponseMsg)} with {@code
   * deviceName}, {@code responseRequest}.
   *
   * <ul>
   *   <li>Then return {@link JsonObject}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toGatewayJson(String, ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test toGatewayJson(String, ProvisionDeviceResponseMsg) with 'deviceName', 'responseRequest'; then return JsonObject")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonConverter.toGatewayJson(String, ProvisionDeviceResponseMsg)"})
  void testToGatewayJsonWithDeviceNameResponseRequest_thenReturnJsonObject() {
    // Arrange and Act
    JsonElement actualToGatewayJsonResult =
        JsonConverter.toGatewayJson("Device Name", ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    assertTrue(actualToGatewayJsonResult instanceof JsonObject);
    assertEquals(2, ((JsonObject) actualToGatewayJsonResult).size());
    assertFalse(actualToGatewayJsonResult.isJsonArray());
    assertFalse(actualToGatewayJsonResult.isJsonNull());
    assertFalse(actualToGatewayJsonResult.isJsonPrimitive());
    assertFalse(((JsonObject) actualToGatewayJsonResult).isEmpty());
    assertTrue(actualToGatewayJsonResult.isJsonObject());
    assertSame(actualToGatewayJsonResult, actualToGatewayJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toGatewayJson(String, ProvisionDeviceResponseMsg)} with {@code
   * deviceName}, {@code responseRequest}.
   *
   * <ul>
   *   <li>When {@code device}.
   *   <li>Then return {@link JsonObject}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toGatewayJson(String, ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test toGatewayJson(String, ProvisionDeviceResponseMsg) with 'deviceName', 'responseRequest'; when 'device'; then return JsonObject")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonConverter.toGatewayJson(String, ProvisionDeviceResponseMsg)"})
  void testToGatewayJsonWithDeviceNameResponseRequest_whenDevice_thenReturnJsonObject() {
    // Arrange and Act
    JsonElement actualToGatewayJsonResult =
        JsonConverter.toGatewayJson("device", ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    assertTrue(actualToGatewayJsonResult instanceof JsonObject);
    assertEquals(2, ((JsonObject) actualToGatewayJsonResult).size());
    assertFalse(actualToGatewayJsonResult.isJsonArray());
    assertFalse(actualToGatewayJsonResult.isJsonNull());
    assertFalse(actualToGatewayJsonResult.isJsonPrimitive());
    assertFalse(((JsonObject) actualToGatewayJsonResult).isEmpty());
    assertTrue(actualToGatewayJsonResult.isJsonObject());
    assertSame(actualToGatewayJsonResult, actualToGatewayJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toGatewayJson(String, ToDeviceRpcRequestMsg)} with {@code
   * deviceName}, {@code rpcRequest}.
   *
   * <ul>
   *   <li>Then return {@link JsonObject}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toGatewayJson(String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test toGatewayJson(String, ToDeviceRpcRequestMsg) with 'deviceName', 'rpcRequest'; then return JsonObject")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "JsonElement JsonConverter.toGatewayJson(String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testToGatewayJsonWithDeviceNameRpcRequest_thenReturnJsonObject() {
    // Arrange and Act
    JsonElement actualToGatewayJsonResult =
        JsonConverter.toGatewayJson("Device Name", ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    assertTrue(actualToGatewayJsonResult instanceof JsonObject);
    assertEquals(2, ((JsonObject) actualToGatewayJsonResult).size());
    assertFalse(actualToGatewayJsonResult.isJsonArray());
    assertFalse(actualToGatewayJsonResult.isJsonNull());
    assertFalse(actualToGatewayJsonResult.isJsonPrimitive());
    assertFalse(((JsonObject) actualToGatewayJsonResult).isEmpty());
    assertTrue(actualToGatewayJsonResult.isJsonObject());
    assertSame(actualToGatewayJsonResult, actualToGatewayJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.addProperty(".", true);

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult =
        JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(3, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); given JsonArray(int) with capacity is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_givenJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add(".", new JsonArray(3));

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult =
        JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(3, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributes(JsonElement); given JsonArray(int) with capacity is three add 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_givenJsonArrayWithCapacityIsThreeAddFalse() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add(false);
    value.add(true);
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add(".", value);

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult =
        JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(3, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add start of heading.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributes(JsonElement); given JsonArray(int) with capacity is three add start of heading")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_givenJsonArrayWithCapacityIsThreeAddStartOfHeading() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add('\u0001');
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add(".", value);

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult =
        JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(3, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributes(JsonElement); given JsonArray(int) with capacity is three add 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_givenJsonArrayWithCapacityIsThreeAddTrue() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add(true);
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add(".", value);

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult =
        JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(3, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); given JsonObject (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_givenJsonObject() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add(".", new JsonObject());

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult =
        JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(3, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then throw {@link JsonSyntaxException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributes(JsonElement); given 'null'; then throw JsonSyntaxException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_givenNull_thenThrowJsonSyntaxException() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add(".", null);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributes(element));
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Given toGatewayDeviceDisconnectJson {@code .} and one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributes(JsonElement); given toGatewayDeviceDisconnectJson '.' and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_givenToGatewayDeviceDisconnectJsonDotAndOne() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add(".", JsonConverter.toGatewayDeviceDisconnectJson(".", 1));

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult =
        JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(3, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributes(JsonElement); when JsonObject (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_whenJsonObject_thenReturnEmpty() {
    // Arrange and Act
    Set<AttributeKvEntry> actualConvertToAttributesResult =
        JsonConverter.convertToAttributes(new JsonObject());

    // Assert
    assertTrue(actualConvertToAttributesResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>When toGatewayDeviceDisconnectJson {@code 42} and one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributes(JsonElement); when toGatewayDeviceDisconnectJson '42' and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_whenToGatewayDeviceDisconnectJson42AndOne() {
    // Arrange and Act
    Set<AttributeKvEntry> actualConvertToAttributesResult =
        JsonConverter.convertToAttributes(JsonConverter.toGatewayDeviceDisconnectJson("42", 1));

    // Assert
    assertEquals(2, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>When toGatewayDeviceDisconnectJson {@code Device Name} and one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributes(JsonElement); when toGatewayDeviceDisconnectJson 'Device Name' and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_whenToGatewayDeviceDisconnectJsonDeviceNameAndOne() {
    // Arrange and Act
    Set<AttributeKvEntry> actualConvertToAttributesResult =
        JsonConverter.convertToAttributes(
            JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1));

    // Assert
    assertEquals(2, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>When toGatewayDeviceDisconnectJson {@code .} and one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributes(JsonElement); when toGatewayDeviceDisconnectJson '.' and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_whenToGatewayDeviceDisconnectJsonDotAndOne() {
    // Arrange and Act
    Set<AttributeKvEntry> actualConvertToAttributesResult =
        JsonConverter.convertToAttributes(JsonConverter.toGatewayDeviceDisconnectJson(".", 1));

    // Assert
    assertEquals(2, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>When toGatewayDeviceDisconnectJson empty string and one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributes(JsonElement); when toGatewayDeviceDisconnectJson empty string and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_whenToGatewayDeviceDisconnectJsonEmptyStringAndOne() {
    // Arrange and Act
    Set<AttributeKvEntry> actualConvertToAttributesResult =
        JsonConverter.convertToAttributes(JsonConverter.toGatewayDeviceDisconnectJson("", 1));

    // Assert
    assertEquals(2, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry2() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray(3));

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("[]", jsonValue.get());
    assertEquals("[]", getResult2.getValueAsString());
    assertEquals("[]", getResult2.getValue());
    assertEquals(DataType.JSON, getResult2.getDataType());
    assertTrue(jsonValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry3() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonObject());

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("{}", jsonValue.get());
    assertEquals("{}", getResult2.getValueAsString());
    assertEquals("{}", getResult2.getValue());
    assertEquals(DataType.JSON, getResult2.getDataType());
    assertTrue(jsonValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then one first return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given '42'; then one first return LongDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_given42_thenOneFirstReturnLongDataEntry()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof LongDataEntry);
    assertEquals("42", getResult2.getValueAsString());
    Optional<Long> longValue = getResult2.getLongValue();
    assertEquals(42L, longValue.get().longValue());
    assertEquals(42L, ((Long) getResult2.getValue()).longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
    assertTrue(longValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given 'A'; when JsonArray(int) with capacity is three add 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenA_whenJsonArrayWithCapacityIsThreeAddA()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>Then return one first StrValue is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given '.'; then return one first StrValue is '.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenDot_thenReturnOneFirstStrValueIsDot()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof StringDataEntry);
    Optional<String> strValue = getResult2.getStrValue();
    assertEquals(".", strValue.get());
    assertEquals(".", getResult2.getValueAsString());
    assertEquals(".", getResult2.getValue());
    assertEquals(DataType.STRING, getResult2.getDataType());
    assertTrue(strValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given 'false'; when JsonArray(int) with capacity is three add 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenFalse_whenJsonArrayWithCapacityIsThreeAddFalse()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given fromIntBits one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given fromIntBits one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenFromIntBitsOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given JsonArray(int) with capacity is three add 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenJsonArrayWithCapacityIsThreeAddFalse()
      throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given JsonArray(int) with capacity is three add 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenJsonArrayWithCapacityIsThreeAddTrue()
      throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@link Double#NaN}.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given NaN; when JsonArray(int) with capacity is three add NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenNaN_whenJsonArrayWithCapacityIsThreeAddNaN()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link JsonObject} (default constructor) addProperty {@code ts} and {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given 'null'; when JsonObject (default constructor) addProperty 'ts' and 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenNull_whenJsonObjectAddPropertyTsAndNull()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", (String) null);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given one; when JsonArray(int) with capacity is three add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenOne_whenJsonArrayWithCapacityIsThreeAddOne()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given one; when JsonArray(int) with capacity is three add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenOne_whenJsonArrayWithCapacityIsThreeAddOne2()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given ten; when JsonArray(int) with capacity is three add ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenTen_whenJsonArrayWithCapacityIsThreeAddTen()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given ten; when JsonArray(int) with capacity is three add ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenTen_whenJsonArrayWithCapacityIsThreeAddTen2()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given 'true'; when JsonArray(int) with capacity is three add 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenTrue_whenJsonArrayWithCapacityIsThreeAddTrue()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenValueOfOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@code values}.
   *   <li>Then return one first Key is {@code values}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given 'values'; then return one first Key is 'values'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenValues_thenReturnOneFirstKeyIsValues()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("values", new JsonArray(3));

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    assertEquals("[]", getResult2.getJsonValue().get());
    assertEquals("[]", getResult2.getValueAsString());
    assertEquals("[]", getResult2.getValue());
    assertEquals("values", getResult2.getKey());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Then one first return {@link BooleanDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); then one first return BooleanDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_thenOneFirstReturnBooleanDataEntry()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", true);

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof BooleanDataEntry);
    assertEquals(DataType.BOOLEAN, getResult2.getDataType());
    Optional<Double> doubleValue = getResult2.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertTrue(booleanValue.get());
    assertTrue(booleanValue.isPresent());
    assertTrue((Boolean) getResult2.getValue());
    String expectedValueAsString = Boolean.TRUE.toString();
    assertEquals(expectedValueAsString, getResult2.getValueAsString());
    assertSame(doubleValue, getResult2.getJsonValue());
    assertSame(doubleValue, getResult2.getLongValue());
    assertSame(doubleValue, getResult2.getStrValue());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Then return one first JsonValue is {@code {"device":"ts","reason":1}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); then return one first JsonValue is '{\"device\":\"ts\",\"reason\":1}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_thenReturnOneFirstJsonValueIsDeviceTsReason1()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", JsonConverter.toGatewayDeviceDisconnectJson("ts", 1));

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("{\"device\":\"ts\",\"reason\":1}", jsonValue.get());
    assertEquals("{\"device\":\"ts\",\"reason\":1}", getResult2.getValueAsString());
    assertEquals("{\"device\":\"ts\",\"reason\":1}", getResult2.getValue());
    assertEquals(DataType.JSON, getResult2.getDataType());
    assertTrue(jsonValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Then return one first StrValue is empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); then return one first StrValue is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_thenReturnOneFirstStrValueIsEmptyString()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "");

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof StringDataEntry);
    Optional<String> strValue = getResult2.getStrValue();
    assertEquals("", strValue.get());
    assertEquals("", getResult2.getValueAsString());
    assertEquals("", getResult2.getValue());
    assertEquals(DataType.STRING, getResult2.getDataType());
    assertTrue(strValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Then return one size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); then return one size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_thenReturnOneSizeIsTwo() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(
            JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1), 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(1);
    assertTrue(getResult2 instanceof LongDataEntry);
    KvEntry getResult3 = getResult.get(0);
    assertTrue(getResult3 instanceof StringDataEntry);
    assertEquals("1", getResult2.getValueAsString());
    assertEquals("Device Name", getResult3.getValueAsString());
    assertEquals("Device Name", getResult3.getValue());
    assertEquals("device", getResult3.getKey());
    assertEquals("reason", getResult2.getKey());
    assertEquals(1L, ((Long) getResult2.getValue()).longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add {@link JsonObject}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); when JsonArray(int) with capacity is three add JsonObject (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_whenJsonArrayWithCapacityIsThreeAddJsonObject()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); when JsonArray(int) with capacity is three; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_whenJsonArrayWithCapacityIsThree_thenReturnEmpty()
      throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(new JsonArray(3), 1L);

    // Assert
    assertTrue(actualConvertToSortedTelemetryResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).
   *   <li>Then throw {@link JsonSyntaxException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); when JsonNull (default constructor); then throw JsonSyntaxException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_whenJsonNull_thenThrowJsonSyntaxException()
      throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToSortedTelemetry(new JsonNull(), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); when JsonObject (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_whenJsonObject_thenReturnEmpty() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(new JsonObject(), 1L);

    // Assert
    assertTrue(actualConvertToSortedTelemetryResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); when JsonPrimitive(Boolean) with bool is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_whenJsonPrimitiveWithBoolIsTrue() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToSortedTelemetry(new JsonPrimitive(true), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Character)} with c is start of heading.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); when JsonPrimitive(Character) with c is start of heading")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_whenJsonPrimitiveWithCIsStartOfHeading()
      throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToSortedTelemetry(new JsonPrimitive('\u0001'), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); when JsonPrimitive(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_whenJsonPrimitiveWithString() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToSortedTelemetry(new JsonPrimitive("String"), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonConverter.convertToProvisionRequestMsg(
                JsonConverter.toGatewayDeviceDisconnectJson("deviceName", -1)));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo2() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonConverter.convertToProvisionRequestMsg(
                JsonConverter.toGatewayDeviceDisconnectJson(null, -1)));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenA() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", (byte) 'A');

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenEmptyString() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.add("", new JsonArray(3));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenFalse() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", false);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>Given forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenFortyTwo() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", 42L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>Given fromIntBits two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given fromIntBits two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenFromIntBitsTwo() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", UnsignedInteger.fromIntBits(2));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given JsonArray(int) with capacity is three add 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenJsonArrayWithCapacityIsThreeAddTrue() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add(true);

    JsonObject jo = new JsonObject();
    jo.add("deviceName", value);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>Given {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenNaN() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", Double.NaN);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>Given {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given 'Property'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenProperty() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.add("Property", new JsonArray(3));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>Given {@code provisionDeviceKey}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given 'provisionDeviceKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenProvisionDeviceKey() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("provisionDeviceKey", "42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>Given start of text.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given start of text")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenStartOfText() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", '\u0002');

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>Given ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenTen() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", 10.0d);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>Given ten.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenTen2() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", 10.0f);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenTrue() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenTwo() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", (short) 2);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>Given valueOf minus one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given valueOf minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenValueOfMinusOne() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", Integer.valueOf(-1));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor) addProperty {@code deviceName} and {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(JsonObject) with 'jo'; when JsonObject (default constructor) addProperty 'deviceName' and '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_whenJsonObjectAddPropertyDeviceNameAnd42() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", "42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(JsonObject) with 'jo'; when JsonObject (default constructor); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_whenJsonObject_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(new JsonObject()));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(String)} with {@code json}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(String)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(String) with 'json'; when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(String)"
  })
  void testConvertToProvisionRequestMsgWithJson_when42() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("42"));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(String)} with {@code json}.
   *
   * <ul>
   *   <li>When {@code 42E}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(String)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(String) with 'json'; when '42E'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(String)"
  })
  void testConvertToProvisionRequestMsgWithJson_when42e() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("42E"));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(String)} with {@code json}.
   *
   * <ul>
   *   <li>When {@code 42.}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(String)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(String) with 'json'; when '42.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(String)"
  })
  void testConvertToProvisionRequestMsgWithJson_when422() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("42."));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(String)} with {@code json}.
   *
   * <ul>
   *   <li>When {@code client}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(String)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(String) with 'json'; when 'client'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(String)"
  })
  void testConvertToProvisionRequestMsgWithJson_whenClient() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("client"));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(String)} with {@code json}.
   *
   * <ul>
   *   <li>When {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(String)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(String) with 'json'; when '.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(String)"
  })
  void testConvertToProvisionRequestMsgWithJson_whenDot() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("."));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(String)} with {@code json}.
   *
   * <ul>
   *   <li>When {@code E}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(String)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(String) with 'json'; when 'E'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(String)"
  })
  void testConvertToProvisionRequestMsgWithJson_whenE() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("E"));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(String)} with {@code json}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(String)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(String) with 'json'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(String)"
  })
  void testConvertToProvisionRequestMsgWithJson_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg(""));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(String)} with {@code json}.
   *
   * <ul>
   *   <li>When {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(String)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(String) with 'json'; when 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(String)"
  })
  void testConvertToProvisionRequestMsgWithJson_whenJson() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("Json"));
  }
}
