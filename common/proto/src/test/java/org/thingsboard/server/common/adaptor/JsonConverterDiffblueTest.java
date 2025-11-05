package org.thingsboard.server.common.adaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.cache.RemovalNotification;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.UnknownFieldSet;
import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement3() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", new JsonArray());

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement4() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("42", false);

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(0, getResult.getTypeValue());
    assertEquals(4, getResult.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, getResult.getType());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement5() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray());
    jsonElement.add("42", new JsonArray());

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(2, kvList.size());
    assertEquals("ts", kvList.get(0).getKey());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement6() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");
    jsonElement.add("42", new JsonArray());

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(2, kvList.size());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement7() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", new JsonObject());

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement8() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", JsonConverter.toGatewayDeviceDisconnectJson("ts", 1));

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals("{\"device\":\"ts\",\"reason\":1}", getResult.getJsonV());
    assertEquals(34, getResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement9() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("42", "");

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement10() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("values", new JsonArray());
    jsonElement.add("42", new JsonArray());

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(2, kvList.size());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement11() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");
    jsonElement.add("42", new JsonArray());

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(2, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(".", getResult.getStringV());
    assertEquals(9, getResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs3() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", new JsonArray());

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs4() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("42", false);

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
    assertEquals(10, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertEquals(4, getResult2.getSerializedSize());
    assertEquals(8, getResult.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, getResult2.getType());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs5() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray());
    jsonElement.add("42", new JsonArray());

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    List<KeyValueProto> kvList = getResult.getKvList();
    assertEquals(2, kvList.size());
    assertEquals("ts", kvList.get(0).getKey());
    assertEquals(26, getResult.getSerializedSize());
    assertEquals(28, actualConvertToTelemetryProtoResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs6() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");
    jsonElement.add("42", new JsonArray());

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    List<KeyValueProto> kvList = getResult.getKvList();
    assertEquals(2, kvList.size());
    KeyValueProto getResult2 = kvList.get(0);
    assertEquals(1, getResult2.getTypeValue());
    assertEquals(24, getResult.getSerializedSize());
    assertEquals(26, actualConvertToTelemetryProtoResult.getSerializedSize());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs7() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", new JsonObject());

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs8() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", JsonConverter.toGatewayDeviceDisconnectJson("ts", 1));

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
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs9() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("42", "");

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs10() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("values", new JsonArray());
    jsonElement.add("42", new JsonArray());

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    List<KeyValueProto> kvList = getResult.getKvList();
    assertEquals(2, kvList.size());
    KeyValueProto getResult2 = kvList.get(0);
    assertEquals("values", getResult2.getKey());
    assertEquals(14, getResult2.getSerializedSize());
    assertEquals(30, getResult.getSerializedSize());
    assertEquals(Integer.SIZE, actualConvertToTelemetryProtoResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs11() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");
    jsonElement.add("42", new JsonArray());

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    List<KeyValueProto> kvList = getResult.getKvList();
    assertEquals(2, kvList.size());
    KeyValueProto getResult2 = kvList.get(0);
    assertEquals(".", getResult2.getStringV());
    assertEquals(25, getResult.getSerializedSize());
    assertEquals(27, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertEquals(9, getResult2.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link JsonArray#JsonArray()} add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given 'false'; when JsonArray() add 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_givenFalse_whenJsonArrayAddFalse()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonArray#JsonArray()} add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given JsonArray() add 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_givenJsonArrayAddFalse()
      throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray();
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray();
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
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray()} add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given JsonArray() add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_givenJsonArrayAddTrue()
      throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray();
    element.add(true);

    JsonArray jsonElement = new JsonArray();
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
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_givenNull() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", null);

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
   *   <li>Given {@code true}.
   *   <li>When {@link JsonArray#JsonArray()} add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given 'true'; when JsonArray() add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_givenTrue_whenJsonArrayAddTrue()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_givenValueOfOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_thenReturnSerializedSizeIsZero()
      throws JsonSyntaxException {
    // Arrange and Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(new JsonArray(), 1L);

    // Assert
    assertEquals(0, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertEquals(0, actualConvertToTelemetryProtoResult.getTsKvListCount());
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertTrue(tsKvListList.isEmpty());
    assertTrue(actualConvertToTelemetryProtoResult.getAllFields().isEmpty());
    PostTelemetryMsg actualDefaultInstanceForType =
        actualConvertToTelemetryProtoResult.getDefaultInstanceForType();
    assertEquals(actualConvertToTelemetryProtoResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToTelemetryProtoResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
    assertSame(tsKvListList, actualConvertToTelemetryProtoResult.getTsKvListOrBuilderList());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with {@code jsonElement},
   * {@code ts}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; when JsonArray() add JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_whenJsonArrayAddJsonArray()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
    jsonElement.add(new JsonArray());
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
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; when JsonArray() add JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement, long)"
  })
  void testConvertToTelemetryProtoWithJsonElementTs_whenJsonArrayAddJsonObject()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; when JsonNull (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; when JsonPrimitive(Boolean) with bool is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>Given {@code false}.
   *   <li>When {@link JsonArray#JsonArray()} add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given 'false'; when JsonArray() add 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_givenFalse_whenJsonArrayAddFalse()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonArray#JsonArray()} add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given JsonArray() add 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_givenJsonArrayAddFalse()
      throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray();
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray();
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray()} add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given JsonArray() add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_givenJsonArrayAddTrue()
      throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray();
    element.add(true);

    JsonArray jsonElement = new JsonArray();
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link JsonObject} (default constructor) add {@code 42} and {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given 'null'; when JsonObject (default constructor) add '42' and 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_givenNull_whenJsonObjectAdd42AndNull()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", null);

    // Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(jsonElement);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    assertEquals(1, actualConvertToTelemetryProtoResult.getDescriptorForType().getFields().size());
    assertTrue(getResult.getKvList().isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link JsonArray#JsonArray()} add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given 'true'; when JsonArray() add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_givenTrue_whenJsonArrayAddTrue()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_givenValueOfOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_thenReturnSerializedSizeIsZero()
      throws JsonSyntaxException {
    // Arrange and Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(new JsonArray());

    // Assert
    assertEquals(0, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertEquals(0, actualConvertToTelemetryProtoResult.getTsKvListCount());
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertTrue(tsKvListList.isEmpty());
    assertTrue(actualConvertToTelemetryProtoResult.getAllFields().isEmpty());
    PostTelemetryMsg actualDefaultInstanceForType =
        actualConvertToTelemetryProtoResult.getDefaultInstanceForType();
    assertEquals(actualConvertToTelemetryProtoResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToTelemetryProtoResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
    assertSame(tsKvListList, actualConvertToTelemetryProtoResult.getTsKvListOrBuilderList());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement) with 'jsonElement'; when JsonArray() add JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_whenJsonArrayAddJsonArray()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
    jsonElement.add(new JsonArray());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with {@code jsonElement}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetryProto(JsonElement) with 'jsonElement'; when JsonArray() add JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_whenJsonArrayAddJsonObject()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonConverter.convertToTelemetryProto(JsonElement)"
  })
  void testConvertToTelemetryProtoWithJsonElement_whenJsonObject() throws JsonSyntaxException {
    // Arrange and Act
    PostTelemetryMsg actualConvertToTelemetryProtoResult =
        JsonConverter.convertToTelemetryProto(new JsonObject());

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    assertEquals(1, actualConvertToTelemetryProtoResult.getDescriptorForType().getFields().size());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry2() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("metadata", new JsonArray());

    JsonArray jsonElement = new JsonArray();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry3() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("Property", new JsonArray());
    element.add("metadata", new JsonArray());

    JsonArray jsonElement = new JsonArray();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry4() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("metadata", new JsonArray());
    element.add("Property", new JsonArray());

    JsonArray jsonElement = new JsonArray();
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
   *   <li>When {@link JsonArray#JsonArray()} add empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given empty string; when JsonArray() add empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenEmptyString_whenJsonArrayAddEmptyString() {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   *   <li>When {@link JsonArray#JsonArray()} add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given 'false'; when JsonArray() add 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenFalse_whenJsonArrayAddFalse() {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonArray#JsonArray()} add {@code false}.
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonArray() add 'false'; when JsonArray() add JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonArrayAddFalse_whenJsonArrayAddJsonArray() {
    // Arrange
    JsonArray element = new JsonArray();
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonArray#JsonArray()} add {@code true}.
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonArray() add 'true'; when JsonArray() add JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonArrayAddTrue_whenJsonArrayAddJsonArray() {
    // Arrange
    JsonArray element = new JsonArray();
    element.add(true);

    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonArray#JsonArray()}.
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonArray(); when JsonArray() add JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonArray_whenJsonArrayAddJsonArray() {
    // Arrange
    JsonArray jsonElement = new JsonArray();
    jsonElement.add(new JsonArray());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code metadata} and {@link
   *       JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) add 'metadata' and JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonObjectAddMetadataAndJsonArray() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("metadata", new JsonArray());

    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonObject} (default constructor) add {@code metadata} and {@link
   *       JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) add 'metadata' and JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonObjectAddMetadataAndJsonArray2() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("metadata", new JsonArray());
    element.add("Property", new JsonArray());

    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonObject} (default constructor) add {@code metadata} and {@link
   *       JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) add 'metadata' and JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonObjectAddMetadataAndJsonObject() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("metadata", new JsonObject());

    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonObject} (default constructor) add {@code Property} and {@link
   *       JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) add 'Property' and JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonObjectAddPropertyAndJsonArray() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("Property", new JsonArray());
    element.add("metadata", new JsonArray());

    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonObject} (default constructor) add {@code Property} and {@link
   *       JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) add 'Property' and JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonObjectAddPropertyAndJsonArray2() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("Property", new JsonArray());

    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonObject} (default constructor) add {@code Property} and {@link
   *       JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) add 'Property' and JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonObjectAddPropertyAndJsonObject() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("Property", new JsonObject());

    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonObject} (default constructor) add {@code Property} and {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) add 'Property' and 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonObjectAddPropertyAndNull() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("Property", null);

    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code Property} and {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) addProperty 'Property' and '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonObjectAddPropertyPropertyAnd42() {
    // Arrange
    JsonObject element = new JsonObject();
    element.addProperty("Property", "42");

    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code Property} and {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) addProperty 'Property' and 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonObjectAddPropertyPropertyAndFalse() {
    // Arrange
    JsonObject element = new JsonObject();
    element.addProperty("Property", false);

    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonObject} (default constructor) add {@code ts} and {@link
   *       JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) add 'ts' and JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonObjectAddTsAndJsonArray() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("ts", new JsonArray());
    element.addProperty("Property", false);

    JsonArray jsonElement = new JsonArray();
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
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor); when JsonArray() add JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenJsonObject_whenJsonArrayAddJsonObject() {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given start of heading.
   *   <li>When {@link JsonArray#JsonArray()} add start of heading.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given start of heading; when JsonArray() add start of heading")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenStartOfHeading_whenJsonArrayAddStartOfHeading() {
    // Arrange
    JsonArray jsonElement = new JsonArray();
    jsonElement.add('\u0001');
    jsonElement.add(new JsonArray());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenToGatewayDeviceDisconnectJsonDeviceNameAndOne() {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   *   <li>When {@link JsonArray#JsonArray()} add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayTelemetry(JsonElement, long); given 'true'; when JsonArray() add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_givenTrue_whenJsonArrayAddTrue() {
    // Arrange
    JsonArray jsonElement = new JsonArray();
    jsonElement.add(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); when JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_whenJsonArray() {
    // Arrange and Act
    TbPair<PostTelemetryMsg, List<GatewayMetadata>> actualConvertToGatewayTelemetryResult =
        JsonConverter.convertToGatewayTelemetry(new JsonArray(), 1L);

    // Assert
    PostTelemetryMsg first = actualConvertToGatewayTelemetryResult.getFirst();
    assertEquals(1, first.getDescriptorForType().getFields().size());
    PostTelemetryMsg actualDefaultInstanceForType = first.getDefaultInstanceForType();
    assertEquals(first, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = first.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair JsonConverter.convertToGatewayTelemetry(JsonElement, long)"})
  void testConvertToGatewayTelemetry_whenJsonArrayWithCapacityIsThree() {
    // Arrange and Act
    TbPair<PostTelemetryMsg, List<GatewayMetadata>> actualConvertToGatewayTelemetryResult =
        JsonConverter.convertToGatewayTelemetry(new JsonArray(3), 1L);

    // Assert
    PostTelemetryMsg first = actualConvertToGatewayTelemetryResult.getFirst();
    assertEquals(1, first.getDescriptorForType().getFields().size());
    PostTelemetryMsg actualDefaultInstanceForType = first.getDefaultInstanceForType();
    assertEquals(first, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = first.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs2() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", new JsonObject());

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    assertEquals("42", getResult2.getKey());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs3() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", JsonConverter.toGatewayDeviceDisconnectJson("ts", 1));

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    assertEquals("42", getResult2.getKey());
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("{\"device\":\"ts\",\"reason\":1}", jsonValue.get());
    assertEquals("{\"device\":\"ts\",\"reason\":1}", getResult2.getValueAsString());
    assertEquals("{\"device\":\"ts\",\"reason\":1}", getResult2.getValue());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs4() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("42", "");

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
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted() throws JsonSyntaxException {
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
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted4() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("42", false);

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
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.get());
    Optional<Double> doubleValue = getResult2.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertFalse((Boolean) getResult2.getValue());
    assertTrue(booleanValue.isPresent());
    assertEquals(Boolean.FALSE.toString(), getResult2.getValueAsString());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted5() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");
    jsonElement.add("42", new JsonArray());

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted6() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", new JsonObject());

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    assertEquals("42", getResult2.getKey());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted7() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", JsonConverter.toGatewayDeviceDisconnectJson("ts", 1));

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    assertEquals("42", getResult2.getKey());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted8() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("42", "");

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted9() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("values", new JsonArray());
    jsonElement.add("42", new JsonArray());

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    KvEntry getResult3 = getResult.get(1);
    assertTrue(getResult3 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("[]", jsonValue.get());
    assertEquals("[]", getResult2.getValueAsString());
    assertEquals("[]", getResult2.getValue());
    assertEquals("values", getResult2.getKey());
    assertEquals(jsonValue, getResult3.getJsonValue());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted10() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");
    jsonElement.add("42", new JsonArray());

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(1);
    assertTrue(getResult2 instanceof JsonDataEntry);
    KvEntry getResult3 = getResult.get(0);
    assertTrue(getResult3 instanceof StringDataEntry);
    assertEquals(".", getResult3.getStrValue().get());
    assertEquals(".", getResult3.getValueAsString());
    assertEquals(".", getResult3.getValue());
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("[]", jsonValue.get());
    assertTrue(jsonValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray()} add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given JsonArray() add 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenJsonArrayAddFalse()
      throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray();
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray();
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
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray()} add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given JsonArray() add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenJsonArrayAddTrue()
      throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray();
    element.add(true);

    JsonArray jsonElement = new JsonArray();
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
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenNull() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", null);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenTrue() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   *   <li>Then return one first Key is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; then return one first Key is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_thenReturnOneFirstKeyIs42()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", new JsonArray());

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    assertEquals("42", getResult2.getKey());
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
   * <ul>
   *   <li>Then return one first Key is {@code ts}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; then return one first Key is 'ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_thenReturnOneFirstKeyIsTs()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray());
    jsonElement.add("42", new JsonArray());

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    KvEntry getResult3 = getResult.get(1);
    assertTrue(getResult3 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("[]", jsonValue.get());
    assertEquals("[]", getResult2.getValueAsString());
    assertEquals("[]", getResult2.getValue());
    assertEquals("ts", getResult2.getKey());
    assertEquals(jsonValue, getResult3.getJsonValue());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; when JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_whenJsonArray()
      throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(new JsonArray(), 1L, true);

    // Assert
    assertTrue(actualConvertToTelemetryResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)} with {@code
   * jsonElement}, {@code systemTs}, {@code sorted}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()} add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; when JsonArray() add 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_whenJsonArrayAddFalse()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; when JsonArray() add JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_whenJsonArrayAddJsonArray()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
    jsonElement.add(new JsonArray());
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
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; when JsonArray() add JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_whenJsonArrayAddJsonObject()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()} add valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; when JsonArray() add valueOf one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long, boolean)"})
  void testConvertToTelemetryWithJsonElementSystemTsSorted_whenJsonArrayAddValueOfOne()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   *   <li>When {@link JsonNull} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; when JsonNull (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>Given {@code false}.
   *   <li>When {@link JsonArray#JsonArray()} add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given 'false'; when JsonArray() add 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_givenFalse_whenJsonArrayAddFalse()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonArray#JsonArray()} add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given JsonArray() add 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_givenJsonArrayAddFalse()
      throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray();
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray();
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
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray()} add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given JsonArray() add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_givenJsonArrayAddTrue()
      throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray();
    element.add(true);

    JsonArray jsonElement = new JsonArray();
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
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_givenNull() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", null);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link JsonArray#JsonArray()} add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given 'true'; when JsonArray() add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_givenTrue_whenJsonArrayAddTrue()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_thenOneFirstReturnBooleanDataEntry()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("42", false);

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
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.get());
    Optional<Double> doubleValue = getResult2.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertFalse((Boolean) getResult2.getValue());
    assertTrue(booleanValue.isPresent());
    assertEquals(Boolean.FALSE.toString(), getResult2.getValueAsString());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_thenOneFirstReturnLongDataEntry()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");
    jsonElement.add("42", new JsonArray());

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
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
   *   <li>Then one second return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; then one second return LongDataEntry")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_thenOneSecondReturnLongDataEntry()
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
   *   <li>Then return one first Key is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; then return one first Key is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_thenReturnOneFirstKeyIs42()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", new JsonArray());

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    assertEquals("42", getResult2.getKey());
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
   * <ul>
   *   <li>Then return one first Key is {@code ts}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; then return one first Key is 'ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_thenReturnOneFirstKeyIsTs()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray());
    jsonElement.add("42", new JsonArray());

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    KvEntry getResult3 = getResult.get(1);
    assertTrue(getResult3 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("[]", jsonValue.get());
    assertEquals("[]", getResult2.getValueAsString());
    assertEquals("[]", getResult2.getValue());
    assertEquals("ts", getResult2.getKey());
    assertEquals(jsonValue, getResult3.getJsonValue());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_thenReturnOneFirstKeyIsValues()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("values", new JsonArray());
    jsonElement.add("42", new JsonArray());

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    KvEntry getResult3 = getResult.get(1);
    assertTrue(getResult3 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("[]", jsonValue.get());
    assertEquals("[]", getResult2.getValueAsString());
    assertEquals("[]", getResult2.getValue());
    assertEquals("values", getResult2.getKey());
    assertEquals(jsonValue, getResult3.getJsonValue());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_thenReturnOneFirstStrValueIsDot()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");
    jsonElement.add("42", new JsonArray());

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(1);
    assertTrue(getResult2 instanceof JsonDataEntry);
    KvEntry getResult3 = getResult.get(0);
    assertTrue(getResult3 instanceof StringDataEntry);
    assertEquals(".", getResult3.getStrValue().get());
    assertEquals(".", getResult3.getValueAsString());
    assertEquals(".", getResult3.getValue());
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("[]", jsonValue.get());
    assertTrue(jsonValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with {@code jsonElement},
   * {@code systemTs}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; when JsonArray() add JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_whenJsonArrayAddJsonArray()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
    jsonElement.add(new JsonArray());
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
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; when JsonArray() add JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_whenJsonArrayAddJsonObject()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()} add valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; when JsonArray() add valueOf one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_whenJsonArrayAddValueOfOne()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   *   <li>When {@link JsonArray#JsonArray()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; when JsonArray(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToTelemetry(JsonElement, long)"})
  void testConvertToTelemetryWithJsonElementSystemTs_whenJsonArray_thenReturnEmpty()
      throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult =
        JsonConverter.convertToTelemetry(new JsonArray(), 1L);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; when JsonObject (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonPrimitive actualAsJsonPrimitive = actualParseResult.getAsJsonPrimitive();
    assertSame(actualParseResult, actualAsJsonPrimitive);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertEquals(new BigDecimal("42"), actualParseResult.getAsBigDecimal());
    JsonPrimitive actualAsJsonPrimitive = actualParseResult.getAsJsonPrimitive();
    assertSame(actualParseResult, actualAsJsonPrimitive);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonPrimitive actualAsJsonPrimitive = actualParseResult.getAsJsonPrimitive();
    assertSame(actualParseResult, actualAsJsonPrimitive);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonPrimitive actualAsJsonPrimitive = actualParseResult.getAsJsonPrimitive();
    assertSame(actualParseResult, actualAsJsonPrimitive);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonPrimitive actualAsJsonPrimitive = actualParseResult.getAsJsonPrimitive();
    assertSame(actualParseResult, actualAsJsonPrimitive);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonPrimitive actualAsJsonPrimitive = actualParseResult.getAsJsonPrimitive();
    assertSame(actualParseResult, actualAsJsonPrimitive);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement JsonConverter.parse(String)"})
  void testParseWithJson_whenEmptyString_thenReturnJsonNull() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("");

    // Assert
    assertTrue(actualParseResult instanceof JsonNull);
    assertFalse(actualParseResult.isJsonPrimitive());
    assertTrue(actualParseResult.isJsonNull());
    assertSame(((JsonNull) actualParseResult).INSTANCE, actualParseResult.getAsJsonNull());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonPrimitive actualAsJsonPrimitive = actualParseResult.getAsJsonPrimitive();
    assertSame(actualParseResult, actualAsJsonPrimitive);
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray()}.
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonArray#JsonArray()}.
   *   <li>Then first return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); given JsonArray(); when JsonArray() add JsonArray(); then first return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_givenJsonArray_whenJsonArrayAddJsonArray_thenFirstReturnList() {
    // Arrange
    JsonArray element = new JsonArray();
    element.add(new JsonArray());
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
   *   <li>Given {@link JsonObject} (default constructor).
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonObject} (default constructor).
   *   <li>Then first return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); given JsonObject (default constructor); when JsonArray() add JsonObject (default constructor); then first return Map")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_givenJsonObject_whenJsonArrayAddJsonObject_thenFirstReturnMap() {
    // Arrange
    JsonArray element = new JsonArray();
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
   *   <li>Given {@code null}.
   *   <li>When {@link JsonArray#JsonArray()} add {@code null}.
   *   <li>Then return first is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); given 'null'; when JsonArray() add 'null'; then return first is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_givenNull_whenJsonArrayAddNull_thenReturnFirstIsNull() {
    // Arrange
    JsonArray element = new JsonArray();
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
   *   <li>Given {@code Property}.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); given 'Property'; then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_givenProperty_thenReturnSizeIsFour() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("Property", new JsonArray());
    element.add("", new JsonArray());
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertEquals(4, ((Map<String, Object>) actualFromJsonResult).size());
    Object getResult = ((Map<String, Object>) actualFromJsonResult).get("Property");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromJsonResult instanceof Map);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("device"));
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("reason"));
    assertEquals(getResult, ((Map<String, Object>) actualFromJsonResult).get(""));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link JsonArray#JsonArray()} add {@code true}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); given 'true'; when JsonArray() add 'true'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_givenTrue_whenJsonArrayAddTrue_thenReturnSizeIsOne() {
    // Arrange
    JsonArray element = new JsonArray();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_thenEmptyStringReturnList() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("", new JsonArray());
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertEquals(3, ((Map<String, Object>) actualFromJsonResult).size());
    Object getResult = ((Map<String, Object>) actualFromJsonResult).get("");
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
   *   <li>Then return empty string is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); then return empty string is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_thenReturnEmptyStringIsNull() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("", null);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals(3, ((Map<String, Object>) actualFromJsonResult).size());
    assertEquals("Device Name", ((Map<String, Object>) actualFromJsonResult).get("device"));
    assertNull(((Map<String, Object>) actualFromJsonResult).get(""));
    assertEquals(
        1.0d, ((Double) ((Map<String, Object>) actualFromJsonResult).get("reason")).doubleValue());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>When {@link JsonArray#JsonArray()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when JsonArray(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonArray_thenReturnEmpty() {
    // Arrange
    JsonArray element = new JsonArray();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonObject (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonPrimitive(Boolean) with bool is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonPrimitiveWithBoolIsFalse_thenReturnFalse() {
    // Arrange
    JsonPrimitive element = new JsonPrimitive(false);
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse((Boolean) JsonConverter.fromJson(element, type));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with string is {@code 42}.
   *   <li>Then return byteValue is {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonPrimitive(String) with string is '42'; then return byteValue is '*'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonPrimitiveWithStringIs42_thenReturnByteValueIsAsterisk() {
    // Arrange, Act and Assert
    assertEquals(
        '*', ((Byte) JsonConverter.fromJson(new JsonPrimitive("42"), Byte.TYPE)).byteValue());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with string is {@code 42}.
   *   <li>Then return floatValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonPrimitive(String) with string is '42'; then return floatValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonPrimitiveWithStringIs42_thenReturnFloatValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        42.0f, ((Float) JsonConverter.fromJson(new JsonPrimitive("42"), Float.TYPE)).floatValue());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with string is {@code 42}.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonPrimitive(String) with string is '42'; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonPrimitiveWithStringIs42_thenReturnIntValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        42, ((Integer) JsonConverter.fromJson(new JsonPrimitive("42"), Integer.TYPE)).intValue());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with string is {@code 42}.
   *   <li>Then return longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonPrimitive(String) with string is '42'; then return longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonPrimitiveWithStringIs42_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        42L, ((Long) JsonConverter.fromJson(new JsonPrimitive("42"), Long.TYPE)).longValue());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with string is {@code 42}.
   *   <li>Then return shortValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName(
      "Test fromJson(JsonElement, Class); when JsonPrimitive(String) with string is '42'; then return shortValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonConverter.fromJson(JsonElement, Class)"})
  void testFromJson_whenJsonPrimitiveWithStringIs42_thenReturnShortValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        (short) 42,
        ((Short) JsonConverter.fromJson(new JsonPrimitive("42"), Short.TYPE)).shortValue());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ClaimDeviceMsg actualConvertToClaimDeviceProtoResult =
        JsonConverter.convertToClaimDeviceProto(deviceId, new JsonObject());

    // Assert
    assertEquals(2, actualConvertToClaimDeviceProtoResult.getAllFields().size());
    assertEquals(21, actualConvertToClaimDeviceProtoResult.getSerializedSize());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement2() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ClaimDeviceMsg actualConvertToClaimDeviceProtoResult =
        JsonConverter.convertToClaimDeviceProto(
            deviceId, JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1));

    // Assert
    UnknownFieldSet unknownFields = actualConvertToClaimDeviceProtoResult.getUnknownFields();
    ClaimDeviceMsg defaultInstanceForType =
        actualConvertToClaimDeviceProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement3() {
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement4() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("secretKey", true);

    // Act
    ClaimDeviceMsg actualConvertToClaimDeviceProtoResult =
        JsonConverter.convertToClaimDeviceProto(deviceId, jsonElement);

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualConvertToClaimDeviceProtoResult.getSecretKey());
    ByteString secretKeyBytes = actualConvertToClaimDeviceProtoResult.getSecretKeyBytes();
    ByteIterator iteratorResult = secretKeyBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals(Boolean.TRUE.toString(), secretKeyBytes.toStringUtf8());
    assertEquals(27, actualConvertToClaimDeviceProtoResult.getSerializedSize());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement5() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonObject jsonElement = new JsonObject();
    Integer value = Integer.valueOf(1);
    jsonElement.addProperty("durationMs", value);
    jsonElement.addProperty("secretKey", true);

    // Act
    ClaimDeviceMsg actualConvertToClaimDeviceProtoResult =
        JsonConverter.convertToClaimDeviceProto(deviceId, jsonElement);

    // Assert
    Descriptor descriptorForType = actualConvertToClaimDeviceProtoResult.getDescriptorForType();
    FileDescriptor file = descriptorForType.getFile();
    List<EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(1L, actualConvertToClaimDeviceProtoResult.getDurationMs());
    assertEquals(29, actualConvertToClaimDeviceProtoResult.getSerializedSize());
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertEquals(4, actualConvertToClaimDeviceProtoResult.getAllFields().size());
    assertSame(
        value,
        descriptorForType.getOptions().getDescriptorForType().toProto().getExtensionRangeCount());
    assertSame(value, fields.get(0).toProto().getNumber());
    assertSame(value, file.toProto().getDescriptorForType().getIndex());
    assertSame(value, messageTypes.get(1).getIndex());
    assertSame(value, enumTypes.get(1).getIndex());
    assertSame(value, fields.get(1).getIndex());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement6() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonArray value = new JsonArray();
    value.add(true);

    JsonObject jsonElement = new JsonObject();
    jsonElement.add("secretKey", value);

    // Act
    ClaimDeviceMsg actualConvertToClaimDeviceProtoResult =
        JsonConverter.convertToClaimDeviceProto(deviceId, jsonElement);

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualConvertToClaimDeviceProtoResult.getSecretKey());
    ByteString secretKeyBytes = actualConvertToClaimDeviceProtoResult.getSecretKeyBytes();
    ByteIterator iteratorResult = secretKeyBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals(Boolean.TRUE.toString(), secretKeyBytes.toStringUtf8());
    assertEquals(27, actualConvertToClaimDeviceProtoResult.getSerializedSize());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement7() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("durationMs", "42");

    // Act
    ClaimDeviceMsg actualConvertToClaimDeviceProtoResult =
        JsonConverter.convertToClaimDeviceProto(deviceId, jsonElement);

    // Assert
    assertEquals(23, actualConvertToClaimDeviceProtoResult.getSerializedSize());
    assertEquals(42L, actualConvertToClaimDeviceProtoResult.getDurationMs());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement8() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonArray element = new JsonArray();
    element.add(true);

    JsonArray value = new JsonArray();
    value.add(element);

    JsonObject jsonElement = new JsonObject();
    jsonElement.add("secretKey", value);

    // Act
    ClaimDeviceMsg actualConvertToClaimDeviceProtoResult =
        JsonConverter.convertToClaimDeviceProto(deviceId, jsonElement);

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualConvertToClaimDeviceProtoResult.getSecretKey());
    ByteString secretKeyBytes = actualConvertToClaimDeviceProtoResult.getSecretKeyBytes();
    ByteIterator iteratorResult = secretKeyBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals(Boolean.TRUE.toString(), secretKeyBytes.toStringUtf8());
    assertEquals(27, actualConvertToClaimDeviceProtoResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenFalse() {
    // Arrange
    JsonArray jsonElement = new JsonArray();
    jsonElement.add(false);
    jsonElement.add(true);

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
   *   <li>Given {@link JsonArray#JsonArray()} add valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given JsonArray() add valueOf one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenJsonArrayAddValueOfOne() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonArray value = new JsonArray();
    Integer number = Integer.valueOf(1);
    value.add(number);

    JsonObject jsonElement = new JsonObject();
    jsonElement.add("durationMs", value);
    jsonElement.addProperty("secretKey", true);

    // Act
    ClaimDeviceMsg actualConvertToClaimDeviceProtoResult =
        JsonConverter.convertToClaimDeviceProto(deviceId, jsonElement);

    // Assert
    Descriptor descriptorForType = actualConvertToClaimDeviceProtoResult.getDescriptorForType();
    FileDescriptor file = descriptorForType.getFile();
    List<EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(1L, actualConvertToClaimDeviceProtoResult.getDurationMs());
    assertEquals(29, actualConvertToClaimDeviceProtoResult.getSerializedSize());
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertEquals(4, actualConvertToClaimDeviceProtoResult.getAllFields().size());
    assertSame(
        number,
        descriptorForType.getOptions().getDescriptorForType().toProto().getExtensionRangeCount());
    assertSame(number, fields.get(0).toProto().getNumber());
    assertSame(number, file.toProto().getDescriptorForType().getIndex());
    assertSame(number, messageTypes.get(1).getIndex());
    assertSame(number, enumTypes.get(1).getIndex());
    assertSame(number, fields.get(1).getIndex());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenNull() {
    // Arrange
    JsonArray jsonElement = new JsonArray();
    jsonElement.add('\u0000');
    jsonElement.add(true);

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
   *   <li>Then return SecretKey is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; then return SecretKey is '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_thenReturnSecretKeyIs1() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Integer value = Integer.valueOf(1);

    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("secretKey", value);

    // Act
    ClaimDeviceMsg actualConvertToClaimDeviceProtoResult =
        JsonConverter.convertToClaimDeviceProto(deviceId, jsonElement);

    // Assert
    assertEquals("1", actualConvertToClaimDeviceProtoResult.getSecretKey());
    ByteString secretKeyBytes = actualConvertToClaimDeviceProtoResult.getSecretKeyBytes();
    ByteIterator iteratorResult = secretKeyBytes.iterator();
    Byte nextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('1', nextResult.byteValue());
    assertEquals("1", secretKeyBytes.toStringUtf8());
    assertEquals(24, actualConvertToClaimDeviceProtoResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <ul>
   *   <li>Then return SecretKey is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; then return SecretKey is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_thenReturnSecretKeyIs42() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("secretKey", "42");

    // Act
    ClaimDeviceMsg actualConvertToClaimDeviceProtoResult =
        JsonConverter.convertToClaimDeviceProto(deviceId, jsonElement);

    // Assert
    assertEquals("42", actualConvertToClaimDeviceProtoResult.getSecretKey());
    ByteString secretKeyBytes = actualConvertToClaimDeviceProtoResult.getSecretKeyBytes();
    ByteIterator iteratorResult = secretKeyBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('4', nextResult.byteValue());
    assertEquals('2', nextResult2.byteValue());
    assertEquals("42", secretKeyBytes.toStringUtf8());
    assertEquals(25, actualConvertToClaimDeviceProtoResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; when JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_whenJsonArray() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, new JsonArray()));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)} with {@code
   * deviceId}, {@code jsonElement}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()} add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; when JsonArray() add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_whenJsonArrayAddTrue() {
    // Arrange
    JsonArray jsonElement = new JsonArray();
    jsonElement.add(true);

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
   *   <li>When {@link JsonArray#JsonArray()} add valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; when JsonArray() add valueOf one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonConverter.convertToClaimDeviceProto(DeviceId, JsonElement)"
  })
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_whenJsonArrayAddValueOfOne() {
    // Arrange
    JsonArray jsonElement = new JsonArray();
    jsonElement.add(Integer.valueOf(1));
    jsonElement.add(true);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = mock(JsonArray.class);

    JsonObject jsonObject2 = mock(JsonObject.class);

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", new JsonArray());

    SimpleEntry<String, JsonElement> simpleEntry2 = new SimpleEntry<>(simpleEntry);
    simpleEntry2.setValue(new JsonObject());
    entrySet.add(simpleEntry2);
    when(jsonObject2.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject2).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject2.add("Property", new JsonArray());
    when(jsonObject.getAsJsonObject()).thenReturn(jsonObject2);
    when(jsonObject.isJsonObject()).thenReturn(true);

    // Act and Assert
    List<KeyValueProto> kvList = JsonConverter.convertToAttributesProto(jsonObject).getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals("{}", getResult.getJsonV());
    ByteString jsonVBytes = getResult.getJsonVBytes();
    ByteIterator iteratorResult = jsonVBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('{', nextResult.byteValue());
    assertEquals('}', nextResult2.byteValue());
    assertEquals("{}", jsonVBytes.toStringUtf8());
    verify(jsonObject).isJsonObject();
    verify(jsonObject).getAsJsonObject();
    verify(jsonObject2).entrySet();
    verify(jsonObject2).add(eq("Property"), isA(JsonElement.class));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonArray = mock(JsonArray.class);
    when(jsonArray.getAsJsonPrimitive()).thenReturn(new JsonPrimitive("String"));
    when(jsonArray.isJsonPrimitive()).thenReturn(true);
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", jsonArray);

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(simpleEntry);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray jsonObject2 = mock(JsonArray.class);
    when(jsonObject2.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonObject2.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(jsonObject2);

    // Assert
    verify(jsonObject2).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(jsonObject2).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    List<KeyValueProto> kvList = actualConvertToAttributesProtoResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    ByteString stringVBytes = getResult.getStringVBytes();
    assertEquals("String", stringVBytes.toStringUtf8());
    assertEquals("String", getResult.getStringV());
    ByteIterator iteratorResult = stringVBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('S', iteratorResult.next().byteValue());
    assertEquals('t', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto3() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonArray = mock(JsonArray.class);
    when(jsonArray.getAsJsonPrimitive()).thenThrow(new JsonSyntaxException("Msg"));
    when(jsonArray.isJsonPrimitive()).thenReturn(true);
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", jsonArray);

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(simpleEntry);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray jsonObject2 = mock(JsonArray.class);
    when(jsonObject2.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonObject2.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject2));
    verify(jsonObject2).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(jsonObject2).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto4() throws JsonSyntaxException {
    // Arrange
    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsString()).thenReturn("As String");
    when(jsonPrimitive.isString()).thenReturn(true);

    JsonArray jsonArray = mock(JsonArray.class);
    when(jsonArray.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(jsonArray.isJsonPrimitive()).thenReturn(true);
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", jsonArray);

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(simpleEntry);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray jsonObject2 = mock(JsonArray.class);
    when(jsonObject2.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonObject2.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(jsonObject2);

    // Assert
    verify(jsonObject2).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(jsonObject2).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    verify(jsonPrimitive, atLeast(1)).getAsString();
    verify(jsonPrimitive).isString();
    List<KeyValueProto> kvList = actualConvertToAttributesProtoResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    ByteString stringVBytes = getResult.getStringVBytes();
    assertEquals("As String", stringVBytes.toStringUtf8());
    assertEquals("As String", getResult.getStringV());
    assertEquals(18, getResult.getSerializedSize());
    assertEquals(20, actualConvertToAttributesProtoResult.getSerializedSize());
    ByteIterator iteratorResult = stringVBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('s', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto5() throws JsonSyntaxException {
    // Arrange
    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsString()).thenThrow(new JsonSyntaxException("Msg"));
    when(jsonPrimitive.isString()).thenReturn(true);

    JsonArray jsonArray = mock(JsonArray.class);
    when(jsonArray.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(jsonArray.isJsonPrimitive()).thenReturn(true);
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", jsonArray);

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(simpleEntry);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray jsonObject2 = mock(JsonArray.class);
    when(jsonObject2.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonObject2.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject2));
    verify(jsonObject2).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(jsonObject2).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    verify(jsonPrimitive).getAsString();
    verify(jsonPrimitive).isString();
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto6() throws JsonSyntaxException {
    // Arrange
    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsBoolean()).thenThrow(new JsonSyntaxException("Msg"));
    when(jsonPrimitive.isBoolean()).thenReturn(true);
    when(jsonPrimitive.isString()).thenReturn(false);

    JsonArray jsonArray = mock(JsonArray.class);
    when(jsonArray.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(jsonArray.isJsonPrimitive()).thenReturn(true);
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", jsonArray);

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(simpleEntry);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray jsonObject2 = mock(JsonArray.class);
    when(jsonObject2.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonObject2.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject2));
    verify(jsonObject2).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(jsonObject2).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    verify(jsonPrimitive).getAsBoolean();
    verify(jsonPrimitive).isBoolean();
    verify(jsonPrimitive).isString();
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto7() throws JsonSyntaxException {
    // Arrange
    RemovalNotification<String, JsonElement> removalNotification = mock(RemovalNotification.class);
    when(removalNotification.getKey()).thenThrow(new JsonSyntaxException("Msg"));
    when(removalNotification.getValue()).thenReturn(new JsonArray());

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(removalNotification);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray jsonObject2 = mock(JsonArray.class);
    when(jsonObject2.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonObject2.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject2));
    verify(jsonObject2).getAsJsonObject();
    verify(jsonObject2).isJsonObject();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    verify(removalNotification).getKey();
    verify(removalNotification).getValue();
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link JsonArray} {@link JsonArray#isJsonObject()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); given 'false'; when JsonArray isJsonObject() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_givenFalse_whenJsonArrayIsJsonObjectReturnFalse()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = mock(JsonArray.class);
    when(jsonObject.isJsonObject()).thenReturn(false);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
    verify(jsonObject).isJsonObject();
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); given JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_givenJsonObject() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = mock(JsonArray.class);
    when(jsonObject.getAsJsonObject()).thenReturn(new JsonObject());
    when(jsonObject.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(jsonObject);

    // Assert
    verify(jsonObject).getAsJsonObject();
    verify(jsonObject).isJsonObject();
    PostAttributeMsg actualDefaultInstanceForType =
        actualConvertToAttributesProtoResult.getDefaultInstanceForType();
    assertEquals(actualConvertToAttributesProtoResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonSyntaxException#JsonSyntaxException(String)} with {@code Msg}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); given JsonSyntaxException(String) with 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_givenJsonSyntaxExceptionWithMsg() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = mock(JsonArray.class);
    when(jsonObject.getAsJsonObject()).thenThrow(new JsonSyntaxException("Msg"));
    when(jsonObject.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
    verify(jsonObject).getAsJsonObject();
    verify(jsonObject).isJsonObject();
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link
   *       AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with {@code Key} and {@link
   *       JsonNull} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); given LinkedHashSet() add SimpleEntry(Object, Object) with 'Key' and JsonNull (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_givenLinkedHashSetAddSimpleEntryWithKeyAndJsonNull()
      throws JsonSyntaxException {
    // Arrange
    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", new JsonNull());
    entrySet.add(simpleEntry);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray jsonObject2 = mock(JsonArray.class);
    when(jsonObject2.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonObject2.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(jsonObject2);

    // Assert
    verify(jsonObject2).getAsJsonObject();
    verify(jsonObject2).isJsonObject();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    PostAttributeMsg actualDefaultInstanceForType =
        actualConvertToAttributesProtoResult.getDefaultInstanceForType();
    assertEquals(actualConvertToAttributesProtoResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Then return DescriptorForType Fields size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); then return DescriptorForType Fields size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_thenReturnDescriptorForTypeFieldsSizeIsTwo()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonArray = mock(JsonArray.class);
    when(jsonArray.isJsonObject()).thenReturn(true);
    when(jsonArray.isJsonPrimitive()).thenReturn(false);
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", jsonArray);

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(simpleEntry);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray jsonObject2 = mock(JsonArray.class);
    when(jsonObject2.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonObject2.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(jsonObject2);

    // Assert
    verify(jsonObject2).getAsJsonObject();
    verify(jsonObject2).isJsonObject();
    verify(jsonArray).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    List<KeyValueProto> kvList = actualConvertToAttributesProtoResult.getKvList();
    assertEquals(1, kvList.size());
    assertEquals(2, actualConvertToAttributesProtoResult.getDescriptorForType().getFields().size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(4, getResult.getTypeValue());
    assertEquals(KeyValueType.JSON_V, getResult.getType());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList first AllFields size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); then return KvList first AllFields size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_thenReturnKvListFirstAllFieldsSizeIsTwo()
      throws JsonSyntaxException {
    // Arrange
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", new JsonArray());

    SimpleEntry<String, JsonElement> simpleEntry2 = new SimpleEntry<>(simpleEntry);
    simpleEntry2.setValue(new JsonPrimitive(""));

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(simpleEntry2);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray jsonObject2 = mock(JsonArray.class);
    when(jsonObject2.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonObject2.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(jsonObject2);

    // Assert
    verify(jsonObject2).getAsJsonObject();
    verify(jsonObject2).isJsonObject();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    List<KeyValueProto> kvList = actualConvertToAttributesProtoResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(3, getResult.getTypeValue());
    assertEquals(7, getResult.getSerializedSize());
    assertEquals(9, actualConvertToAttributesProtoResult.getSerializedSize());
    assertEquals(KeyValueType.STRING_V, getResult.getType());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList first SerializedSize is fourteen.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); then return KvList first SerializedSize is fourteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_thenReturnKvListFirstSerializedSizeIsFourteen()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("Property", "42");

    JsonArray jsonObject2 = mock(JsonArray.class);
    when(jsonObject2.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonObject2.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(jsonObject2);

    // Assert
    verify(jsonObject2).getAsJsonObject();
    verify(jsonObject2).isJsonObject();
    List<KeyValueProto> kvList = actualConvertToAttributesProtoResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(1, getResult.getTypeValue());
    assertEquals(14, getResult.getSerializedSize());
    assertEquals(42L, getResult.getLongV());
    assertEquals(KeyValueType.LONG_V, getResult.getType());
    assertEquals(Short.SIZE, actualConvertToAttributesProtoResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList first SerializedSize is twelve.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); then return KvList first SerializedSize is twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_thenReturnKvListFirstSerializedSizeIsTwelve()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("Property", true);

    JsonArray jsonObject2 = mock(JsonArray.class);
    when(jsonObject2.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonObject2.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(jsonObject2);

    // Assert
    verify(jsonObject2).getAsJsonObject();
    verify(jsonObject2).isJsonObject();
    List<KeyValueProto> kvList = actualConvertToAttributesProtoResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(0, getResult.getTypeValue());
    assertEquals(12, getResult.getSerializedSize());
    assertEquals(14, actualConvertToAttributesProtoResult.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, getResult.getType());
    assertTrue(getResult.getBoolV());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList first TypeValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); then return KvList first TypeValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_thenReturnKvListFirstTypeValueIsZero()
      throws JsonSyntaxException {
    // Arrange
    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsBoolean()).thenReturn(true);
    when(jsonPrimitive.isBoolean()).thenReturn(true);
    when(jsonPrimitive.isString()).thenReturn(false);

    JsonArray jsonArray = mock(JsonArray.class);
    when(jsonArray.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(jsonArray.isJsonPrimitive()).thenReturn(true);
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", jsonArray);

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(simpleEntry);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray jsonObject2 = mock(JsonArray.class);
    when(jsonObject2.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonObject2.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(jsonObject2);

    // Assert
    verify(jsonObject2).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(jsonObject2).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    verify(jsonPrimitive).getAsBoolean();
    verify(jsonPrimitive).isBoolean();
    verify(jsonPrimitive).isString();
    List<KeyValueProto> kvList = actualConvertToAttributesProtoResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(0, getResult.getTypeValue());
    assertEquals(7, getResult.getSerializedSize());
    assertEquals(9, actualConvertToAttributesProtoResult.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, getResult.getType());
    assertTrue(getResult.getBoolV());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); then return KvList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_thenReturnKvListSizeIsTwo() throws JsonSyntaxException {
    // Arrange and Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(
            JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1));

    // Assert
    List<KeyValueProto> kvList = actualConvertToAttributesProtoResult.getKvList();
    assertEquals(2, kvList.size());
    assertEquals(2, actualConvertToAttributesProtoResult.getKvCount());
    assertEquals(39, actualConvertToAttributesProtoResult.getSerializedSize());
    UnknownFieldSet unknownFields = actualConvertToAttributesProtoResult.getUnknownFields();
    PostAttributeMsg defaultInstanceForType =
        actualConvertToAttributesProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(kvList, actualConvertToAttributesProtoResult.getKvOrBuilderList());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is eleven.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); then return SerializedSize is eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_thenReturnSerializedSizeIsEleven() throws JsonSyntaxException {
    // Arrange
    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsString()).thenReturn("42");
    when(jsonPrimitive.isString()).thenReturn(true);

    JsonArray jsonArray = mock(JsonArray.class);
    when(jsonArray.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(jsonArray.isJsonPrimitive()).thenReturn(true);
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", jsonArray);

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(simpleEntry);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray jsonObject2 = mock(JsonArray.class);
    when(jsonObject2.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonObject2.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(jsonObject2);

    // Assert
    verify(jsonObject2).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(jsonObject2).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    verify(jsonPrimitive, atLeast(1)).getAsString();
    verify(jsonPrimitive).isString();
    List<KeyValueProto> kvList = actualConvertToAttributesProtoResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(1, getResult.getTypeValue());
    assertEquals(11, actualConvertToAttributesProtoResult.getSerializedSize());
    assertEquals(42L, getResult.getLongV());
    assertEquals(9, getResult.getSerializedSize());
    assertEquals(KeyValueType.LONG_V, getResult.getType());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()}.
   *   <li>Then throw {@link JsonSyntaxException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributesProto(JsonElement); when JsonArray(); then throw JsonSyntaxException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_whenJsonArray_thenThrowJsonSyntaxException()
      throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(new JsonArray()));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); when JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonConverter.convertToAttributesProto(JsonElement)"
  })
  void testConvertToAttributesProto_whenJsonObject() throws JsonSyntaxException {
    // Arrange and Act
    PostAttributeMsg actualConvertToAttributesProtoResult =
        JsonConverter.convertToAttributesProto(new JsonObject());

    // Assert
    PostAttributeMsg actualDefaultInstanceForType =
        actualConvertToAttributesProtoResult.getDefaultInstanceForType();
    assertEquals(actualConvertToAttributesProtoResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToAttributesProtoResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonObject actualAsJsonObject = actualToJsonResult.getAsJsonObject();
    assertSame(actualToJsonResult, actualAsJsonObject);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonObject actualAsJsonObject = actualToJsonResult.getAsJsonObject();
    assertSame(actualToJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link JsonArray#JsonArray()} add {@code false}.
   *   <li>Then return {@code [false,true]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test toJson(JsonElement) with 'JsonElement'; given 'false'; when JsonArray() add 'false'; then return '[false,true]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonConverter.toJson(JsonElement)"})
  void testToJsonWithJsonElement_givenFalse_whenJsonArrayAddFalse_thenReturnFalseTrue() {
    // Arrange
    JsonArray element = new JsonArray();
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
   *   <li>When {@link JsonArray#JsonArray()} add null.
   *   <li>Then return {@code ["\u0000",true]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test toJson(JsonElement) with 'JsonElement'; given null; when JsonArray() add null; then return '[\"\\u0000\",true]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonConverter.toJson(JsonElement)"})
  void testToJsonWithJsonElement_givenNull_whenJsonArrayAddNull_thenReturnU0000True() {
    // Arrange
    JsonArray element = new JsonArray();
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
   *   <li>When {@link JsonArray#JsonArray()} add {@code true}.
   *   <li>Then return {@code [true]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test toJson(JsonElement) with 'JsonElement'; given 'true'; when JsonArray() add 'true'; then return '[true]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonConverter.toJson(JsonElement)"})
  void testToJsonWithJsonElement_givenTrue_whenJsonArrayAddTrue_thenReturnTrue() {
    // Arrange
    JsonArray element = new JsonArray();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonConverter.toJson(JsonElement)"})
  void testToJsonWithJsonElement_thenReturnLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("[]", JsonConverter.toJson(new JsonArray()));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonConverter.toJson(JsonElement)"})
  void testToJsonWithJsonElement_whenJsonPrimitiveWithBoolIsTrue_thenReturnTrueToString() {
    // Arrange, Act and Assert
    assertEquals(Boolean.TRUE.toString(), JsonConverter.toJson(new JsonPrimitive(true)));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonObject actualAsJsonObject = actualToJsonResult.getAsJsonObject();
    assertSame(actualToJsonResult, actualAsJsonObject);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonObject actualAsJsonObject = actualToJsonResult.getAsJsonObject();
    assertSame(actualToJsonResult, actualAsJsonObject);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonObject actualAsJsonObject = actualToJsonResult.getAsJsonObject();
    assertSame(actualToJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link JsonConverter#toJson(ToDeviceRpcRequestMsg, boolean)} with {@code
   * ToDeviceRpcRequestMsg}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJson(TransportProtos.ToDeviceRpcRequestMsg,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test toJson(ToDeviceRpcRequestMsg, boolean) with 'ToDeviceRpcRequestMsg', 'boolean'; when 'false'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonElement JsonConverter.toJson(TransportProtos.ToDeviceRpcRequestMsg, boolean)"
  })
  void testToJsonWithToDeviceRpcRequestMsgBoolean_whenFalse_thenReturnSizeIsTwo() {
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
    JsonObject actualAsJsonObject = actualToJsonResult.getAsJsonObject();
    assertSame(actualToJsonResult, actualAsJsonObject);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertSame(((JsonNull) actualToJsonResult).INSTANCE, actualToJsonResult.getAsJsonNull());
  }

  /**
   * Test {@link JsonConverter#toJsonObject(Object)}.
   *
   * <ul>
   *   <li>Then return toGatewayDeviceDisconnectJson {@code Device Name} and one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  @DisplayName(
      "Test toJsonObject(Object); then return toGatewayDeviceDisconnectJson 'Device Name' and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonObject JsonConverter.toJsonObject(Object)"})
  void testToJsonObject_thenReturnToGatewayDeviceDisconnectJsonDeviceNameAndOne() {
    // Arrange
    JsonObject toGatewayDeviceDisconnectJsonResult =
        JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);

    // Act
    JsonObject actualToJsonObjectResult =
        JsonConverter.toJsonObject(toGatewayDeviceDisconnectJsonResult);

    // Assert
    assertEquals(toGatewayDeviceDisconnectJsonResult, actualToJsonObjectResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonObject JsonConverter.toJsonObject(Object)"})
  void testToJsonObject_whenJsonObject_thenReturnJsonObject() {
    // Arrange
    JsonObject jsonObject = new JsonObject();

    // Act
    JsonObject actualToJsonObjectResult = JsonConverter.toJsonObject(jsonObject);

    // Assert
    assertEquals(jsonObject, actualToJsonObjectResult);
  }

  /**
   * Test {@link JsonConverter#parseWithTs(Map, JsonObject)} with {@code result}, {@code jo}.
   *
   * <p>Method under test: {@link JsonConverter#parseWithTs(Map, JsonObject)}
   */
  @Test
  @DisplayName("Test parseWithTs(Map, JsonObject) with 'result', 'jo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonConverter.parseWithTs(Map, JsonObject)"})
  void testParseWithTsWithResultJo() {
    // Arrange
    HashMap<Long, List<KvEntry>> result = new HashMap<>();

    JsonObject jo = JsonConverter.toGatewayDeviceDisconnectJson("ts", 1);
    jo.add("values", new JsonObject());
    jo.addProperty("ts", "42");

    // Act
    JsonConverter.parseWithTs(result, jo);

    // Assert that nothing has changed
    assertTrue(result.isEmpty());
  }

  /**
   * Test {@link JsonConverter#parseWithTs(Map, JsonObject)} with {@code result}, {@code jo}.
   *
   * <p>Method under test: {@link JsonConverter#parseWithTs(Map, JsonObject)}
   */
  @Test
  @DisplayName("Test parseWithTs(Map, JsonObject) with 'result', 'jo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonConverter.parseWithTs(Map, JsonObject)"})
  void testParseWithTsWithResultJo2() {
    // Arrange
    HashMap<Long, List<KvEntry>> result = new HashMap<>();

    JsonObject value = new JsonObject();
    value.add("ts", new JsonArray());

    JsonObject jo = new JsonObject();
    jo.add("values", value);
    jo.addProperty("ts", "42");

    // Act
    JsonConverter.parseWithTs(result, jo);

    // Assert
    assertEquals(1, result.size());
    List<KvEntry> getResult = result.get(42L);
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
   * Test {@link JsonConverter#parseWithTs(Map, JsonObject)} with {@code result}, {@code jo}.
   *
   * <p>Method under test: {@link JsonConverter#parseWithTs(Map, JsonObject)}
   */
  @Test
  @DisplayName("Test parseWithTs(Map, JsonObject) with 'result', 'jo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonConverter.parseWithTs(Map, JsonObject)"})
  void testParseWithTsWithResultJo3() {
    // Arrange
    HashMap<Long, List<KvEntry>> result = new HashMap<>();

    JsonObject value = new JsonObject();
    value.add("ts", new JsonObject());

    JsonObject jo = new JsonObject();
    jo.add("values", value);
    jo.addProperty("ts", "42");

    // Act
    JsonConverter.parseWithTs(result, jo);

    // Assert
    assertEquals(1, result.size());
    List<KvEntry> getResult = result.get(42L);
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
   * Test {@link JsonConverter#parseWithTs(Map, JsonObject)} with {@code result}, {@code jo}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).
   *   <li>Then {@link HashMap#HashMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parseWithTs(Map, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test parseWithTs(Map, JsonObject) with 'result', 'jo'; given JsonObject (default constructor); then HashMap() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonConverter.parseWithTs(Map, JsonObject)"})
  void testParseWithTsWithResultJo_givenJsonObject_thenHashMapEmpty() {
    // Arrange
    HashMap<Long, List<KvEntry>> result = new HashMap<>();

    JsonObject jo = new JsonObject();
    jo.add("values", new JsonObject());
    jo.addProperty("ts", "42");

    // Act
    JsonConverter.parseWithTs(result, jo);

    // Assert that nothing has changed
    assertTrue(result.isEmpty());
  }

  /**
   * Test {@link JsonConverter#parseWithTs(Map, JsonObject)} with {@code result}, {@code jo}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} forty-two first {@link BooleanDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parseWithTs(Map, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test parseWithTs(Map, JsonObject) with 'result', 'jo'; then HashMap() forty-two first BooleanDataEntry")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonConverter.parseWithTs(Map, JsonObject)"})
  void testParseWithTsWithResultJo_thenHashMapFortyTwoFirstBooleanDataEntry() {
    // Arrange
    HashMap<Long, List<KvEntry>> result = new HashMap<>();

    JsonObject value = new JsonObject();
    value.addProperty("ts", false);

    JsonObject jo = new JsonObject();
    jo.add("values", value);
    jo.addProperty("ts", "42");

    // Act
    JsonConverter.parseWithTs(result, jo);

    // Assert
    assertEquals(1, result.size());
    List<KvEntry> getResult = result.get(42L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof BooleanDataEntry);
    assertEquals(DataType.BOOLEAN, getResult2.getDataType());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.get());
    Optional<Double> doubleValue = getResult2.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertFalse((Boolean) getResult2.getValue());
    assertTrue(booleanValue.isPresent());
    assertEquals(Boolean.FALSE.toString(), getResult2.getValueAsString());
    assertSame(doubleValue, getResult2.getJsonValue());
    assertSame(doubleValue, getResult2.getLongValue());
    assertSame(doubleValue, getResult2.getStrValue());
  }

  /**
   * Test {@link JsonConverter#parseWithTs(Map, JsonObject)} with {@code result}, {@code jo}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} forty-two first JsonValue is {@code
   *       {"device":"ts","reason":1}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parseWithTs(Map, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test parseWithTs(Map, JsonObject) with 'result', 'jo'; then HashMap() forty-two first JsonValue is '{\"device\":\"ts\",\"reason\":1}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonConverter.parseWithTs(Map, JsonObject)"})
  void testParseWithTsWithResultJo_thenHashMapFortyTwoFirstJsonValueIsDeviceTsReason1() {
    // Arrange
    HashMap<Long, List<KvEntry>> result = new HashMap<>();

    JsonObject value = new JsonObject();
    value.add("ts", JsonConverter.toGatewayDeviceDisconnectJson("ts", 1));

    JsonObject jo = new JsonObject();
    jo.add("values", value);
    jo.addProperty("ts", "42");

    // Act
    JsonConverter.parseWithTs(result, jo);

    // Assert
    assertEquals(1, result.size());
    List<KvEntry> getResult = result.get(42L);
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
   * Test {@link JsonConverter#parseWithTs(Map, JsonObject)} with {@code result}, {@code jo}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} forty-two first {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parseWithTs(Map, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test parseWithTs(Map, JsonObject) with 'result', 'jo'; then HashMap() forty-two first LongDataEntry")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonConverter.parseWithTs(Map, JsonObject)"})
  void testParseWithTsWithResultJo_thenHashMapFortyTwoFirstLongDataEntry() {
    // Arrange
    HashMap<Long, List<KvEntry>> result = new HashMap<>();

    JsonObject value = new JsonObject();
    value.addProperty("ts", "42");

    JsonObject jo = new JsonObject();
    jo.add("values", value);
    jo.addProperty("ts", "42");

    // Act
    JsonConverter.parseWithTs(result, jo);

    // Assert
    assertEquals(1, result.size());
    List<KvEntry> getResult = result.get(42L);
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
   * Test {@link JsonConverter#parseWithTs(Map, JsonObject)} with {@code result}, {@code jo}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} forty-two size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parseWithTs(Map, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test parseWithTs(Map, JsonObject) with 'result', 'jo'; then HashMap() forty-two size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonConverter.parseWithTs(Map, JsonObject)"})
  void testParseWithTsWithResultJo_thenHashMapFortyTwoSizeIsTwo() {
    // Arrange
    HashMap<Long, List<KvEntry>> result = new HashMap<>();

    JsonObject jo = new JsonObject();
    jo.add("values", JsonConverter.toGatewayDeviceDisconnectJson("ts", 1));
    jo.addProperty("ts", "42");

    // Act
    JsonConverter.parseWithTs(result, jo);

    // Assert
    assertEquals(1, result.size());
    List<KvEntry> getResult = result.get(42L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(1);
    assertTrue(getResult2 instanceof LongDataEntry);
    KvEntry getResult3 = getResult.get(0);
    assertTrue(getResult3 instanceof StringDataEntry);
    assertEquals("1", getResult2.getValueAsString());
    assertEquals("device", getResult3.getKey());
    assertEquals("reason", getResult2.getKey());
    assertEquals("ts", getResult3.getValueAsString());
    assertEquals("ts", getResult3.getValue());
    assertEquals(1L, ((Long) getResult2.getValue()).longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
    assertEquals(DataType.STRING, getResult3.getDataType());
  }

  /**
   * Test {@link JsonConverter#parseWithTs(Map, JsonObject)} with {@code result}, {@code jo}.
   *
   * <ul>
   *   <li>Then throw {@link JsonSyntaxException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#parseWithTs(Map, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test parseWithTs(Map, JsonObject) with 'result', 'jo'; then throw JsonSyntaxException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonConverter.parseWithTs(Map, JsonObject)"})
  void testParseWithTsWithResultJo_thenThrowJsonSyntaxException() {
    // Arrange
    HashMap<Long, List<KvEntry>> result = new HashMap<>();

    JsonObject value = new JsonObject();
    value.add("ts", null);

    JsonObject jo = new JsonObject();
    jo.add("values", value);
    jo.addProperty("ts", "42");

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.parseWithTs(result, jo));
  }

  /**
   * Test {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(JsonElement, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest() throws JsonSyntaxException {
    // Arrange
    JsonObject json = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    json.add("params", new JsonObject());
    json.addProperty("method", "42");

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    assertEquals("{}", actualConvertToServerRpcRequestResult.getParams());
    ByteString paramsBytes = actualConvertToServerRpcRequestResult.getParamsBytes();
    ByteIterator iteratorResult = paramsBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('{', nextResult.byteValue());
    assertEquals('}', nextResult2.byteValue());
    assertEquals("{}", paramsBytes.toStringUtf8());
  }

  /**
   * Test {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return ParamsBytes toStringUtf8 is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}
   */
  @Test
  @DisplayName(
      "Test convertToServerRpcRequest(JsonElement, int); given '42'; then return ParamsBytes toStringUtf8 is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest_given42_thenReturnParamsBytesToStringUtf8IsNull()
      throws JsonSyntaxException {
    // Arrange
    JsonObject json = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    json.addProperty("method", "42");

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    ByteString paramsBytes = actualConvertToServerRpcRequestResult.getParamsBytes();
    assertEquals("null", paramsBytes.toStringUtf8());
    assertEquals("null", actualConvertToServerRpcRequestResult.getParams());
    assertEquals(12, actualConvertToServerRpcRequestResult.getSerializedSize());
    ByteIterator iteratorResult = paramsBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('n', iteratorResult.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(JsonElement, int); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest_givenNull() throws JsonSyntaxException {
    // Arrange
    JsonObject json = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    json.add("params", null);
    json.addProperty("method", "42");

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    ByteString paramsBytes = actualConvertToServerRpcRequestResult.getParamsBytes();
    assertEquals("null", paramsBytes.toStringUtf8());
    assertEquals("null", actualConvertToServerRpcRequestResult.getParams());
    assertEquals(12, actualConvertToServerRpcRequestResult.getSerializedSize());
    ByteIterator iteratorResult = paramsBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('n', iteratorResult.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}.
   *
   * <ul>
   *   <li>Then return MethodName is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(JsonElement, int); then return MethodName is '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest_thenReturnMethodNameIs1() throws JsonSyntaxException {
    // Arrange
    JsonObject json = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    json.addProperty("method", Integer.valueOf(1));

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    assertEquals("1", actualConvertToServerRpcRequestResult.getMethodName());
    ByteString methodNameBytes = actualConvertToServerRpcRequestResult.getMethodNameBytes();
    ByteIterator iteratorResult = methodNameBytes.iterator();
    Byte nextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('1', nextResult.byteValue());
    assertEquals("1", methodNameBytes.toStringUtf8());
    assertEquals(11, actualConvertToServerRpcRequestResult.getSerializedSize());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest_thenReturnMethodNameIsTrueToString()
      throws JsonSyntaxException {
    // Arrange
    JsonObject json = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    json.addProperty("method", true);

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualConvertToServerRpcRequestResult.getMethodName());
    ByteString methodNameBytes = actualConvertToServerRpcRequestResult.getMethodNameBytes();
    ByteIterator iteratorResult = methodNameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals(Boolean.TRUE.toString(), methodNameBytes.toStringUtf8());
  }

  /**
   * Test {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}.
   *
   * <ul>
   *   <li>Then return Params is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(JsonElement, int); then return Params is '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest_thenReturnParamsIs1() throws JsonSyntaxException {
    // Arrange
    JsonObject json = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    json.addProperty("params", Integer.valueOf(1));
    json.addProperty("method", "42");

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    assertEquals("1", actualConvertToServerRpcRequestResult.getParams());
    ByteString paramsBytes = actualConvertToServerRpcRequestResult.getParamsBytes();
    ByteIterator iteratorResult = paramsBytes.iterator();
    Byte nextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('1', nextResult.byteValue());
    assertEquals("1", paramsBytes.toStringUtf8());
    assertEquals(9, actualConvertToServerRpcRequestResult.getSerializedSize());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest_thenReturnParamsIsFalseToString() throws JsonSyntaxException {
    // Arrange
    JsonObject json = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    json.addProperty("params", false);
    json.addProperty("method", "42");

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    assertEquals(Boolean.FALSE.toString(), actualConvertToServerRpcRequestResult.getParams());
    ByteString paramsBytes = actualConvertToServerRpcRequestResult.getParamsBytes();
    ByteIterator iteratorResult = paramsBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('f', iteratorResult.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals(Boolean.FALSE.toString(), paramsBytes.toStringUtf8());
  }

  /**
   * Test {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}.
   *
   * <ul>
   *   <li>Then return Params is {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToServerRpcRequest(JsonElement, int)}
   */
  @Test
  @DisplayName(
      "Test convertToServerRpcRequest(JsonElement, int); then return Params is TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg JsonConverter.convertToServerRpcRequest(JsonElement, int)"
  })
  void testConvertToServerRpcRequest_thenReturnParamsIsTrueToString() throws JsonSyntaxException {
    // Arrange
    JsonObject json = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    json.add("params", new JsonPrimitive(true));
    json.addProperty("method", "42");

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        JsonConverter.convertToServerRpcRequest(json, 1);

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualConvertToServerRpcRequestResult.getParams());
    ByteString paramsBytes = actualConvertToServerRpcRequestResult.getParamsBytes();
    ByteIterator iteratorResult = paramsBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertEquals(Boolean.TRUE.toString(), paramsBytes.toStringUtf8());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonObject actualAsJsonObject = actualJsonObjectForGateway.getAsJsonObject();
    assertSame(actualJsonObjectForGateway, actualAsJsonObject);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonObject actualAsJsonObject = actualJsonObjectForGateway.getAsJsonObject();
    assertSame(actualJsonObjectForGateway, actualAsJsonObject);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonObject actualAsJsonObject = actualToGatewayDeviceDisconnectJsonResult.getAsJsonObject();
    assertSame(actualToGatewayDeviceDisconnectJsonResult, actualAsJsonObject);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonObject actualAsJsonObject = actualToGatewayDeviceDisconnectJsonResult.getAsJsonObject();
    assertSame(actualToGatewayDeviceDisconnectJsonResult, actualAsJsonObject);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonObject actualAsJsonObject = actualToErrorJsonResult.getAsJsonObject();
    assertSame(actualToErrorJsonResult, actualAsJsonObject);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonObject actualAsJsonObject = actualToErrorJsonResult.getAsJsonObject();
    assertSame(actualToErrorJsonResult, actualAsJsonObject);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonObject actualAsJsonObject = actualToGatewayJsonResult.getAsJsonObject();
    assertSame(actualToGatewayJsonResult, actualAsJsonObject);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonObject actualAsJsonObject = actualToGatewayJsonResult.getAsJsonObject();
    assertSame(actualToGatewayJsonResult, actualAsJsonObject);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    JsonObject actualAsJsonObject = actualToGatewayJsonResult.getAsJsonObject();
    assertSame(actualToGatewayJsonResult, actualAsJsonObject);
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.addProperty("42", false);

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult =
        JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(3, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes2() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.addProperty(".", "42");
    element.add("42", new JsonArray());

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult =
        JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(4, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_givenEmptyString() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.addProperty("42", "");

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
   *   <li>Given {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); given JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_givenJsonArray() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("42", new JsonArray());

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
   *   <li>Given {@link JsonArray#JsonArray()} add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); given JsonArray() add 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_givenJsonArrayAddFalse() {
    // Arrange
    JsonArray value = new JsonArray();
    value.add(false);
    value.add(true);

    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("42", value);

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
   *   <li>Given {@link JsonArray#JsonArray()} add start of heading.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); given JsonArray() add start of heading")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_givenJsonArrayAddStartOfHeading() {
    // Arrange
    JsonArray value = new JsonArray();
    value.add('\u0001');

    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("42", value);

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
   *   <li>Given {@link JsonArray#JsonArray()} add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); given JsonArray() add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_givenJsonArrayAddTrue() {
    // Arrange
    JsonArray value = new JsonArray();
    value.add(true);

    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("42", value);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_givenJsonObject() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("42", new JsonObject());

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_givenNull_thenThrowJsonSyntaxException() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("42", null);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributes(element));
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); given 'Property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_givenProperty() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.addProperty("Property", ".");
    element.addProperty("42", false);

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult =
        JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(4, actualConvertToAttributesResult.size());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_givenToGatewayDeviceDisconnectJsonDotAndOne() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("42", JsonConverter.toGatewayDeviceDisconnectJson(".", 1));

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
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_thenReturnSizeIsTwo() {
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
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToAttributes(JsonElement); when JsonObject (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set JsonConverter.convertToAttributes(JsonElement)"})
  void testConvertToAttributes_whenJsonObject_thenReturnEmpty() {
    // Arrange and Act
    Set<AttributeKvEntry> actualConvertToAttributesResult =
        JsonConverter.convertToAttributes(new JsonObject());

    // Assert
    assertTrue(actualConvertToAttributesResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", new JsonObject());

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    assertEquals("42", getResult2.getKey());
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
   *   <li>Given {@code .}.
   *   <li>Then return one first StrValue is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given '.'; then return one first StrValue is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenDot_thenReturnOneFirstStrValueIsDot()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");
    jsonElement.add("42", new JsonArray());

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(1);
    assertTrue(getResult2 instanceof JsonDataEntry);
    KvEntry getResult3 = getResult.get(0);
    assertTrue(getResult3 instanceof StringDataEntry);
    assertEquals(".", getResult3.getStrValue().get());
    assertEquals(".", getResult3.getValueAsString());
    assertEquals(".", getResult3.getValue());
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("[]", jsonValue.get());
    assertTrue(jsonValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link JsonArray#JsonArray()} add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given 'false'; when JsonArray() add 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenFalse_whenJsonArrayAddFalse() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonArray#JsonArray()} add {@code false}.
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given JsonArray() add 'false'; when JsonArray() add JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenJsonArrayAddFalse_whenJsonArrayAddJsonArray()
      throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray();
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonArray#JsonArray()} add {@code true}.
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given JsonArray() add 'true'; when JsonArray() add JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenJsonArrayAddTrue_whenJsonArrayAddJsonArray()
      throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray();
    element.add(true);

    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@link JsonObject} (default constructor).
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given JsonObject (default constructor); when JsonArray() add JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenJsonObject_whenJsonArrayAddJsonObject()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   *   <li>Given {@code null}.
   *   <li>When {@link JsonObject} (default constructor) add {@code 42} and {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given 'null'; when JsonObject (default constructor) add '42' and 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenNull_whenJsonObjectAdd42AndNull()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", null);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link JsonArray#JsonArray()} add {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given 'true'; when JsonArray() add JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenTrue_whenJsonArrayAddJsonArray()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
    jsonElement.add(new JsonArray());
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
   *   <li>When {@link JsonArray#JsonArray()} add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given 'true'; when JsonArray() add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenTrue_whenJsonArrayAddTrue() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   *   <li>When {@link JsonArray#JsonArray()} add valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); given valueOf one; when JsonArray() add valueOf one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_givenValueOfOne_whenJsonArrayAddValueOfOne()
      throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray();
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
   *   <li>Then one first return {@link BooleanDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); then one first return BooleanDataEntry")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_thenOneFirstReturnBooleanDataEntry()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("42", false);

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
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.get());
    Optional<Double> doubleValue = getResult2.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertFalse((Boolean) getResult2.getValue());
    assertTrue(booleanValue.isPresent());
    assertEquals(Boolean.FALSE.toString(), getResult2.getValueAsString());
    assertSame(doubleValue, getResult2.getJsonValue());
    assertSame(doubleValue, getResult2.getLongValue());
    assertSame(doubleValue, getResult2.getStrValue());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Then one first return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); then one first return LongDataEntry")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_thenOneFirstReturnLongDataEntry() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");
    jsonElement.add("42", new JsonArray());

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
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
   *   <li>Then one second return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); then one second return LongDataEntry")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_thenOneSecondReturnLongDataEntry() throws JsonSyntaxException {
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
   *   <li>Then return one first JsonValue is {@code {"device":"ts","reason":1}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); then return one first JsonValue is '{\"device\":\"ts\",\"reason\":1}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_thenReturnOneFirstJsonValueIsDeviceTsReason1()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", JsonConverter.toGatewayDeviceDisconnectJson("ts", 1));

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    assertEquals("42", getResult2.getKey());
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
   *   <li>Then return one first Key is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); then return one first Key is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_thenReturnOneFirstKeyIs42() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("42", new JsonArray());

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    assertEquals("42", getResult2.getKey());
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
   * <ul>
   *   <li>Then return one first Key is {@code ts}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); then return one first Key is 'ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_thenReturnOneFirstKeyIsTs() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray());
    jsonElement.add("42", new JsonArray());

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    KvEntry getResult3 = getResult.get(1);
    assertTrue(getResult3 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("[]", jsonValue.get());
    assertEquals("[]", getResult2.getValueAsString());
    assertEquals("[]", getResult2.getValue());
    assertEquals("ts", getResult2.getKey());
    assertEquals(jsonValue, getResult3.getJsonValue());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   *
   * <ul>
   *   <li>Then return one first Key is {@code values}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); then return one first Key is 'values'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_thenReturnOneFirstKeyIsValues() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("values", new JsonArray());
    jsonElement.add("42", new JsonArray());

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    KvEntry getResult3 = getResult.get(1);
    assertTrue(getResult3 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("[]", jsonValue.get());
    assertEquals("[]", getResult2.getValueAsString());
    assertEquals("[]", getResult2.getValue());
    assertEquals("values", getResult2.getKey());
    assertEquals(jsonValue, getResult3.getJsonValue());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_thenReturnOneFirstStrValueIsEmptyString()
      throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("42", "");

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
   *   <li>When {@link JsonArray#JsonArray()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName(
      "Test convertToSortedTelemetry(JsonElement, long); when JsonArray(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonConverter.convertToSortedTelemetry(JsonElement, long)"})
  void testConvertToSortedTelemetry_whenJsonArray_thenReturnEmpty() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult =
        JsonConverter.convertToSortedTelemetry(new JsonArray(), 1L);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenEmptyString() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.add("", new JsonArray());

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>Given {@link JsonArray#JsonArray()} add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given JsonArray() add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_givenJsonArrayAddTrue() {
    // Arrange
    JsonArray value = new JsonArray();
    value.add(true);

    JsonObject jo = new JsonObject();
    jo.add("token", value);
    jo.addProperty("deviceName", Integer.valueOf(-1));

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>Given valueOf minus one.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given valueOf minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>When {@link JsonObject} (default constructor) add {@code Property} and {@link
   *       JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(JsonObject) with 'jo'; when JsonObject (default constructor) add 'Property' and JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_whenJsonObjectAddPropertyAndJsonArray() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.add("Property", new JsonArray());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with {@code jo}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor) add {@code Property} and {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(JsonObject) with 'jo'; when JsonObject (default constructor) add 'Property' and 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(JsonObject)"
  })
  void testConvertToProvisionRequestMsgWithJo_whenJsonObjectAddPropertyAndNull() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.add("Property", null);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonConverter.convertToProvisionRequestMsg(String)"
  })
  void testConvertToProvisionRequestMsgWithJson_whenJson() {
    // Arrange, Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("Json"));
  }
}
