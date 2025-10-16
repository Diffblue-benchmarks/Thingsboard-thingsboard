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
package org.thingsboard.server.transport.lwm2m.server.adaptors;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
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
    jsonObject.add("ts", new JsonArray(3));

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
    jsonObject.add("ts", new JsonArray(3));

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
    jsonObject.add("ts", new JsonArray(3));

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
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(JsonElement); given JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_givenJsonArrayWithCapacityIsThree() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonArray()).thenReturn(new JsonArray(3));
    when(jsonElement.isJsonArray()).thenReturn(true);
    when(jsonElement.isJsonObject()).thenReturn(false);

    JsonObject jsonObject = mock(JsonObject.class);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("ts", new JsonArray(3));

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
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(JsonElement); given JsonArray(int) with capacity is three add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_givenJsonArrayWithCapacityIsThreeAddTrue()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonArray = new JsonArray(3);
    jsonArray.add(true);

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonArray()).thenReturn(jsonArray);
    when(jsonElement.isJsonArray()).thenReturn(true);
    when(jsonElement.isJsonObject()).thenReturn(false);

    JsonObject jsonObject = mock(JsonObject.class);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("ts", new JsonArray(3));

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
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(JsonElement); given JsonArray(int) with capacity is three add valueOf one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_givenJsonArrayWithCapacityIsThreeAddValueOfOne()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonArray = new JsonArray(3);
    jsonArray.add(Integer.valueOf(1));

    JsonArray jsonElement = mock(JsonArray.class);
    when(jsonElement.getAsJsonArray()).thenReturn(jsonArray);
    when(jsonElement.isJsonArray()).thenReturn(true);
    when(jsonElement.isJsonObject()).thenReturn(false);

    JsonObject jsonObject = mock(JsonObject.class);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("ts", new JsonArray(3));

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
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(JsonElement); given JsonObject get(String) return JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_givenJsonObjectGetReturnJsonArrayWithCapacityIsThree()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.get(Mockito.<String>any())).thenReturn(new JsonArray(3));
    when(jsonObject.has(Mockito.<String>any())).thenReturn(true);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("ts", new JsonArray(3));

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
    jsonObject.add("ts", new JsonArray(3));

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
    jsonElement.add("ts", new JsonArray(3));
    jsonElement.add("values", new JsonArray(3));

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
    jsonObject2.add("ts", new JsonArray(3));

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
    jsonObject.add("ts", new JsonArray(3));

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
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(JsonElement); when JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg LwM2MJsonAdaptor.convertToPostTelemetry(JsonElement)"
  })
  void testConvertToPostTelemetry_whenJsonArrayWithCapacityIsThree() throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        lwM2MJsonAdaptor.convertToPostTelemetry(new JsonArray(3));

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
    // Arrange and Act
    GetAttributeRequestMsg actualConvertToGetAttributesResult =
        new LwM2MJsonAdaptor().convertToGetAttributes(null, null);

    // Assert
    UnknownFieldSet unknownFields = actualConvertToGetAttributesResult.getUnknownFields();
    GetAttributeRequestMsg defaultInstanceForType =
        actualConvertToGetAttributesResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    ProtocolStringList clientAttributeNamesList =
        actualConvertToGetAttributesResult.getClientAttributeNamesList();
    assertSame(clientAttributeNamesList, defaultInstanceForType.getClientAttributeNamesList());
    assertSame(clientAttributeNamesList, defaultInstanceForType.getSharedAttributeNamesList());
    assertSame(
        clientAttributeNamesList, actualConvertToGetAttributesResult.getSharedAttributeNamesList());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
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
   *   <li>Then return ClientAttributeNamesList size is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributes(Collection, Collection); then return ClientAttributeNamesList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg LwM2MJsonAdaptor.convertToGetAttributes(Collection, Collection)"
  })
  void testConvertToGetAttributes_thenReturnClientAttributeNamesListSizeIsOne()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    LinkedHashSet<String> clientKeys = new LinkedHashSet<>();
    clientKeys.add("Client Keys");

    // Act
    GetAttributeRequestMsg actualConvertToGetAttributesResult =
        lwM2MJsonAdaptor.convertToGetAttributes(clientKeys, null);

    // Assert
    ProtocolStringList clientAttributeNamesList =
        actualConvertToGetAttributesResult.getClientAttributeNamesList();
    assertEquals(1, clientAttributeNamesList.size());
    assertEquals("Client Keys", clientAttributeNamesList.get(0));
    assertEquals(1, actualConvertToGetAttributesResult.getClientAttributeNamesCount());
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

  /**
   * Test {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return AllFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributes(Collection, Collection); when ArrayList(); then return AllFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg LwM2MJsonAdaptor.convertToGetAttributes(Collection, Collection)"
  })
  void testConvertToGetAttributes_whenArrayList_thenReturnAllFieldsSizeIsOne()
      throws AdaptorException {
    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    ArrayList<String> clientKeys = new ArrayList<>();

    // Act
    GetAttributeRequestMsg actualConvertToGetAttributesResult =
        lwM2MJsonAdaptor.convertToGetAttributes(clientKeys, new ArrayList<>());

    // Assert
    assertEquals(1, actualConvertToGetAttributesResult.getAllFields().size());
    assertTrue(actualConvertToGetAttributesResult.getSharedAttributeNamesList().isEmpty());
  }
}
