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
package org.thingsboard.server.common.adaptor;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.google.common.primitives.UnsignedInteger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.gen.transport.TransportProtos;

class JsonConverterDiffblueTest {
  /**
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  void testConvertToTelemetryProto() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(new JsonNull()));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive("String")));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive(true)));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive('\u0001')));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(new JsonNull(), 1L));
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive("String"), 1L));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive(true), 1L));
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive('\u0001'), 1L));
  }

  /**
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  void testConvertToTelemetryProto2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  void testConvertToTelemetryProto3() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  void testConvertToTelemetryProto4() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  void testConvertToTelemetryProto5() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  void testConvertToTelemetryProto6() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  void testConvertToTelemetryProto7() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  void testConvertToTelemetryProto8() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  void testConvertToTelemetryProto9() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  void testConvertToTelemetryProto10() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  void testConvertToTelemetryProto11() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  void testConvertToTelemetryProto12() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  void testConvertToTelemetryProto13() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  void testConvertToTelemetryProto14() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  void testConvertToTelemetryProto15() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetryProto16() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetryProto17() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetryProto18() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetryProto19() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetryProto20() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetryProto21() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetryProto22() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetryProto23() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetryProto24() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetryProto25() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetryProto26() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetryProto27() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetryProto28() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetryProto29() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToGatewayTelemetry() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(new JsonNull(), 1L));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(new JsonObject(), 1L));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter
        .convertToGatewayTelemetry(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", -1), 1L));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(new JsonPrimitive(true), 1L));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(new JsonPrimitive('￿'), 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToGatewayTelemetry2() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToGatewayTelemetry3() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToGatewayTelemetry4() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToGatewayTelemetry5() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add("");
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToGatewayTelemetry6() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add('\u0001');
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToGatewayTelemetry7() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToGatewayTelemetry8() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToGatewayTelemetry9() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToGatewayTelemetry10() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToGatewayTelemetry11() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("ts", new JsonArray(3));

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToGatewayTelemetry12() {
    // Arrange
    JsonObject element = new JsonObject();
    element.addProperty("ts", true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToGatewayTelemetry13() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("metadata", new JsonArray(3));

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToGatewayTelemetry14() {
    // Arrange
    JsonObject element = new JsonObject();
    element.addProperty("ts", "42");

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToGatewayTelemetry15() {
    // Arrange
    JsonObject element = new JsonObject();
    element.addProperty("ts", "");

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(new JsonArray(3), 1L);

    // Assert
    assertTrue(actualConvertToTelemetryResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry2() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(new JsonNull(), 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry3() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(new JsonObject(), 1L);

    // Assert
    assertTrue(actualConvertToTelemetryResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry4() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter
        .convertToTelemetry(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1), 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(1);
    assertTrue(getResult2 instanceof LongDataEntry);
    KvEntry getResult3 = getResult.get(0);
    assertTrue(getResult3 instanceof StringDataEntry);
    assertEquals("1", getResult2.getValueAsString());
    Optional<String> strValue = getResult3.getStrValue();
    assertEquals("Device Name", strValue.get());
    assertEquals("Device Name", getResult3.getValueAsString());
    assertEquals("Device Name", getResult3.getValue());
    assertEquals("device", getResult3.getKey());
    assertEquals("reason", getResult2.getKey());
    Optional<Long> longValue = getResult2.getLongValue();
    assertEquals(1L, longValue.get().longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
    assertEquals(DataType.STRING, getResult3.getDataType());
    Optional<Boolean> booleanValue = getResult3.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(longValue.isPresent());
    assertTrue(strValue.isPresent());
    assertSame(booleanValue, getResult2.getBooleanValue());
    assertSame(booleanValue, getResult3.getDoubleValue());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, getResult3.getJsonValue());
    assertSame(booleanValue, getResult2.getJsonValue());
    assertSame(booleanValue, getResult3.getLongValue());
    assertSame(booleanValue, getResult2.getStrValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry5() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(new JsonPrimitive("String"), 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry6() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(new JsonPrimitive(true), 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry7() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(new JsonPrimitive('\u0001'), 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry8() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry9() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry10() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry11() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry12() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray(3));

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L);

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
    assertEquals("ts", getResult2.getKey());
    assertEquals(DataType.JSON, getResult2.getDataType());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(jsonValue.isPresent());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, getResult2.getLongValue());
    assertSame(booleanValue, getResult2.getStrValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry13() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof LongDataEntry);
    assertEquals("42", getResult2.getValueAsString());
    assertEquals("ts", getResult2.getKey());
    Optional<Long> longValue = getResult2.getLongValue();
    assertEquals(42L, longValue.get().longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(longValue.isPresent());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, getResult2.getJsonValue());
    assertSame(booleanValue, getResult2.getStrValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry14() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", true);

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof BooleanDataEntry);
    assertEquals("ts", getResult2.getKey());
    assertEquals(DataType.BOOLEAN, getResult2.getDataType());
    Optional<Double> doubleValue = getResult2.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertTrue(booleanValue.get());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.TRUE.toString();
    assertEquals(expectedValueAsString, getResult2.getValueAsString());
    assertSame(doubleValue, getResult2.getJsonValue());
    assertSame(doubleValue, getResult2.getLongValue());
    assertSame(doubleValue, getResult2.getStrValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry15() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L);

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
    assertEquals("ts", getResult2.getKey());
    assertEquals(DataType.STRING, getResult2.getDataType());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(strValue.isPresent());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, getResult2.getJsonValue());
    assertSame(booleanValue, getResult2.getLongValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry16() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", (String) null);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry17() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L);

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
    assertEquals("ts", getResult2.getKey());
    assertEquals(DataType.STRING, getResult2.getDataType());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(strValue.isPresent());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, getResult2.getJsonValue());
    assertSame(booleanValue, getResult2.getLongValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry18() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry19() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry20() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry21() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry22() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry23() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry24() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry25() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry26() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToTelemetry27() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry28() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(new JsonArray(3), 1L,
        true);

    // Assert
    assertTrue(actualConvertToTelemetryResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry29() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(new JsonNull(), 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry30() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(new JsonObject(), 1L,
        true);

    // Assert
    assertTrue(actualConvertToTelemetryResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry31() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter
        .convertToTelemetry(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1), 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(1);
    assertTrue(getResult2 instanceof LongDataEntry);
    KvEntry getResult3 = getResult.get(0);
    assertTrue(getResult3 instanceof StringDataEntry);
    assertEquals("1", getResult2.getValueAsString());
    Optional<String> strValue = getResult3.getStrValue();
    assertEquals("Device Name", strValue.get());
    assertEquals("Device Name", getResult3.getValueAsString());
    assertEquals("Device Name", getResult3.getValue());
    assertEquals("device", getResult3.getKey());
    assertEquals("reason", getResult2.getKey());
    Optional<Long> longValue = getResult2.getLongValue();
    assertEquals(1L, longValue.get().longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
    assertEquals(DataType.STRING, getResult3.getDataType());
    Optional<Boolean> booleanValue = getResult3.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(longValue.isPresent());
    assertTrue(strValue.isPresent());
    assertSame(booleanValue, getResult2.getBooleanValue());
    assertSame(booleanValue, getResult3.getDoubleValue());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, getResult3.getJsonValue());
    assertSame(booleanValue, getResult2.getJsonValue());
    assertSame(booleanValue, getResult3.getLongValue());
    assertSame(booleanValue, getResult2.getStrValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry32() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetry(new JsonPrimitive("String"), 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry33() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(new JsonPrimitive(true), 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry34() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetry(new JsonPrimitive('\u0001'), 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry35() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry36() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry37() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry38() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry39() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(new JsonArray(3), 1L,
        false);

    // Assert
    assertTrue(actualConvertToTelemetryResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry40() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray(3));

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L, true);

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
    assertEquals("ts", getResult2.getKey());
    assertEquals(DataType.JSON, getResult2.getDataType());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(jsonValue.isPresent());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, getResult2.getLongValue());
    assertSame(booleanValue, getResult2.getStrValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry41() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof LongDataEntry);
    assertEquals("42", getResult2.getValueAsString());
    assertEquals("ts", getResult2.getKey());
    Optional<Long> longValue = getResult2.getLongValue();
    assertEquals(42L, longValue.get().longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(longValue.isPresent());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, getResult2.getJsonValue());
    assertSame(booleanValue, getResult2.getStrValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry42() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", true);

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof BooleanDataEntry);
    assertEquals("ts", getResult2.getKey());
    assertEquals(DataType.BOOLEAN, getResult2.getDataType());
    Optional<Double> doubleValue = getResult2.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertTrue(booleanValue.get());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.TRUE.toString();
    assertEquals(expectedValueAsString, getResult2.getValueAsString());
    assertSame(doubleValue, getResult2.getJsonValue());
    assertSame(doubleValue, getResult2.getLongValue());
    assertSame(doubleValue, getResult2.getStrValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry43() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L, true);

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
    assertEquals("ts", getResult2.getKey());
    assertEquals(DataType.STRING, getResult2.getDataType());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(strValue.isPresent());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, getResult2.getJsonValue());
    assertSame(booleanValue, getResult2.getLongValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry44() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", (String) null);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry45() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L, true);

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
    assertEquals("ts", getResult2.getKey());
    assertEquals(DataType.STRING, getResult2.getDataType());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(strValue.isPresent());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, getResult2.getJsonValue());
    assertSame(booleanValue, getResult2.getLongValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry46() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry47() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry48() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry49() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry50() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry51() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry52() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry53() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry54() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  void testConvertToTelemetry55() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  void testParse() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("Json");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("Json", actualParseResult.getAsString());
    assertEquals("Json", asNumber.toString());
    assertEquals('J', actualParseResult.getAsCharacter());
    assertFalse(actualParseResult.getAsBoolean());
    assertFalse(actualParseResult.isJsonArray());
    assertFalse(actualParseResult.isJsonNull());
    assertFalse(actualParseResult.isJsonObject());
    assertFalse(((JsonPrimitive) actualParseResult).isBoolean());
    assertFalse(((JsonPrimitive) actualParseResult).isNumber());
    assertTrue(actualParseResult.isJsonPrimitive());
    assertTrue(((JsonPrimitive) actualParseResult).isString());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  void testParse2() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("");

    // Assert
    assertTrue(actualParseResult instanceof JsonNull);
    assertFalse(actualParseResult.isJsonArray());
    assertFalse(actualParseResult.isJsonObject());
    assertFalse(actualParseResult.isJsonPrimitive());
    assertTrue(actualParseResult.isJsonNull());
    JsonNull expectedAsJsonNull = ((JsonNull) actualParseResult).INSTANCE;
    assertSame(expectedAsJsonNull, actualParseResult.getAsJsonNull());
  }

  /**
   * Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  void testParse3() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("42");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("42", actualParseResult.getAsString());
    assertEquals("42", asNumber.toString());
    BigInteger asBigInteger = actualParseResult.getAsBigInteger();
    assertEquals("42", asBigInteger.toString());
    assertEquals('4', actualParseResult.getAsCharacter());
    assertEquals(1, asBigInteger.getLowestSetBit());
    assertEquals(1, asBigInteger.signum());
    assertEquals(42, actualParseResult.getAsInt());
    assertEquals(42.0d, actualParseResult.getAsDouble());
    assertEquals(42.0f, actualParseResult.getAsFloat());
    assertEquals(42L, actualParseResult.getAsLong());
    assertEquals((short) 42, actualParseResult.getAsShort());
    assertFalse(actualParseResult.getAsBoolean());
    assertFalse(actualParseResult.isJsonArray());
    assertFalse(actualParseResult.isJsonNull());
    assertFalse(actualParseResult.isJsonObject());
    assertFalse(((JsonPrimitive) actualParseResult).isBoolean());
    assertFalse(((JsonPrimitive) actualParseResult).isString());
    assertTrue(actualParseResult.isJsonPrimitive());
    assertTrue(((JsonPrimitive) actualParseResult).isNumber());
    BigDecimal expectedAsBigDecimal = new BigDecimal("42");
    assertEquals(expectedAsBigDecimal, actualParseResult.getAsBigDecimal());
    assertEquals('*', actualParseResult.getAsByte());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
    assertArrayEquals(new byte[]{'*'}, asBigInteger.toByteArray());
  }

  /**
   * Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  void testParse4() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse(".");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals(".", actualParseResult.getAsString());
    assertEquals(".", asNumber.toString());
    assertEquals('.', actualParseResult.getAsCharacter());
    assertFalse(actualParseResult.getAsBoolean());
    assertFalse(actualParseResult.isJsonArray());
    assertFalse(actualParseResult.isJsonNull());
    assertFalse(actualParseResult.isJsonObject());
    assertFalse(((JsonPrimitive) actualParseResult).isBoolean());
    assertFalse(((JsonPrimitive) actualParseResult).isNumber());
    assertTrue(actualParseResult.isJsonPrimitive());
    assertTrue(((JsonPrimitive) actualParseResult).isString());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  void testParse5() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("E");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("E", actualParseResult.getAsString());
    assertEquals("E", asNumber.toString());
    assertEquals('E', actualParseResult.getAsCharacter());
    assertFalse(actualParseResult.getAsBoolean());
    assertFalse(actualParseResult.isJsonArray());
    assertFalse(actualParseResult.isJsonNull());
    assertFalse(actualParseResult.isJsonObject());
    assertFalse(((JsonPrimitive) actualParseResult).isBoolean());
    assertFalse(((JsonPrimitive) actualParseResult).isNumber());
    assertTrue(actualParseResult.isJsonPrimitive());
    assertTrue(((JsonPrimitive) actualParseResult).isString());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  void testParse6() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("client");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("client", actualParseResult.getAsString());
    assertEquals("client", asNumber.toString());
    assertEquals('c', actualParseResult.getAsCharacter());
    assertFalse(actualParseResult.getAsBoolean());
    assertFalse(actualParseResult.isJsonArray());
    assertFalse(actualParseResult.isJsonNull());
    assertFalse(actualParseResult.isJsonObject());
    assertFalse(((JsonPrimitive) actualParseResult).isBoolean());
    assertFalse(((JsonPrimitive) actualParseResult).isNumber());
    assertTrue(actualParseResult.isJsonPrimitive());
    assertTrue(((JsonPrimitive) actualParseResult).isString());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  void testParse7() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("42.");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("42.", actualParseResult.getAsString());
    assertEquals("42.", asNumber.toString());
    assertEquals('4', actualParseResult.getAsCharacter());
    assertEquals(42.0d, actualParseResult.getAsDouble());
    assertEquals(42.0f, actualParseResult.getAsFloat());
    assertFalse(actualParseResult.getAsBoolean());
    assertFalse(actualParseResult.isJsonArray());
    assertFalse(actualParseResult.isJsonNull());
    assertFalse(actualParseResult.isJsonObject());
    assertFalse(((JsonPrimitive) actualParseResult).isBoolean());
    assertFalse(((JsonPrimitive) actualParseResult).isNumber());
    assertTrue(actualParseResult.isJsonPrimitive());
    assertTrue(((JsonPrimitive) actualParseResult).isString());
    BigDecimal expectedAsBigDecimal = new BigDecimal("42");
    assertEquals(expectedAsBigDecimal, actualParseResult.getAsBigDecimal());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  void testParse8() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("42E");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("42E", actualParseResult.getAsString());
    assertEquals("42E", asNumber.toString());
    assertEquals('4', actualParseResult.getAsCharacter());
    assertFalse(actualParseResult.getAsBoolean());
    assertFalse(actualParseResult.isJsonArray());
    assertFalse(actualParseResult.isJsonNull());
    assertFalse(actualParseResult.isJsonObject());
    assertFalse(((JsonPrimitive) actualParseResult).isBoolean());
    assertFalse(((JsonPrimitive) actualParseResult).isNumber());
    assertTrue(actualParseResult.isJsonPrimitive());
    assertTrue(((JsonPrimitive) actualParseResult).isString());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  void testParse9() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("Json", JsonConverter.parse("Json", clazz));
  }

  /**
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  void testParse10() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(JsonConverter.parse("", clazz));
  }

  /**
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  void testParse11() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(42.0d, ((Double) JsonConverter.parse("42", clazz)).doubleValue());
  }

  /**
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  void testParse12() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(".", JsonConverter.parse(".", clazz));
  }

  /**
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  void testParse13() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("E", JsonConverter.parse("E", clazz));
  }

  /**
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  void testParse14() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("client", JsonConverter.parse("client", clazz));
  }

  /**
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  void testParse15() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.parse("", Integer.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  void testParse16() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.parse("", Float.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  void testParse17() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.parse("", Byte.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  void testParse18() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.parse("", Double.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  void testParse19() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.parse("", Long.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  void testParse20() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.parse("", Character.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  void testParse21() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.parse("", Short.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  void testParse22() {
    // Arrange, Act and Assert
    assertEquals(42.0f, ((Float) JsonConverter.parse("42", Float.TYPE)).floatValue());
  }

  /**
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  void testParse23() {
    // Arrange, Act and Assert
    assertEquals(42.0d, ((Double) JsonConverter.parse("42", Double.TYPE)).doubleValue());
  }

  /**
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  void testParse24() {
    // Arrange
    Class<JsonElement> clazz = JsonElement.class;

    // Act
    Object actualParseResult = JsonConverter.parse("Json", clazz);

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = ((JsonPrimitive) actualParseResult).getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("Json", ((JsonPrimitive) actualParseResult).getAsString());
    assertEquals("Json", asNumber.toString());
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
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson() {
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
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson2() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Integer.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson3() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Float.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson4() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Byte.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson5() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Double.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson6() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Long.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson7() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Character.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson8() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Boolean.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson9() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Short.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson10() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Void.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson11() {
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
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson12() {
    // Arrange
    JsonNull element = new JsonNull();
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(JsonConverter.fromJson(element, type));
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson13() {
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
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson14() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals(2, ((Map<String, Object>) actualFromJsonResult).size());
    assertEquals("Device Name", ((Map<String, Object>) actualFromJsonResult).get("device"));
    assertEquals(1.0d, ((Double) ((Map<String, Object>) actualFromJsonResult).get("reason")).doubleValue());
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson15() {
    // Arrange
    JsonPrimitive element = new JsonPrimitive("String");
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals("String", JsonConverter.fromJson(element, type));
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson16() {
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
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson17() {
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
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson18() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(new JsonNull(), Float.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson19() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(new JsonNull(), Double.TYPE));
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson20() {
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
    assertEquals(1.0d, ((Double) ((Map<String, Object>) actualFromJsonResult).get("reason")).doubleValue());
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson21() {
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
    Object getResult2 = ((Map<String, Object>) actualFromJsonResult).get("Property");
    assertTrue(getResult2 instanceof List);
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals("Device Name", ((Map<String, Object>) actualFromJsonResult).get("device"));
    assertEquals(1.0d, ((Double) ((Map<String, Object>) actualFromJsonResult).get("reason")).doubleValue());
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((List<Object>) getResult2).isEmpty());
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson22() {
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
    Object getResult2 = ((Map<String, Object>) actualFromJsonResult).get("42");
    assertTrue(getResult2 instanceof List);
    Object getResult3 = ((Map<String, Object>) actualFromJsonResult).get("Property");
    assertTrue(getResult3 instanceof List);
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals("Device Name", ((Map<String, Object>) actualFromJsonResult).get("device"));
    assertEquals(1.0d, ((Double) ((Map<String, Object>) actualFromJsonResult).get("reason")).doubleValue());
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((List<Object>) getResult2).isEmpty());
    assertTrue(((List<Object>) getResult3).isEmpty());
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson23() {
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
    assertTrue(((Map<String, ArrayList>) actualFromJsonResult).get("").isEmpty());
    assertTrue(((Map<String, ArrayList>) actualFromJsonResult).get("42").isEmpty());
    assertTrue(((Map<String, ArrayList>) actualFromJsonResult).get("Property").isEmpty());
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson24() {
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
    Object getResult = ((Map<String, Object>) actualFromJsonResult).get("");
    assertTrue(getResult instanceof List);
    Object getResult2 = ((Map<String, Object>) actualFromJsonResult).get("42");
    assertTrue(getResult2 instanceof List);
    Object getResult3 = ((Map<String, Object>) actualFromJsonResult).get("Property");
    assertTrue(getResult3 instanceof List);
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals("Device Name", ((Map<String, Object>) actualFromJsonResult).get("device"));
    assertEquals(1.0d, ((Double) ((Map<String, Object>) actualFromJsonResult).get("reason")).doubleValue());
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((List<Object>) getResult2).isEmpty());
    assertTrue(((List<Object>) getResult3).isEmpty());
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson25() {
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
    Object getResult2 = ((Map<String, Object>) actualFromJsonResult).get("42");
    assertTrue(getResult2 instanceof List);
    Object getResult3 = ((Map<String, Object>) actualFromJsonResult).get("Property");
    assertTrue(getResult3 instanceof List);
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals("Device Name", ((Map<String, Object>) actualFromJsonResult).get("device"));
    assertEquals(1.0d, ((Double) ((Map<String, Object>) actualFromJsonResult).get("reason")).doubleValue());
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((List<Object>) getResult2).isEmpty());
    assertTrue(((List<Object>) getResult3).isEmpty());
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson26() {
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
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson27() {
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
  }

  /**
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  void testFromJson28() {
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
    assertEquals(1.0d, ((Double) ((Map<String, Object>) actualFromJsonResult).get("reason")).doubleValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  void testConvertToClaimDeviceProto() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, new JsonArray(3)));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, new JsonNull()));
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, new JsonPrimitive("String")));
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, new JsonPrimitive(true)));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, "Json"));
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(new DeviceId(UUID.randomUUID()), "Json"));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, "42"));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, "."));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, "E"));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, "client"));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  void testConvertToClaimDeviceProto2() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  void testConvertToClaimDeviceProto3() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add('\u0000');

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  void testConvertToClaimDeviceProto4() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  void testConvertToClaimDeviceProto5() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);
    jsonElement.add(false);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  void testConvertToClaimDeviceProto6() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  void testConvertToClaimDeviceProto7() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  void testConvertToClaimDeviceProto8() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  void testConvertToClaimDeviceProto9() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  void testConvertToClaimDeviceProto10() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  void testConvertToClaimDeviceProto11() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  void testConvertToClaimDeviceProto12() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  void testConvertToAttributesProto() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(new JsonArray(3)));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(new JsonNull()));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(new JsonPrimitive("String")));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(new JsonPrimitive(true)));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  void testConvertToAttributesProto2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  void testConvertToAttributesProto3() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(false);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  void testConvertToAttributesProto4() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add('\u0000');
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  void testConvertToAttributesProto5() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(Integer.valueOf(1));
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  void testConvertToAttributesProto6() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add((byte) 'A');
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  void testConvertToAttributesProto7() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(10.0d);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  void testConvertToAttributesProto8() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(10.0f);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  void testConvertToAttributesProto9() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(1L);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  void testConvertToAttributesProto10() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(Double.NaN);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  void testConvertToAttributesProto11() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add((short) 1);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  void testConvertToAttributesProto12() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(UnsignedInteger.fromIntBits(1));
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  void testToJson() {
    // Arrange, Act and Assert
    assertEquals("[]", JsonConverter.toJson(new JsonArray(3)));
    assertEquals("null", JsonConverter.toJson((JsonElement) null));
    assertEquals("null", JsonConverter.toJson(new JsonNull()));
    assertEquals("{}", JsonConverter.toJson(new JsonObject()));
    assertEquals("{\"device\":\"Device Name\",\"reason\":1}",
        JsonConverter.toJson(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1)));
  }

  /**
   * Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  void testToJson2() {
    // Arrange and Act
    String actualToJsonResult = JsonConverter.toJson(new JsonPrimitive(true));

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualToJsonResult);
  }

  /**
   * Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  void testToJson3() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    // Act and Assert
    assertEquals("[true]", JsonConverter.toJson(element));
  }

  /**
   * Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  void testToJson4() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    // Act and Assert
    assertEquals("[false,true]", JsonConverter.toJson(element));
  }

  /**
   * Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  void testToJson5() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add('\u0000');
    element.add(true);

    // Act and Assert
    assertEquals("[\"\\u0000\",true]", JsonConverter.toJson(element));
  }

  /**
   * Method under test:
   * {@link JsonConverter#toJson(TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testToJson6() {
    // Arrange and Act
    JsonObject actualToJsonResult = JsonConverter
        .toJson(TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

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
   * Method under test:
   * {@link JsonConverter#toJson(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testToJson7() {
    // Arrange and Act
    JsonObject actualToJsonResult = JsonConverter.toJson(TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

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
   * Method under test:
   * {@link JsonConverter#toJson(TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  void testToJson8() {
    // Arrange and Act
    JsonObject actualToJsonResult = JsonConverter
        .toJson(TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance());

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
   * Method under test:
   * {@link JsonConverter#toJson(TransportProtos.ProvisionDeviceResponseMsg, int)}
   */
  @Test
  void testToJson9() {
    // Arrange and Act
    JsonObject actualToJsonResult = JsonConverter
        .toJson(TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance(), 1);

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
   * Method under test:
   * {@link JsonConverter#toJson(TransportProtos.ToDeviceRpcRequestMsg, boolean)}
   */
  @Test
  void testToJson10() {
    // Arrange and Act
    JsonElement actualToJsonResult = JsonConverter.toJson(TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(),
        true);

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
   * Method under test:
   * {@link JsonConverter#toJson(TransportProtos.ToDeviceRpcRequestMsg, boolean)}
   */
  @Test
  void testToJson11() {
    // Arrange and Act
    JsonElement actualToJsonResult = JsonConverter.toJson(TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(),
        false);

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
   * Method under test:
   * {@link JsonConverter#toJson(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  void testToJson12() {
    // Arrange and Act
    JsonElement actualToJsonResult = JsonConverter.toJson(TransportProtos.ToServerRpcResponseMsg.getDefaultInstance());

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
   * Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  void testToJsonObject() {
    // Arrange
    JsonObject jsonObject = new JsonObject();

    // Act and Assert
    assertEquals(jsonObject, JsonConverter.toJsonObject(jsonObject));
  }

  /**
   * Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  void testToJsonObject2() {
    // Arrange
    JsonObject toGatewayDeviceDisconnectJsonResult = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);

    // Act and Assert
    assertEquals(toGatewayDeviceDisconnectJsonResult, JsonConverter.toJsonObject(toGatewayDeviceDisconnectJsonResult));
  }

  /**
   * Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  void testToJsonObject3() {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(jsonObject, JsonConverter.toJsonObject(jsonObject));
  }

  /**
   * Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  void testToJsonObject4() {
    // Arrange
    JsonObject toGatewayDeviceDisconnectJsonResult = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    toGatewayDeviceDisconnectJsonResult.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(toGatewayDeviceDisconnectJsonResult, JsonConverter.toJsonObject(toGatewayDeviceDisconnectJsonResult));
  }

  /**
   * Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  void testToJsonObject5() {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("42", false);
    jsonObject.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(jsonObject, JsonConverter.toJsonObject(jsonObject));
  }

  /**
   * Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  void testToJsonObject6() {
    // Arrange
    JsonObject toGatewayDeviceDisconnectJsonResult = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    toGatewayDeviceDisconnectJsonResult.addProperty("42", false);
    toGatewayDeviceDisconnectJsonResult.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(toGatewayDeviceDisconnectJsonResult, JsonConverter.toJsonObject(toGatewayDeviceDisconnectJsonResult));
  }

  /**
   * Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  void testToJsonObject7() {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("", new JsonArray(3));
    jsonObject.addProperty("42", false);
    jsonObject.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(jsonObject, JsonConverter.toJsonObject(jsonObject));
  }

  /**
   * Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  void testToJsonObject8() {
    // Arrange
    JsonObject toGatewayDeviceDisconnectJsonResult = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    toGatewayDeviceDisconnectJsonResult.add("", new JsonArray(3));
    toGatewayDeviceDisconnectJsonResult.addProperty("42", false);
    toGatewayDeviceDisconnectJsonResult.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(toGatewayDeviceDisconnectJsonResult, JsonConverter.toJsonObject(toGatewayDeviceDisconnectJsonResult));
  }

  /**
   * Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  void testToJsonObject9() {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("Property", new JsonArray(3));
    jsonObject.add("", new JsonArray(3));
    jsonObject.addProperty("42", false);
    jsonObject.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(jsonObject, JsonConverter.toJsonObject(jsonObject));
  }

  /**
   * Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  void testToJsonObject10() {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("", new JsonArray(3));
    jsonObject.add("Property", new JsonArray(3));
    jsonObject.add("", new JsonArray(3));
    jsonObject.addProperty("42", false);
    jsonObject.add("Property", new JsonArray(3));

    // Act and Assert
    assertEquals(jsonObject, JsonConverter.toJsonObject(jsonObject));
  }

  /**
   * Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  void testToJsonObject11() {
    // Arrange
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("Property", null);

    // Act
    JsonObject actualToJsonObjectResult = JsonConverter.toJsonObject(jsonObject);

    // Assert
    assertEquals(0, actualToJsonObjectResult.size());
    assertFalse(actualToJsonObjectResult.isJsonArray());
    assertFalse(actualToJsonObjectResult.isJsonNull());
    assertFalse(actualToJsonObjectResult.isJsonPrimitive());
    assertTrue(actualToJsonObjectResult.isJsonObject());
    assertTrue(actualToJsonObjectResult.isEmpty());
    assertSame(actualToJsonObjectResult, actualToJsonObjectResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  void testToJsonObject12() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add(true);

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("Property", value);

    // Act and Assert
    assertEquals(jsonObject, JsonConverter.toJsonObject(jsonObject));
  }

  /**
   * Method under test:
   * {@link JsonConverter#getJsonObjectForGateway(String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testGetJsonObjectForGateway() {
    // Arrange and Act
    JsonObject actualJsonObjectForGateway = JsonConverter.getJsonObjectForGateway("Device Name",
        TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

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
   * Method under test:
   * {@link JsonConverter#getJsonObjectForGateway(String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testGetJsonObjectForGateway2() {
    // Arrange and Act
    JsonObject actualJsonObjectForGateway = JsonConverter.getJsonObjectForGateway("Device Name",
        TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

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
   * Method under test:
   * {@link JsonConverter#toGatewayDeviceDisconnectJson(String, int)}
   */
  @Test
  void testToGatewayDeviceDisconnectJson() {
    // Arrange and Act
    JsonObject actualToGatewayDeviceDisconnectJsonResult = JsonConverter.toGatewayDeviceDisconnectJson("Device Name",
        1);

    // Assert
    assertEquals(2, actualToGatewayDeviceDisconnectJsonResult.size());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonArray());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonNull());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonPrimitive());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isEmpty());
    assertTrue(actualToGatewayDeviceDisconnectJsonResult.isJsonObject());
    assertSame(actualToGatewayDeviceDisconnectJsonResult, actualToGatewayDeviceDisconnectJsonResult.getAsJsonObject());
  }

  /**
   * Method under test:
   * {@link JsonConverter#toGatewayDeviceDisconnectJson(String, int)}
   */
  @Test
  void testToGatewayDeviceDisconnectJson2() {
    // Arrange and Act
    JsonObject actualToGatewayDeviceDisconnectJsonResult = JsonConverter.toGatewayDeviceDisconnectJson(null, 1);

    // Assert
    assertEquals(2, actualToGatewayDeviceDisconnectJsonResult.size());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonArray());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonNull());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonPrimitive());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isEmpty());
    assertTrue(actualToGatewayDeviceDisconnectJsonResult.isJsonObject());
    assertSame(actualToGatewayDeviceDisconnectJsonResult, actualToGatewayDeviceDisconnectJsonResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link JsonConverter#toErrorJson(String)}
   */
  @Test
  void testToErrorJson() {
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
   * Method under test: {@link JsonConverter#toErrorJson(String)}
   */
  @Test
  void testToErrorJson2() {
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
   * Method under test:
   * {@link JsonConverter#toGatewayJson(String, TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  void testToGatewayJson() {
    // Arrange and Act
    JsonElement actualToGatewayJsonResult = JsonConverter.toGatewayJson("Device Name",
        TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance());

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
   * Method under test:
   * {@link JsonConverter#toGatewayJson(String, TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  void testToGatewayJson2() {
    // Arrange and Act
    JsonElement actualToGatewayJsonResult = JsonConverter.toGatewayJson("device",
        TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance());

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
   * Method under test:
   * {@link JsonConverter#toGatewayJson(String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testToGatewayJson3() {
    // Arrange and Act
    JsonElement actualToGatewayJsonResult = JsonConverter.toGatewayJson("Device Name",
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

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
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  void testConvertToAttributes() {
    // Arrange and Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter.convertToAttributes(new JsonObject());

    // Assert
    assertTrue(actualConvertToAttributesResult.isEmpty());
  }

  /**
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  void testConvertToAttributes2() {
    // Arrange and Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter
        .convertToAttributes(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1));

    // Assert
    assertEquals(2, actualConvertToAttributesResult.size());
  }

  /**
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  void testConvertToAttributes3() {
    // Arrange and Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter
        .convertToAttributes(JsonConverter.toGatewayDeviceDisconnectJson(".", 1));

    // Assert
    assertEquals(2, actualConvertToAttributesResult.size());
  }

  /**
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  void testConvertToAttributes4() {
    // Arrange and Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter
        .convertToAttributes(JsonConverter.toGatewayDeviceDisconnectJson("", 1));

    // Assert
    assertEquals(2, actualConvertToAttributesResult.size());
  }

  /**
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  void testConvertToAttributes5() {
    // Arrange and Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter
        .convertToAttributes(JsonConverter.toGatewayDeviceDisconnectJson("42", 1));

    // Assert
    assertEquals(2, actualConvertToAttributesResult.size());
  }

  /**
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  void testConvertToAttributes6() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add(".", new JsonArray(3));

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(3, actualConvertToAttributesResult.size());
  }

  /**
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  void testConvertToAttributes7() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.addProperty(".", true);

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(3, actualConvertToAttributesResult.size());
  }

  /**
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  void testConvertToAttributes8() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add(".", null);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributes(element));
  }

  /**
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  void testConvertToAttributes9() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add(".", new JsonObject());

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(3, actualConvertToAttributesResult.size());
  }

  /**
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  void testConvertToAttributes10() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add(".", JsonConverter.toGatewayDeviceDisconnectJson(".", 1));

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(3, actualConvertToAttributesResult.size());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult = JsonConverter
        .convertToSortedTelemetry(new JsonArray(3), 1L);

    // Assert
    assertTrue(actualConvertToSortedTelemetryResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry2() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(new JsonNull(), 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry3() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult = JsonConverter
        .convertToSortedTelemetry(new JsonObject(), 1L);

    // Assert
    assertTrue(actualConvertToSortedTelemetryResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry4() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult = JsonConverter
        .convertToSortedTelemetry(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1), 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(1);
    assertTrue(getResult2 instanceof LongDataEntry);
    KvEntry getResult3 = getResult.get(0);
    assertTrue(getResult3 instanceof StringDataEntry);
    assertEquals("1", getResult2.getValueAsString());
    Optional<String> strValue = getResult3.getStrValue();
    assertEquals("Device Name", strValue.get());
    assertEquals("Device Name", getResult3.getValueAsString());
    assertEquals("Device Name", getResult3.getValue());
    assertEquals("device", getResult3.getKey());
    assertEquals("reason", getResult2.getKey());
    Optional<Long> longValue = getResult2.getLongValue();
    assertEquals(1L, longValue.get().longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
    assertEquals(DataType.STRING, getResult3.getDataType());
    Optional<Boolean> booleanValue = getResult3.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(longValue.isPresent());
    assertTrue(strValue.isPresent());
    assertSame(booleanValue, getResult2.getBooleanValue());
    assertSame(booleanValue, getResult3.getDoubleValue());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, getResult3.getJsonValue());
    assertSame(booleanValue, getResult2.getJsonValue());
    assertSame(booleanValue, getResult3.getLongValue());
    assertSame(booleanValue, getResult2.getStrValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry5() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToSortedTelemetry(new JsonPrimitive("String"), 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry6() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(new JsonPrimitive(true), 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry7() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToSortedTelemetry(new JsonPrimitive('\u0001'), 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry8() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry9() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry10() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry11() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry12() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray(3));

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult = JsonConverter.convertToSortedTelemetry(jsonElement,
        1L);

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
    assertEquals("ts", getResult2.getKey());
    assertEquals(DataType.JSON, getResult2.getDataType());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(jsonValue.isPresent());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, getResult2.getLongValue());
    assertSame(booleanValue, getResult2.getStrValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry13() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult = JsonConverter.convertToSortedTelemetry(jsonElement,
        1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof LongDataEntry);
    assertEquals("42", getResult2.getValueAsString());
    assertEquals("ts", getResult2.getKey());
    Optional<Long> longValue = getResult2.getLongValue();
    assertEquals(42L, longValue.get().longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(longValue.isPresent());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, getResult2.getJsonValue());
    assertSame(booleanValue, getResult2.getStrValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry14() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", true);

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult = JsonConverter.convertToSortedTelemetry(jsonElement,
        1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof BooleanDataEntry);
    assertEquals("ts", getResult2.getKey());
    assertEquals(DataType.BOOLEAN, getResult2.getDataType());
    Optional<Double> doubleValue = getResult2.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertTrue(booleanValue.get());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.TRUE.toString();
    assertEquals(expectedValueAsString, getResult2.getValueAsString());
    assertSame(doubleValue, getResult2.getJsonValue());
    assertSame(doubleValue, getResult2.getLongValue());
    assertSame(doubleValue, getResult2.getStrValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry15() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult = JsonConverter.convertToSortedTelemetry(jsonElement,
        1L);

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
    assertEquals("ts", getResult2.getKey());
    assertEquals(DataType.STRING, getResult2.getDataType());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(strValue.isPresent());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, getResult2.getJsonValue());
    assertSame(booleanValue, getResult2.getLongValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry16() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", (String) null);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry17() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "");

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult = JsonConverter.convertToSortedTelemetry(jsonElement,
        1L);

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
    assertEquals("ts", getResult2.getKey());
    assertEquals(DataType.STRING, getResult2.getDataType());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(strValue.isPresent());
    assertSame(booleanValue, getResult2.getDoubleValue());
    assertSame(booleanValue, getResult2.getJsonValue());
    assertSame(booleanValue, getResult2.getLongValue());
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry18() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry19() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry20() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry21() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry22() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry23() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry24() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry25() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry26() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  void testConvertToSortedTelemetry27() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(new JsonObject()));
    assertThrows(RuntimeException.class, () -> JsonConverter
        .convertToProvisionRequestMsg(JsonConverter.toGatewayDeviceDisconnectJson("deviceName", -1)));
    assertThrows(RuntimeException.class,
        () -> JsonConverter.convertToProvisionRequestMsg(JsonConverter.toGatewayDeviceDisconnectJson(null, -1)));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("Json"));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg(""));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("42"));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("."));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("E"));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("client"));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("42."));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("42E"));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg2() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", "42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg3() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", Integer.valueOf(-1));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg4() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg5() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", '￿');

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg6() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.add("Property", new JsonArray(3));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg7() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.add("", new JsonArray(3));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg8() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("provisionDeviceKey", "42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg9() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", false);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg10() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", '\u0002');

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg11() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add(true);

    JsonObject jo = new JsonObject();
    jo.add("deviceName", value);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg12() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", (byte) 'A');

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg13() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", 42L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg14() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", (short) 2);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg15() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", 10.0d);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg16() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", 10.0f);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg17() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", Double.NaN);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  void testConvertToProvisionRequestMsg18() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", UnsignedInteger.fromIntBits(2));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }
}
