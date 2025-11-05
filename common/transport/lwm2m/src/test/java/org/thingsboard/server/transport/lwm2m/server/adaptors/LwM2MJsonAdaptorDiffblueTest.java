package org.thingsboard.server.transport.lwm2m.server.adaptors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import com.amazonaws.transform.MapEntry;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.common.adaptor.JsonConverter;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.AttributeUpdateNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueProto;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueType;
import org.thingsboard.server.gen.transport.TransportProtos.PostAttributeMsg;
import org.thingsboard.server.gen.transport.TransportProtos.PostTelemetryMsg;
import org.thingsboard.server.gen.transport.TransportProtos.TsKvListProto;

class LwM2MJsonAdaptorDiffblueTest {
  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        lwM2MJsonAdaptor.convertToPostTelemetry(new JsonObject());

    // Assert
    UnknownFieldSet unknownFields = actualConvertToPostTelemetryResult.getUnknownFields();
    PostTelemetryMsg defaultInstanceForType =
        actualConvertToPostTelemetryResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry2() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("ts", new JsonArray());

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals("[]", getResult.getJsonV());
    assertEquals(10, getResult.getSerializedSize());
    assertEquals(4, getResult.getTypeValue());
    assertEquals(KeyValueType.JSON_V, getResult.getType());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry3() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("ts", '\u0001');

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals("\u0001", getResult.getStringV());
    assertEquals(3, getResult.getTypeValue());
    assertEquals(9, getResult.getSerializedSize());
    assertEquals(KeyValueType.STRING_V, getResult.getType());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_givenIllegalStateException() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenThrow(new IllegalStateException());
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); given JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_givenJsonArray() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonArray()).thenReturn(new JsonArray());
    when(jsonElement.isJsonArray()).thenReturn(true);
    when(jsonElement.isJsonObject()).thenReturn(false);

    JsonObject jsonObject = mock(JsonObject.class);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("ts", new JsonArray());

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonArray();
    verify(jsonElement).isJsonArray();
    verify(jsonElement).isJsonObject();
    verify(jsonObject).add(eq("ts"), isA(JsonElement.class));
    PostTelemetryMsg actualDefaultInstanceForType =
        actualConvertToPostTelemetryResult.getDefaultInstanceForType();
    assertEquals(actualConvertToPostTelemetryResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray()} add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); given JsonArray() add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_givenJsonArrayAddTrue() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonArray = new JsonArray();
    jsonArray.add(true);

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonArray()).thenReturn(jsonArray);
    when(jsonElement.isJsonArray()).thenReturn(true);
    when(jsonElement.isJsonObject()).thenReturn(false);

    JsonObject jsonObject = mock(JsonObject.class);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("ts", new JsonArray());

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
    verify(jsonElement).getAsJsonArray();
    verify(jsonElement).isJsonArray();
    verify(jsonElement).isJsonObject();
    verify(jsonObject).add(eq("ts"), isA(JsonElement.class));
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray()} add valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); given JsonArray() add valueOf one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_givenJsonArrayAddValueOfOne() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonArray = new JsonArray();
    jsonArray.add(Integer.valueOf(1));

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonArray()).thenReturn(jsonArray);
    when(jsonElement.isJsonArray()).thenReturn(true);
    when(jsonElement.isJsonObject()).thenReturn(false);

    JsonObject jsonObject = mock(JsonObject.class);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("ts", new JsonArray());

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
    verify(jsonElement).getAsJsonArray();
    verify(jsonElement).isJsonArray();
    verify(jsonElement).isJsonObject();
    verify(jsonObject).add(eq("ts"), isA(JsonElement.class));
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray} {@link JsonArray#forEach(Consumer)} does nothing.
   *   <li>Then calls {@link JsonArray#add(Boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(JsonElement); given JsonArray forEach(Consumer) does nothing; then calls add(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_givenJsonArrayForEachDoesNothing_thenCallsAdd()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonArray = mock(JsonArray.class);
    doNothing().when(jsonArray).forEach(Mockito.<Consumer<JsonElement>>any());
    doNothing().when(jsonArray).add(Mockito.<Boolean>any());
    jsonArray.add(true);

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonArray()).thenReturn(jsonArray);
    when(jsonElement.isJsonArray()).thenReturn(true);
    when(jsonElement.isJsonObject()).thenReturn(false);

    JsonObject jsonObject = mock(JsonObject.class);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("ts", new JsonArray());

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement);

    // Assert
    verify(jsonArray).add(true);
    verify(jsonElement).getAsJsonArray();
    verify(jsonElement).isJsonArray();
    verify(jsonElement).isJsonObject();
    verify(jsonObject).add(eq("ts"), isA(JsonElement.class));
    verify(jsonArray).forEach(isA(Consumer.class));
    PostTelemetryMsg actualDefaultInstanceForType =
        actualConvertToPostTelemetryResult.getDefaultInstanceForType();
    assertEquals(actualConvertToPostTelemetryResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray} {@link JsonArray#getAsJsonObject()} return {@link JsonObject}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(JsonElement); given JsonArray getAsJsonObject() return JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_givenJsonArrayGetAsJsonObjectReturnJsonObject()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonArray = mock(JsonArray.class);
    when(jsonArray.getAsJsonObject()).thenReturn(new JsonObject());
    when(jsonArray.getAsLong()).thenReturn(1L);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.get(Mockito.<String>any())).thenReturn(jsonArray);
    when(jsonObject.has(Mockito.<String>any())).thenReturn(true);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("ts", new JsonArray());

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement);

    // Assert
    verify(jsonArray).getAsLong();
    verify(jsonElement).getAsJsonObject();
    verify(jsonArray).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    verify(jsonObject).add(eq("ts"), isA(JsonElement.class));
    verify(jsonObject, atLeast(1)).get(Mockito.<String>any());
    verify(jsonObject, atLeast(1)).has(Mockito.<String>any());
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    assertEquals(1L, getResult.getTs());
    assertEquals(2, getResult.getSerializedSize());
    assertEquals(4, actualConvertToPostTelemetryResult.getSerializedSize());
    assertTrue(getResult.getKvList().isEmpty());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); given JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_givenJsonObject() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(new JsonObject());
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    assertEquals(1, actualConvertToPostTelemetryResult.getTsKvListList().size());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} {@link JsonObject#get(String)} return {@link
   *       JsonArray#JsonArray()}.
   *   <li>Then calls {@link JsonObject#get(String)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(JsonElement); given JsonObject get(String) return JsonArray(); then calls get(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_givenJsonObjectGetReturnJsonArray_thenCallsGet()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.get(Mockito.<String>any())).thenReturn(new JsonArray());
    when(jsonObject.has(Mockito.<String>any())).thenReturn(true);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("ts", new JsonArray());

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    verify(jsonObject).add(eq("ts"), isA(JsonElement.class));
    verify(jsonObject).get("ts");
    verify(jsonObject, atLeast(1)).has(Mockito.<String>any());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} {@link JsonObject#get(String)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(JsonElement); given JsonObject get(String) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_givenJsonObjectGetThrowIllegalStateException()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.get(Mockito.<String>any())).thenThrow(new IllegalStateException());
    when(jsonObject.has(Mockito.<String>any())).thenReturn(true);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("ts", new JsonArray());

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    verify(jsonObject).add(eq("ts"), isA(JsonElement.class));
    verify(jsonObject).get("ts");
    verify(jsonObject, atLeast(1)).has(Mockito.<String>any());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@code ts}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); given 'ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_givenTs() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonElement =
        JsonConverter.getJsonObjectForGateway(
            "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());
    jsonElement.add("ts", new JsonArray());
    jsonElement.add("values", new JsonArray());

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>Then calls {@link JsonObject#entrySet()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); then calls entrySet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_thenCallsEntrySet() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(new HashSet<>());

    JsonArray jsonArray = mock(JsonArray.class);
    when(jsonArray.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonArray.getAsLong()).thenReturn(1L);

    JsonObject jsonObject2 = mock(JsonObject.class);
    when(jsonObject2.get(Mockito.<String>any())).thenReturn(jsonArray);
    when(jsonObject2.has(Mockito.<String>any())).thenReturn(true);
    doNothing().when(jsonObject2).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject2.add("ts", new JsonArray());

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject2);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement);

    // Assert
    verify(jsonArray).getAsLong();
    verify(jsonElement).getAsJsonObject();
    verify(jsonArray).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    verify(jsonObject2).add(eq("ts"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    verify(jsonObject2, atLeast(1)).get(Mockito.<String>any());
    verify(jsonObject2, atLeast(1)).has(Mockito.<String>any());
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    assertEquals(1L, getResult.getTs());
    assertEquals(2, getResult.getSerializedSize());
    assertEquals(4, actualConvertToPostTelemetryResult.getSerializedSize());
    assertTrue(getResult.getKvList().isEmpty());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>Then return DescriptorForType File EnumTypes size is ten.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(JsonElement); then return DescriptorForType File EnumTypes size is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_thenReturnDescriptorForTypeFileEnumTypesSizeIsTen()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    Integer value = Integer.valueOf(1);
    jsonObject.addProperty("ts", value);

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    Descriptor descriptorForType = actualConvertToPostTelemetryResult.getDescriptorForType();
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    List<KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    FileDescriptor file = descriptorForType.getFile();
    List<EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    KeyValueProto getResult2 = kvList.get(0);
    assertEquals(1L, getResult2.getLongV());
    assertSame(
        value,
        descriptorForType.getOptions().getDescriptorForType().toProto().getExtensionRangeCount());
    assertSame(value, descriptorForType.toProto().getFieldCount());
    FieldDescriptor getResult3 = fields.get(0);
    assertSame(value, getResult3.toProto().getNumber());
    assertSame(value, file.toProto().getDescriptorForType().getIndex());
    assertSame(value, messageTypes.get(1).getIndex());
    assertSame(value, enumTypes.get(1).getIndex());
    assertSame(value, getResult3.getNumber());
    assertSame(value, getResult2.getTypeValue());
    assertSame(value, getResult.getKvCount());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>Then return TsKvListList first KvList first TypeValue is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(JsonElement); then return TsKvListList first KvList first TypeValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_thenReturnTsKvListListFirstKvListFirstTypeValueIsOne()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("ts", "42");

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
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
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>Then return TsKvListList first KvList first TypeValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(JsonElement); then return TsKvListList first KvList first TypeValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_thenReturnTsKvListListFirstKvListFirstTypeValueIsZero()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("ts", true);

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
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
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_thenThrowUnsupportedOperationException() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.get(Mockito.<String>any())).thenReturn(new JsonNull());
    when(jsonObject.has(Mockito.<String>any())).thenReturn(true);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("ts", new JsonArray());

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    verify(jsonObject).add(eq("ts"), isA(JsonElement.class));
    verify(jsonObject).get("ts");
    verify(jsonObject, atLeast(1)).has(Mockito.<String>any());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); when JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_whenJsonArray() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        lwM2MJsonAdaptor.convertToPostTelemetry(new JsonArray());

    // Assert
    assertEquals(1, actualConvertToPostTelemetryResult.getDescriptorForType().getFields().size());
    PostTelemetryMsg actualDefaultInstanceForType =
        actualConvertToPostTelemetryResult.getDefaultInstanceForType();
    assertEquals(actualConvertToPostTelemetryResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToPostTelemetryResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonArray} {@link JsonArray#isJsonArray()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(JsonElement); when JsonArray isJsonArray() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_whenJsonArrayIsJsonArrayReturnFalse() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.isJsonArray()).thenReturn(false);
    when(jsonElement.isJsonObject()).thenReturn(false);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
    verify(jsonElement).isJsonArray();
    verify(jsonElement).isJsonObject();
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(JsonElement); when JsonNull (default constructor); then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_whenJsonNull_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(new JsonNull()));
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(JsonElement); when JsonPrimitive(String) with 'String'; then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_whenJsonPrimitiveWithString_thenThrowAdaptorException()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> lwM2MJsonAdaptor.convertToPostTelemetry(new JsonPrimitive("String")));
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        lwM2MJsonAdaptor.convertToPostAttributes(new JsonObject());

    // Assert
    PostAttributeMsg actualDefaultInstanceForType =
        actualConvertToPostAttributesResult.getDefaultInstanceForType();
    assertEquals(actualConvertToPostAttributesResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToPostAttributesResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes2() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("Property", '\u0001');

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        lwM2MJsonAdaptor.convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    List<KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    ByteString stringVBytes = getResult.getStringVBytes();
    assertEquals("\u0001", stringVBytes.toStringUtf8());
    assertEquals("\u0001", getResult.getStringV());
    ByteIterator iteratorResult = stringVBytes.iterator();
    assertEquals((byte) 1, iteratorResult.next().byteValue());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes3() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonElement = mock(JsonArray.class);

    JsonObject jsonObject = mock(JsonObject.class);

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", new JsonArray());

    SimpleEntry<String, JsonElement> simpleEntry2 = new SimpleEntry<>(simpleEntry);
    simpleEntry2.setValue(new JsonObject());
    entrySet.add(simpleEntry2);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    List<KeyValueProto> kvList = lwM2MJsonAdaptor.convertToPostAttributes(jsonElement).getKvList();
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
    verify(jsonElement).isJsonObject();
    verify(jsonElement).getAsJsonObject();
    verify(jsonObject).entrySet();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes4() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

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

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        lwM2MJsonAdaptor.convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(jsonElement).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    List<KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
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
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes5() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonArray = mock(JsonArray.class);
    when(jsonArray.getAsJsonPrimitive()).thenThrow(new IllegalStateException());
    when(jsonArray.isJsonPrimitive()).thenReturn(true);
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", jsonArray);

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(simpleEntry);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(jsonElement).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes6() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

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

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        lwM2MJsonAdaptor.convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(jsonElement).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    verify(jsonPrimitive, atLeast(1)).getAsString();
    verify(jsonPrimitive).isString();
    List<KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    ByteString stringVBytes = getResult.getStringVBytes();
    assertEquals("As String", stringVBytes.toStringUtf8());
    assertEquals("As String", getResult.getStringV());
    assertEquals(18, getResult.getSerializedSize());
    assertEquals(20, actualConvertToPostAttributesResult.getSerializedSize());
    ByteIterator iteratorResult = stringVBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('s', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes7() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsString()).thenThrow(new IllegalStateException());
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

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(jsonElement).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    verify(jsonPrimitive).getAsString();
    verify(jsonPrimitive).isString();
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes8() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsBoolean()).thenThrow(new IllegalStateException());
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

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(jsonElement).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    verify(jsonPrimitive).getAsBoolean();
    verify(jsonPrimitive).isBoolean();
    verify(jsonPrimitive).isString();
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes9() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

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

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        lwM2MJsonAdaptor.convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    verify(jsonArray).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    List<KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    ByteIterator iteratorResult = kvList.get(0).getJsonVBytes().iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('M', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link JsonArray} {@link JsonArray#isJsonObject()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(JsonElement); given 'false'; when JsonArray isJsonObject() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes_givenFalse_whenJsonArrayIsJsonObjectReturnFalse()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.isJsonObject()).thenReturn(false);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(jsonElement));
    verify(jsonElement).isJsonObject();
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes_givenIllegalStateException() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenThrow(new IllegalStateException());
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement); given JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes_givenJsonObject() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(new JsonObject());
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        lwM2MJsonAdaptor.convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    PostAttributeMsg actualDefaultInstanceForType =
        actualConvertToPostAttributesResult.getDefaultInstanceForType();
    assertEquals(actualConvertToPostAttributesResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code Property} and {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(JsonElement); given JsonObject (default constructor) addProperty 'Property' and '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes_givenJsonObjectAddPropertyPropertyAnd42()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("Property", "42");

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        lwM2MJsonAdaptor.convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    List<KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(1, getResult.getTypeValue());
    assertEquals(14, getResult.getSerializedSize());
    assertEquals(42L, getResult.getLongV());
    assertEquals(Short.SIZE, actualConvertToPostAttributesResult.getSerializedSize());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code Property} and {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(JsonElement); given JsonObject (default constructor) addProperty 'Property' and 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes_givenJsonObjectAddPropertyPropertyAndTrue()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("Property", true);

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        lwM2MJsonAdaptor.convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    List<KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(0, getResult.getTypeValue());
    assertEquals(12, getResult.getSerializedSize());
    assertEquals(14, actualConvertToPostAttributesResult.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, getResult.getType());
    assertTrue(getResult.getBoolV());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link MapEntry} {@link MapEntry#getKey()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(JsonElement); given MapEntry getKey() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes_givenMapEntryGetKeyThrowIllegalStateException()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    MapEntry<String, JsonElement> mapEntry = mock(MapEntry.class);
    when(mapEntry.getKey()).thenThrow(new IllegalStateException());
    when(mapEntry.getValue()).thenReturn(new JsonArray());

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(mapEntry);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(jsonElement));
    verify(mapEntry).getKey();
    verify(mapEntry).getValue();
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link AbstractMap.SimpleEntry#SimpleEntry(Entry)} with {@link
   *       AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} Value is {@link JsonNull} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(JsonElement); given SimpleEntry(Entry) with SimpleEntry(Object, Object) Value is JsonNull (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes_givenSimpleEntryWithSimpleEntryValueIsJsonNull()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", new JsonArray());

    SimpleEntry<String, JsonElement> simpleEntry2 = new SimpleEntry<>(simpleEntry);
    simpleEntry2.setValue(new JsonNull());

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(simpleEntry2);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        lwM2MJsonAdaptor.convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    PostAttributeMsg actualDefaultInstanceForType =
        actualConvertToPostAttributesResult.getDefaultInstanceForType();
    assertEquals(actualConvertToPostAttributesResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList first AllFields size is two.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(JsonElement); then return KvList first AllFields size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes_thenReturnKvListFirstAllFieldsSizeIsTwo()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", new JsonArray());

    SimpleEntry<String, JsonElement> simpleEntry2 = new SimpleEntry<>(simpleEntry);
    simpleEntry2.setValue(new JsonPrimitive(""));

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(simpleEntry2);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        lwM2MJsonAdaptor.convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    List<KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(3, getResult.getTypeValue());
    assertEquals(7, getResult.getSerializedSize());
    assertEquals(9, actualConvertToPostAttributesResult.getSerializedSize());
    assertEquals(KeyValueType.STRING_V, getResult.getType());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList first JsonVBytes toStringUtf8 is {@code [1]}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(JsonElement); then return KvList first JsonVBytes toStringUtf8 is '[1]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes_thenReturnKvListFirstJsonVBytesToStringUtf8Is1()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonArray = new JsonArray();
    Integer number = Integer.valueOf(1);
    jsonArray.add(number);

    MapEntry<String, JsonElement> mapEntry = mock(MapEntry.class);
    when(mapEntry.getKey()).thenReturn("Key");
    when(mapEntry.getValue()).thenReturn(jsonArray);

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(mapEntry);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        lwM2MJsonAdaptor.convertToPostAttributes(jsonElement);

    // Assert
    verify(mapEntry).getKey();
    verify(mapEntry).getValue();
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    List<KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals("[1]", getResult.getJsonVBytes().toStringUtf8());
    assertEquals("[1]", getResult.getJsonV());
    Descriptor descriptorForType = actualConvertToPostAttributesResult.getDescriptorForType();
    FileDescriptor file = descriptorForType.getFile();
    assertEquals(10, file.getEnumTypes().size());
    assertEquals(12, getResult.getSerializedSize());
    assertEquals(14, actualConvertToPostAttributesResult.getSerializedSize());
    assertEquals(180, file.getMessageTypes().size());
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertSame(number, fields.get(1).getIndex());
    assertSame(number, fields.get(0).getNumber());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList first LongV is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement); then return KvList first LongV is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes_thenReturnKvListFirstLongVIsOne() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    Integer value = Integer.valueOf(1);
    jsonObject.addProperty("Property", value);

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        lwM2MJsonAdaptor.convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    List<KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    Descriptor descriptorForType = actualConvertToPostAttributesResult.getDescriptorForType();
    FileDescriptor file = descriptorForType.getFile();
    assertEquals(10, file.getEnumTypes().size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(14, getResult.getSerializedSize());
    assertEquals(180, file.getMessageTypes().size());
    assertEquals(1L, getResult.getLongV());
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(Short.SIZE, actualConvertToPostAttributesResult.getSerializedSize());
    assertSame(value, fields.get(1).getIndex());
    assertSame(value, fields.get(0).getNumber());
    assertSame(value, getResult.getTypeValue());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList first TypeValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(JsonElement); then return KvList first TypeValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes_thenReturnKvListFirstTypeValueIsZero() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

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

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        lwM2MJsonAdaptor.convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(jsonElement).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    verify(jsonPrimitive).getAsBoolean();
    verify(jsonPrimitive).isBoolean();
    verify(jsonPrimitive).isString();
    List<KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(0, getResult.getTypeValue());
    assertEquals(7, getResult.getSerializedSize());
    assertEquals(9, actualConvertToPostAttributesResult.getSerializedSize());
    assertEquals(KeyValueType.BOOLEAN_V, getResult.getType());
    assertTrue(getResult.getBoolV());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is eleven.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement); then return SerializedSize is eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes_thenReturnSerializedSizeIsEleven() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

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

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        lwM2MJsonAdaptor.convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(jsonElement).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    verify(jsonPrimitive, atLeast(1)).getAsString();
    verify(jsonPrimitive).isString();
    List<KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(1, getResult.getTypeValue());
    assertEquals(11, actualConvertToPostAttributesResult.getSerializedSize());
    assertEquals(42L, getResult.getLongV());
    assertEquals(9, getResult.getSerializedSize());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()}.
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(JsonElement); when JsonArray(); then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes_whenJsonArray_thenThrowAdaptorException()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(new JsonArray()));
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(JsonElement); when JsonPrimitive(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg LwM2MJsonAdaptor.convertToPostAttributes(JsonElement)"
  })
  void testConvertToPostAttributes_whenJsonPrimitiveWithString() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> lwM2MJsonAdaptor.convertToPostAttributes(new JsonPrimitive("String")));
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}.
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}
   */
  @Test
  @DisplayName("Test convertToGetAttributes(Collection, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg LwM2MJsonAdaptor.convertToGetAttributes(Collection, Collection)"
  })
  void testConvertToGetAttributes() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    LinkedHashSet<String> clientKeys = new LinkedHashSet<>();
    clientKeys.add("Client Keys");

    // Act
    GetAttributeRequestMsg actualConvertToGetAttributesResult =
        lwM2MJsonAdaptor.convertToGetAttributes(clientKeys, null);

    // Assert
    UnknownFieldSet unknownFields = actualConvertToGetAttributesResult.getUnknownFields();
    GetAttributeRequestMsg defaultInstanceForType =
        actualConvertToGetAttributesResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    ProtocolStringList sharedAttributeNamesList =
        actualConvertToGetAttributesResult.getSharedAttributeNamesList();
    assertSame(sharedAttributeNamesList, defaultInstanceForType.getClientAttributeNamesList());
    assertSame(sharedAttributeNamesList, defaultInstanceForType.getSharedAttributeNamesList());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}.
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}
   */
  @Test
  @DisplayName("Test convertToGetAttributes(Collection, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg LwM2MJsonAdaptor.convertToGetAttributes(Collection, Collection)"
  })
  void testConvertToGetAttributes2() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act
    GetAttributeRequestMsg actualConvertToGetAttributesResult =
        lwM2MJsonAdaptor.convertToGetAttributes(null, LazyStringArrayList.emptyList());

    // Assert
    ProtocolStringList clientAttributeNamesList =
        actualConvertToGetAttributesResult.getClientAttributeNamesList();
    assertEquals(
        clientAttributeNamesList, actualConvertToGetAttributesResult.getSharedAttributeNamesList());
    UnknownFieldSet unknownFields = actualConvertToGetAttributesResult.getUnknownFields();
    GetAttributeRequestMsg defaultInstanceForType =
        actualConvertToGetAttributesResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(clientAttributeNamesList, defaultInstanceForType.getClientAttributeNamesList());
    assertSame(clientAttributeNamesList, defaultInstanceForType.getSharedAttributeNamesList());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(LazyStringArrayList.EMPTY, clientAttributeNamesList);
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return SharedAttributeNamesList size is two.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributes(Collection, Collection); given '42'; then return SharedAttributeNamesList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg LwM2MJsonAdaptor.convertToGetAttributes(Collection, Collection)"
  })
  void testConvertToGetAttributes_given42_thenReturnSharedAttributeNamesListSizeIsTwo()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    ArrayList<String> clientKeys = new ArrayList<>();

    ArrayList<String> sharedKeys = new ArrayList<>();
    sharedKeys.add("42");
    sharedKeys.add("foo");

    // Act
    GetAttributeRequestMsg actualConvertToGetAttributesResult =
        lwM2MJsonAdaptor.convertToGetAttributes(clientKeys, sharedKeys);

    // Assert
    ProtocolStringList sharedAttributeNamesList =
        actualConvertToGetAttributesResult.getSharedAttributeNamesList();
    assertEquals(2, sharedAttributeNamesList.size());
    assertEquals("42", sharedAttributeNamesList.get(0));
    assertEquals("foo", sharedAttributeNamesList.get(1));
    assertEquals(2, actualConvertToGetAttributesResult.getSharedAttributeNamesCount());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}.
   *
   * <ul>
   *   <li>Given {@code Client Keys}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Client Keys}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributes(Collection, Collection); given 'Client Keys'; when LinkedHashSet() add 'Client Keys'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg LwM2MJsonAdaptor.convertToGetAttributes(Collection, Collection)"
  })
  void testConvertToGetAttributes_givenClientKeys_whenLinkedHashSetAddClientKeys()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    LinkedHashSet<String> clientKeys = new LinkedHashSet<>();
    clientKeys.add("Client Keys");

    // Act
    GetAttributeRequestMsg actualConvertToGetAttributesResult =
        lwM2MJsonAdaptor.convertToGetAttributes(clientKeys, LazyStringArrayList.emptyList());

    // Assert
    UnknownFieldSet unknownFields = actualConvertToGetAttributesResult.getUnknownFields();
    GetAttributeRequestMsg defaultInstanceForType =
        actualConvertToGetAttributesResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return SharedAttributeNamesList size is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributes(Collection, Collection); given 'foo'; then return SharedAttributeNamesList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg LwM2MJsonAdaptor.convertToGetAttributes(Collection, Collection)"
  })
  void testConvertToGetAttributes_givenFoo_thenReturnSharedAttributeNamesListSizeIsOne()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    ArrayList<String> clientKeys = new ArrayList<>();

    ArrayList<String> sharedKeys = new ArrayList<>();
    sharedKeys.add("foo");

    // Act
    GetAttributeRequestMsg actualConvertToGetAttributesResult =
        lwM2MJsonAdaptor.convertToGetAttributes(clientKeys, sharedKeys);

    // Assert
    ProtocolStringList sharedAttributeNamesList =
        actualConvertToGetAttributesResult.getSharedAttributeNamesList();
    assertEquals(1, sharedAttributeNamesList.size());
    assertEquals("foo", sharedAttributeNamesList.get(0));
    assertEquals(1, actualConvertToGetAttributesResult.getSharedAttributeNamesCount());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}.
   *
   * <ul>
   *   <li>Then return ClientAttributeNamesCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributes(Collection, Collection); then return ClientAttributeNamesCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg LwM2MJsonAdaptor.convertToGetAttributes(Collection, Collection)"
  })
  void testConvertToGetAttributes_thenReturnClientAttributeNamesCountIsZero()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    ArrayList<String> clientKeys = new ArrayList<>();

    // Act
    GetAttributeRequestMsg actualConvertToGetAttributesResult =
        lwM2MJsonAdaptor.convertToGetAttributes(clientKeys, new ArrayList<>());

    // Assert
    assertEquals(0, actualConvertToGetAttributesResult.getClientAttributeNamesCount());
    assertEquals(1, actualConvertToGetAttributesResult.getAllFields().size());
    assertTrue(actualConvertToGetAttributesResult.getClientAttributeNamesList().isEmpty());
    assertTrue(actualConvertToGetAttributesResult.getSharedAttributeNamesList().isEmpty());
    GetAttributeRequestMsg defaultInstanceForType =
        actualConvertToGetAttributesResult.getDefaultInstanceForType();
    ProtocolStringList clientAttributeNamesList =
        defaultInstanceForType.getClientAttributeNamesList();
    assertEquals(clientKeys, clientAttributeNamesList);
    UnknownFieldSet unknownFields = actualConvertToGetAttributesResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(clientAttributeNamesList, defaultInstanceForType.getSharedAttributeNamesList());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}.
   *
   * <ul>
   *   <li>Then return ClientAttributeNamesList size is two.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributes(Collection, Collection); then return ClientAttributeNamesList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg LwM2MJsonAdaptor.convertToGetAttributes(Collection, Collection)"
  })
  void testConvertToGetAttributes_thenReturnClientAttributeNamesListSizeIsTwo()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    ArrayList<String> clientKeys = new ArrayList<>();
    clientKeys.add("");
    clientKeys.add("foo");

    // Act
    GetAttributeRequestMsg actualConvertToGetAttributesResult =
        lwM2MJsonAdaptor.convertToGetAttributes(clientKeys, new ArrayList<>());

    // Assert
    ProtocolStringList clientAttributeNamesList =
        actualConvertToGetAttributesResult.getClientAttributeNamesList();
    assertEquals(2, clientAttributeNamesList.size());
    assertEquals("", clientAttributeNamesList.get(0));
    assertEquals("foo", clientAttributeNamesList.get(1));
    assertEquals(2, actualConvertToGetAttributesResult.getClientAttributeNamesCount());
  }
}
