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
package org.thingsboard.server.transport.coap.efento.adaptor;

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
import com.google.protobuf.UnknownFieldSet;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueProto;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueType;
import org.thingsboard.server.gen.transport.TransportProtos.PostAttributeMsg;
import org.thingsboard.server.gen.transport.TransportProtos.PostTelemetryMsg;
import org.thingsboard.server.gen.transport.TransportProtos.TsKvListProto;
import org.thingsboard.server.transport.coap.efento.CoapEfentoTransportResource;
import org.thingsboard.server.transport.coap.efento.CoapEfentoTransportResource.EfentoTelemetry;

@ContextConfiguration(classes = {EfentoCoapAdaptor.class})
@ExtendWith(SpringExtension.class)
class EfentoCoapAdaptorDiffblueTest {
  @Autowired private EfentoCoapAdaptor efentoCoapAdaptor;

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, new JsonArray());
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(new JsonPrimitive("String"));
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(new JsonPrimitive(""));
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry4() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(new JsonPrimitive(true));
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry5() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(new JsonPrimitive('\u0001'));
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry6() throws AdaptorException {
    // Arrange
    EfentoCoapAdaptor efentoCoapAdaptor = new EfentoCoapAdaptor();
    UUID sessionId = UUID.randomUUID();

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("ts", new JsonArray());

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonObject()).thenReturn(jsonObject);
    when(values.isJsonArray()).thenReturn(false);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonObject()).thenReturn(true);
    when(values.isJsonPrimitive()).thenReturn(false);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    JsonArray jsonArray = mock(JsonArray.class);
    doNothing().when(jsonArray).add(Mockito.<Boolean>any());
    jsonArray.add(true);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList);

    // Assert
    verify(jsonArray).add(true);
    verify(values).getAsJsonObject();
    verify(values).isJsonArray();
    verify(values).isJsonNull();
    verify(values).isJsonObject();
    verify(values).isJsonPrimitive();
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    List<KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult2 = kvList.get(0);
    assertEquals("[]", getResult2.getJsonV());
    assertEquals(10, getResult2.getSerializedSize());
    assertEquals(14, getResult.getSerializedSize());
    assertEquals(4, getResult2.getTypeValue());
    assertEquals(KeyValueType.JSON_V, getResult2.getType());
    assertEquals(Short.SIZE, actualConvertToPostTelemetryResult.getSerializedSize());
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry7() throws AdaptorException {
    // Arrange
    EfentoCoapAdaptor efentoCoapAdaptor = new EfentoCoapAdaptor();
    UUID sessionId = UUID.randomUUID();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("ts", '\u0001');

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonObject()).thenReturn(jsonObject);
    when(values.isJsonArray()).thenReturn(false);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonObject()).thenReturn(true);
    when(values.isJsonPrimitive()).thenReturn(false);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    JsonArray jsonArray = mock(JsonArray.class);
    doNothing().when(jsonArray).add(Mockito.<Boolean>any());
    jsonArray.add(true);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList);

    // Assert
    verify(jsonArray).add(true);
    verify(values).getAsJsonObject();
    verify(values).isJsonArray();
    verify(values).isJsonNull();
    verify(values).isJsonObject();
    verify(values).isJsonPrimitive();
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    List<KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult2 = kvList.get(0);
    assertEquals("\u0001", getResult2.getStringV());
    assertEquals(13, getResult.getSerializedSize());
    assertEquals(15, actualConvertToPostTelemetryResult.getSerializedSize());
    assertEquals(3, getResult2.getTypeValue());
    assertEquals(9, getResult2.getSerializedSize());
    assertEquals(KeyValueType.STRING_V, getResult2.getType());
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link CoapEfentoTransportResource.EfentoTelemetry#EfentoTelemetry(long,
   *       JsonElement)} with ts is minus one and values is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given EfentoTelemetry(long, JsonElement) with ts is minus one and values is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenEfentoTelemetryWithTsIsMinusOneAndValuesIsNull()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, null);
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    List<TsKvListProto> tsKvListList =
        efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList).getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(1, getResult.getKvList().size());
    assertEquals(1, getResult.getKvCount());
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link CoapEfentoTransportResource.EfentoTelemetry#EfentoTelemetry(long,
   *       JsonElement)} with ts is one and values is {@link JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given EfentoTelemetry(long, JsonElement) with ts is one and values is JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenEfentoTelemetryWithTsIsOneAndValuesIsJsonArray()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, new JsonArray());
    telemetryList.add(efentoTelemetry);
    EfentoTelemetry efentoTelemetry2 = new EfentoTelemetry(-1L, new JsonArray());
    telemetryList.add(efentoTelemetry2);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray()} add {@code false}.
   *   <li>Then calls {@link JsonArray#getAsJsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonArray() add 'false'; then calls getAsJsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonArrayAddFalse_thenCallsGetAsJsonArray()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray jsonArray = new JsonArray();
    jsonArray.add(false);
    jsonArray.add(true);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonArray()).thenReturn(jsonArray);
    when(values.isJsonArray()).thenReturn(true);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(false);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonArray();
    verify(values).isJsonArray();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray()} add {@code true}.
   *   <li>Then calls {@link JsonArray#getAsJsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonArray() add 'true'; then calls getAsJsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonArrayAddTrue_thenCallsGetAsJsonArray()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray jsonArray = new JsonArray();
    jsonArray.add(true);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonArray()).thenReturn(jsonArray);
    when(values.isJsonArray()).thenReturn(true);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(false);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonArray();
    verify(values).isJsonArray();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray} {@link JsonArray#getAsJsonArray()} return {@link
   *       JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonArray getAsJsonArray() return JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonArrayGetAsJsonArrayReturnJsonArray()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonArray()).thenReturn(new JsonArray());
    when(values.isJsonArray()).thenReturn(true);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(false);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonArray();
    verify(values).isJsonArray();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray} {@link JsonArray#getAsJsonArray()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonArray getAsJsonArray() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonArrayGetAsJsonArrayThrowRuntimeException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonArray()).thenThrow(new RuntimeException());
    when(values.isJsonArray()).thenReturn(true);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(false);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonArray();
    verify(values).isJsonArray();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray} {@link JsonArray#getAsJsonObject()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonArray getAsJsonObject() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonArrayGetAsJsonObjectThrowRuntimeException()
      throws AdaptorException {
    // Arrange
    EfentoCoapAdaptor efentoCoapAdaptor = new EfentoCoapAdaptor();
    UUID sessionId = UUID.randomUUID();

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonObject()).thenThrow(new RuntimeException());
    when(values.isJsonArray()).thenReturn(false);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonObject()).thenReturn(true);
    when(values.isJsonPrimitive()).thenReturn(false);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    JsonArray jsonArray = mock(JsonArray.class);
    doNothing().when(jsonArray).add(Mockito.<Boolean>any());
    jsonArray.add(true);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(jsonArray).add(true);
    verify(values).getAsJsonObject();
    verify(values).isJsonArray();
    verify(values).isJsonNull();
    verify(values).isJsonObject();
    verify(values).isJsonPrimitive();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray} {@link JsonArray#isJsonNull()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonArray isJsonNull() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonArrayIsJsonNullReturnTrue() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = mock(JsonArray.class);
    when(values.isJsonNull()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList);

    // Assert
    verify(values).isJsonNull();
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(1, getResult.getKvList().size());
    assertEquals(1, getResult.getKvCount());
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray} {@link JsonArray#isJsonNull()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonArray isJsonNull() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonArrayIsJsonNullThrowRuntimeException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = mock(JsonArray.class);
    when(values.isJsonNull()).thenThrow(new RuntimeException());
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).isJsonNull();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonArray} {@link JsonArray#isJsonObject()} return {@code false}.
   *   <li>Then calls {@link JsonObject#add(String, JsonElement)}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonArray isJsonObject() return 'false'; then calls add(String, JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonArrayIsJsonObjectReturnFalse_thenCallsAdd()
      throws AdaptorException {
    // Arrange
    EfentoCoapAdaptor efentoCoapAdaptor = new EfentoCoapAdaptor();
    UUID sessionId = UUID.randomUUID();

    JsonArray values = mock(JsonArray.class);
    when(values.isJsonArray()).thenReturn(false);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonObject()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(false);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    JsonObject jsonObject = mock(JsonObject.class);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("ts", new JsonArray());

    JsonArray jsonArray = mock(JsonArray.class);
    doNothing().when(jsonArray).add(Mockito.<Boolean>any());
    jsonArray.add(true);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(jsonArray).add(true);
    verify(values).isJsonArray();
    verify(values).isJsonNull();
    verify(values).isJsonObject();
    verify(values).isJsonPrimitive();
    verify(jsonObject).add(eq("ts"), isA(JsonElement.class));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonPrimitive} {@link JsonPrimitive#getAsBoolean()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonPrimitive getAsBoolean() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonPrimitiveGetAsBooleanReturnFalse()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsBoolean()).thenReturn(false);
    when(jsonPrimitive.isBoolean()).thenReturn(true);
    when(jsonPrimitive.isNumber()).thenReturn(false);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
    verify(jsonPrimitive).getAsBoolean();
    verify(jsonPrimitive).isBoolean();
    verify(jsonPrimitive).isNumber();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonPrimitive} {@link JsonPrimitive#getAsBoolean()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonPrimitive getAsBoolean() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonPrimitiveGetAsBooleanReturnTrue()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsBoolean()).thenReturn(true);
    when(jsonPrimitive.isBoolean()).thenReturn(true);
    when(jsonPrimitive.isNumber()).thenReturn(false);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
    verify(jsonPrimitive).getAsBoolean();
    verify(jsonPrimitive).isBoolean();
    verify(jsonPrimitive).isNumber();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonPrimitive} {@link JsonPrimitive#getAsBoolean()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonPrimitive getAsBoolean() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonPrimitiveGetAsBooleanThrowRuntimeException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsBoolean()).thenThrow(new RuntimeException());
    when(jsonPrimitive.isBoolean()).thenReturn(true);
    when(jsonPrimitive.isNumber()).thenReturn(false);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
    verify(jsonPrimitive).getAsBoolean();
    verify(jsonPrimitive).isBoolean();
    verify(jsonPrimitive).isNumber();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonPrimitive} {@link JsonPrimitive#getAsNumber()} return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonPrimitive getAsNumber() return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonPrimitiveGetAsNumberReturnA() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsNumber()).thenReturn((byte) 'A');
    when(jsonPrimitive.isNumber()).thenReturn(true);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
    verify(jsonPrimitive).getAsNumber();
    verify(jsonPrimitive).isNumber();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonPrimitive} {@link JsonPrimitive#getAsNumber()} return {@link
   *       Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonPrimitive getAsNumber() return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonPrimitiveGetAsNumberReturnNaN() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsNumber()).thenReturn(Double.NaN);
    when(jsonPrimitive.isNumber()).thenReturn(true);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
    verify(jsonPrimitive).getAsNumber();
    verify(jsonPrimitive).isNumber();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonPrimitive} {@link JsonPrimitive#getAsNumber()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonPrimitive getAsNumber() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonPrimitiveGetAsNumberReturnNull()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsNumber()).thenReturn(null);
    when(jsonPrimitive.isNumber()).thenReturn(true);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList);

    // Assert
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
    verify(jsonPrimitive).getAsNumber();
    verify(jsonPrimitive).isNumber();
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(1, getResult.getKvList().size());
    assertEquals(1, getResult.getKvCount());
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonPrimitive} {@link JsonPrimitive#getAsNumber()} return one.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonPrimitive getAsNumber() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonPrimitiveGetAsNumberReturnOne() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsNumber()).thenReturn(1L);
    when(jsonPrimitive.isNumber()).thenReturn(true);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
    verify(jsonPrimitive).getAsNumber();
    verify(jsonPrimitive).isNumber();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonPrimitive} {@link JsonPrimitive#getAsNumber()} return one.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonPrimitive getAsNumber() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonPrimitiveGetAsNumberReturnOne2()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsNumber()).thenReturn((short) 1);
    when(jsonPrimitive.isNumber()).thenReturn(true);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
    verify(jsonPrimitive).getAsNumber();
    verify(jsonPrimitive).isNumber();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonPrimitive} {@link JsonPrimitive#getAsNumber()} return ten.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonPrimitive getAsNumber() return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonPrimitiveGetAsNumberReturnTen() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsNumber()).thenReturn(10.0d);
    when(jsonPrimitive.isNumber()).thenReturn(true);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
    verify(jsonPrimitive).getAsNumber();
    verify(jsonPrimitive).isNumber();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonPrimitive} {@link JsonPrimitive#getAsNumber()} return ten.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonPrimitive getAsNumber() return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonPrimitiveGetAsNumberReturnTen2()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsNumber()).thenReturn(10.0f);
    when(jsonPrimitive.isNumber()).thenReturn(true);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
    verify(jsonPrimitive).getAsNumber();
    verify(jsonPrimitive).isNumber();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonPrimitive} {@link JsonPrimitive#getAsNumber()} return valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonPrimitive getAsNumber() return valueOf one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonPrimitiveGetAsNumberReturnValueOfOne()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsNumber()).thenReturn(Integer.valueOf(1));
    when(jsonPrimitive.isNumber()).thenReturn(true);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
    verify(jsonPrimitive).getAsNumber();
    verify(jsonPrimitive).isNumber();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonPrimitive} {@link JsonPrimitive#getAsNumber()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonPrimitive getAsNumber() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonPrimitiveGetAsNumberThrowRuntimeException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsNumber()).thenThrow(new RuntimeException());
    when(jsonPrimitive.isNumber()).thenReturn(true);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
    verify(jsonPrimitive).getAsNumber();
    verify(jsonPrimitive).isNumber();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link JsonPrimitive#JsonPrimitive(String)} with string is {@code ts}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonPrimitive(String) with string is 'ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonPrimitiveWithStringIsTs() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, new JsonPrimitive("ts"));
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); given 'null'; when ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenNull_whenArrayListAddNull() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(null);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Then calls {@link JsonObject#entrySet()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); then calls entrySet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_thenCallsEntrySet() throws AdaptorException {
    // Arrange
    EfentoCoapAdaptor efentoCoapAdaptor = new EfentoCoapAdaptor();
    UUID sessionId = UUID.randomUUID();

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(new HashSet<>());
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("ts", new JsonArray());

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonObject()).thenReturn(jsonObject);
    when(values.isJsonArray()).thenReturn(false);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonObject()).thenReturn(true);
    when(values.isJsonPrimitive()).thenReturn(false);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    JsonArray jsonArray = mock(JsonArray.class);
    doNothing().when(jsonArray).add(Mockito.<Boolean>any());
    jsonArray.add(true);
    ArrayList<JsonElement> expectedExtensions = new ArrayList<>();

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList);

    // Assert
    verify(jsonArray).add(true);
    verify(values).getAsJsonObject();
    verify(values).isJsonArray();
    verify(values).isJsonNull();
    verify(values).isJsonObject();
    verify(values).isJsonPrimitive();
    verify(jsonObject).add(eq("ts"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    List<FieldDescriptor> fields =
        actualConvertToPostTelemetryResult.getDescriptorForType().getFields();
    assertEquals(1, fields.size());
    assertEquals(2, getResult.getSerializedSize());
    assertEquals(4, actualConvertToPostTelemetryResult.getSerializedSize());
    assertTrue(getResult.getKvList().isEmpty());
    assertEquals(
        expectedExtensions, fields.get(0).toProto().getDescriptorForType().getExtensions());
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Then calls {@link JsonPrimitive#getAsString()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); then calls getAsString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_thenCallsGetAsString() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.isBoolean()).thenReturn(false);
    when(jsonPrimitive.isNumber()).thenReturn(false);
    when(jsonPrimitive.getAsString()).thenReturn("As String");

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(jsonPrimitive);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(values).getAsJsonPrimitive();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
    verify(jsonPrimitive).getAsString();
    verify(jsonPrimitive).isBoolean();
    verify(jsonPrimitive).isNumber();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Then calls {@link JsonArray#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); then calls iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_thenCallsIterator() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray jsonArray = mock(JsonArray.class);

    ArrayList<JsonElement> jsonElementList = new ArrayList<>();
    when(jsonArray.iterator()).thenReturn(jsonElementList.iterator());
    doNothing().when(jsonArray).add(Mockito.<Boolean>any());
    jsonArray.add(true);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonArray()).thenReturn(jsonArray);
    when(values.isJsonArray()).thenReturn(true);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(false);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
    verify(jsonArray).add(true);
    verify(jsonArray).iterator();
    verify(values).getAsJsonArray();
    verify(values).isJsonArray();
    verify(values).isJsonNull();
    verify(values).isJsonPrimitive();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Then return TsKvListList first KvList first TypeValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); then return TsKvListList first KvList first TypeValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_thenReturnTsKvListListFirstKvListFirstTypeValueIsZero()
      throws AdaptorException {
    // Arrange
    EfentoCoapAdaptor efentoCoapAdaptor = new EfentoCoapAdaptor();
    UUID sessionId = UUID.randomUUID();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("ts", true);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonObject()).thenReturn(jsonObject);
    when(values.isJsonArray()).thenReturn(false);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonObject()).thenReturn(true);
    when(values.isJsonPrimitive()).thenReturn(false);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    JsonArray jsonArray = mock(JsonArray.class);
    doNothing().when(jsonArray).add(Mockito.<Boolean>any());
    jsonArray.add(true);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList);

    // Assert
    verify(jsonArray).add(true);
    verify(values).getAsJsonObject();
    verify(values).isJsonArray();
    verify(values).isJsonNull();
    verify(values).isJsonObject();
    verify(values).isJsonPrimitive();
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
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Then return TsKvListList first SerializedSize is twelve.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); then return TsKvListList first SerializedSize is twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_thenReturnTsKvListListFirstSerializedSizeIsTwelve()
      throws AdaptorException {
    // Arrange
    EfentoCoapAdaptor efentoCoapAdaptor = new EfentoCoapAdaptor();
    UUID sessionId = UUID.randomUUID();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("ts", "42");

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonObject()).thenReturn(jsonObject);
    when(values.isJsonArray()).thenReturn(false);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonObject()).thenReturn(true);
    when(values.isJsonPrimitive()).thenReturn(false);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    JsonArray jsonArray = mock(JsonArray.class);
    doNothing().when(jsonArray).add(Mockito.<Boolean>any());
    jsonArray.add(true);
    Integer expectedTypeValue = Integer.valueOf(1);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList);

    // Assert
    verify(jsonArray).add(true);
    verify(values).getAsJsonObject();
    verify(values).isJsonArray();
    verify(values).isJsonNull();
    verify(values).isJsonObject();
    verify(values).isJsonPrimitive();
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    List<KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    assertEquals(12, getResult.getSerializedSize());
    assertEquals(14, actualConvertToPostTelemetryResult.getSerializedSize());
    KeyValueProto getResult2 = kvList.get(0);
    assertEquals(42L, getResult2.getLongV());
    assertSame(expectedTypeValue, getResult2.getTypeValue());
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Then return TsKvListList first SerializedSize is two.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); then return TsKvListList first SerializedSize is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_thenReturnTsKvListListFirstSerializedSizeIsTwo()
      throws AdaptorException {
    // Arrange
    EfentoCoapAdaptor efentoCoapAdaptor = new EfentoCoapAdaptor();
    UUID sessionId = UUID.randomUUID();

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonObject()).thenReturn(new JsonObject());
    when(values.isJsonArray()).thenReturn(false);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonObject()).thenReturn(true);
    when(values.isJsonPrimitive()).thenReturn(false);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    JsonArray jsonArray = mock(JsonArray.class);
    doNothing().when(jsonArray).add(Mockito.<Boolean>any());
    jsonArray.add(true);
    ArrayList<JsonElement> expectedExtensions = new ArrayList<>();

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList);

    // Assert
    verify(jsonArray).add(true);
    verify(values).getAsJsonObject();
    verify(values).isJsonArray();
    verify(values).isJsonNull();
    verify(values).isJsonObject();
    verify(values).isJsonPrimitive();
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    List<FieldDescriptor> fields =
        actualConvertToPostTelemetryResult.getDescriptorForType().getFields();
    assertEquals(1, fields.size());
    assertEquals(2, getResult.getSerializedSize());
    assertEquals(4, actualConvertToPostTelemetryResult.getSerializedSize());
    assertTrue(getResult.getKvList().isEmpty());
    assertEquals(
        expectedExtensions, fields.get(0).toProto().getDescriptorForType().getExtensions());
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>Then return TsKvListList first Ts is minus one.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); then return TsKvListList first Ts is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_thenReturnTsKvListListFirstTsIsMinusOne()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(-1L, new JsonObject());
    telemetryList.add(efentoTelemetry);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList);

    // Assert
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(-1L, getResult.getTs());
    assertEquals(0, getResult.getKvCount());
    assertEquals(1, actualConvertToPostTelemetryResult.getDescriptorForType().getFields().size());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(13, actualConvertToPostTelemetryResult.getSerializedSize());
    assertTrue(getResult.getKvList().isEmpty());
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return SerializedSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); when ArrayList(); then return SerializedSize is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_whenArrayList_thenReturnSerializedSizeIsZero()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        efentoCoapAdaptor.convertToPostTelemetry(sessionId, new ArrayList<>());

    // Assert
    assertEquals(0, actualConvertToPostTelemetryResult.getSerializedSize());
    assertEquals(0, actualConvertToPostTelemetryResult.getTsKvListCount());
    assertTrue(actualConvertToPostTelemetryResult.getTsKvListList().isEmpty());
    assertTrue(actualConvertToPostTelemetryResult.getAllFields().isEmpty());
    PostTelemetryMsg actualDefaultInstanceForType =
        actualConvertToPostTelemetryResult.getDefaultInstanceForType();
    assertEquals(actualConvertToPostTelemetryResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); when 'null'; then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_whenNull_thenThrowAdaptorException() throws AdaptorException {
    // Arrange, Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostTelemetry(UUID.randomUUID(), null));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, new JsonObject());

    // Assert
    PostAttributeMsg actualDefaultInstanceForType =
        actualConvertToPostAttributesResult.getDefaultInstanceForType();
    assertEquals(actualConvertToPostAttributesResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToPostAttributesResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            efentoCoapAdaptor.convertToPostAttributes(
                sessionId,
                new JsonPrimitive("[{}] Failed to convert JsonObject to PostTelemetry request!")));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("Property", '\u0001');

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo);

    // Assert
    verify(deviceInfo).getAsJsonObject();
    verify(deviceInfo).isJsonObject();
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
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes4() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray deviceInfo = mock(JsonArray.class);

    JsonObject jsonObject = mock(JsonObject.class);

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", new JsonArray());

    SimpleEntry<String, JsonElement> simpleEntry2 = new SimpleEntry<>(simpleEntry);
    simpleEntry2.setValue(new JsonObject());
    entrySet.add(simpleEntry2);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act and Assert
    List<KeyValueProto> kvList =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo).getKvList();
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
    verify(deviceInfo).isJsonObject();
    verify(deviceInfo).getAsJsonObject();
    verify(jsonObject).entrySet();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes5() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

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

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo);

    // Assert
    verify(deviceInfo).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(deviceInfo).isJsonObject();
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
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes6() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray jsonArray = mock(JsonArray.class);
    when(jsonArray.getAsJsonPrimitive()).thenThrow(new RuntimeException());
    when(jsonArray.isJsonPrimitive()).thenReturn(true);
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", jsonArray);

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(simpleEntry);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
    verify(deviceInfo).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(deviceInfo).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes7() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

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

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo);

    // Assert
    verify(deviceInfo).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(deviceInfo).isJsonObject();
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
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link JsonArray} {@link JsonArray#isJsonObject()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); given 'false'; when JsonArray isJsonObject() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_givenFalse_whenJsonArrayIsJsonObjectReturnFalse()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.isJsonObject()).thenReturn(false);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
    verify(deviceInfo).isJsonObject();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); given JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_givenJsonObject() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(new JsonObject());
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo);

    // Assert
    verify(deviceInfo).getAsJsonObject();
    verify(deviceInfo).isJsonObject();
    PostAttributeMsg actualDefaultInstanceForType =
        actualConvertToPostAttributesResult.getDefaultInstanceForType();
    assertEquals(actualConvertToPostAttributesResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code Property} and {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); given JsonObject (default constructor) addProperty 'Property' and 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_givenJsonObjectAddPropertyPropertyAndTrue()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("Property", true);

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo);

    // Assert
    verify(deviceInfo).getAsJsonObject();
    verify(deviceInfo).isJsonObject();
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
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonPrimitive} {@link JsonPrimitive#getAsBoolean()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); given JsonPrimitive getAsBoolean() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_givenJsonPrimitiveGetAsBooleanReturnTrue()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

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

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo);

    // Assert
    verify(deviceInfo).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(deviceInfo).isJsonObject();
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
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonPrimitive} {@link JsonPrimitive#getAsBoolean()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); given JsonPrimitive getAsBoolean() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_givenJsonPrimitiveGetAsBooleanThrowRuntimeException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsBoolean()).thenThrow(new RuntimeException());
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

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
    verify(deviceInfo).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(deviceInfo).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    verify(jsonPrimitive).getAsBoolean();
    verify(jsonPrimitive).isBoolean();
    verify(jsonPrimitive).isString();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link JsonPrimitive} {@link JsonPrimitive#getAsString()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); given JsonPrimitive getAsString() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_givenJsonPrimitiveGetAsStringThrowRuntimeException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsString()).thenThrow(new RuntimeException());
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

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
    verify(deviceInfo).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(deviceInfo).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    verify(jsonPrimitive).getAsString();
    verify(jsonPrimitive).isString();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link
   *       AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with {@code Key} and {@link
   *       JsonNull} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); given LinkedHashSet() add SimpleEntry(Object, Object) with 'Key' and JsonNull (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_givenLinkedHashSetAddSimpleEntryWithKeyAndJsonNull()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", new JsonNull());
    entrySet.add(simpleEntry);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo);

    // Assert
    verify(deviceInfo).getAsJsonObject();
    verify(deviceInfo).isJsonObject();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    PostAttributeMsg actualDefaultInstanceForType =
        actualConvertToPostAttributesResult.getDefaultInstanceForType();
    assertEquals(actualConvertToPostAttributesResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link MapEntry} {@link MapEntry#getKey()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); given MapEntry getKey() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_givenMapEntryGetKeyThrowRuntimeException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    MapEntry<String, JsonElement> mapEntry = mock(MapEntry.class);
    when(mapEntry.getKey()).thenThrow(new RuntimeException());
    when(mapEntry.getValue()).thenReturn(new JsonArray());

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(mapEntry);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
    verify(mapEntry).getKey();
    verify(mapEntry).getValue();
    verify(deviceInfo).getAsJsonObject();
    verify(deviceInfo).isJsonObject();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_givenRuntimeException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenThrow(new RuntimeException());
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
    verify(deviceInfo).getAsJsonObject();
    verify(deviceInfo).isJsonObject();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Then calls {@link JsonPrimitive#isNumber()}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement); then calls isNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_thenCallsIsNumber() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonPrimitive jsonPrimitive = mock(JsonPrimitive.class);
    when(jsonPrimitive.getAsString()).thenReturn("As String");
    when(jsonPrimitive.isBoolean()).thenReturn(false);
    when(jsonPrimitive.isNumber()).thenReturn(true);
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

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
    verify(deviceInfo).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(deviceInfo).isJsonObject();
    verify(jsonArray).isJsonPrimitive();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    verify(jsonPrimitive).getAsString();
    verify(jsonPrimitive).isBoolean();
    verify(jsonPrimitive).isNumber();
    verify(jsonPrimitive).isString();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList first AllFields size is two.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); then return KvList first AllFields size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_thenReturnKvListFirstAllFieldsSizeIsTwo()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", new JsonArray());

    SimpleEntry<String, JsonElement> simpleEntry2 = new SimpleEntry<>(simpleEntry);
    simpleEntry2.setValue(new JsonPrimitive(""));

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    entrySet.add(simpleEntry2);

    JsonObject jsonObject = mock(JsonObject.class);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo);

    // Assert
    verify(deviceInfo).getAsJsonObject();
    verify(deviceInfo).isJsonObject();
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
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList first JsonVBytes iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); then return KvList first JsonVBytes iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_thenReturnKvListFirstJsonVBytesIteratorHasNext()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

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

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo);

    // Assert
    verify(deviceInfo).getAsJsonObject();
    verify(deviceInfo).isJsonObject();
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
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList first JsonVBytes toStringUtf8 is {@code [1]}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); then return KvList first JsonVBytes toStringUtf8 is '[1]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_thenReturnKvListFirstJsonVBytesToStringUtf8Is1()
      throws AdaptorException {
    // Arrange
    EfentoCoapAdaptor efentoCoapAdaptor = new EfentoCoapAdaptor();
    UUID sessionId = UUID.randomUUID();

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

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo);

    // Assert
    verify(mapEntry).getKey();
    verify(mapEntry).getValue();
    verify(deviceInfo).getAsJsonObject();
    verify(deviceInfo).isJsonObject();
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
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList first LongV is one.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); then return KvList first LongV is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_thenReturnKvListFirstLongVIsOne() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonObject jsonObject = new JsonObject();
    Integer value = Integer.valueOf(1);
    jsonObject.addProperty("Property", value);

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo);

    // Assert
    verify(deviceInfo).getAsJsonObject();
    verify(deviceInfo).isJsonObject();
    List<KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    Descriptor descriptorForType = actualConvertToPostAttributesResult.getDescriptorForType();
    FileDescriptor file = descriptorForType.getFile();
    List<EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(1L, getResult.getLongV());
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertSame(
        value,
        descriptorForType.getOptions().getDescriptorForType().toProto().getExtensionRangeCount());
    FieldDescriptor getResult2 = fields.get(0);
    assertSame(value, getResult2.toProto().getNumber());
    assertSame(value, file.toProto().getDescriptorForType().getIndex());
    assertSame(value, messageTypes.get(1).getIndex());
    assertSame(value, enumTypes.get(1).getIndex());
    assertSame(value, fields.get(1).getIndex());
    assertSame(value, getResult2.getNumber());
    assertSame(value, getResult.getTypeValue());
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList first SerializedSize is eleven.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); then return KvList first SerializedSize is eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_thenReturnKvListFirstSerializedSizeIsEleven()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray deviceInfo = mock(JsonArray.class);

    JsonObject jsonObject = mock(JsonObject.class);

    LinkedHashSet<Entry<String, JsonElement>> entrySet = new LinkedHashSet<>();
    SimpleEntry<String, JsonElement> simpleEntry = new SimpleEntry<>("Key", new JsonArray());
    entrySet.add(simpleEntry);
    when(jsonObject.entrySet()).thenReturn(entrySet);
    doNothing().when(jsonObject).add(Mockito.<String>any(), Mockito.<JsonElement>any());
    jsonObject.add("Property", new JsonArray());
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo);

    // Assert
    List<KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals("[]", getResult.getJsonV());
    ByteString jsonVBytes = getResult.getJsonVBytes();
    ByteIterator iteratorResult = jsonVBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('[', nextResult.byteValue());
    assertEquals(']', nextResult2.byteValue());
    assertEquals("[]", jsonVBytes.toStringUtf8());
    assertEquals(11, getResult.getSerializedSize());
    assertEquals(13, actualConvertToPostAttributesResult.getSerializedSize());
    verify(deviceInfo).isJsonObject();
    verify(deviceInfo).getAsJsonObject();
    verify(jsonObject).entrySet();
    verify(jsonObject).add(eq("Property"), isA(JsonElement.class));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList first SerializedSize is fourteen.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); then return KvList first SerializedSize is fourteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_thenReturnKvListFirstSerializedSizeIsFourteen()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("Property", "42");

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo);

    // Assert
    verify(deviceInfo).getAsJsonObject();
    verify(deviceInfo).isJsonObject();
    List<KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals(1, getResult.getTypeValue());
    assertEquals(14, getResult.getSerializedSize());
    assertEquals(42L, getResult.getLongV());
    assertEquals(Short.SIZE, actualConvertToPostAttributesResult.getSerializedSize());
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList first SerializedSize is {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); then return KvList first SerializedSize is SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_thenReturnKvListFirstSerializedSizeIsSize()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray deviceInfo = mock(JsonArray.class);

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("Property", new JsonArray());
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo);

    // Assert
    List<KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    KeyValueProto getResult = kvList.get(0);
    assertEquals("[]", getResult.getJsonV());
    ByteString jsonVBytes = getResult.getJsonVBytes();
    ByteIterator iteratorResult = jsonVBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('[', nextResult.byteValue());
    assertEquals(']', nextResult2.byteValue());
    assertEquals("[]", jsonVBytes.toStringUtf8());
    assertEquals(Short.SIZE, getResult.getSerializedSize());
    assertEquals(18, actualConvertToPostAttributesResult.getSerializedSize());
    verify(deviceInfo).isJsonObject();
    verify(deviceInfo).getAsJsonObject();
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Then return KvList size is two.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, JsonElement); then return KvList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_thenReturnKvListSizeIsTwo() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("", new JsonArray());
    jsonObject.add("Property", new JsonArray());

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo);

    // Assert
    verify(deviceInfo).getAsJsonObject();
    verify(deviceInfo).isJsonObject();
    assertEquals(2, actualConvertToPostAttributesResult.getDescriptorForType().getFields().size());
    assertEquals(2, actualConvertToPostAttributesResult.getKvList().size());
    assertEquals(2, actualConvertToPostAttributesResult.getKvCount());
    assertEquals(26, actualConvertToPostAttributesResult.getSerializedSize());
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is eleven.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); then return SerializedSize is eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_thenReturnSerializedSizeIsEleven() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

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

    JsonArray deviceInfo = mock(JsonArray.class);
    when(deviceInfo.getAsJsonObject()).thenReturn(jsonObject);
    when(deviceInfo.isJsonObject()).thenReturn(true);

    // Act
    PostAttributeMsg actualConvertToPostAttributesResult =
        efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo);

    // Assert
    verify(deviceInfo).getAsJsonObject();
    verify(jsonArray).getAsJsonPrimitive();
    verify(deviceInfo).isJsonObject();
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
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray()}.
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); when JsonArray(); then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_whenJsonArray_thenThrowAdaptorException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, new JsonArray()));
  }

  /**
   * Test {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}.
   *
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, JsonElement); when JsonNull (default constructor); then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg EfentoCoapAdaptor.convertToPostAttributes(UUID, JsonElement)"
  })
  void testConvertToPostAttributes_whenJsonNull_thenThrowAdaptorException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, new JsonNull()));
  }
}
