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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(new JsonPrimitive("String"));
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
  void testConvertToPostTelemetry2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonPrimitive()).thenReturn(new JsonPrimitive(""));
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    when(values.getAsJsonPrimitive()).thenReturn(new JsonPrimitive(true));
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    when(values.getAsJsonPrimitive()).thenReturn(new JsonPrimitive('\u0001'));
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(true);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    when(values.getAsJsonArray()).thenReturn(new JsonArray(3));
    when(values.isJsonArray()).thenReturn(true);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(false);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    jsonObject.add("ts", new JsonArray(3));

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
   *       JsonElement)} with ts is one and values is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given EfentoTelemetry(long, JsonElement) with ts is one and values is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenEfentoTelemetryWithTsIsOneAndValuesIsNull()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, null);
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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    jsonObject.add("ts", new JsonArray(3));

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
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonArrayWithCapacityIsThree() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, new JsonArray(3));
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
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonArrayWithCapacityIsThree2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, new JsonArray(3));
    telemetryList.add(efentoTelemetry);
    EfentoTelemetry efentoTelemetry2 = new EfentoTelemetry(1L, new JsonArray(3));
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
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonArray(int) with capacity is three add 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonArrayWithCapacityIsThreeAddFalse()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray jsonArray = new JsonArray(3);
    jsonArray.add(false);
    jsonArray.add(true);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonArray()).thenReturn(jsonArray);
    when(values.isJsonArray()).thenReturn(true);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(false);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); given JsonArray(int) with capacity is three add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_givenJsonArrayWithCapacityIsThreeAddTrue()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray jsonArray = new JsonArray(3);
    jsonArray.add(true);

    JsonArray values = mock(JsonArray.class);
    when(values.getAsJsonArray()).thenReturn(jsonArray);
    when(values.isJsonArray()).thenReturn(true);
    when(values.isJsonNull()).thenReturn(false);
    when(values.isJsonPrimitive()).thenReturn(false);
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, new JsonPrimitive("ts"));
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
    jsonObject.add("ts", new JsonArray(3));

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
    verify(jsonObject).add(eq("ts"), isA(JsonElement.class));
    verify(jsonObject).entrySet();
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    assertEquals(2, getResult.getSerializedSize());
    assertEquals(4, actualConvertToPostTelemetryResult.getSerializedSize());
    assertTrue(getResult.getKvList().isEmpty());
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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, values);

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
   *   <li>Then return TsKvListList first KvCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, List); then return TsKvListList first KvCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_thenReturnTsKvListListFirstKvCountIsZero()
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
    assertEquals(2, getResult.getSerializedSize());
    assertEquals(4, actualConvertToPostTelemetryResult.getSerializedSize());
    assertTrue(getResult.getKvList().isEmpty());
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
   *   <li>Then return TsKvListList first Ts is one.
   * </ul>
   *
   * <p>Method under test: {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, List); then return TsKvListList first Ts is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg EfentoCoapAdaptor.convertToPostTelemetry(UUID, List)"
  })
  void testConvertToPostTelemetry_thenReturnTsKvListListFirstTsIsOne() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<EfentoTelemetry> telemetryList = new ArrayList<>();
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, new JsonObject());
    telemetryList.add(efentoTelemetry);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList);

    // Assert
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
    assertEquals(1, actualConvertToPostTelemetryResult.getDescriptorForType().getFields().size());
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
}
