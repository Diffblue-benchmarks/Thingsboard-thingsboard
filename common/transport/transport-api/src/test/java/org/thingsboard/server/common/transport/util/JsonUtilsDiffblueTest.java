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
package org.thingsboard.server.common.transport.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.amazonaws.transform.MapEntry;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;

class JsonUtilsDiffblueTest {
  /**
   * Method under test: {@link JsonUtils#getJsonObject(List)}
   */
  @Test
  void testGetJsonObject() {
    // Arrange and Act
    JsonObject actualJsonObject = JsonUtils.getJsonObject(new ArrayList<>());

    // Assert
    assertEquals(0, actualJsonObject.size());
    assertFalse(actualJsonObject.isJsonArray());
    assertFalse(actualJsonObject.isJsonNull());
    assertFalse(actualJsonObject.isJsonPrimitive());
    assertTrue(actualJsonObject.isJsonObject());
    assertTrue(actualJsonObject.isEmpty());
    assertSame(actualJsonObject, actualJsonObject.getAsJsonObject());
  }

  /**
   * Method under test: {@link JsonUtils#getJsonObject(List)}
   */
  @Test
  void testGetJsonObject2() {
    // Arrange
    ArrayList<TransportProtos.KeyValueProto> tsKv = new ArrayList<>();
    tsKv.add(TransportProtos.KeyValueProto.getDefaultInstance());

    // Act
    JsonObject actualJsonObject = JsonUtils.getJsonObject(tsKv);

    // Assert
    assertEquals(1, actualJsonObject.size());
    assertFalse(actualJsonObject.isJsonArray());
    assertFalse(actualJsonObject.isJsonNull());
    assertFalse(actualJsonObject.isJsonPrimitive());
    assertFalse(actualJsonObject.isEmpty());
    assertTrue(actualJsonObject.isJsonObject());
    assertSame(actualJsonObject, actualJsonObject.getAsJsonObject());
  }

  /**
   * Method under test: {@link JsonUtils#getJsonObject(List)}
   */
  @Test
  void testGetJsonObject3() {
    // Arrange
    ArrayList<TransportProtos.KeyValueProto> tsKv = new ArrayList<>();
    tsKv.add(TransportProtos.KeyValueProto.getDefaultInstance());
    tsKv.add(TransportProtos.KeyValueProto.getDefaultInstance());

    // Act
    JsonObject actualJsonObject = JsonUtils.getJsonObject(tsKv);

    // Assert
    assertEquals(1, actualJsonObject.size());
    assertFalse(actualJsonObject.isJsonArray());
    assertFalse(actualJsonObject.isJsonNull());
    assertFalse(actualJsonObject.isJsonPrimitive());
    assertFalse(actualJsonObject.isEmpty());
    assertTrue(actualJsonObject.isJsonObject());
    assertSame(actualJsonObject, actualJsonObject.getAsJsonObject());
  }

  /**
   * Method under test: {@link JsonUtils#parse(Object)}
   */
  @Test
  void testParse() {
    // Arrange and Act
    JsonElement actualParseResult = JsonUtils.parse("Value");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("Value", actualParseResult.getAsString());
    assertEquals("Value", asNumber.toString());
    assertEquals('V', actualParseResult.getAsCharacter());
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
   * Method under test: {@link JsonUtils#parse(Object)}
   */
  @Test
  void testParse2() {
    // Arrange and Act
    JsonElement actualParseResult = JsonUtils.parse(42);

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    assertEquals("42", actualParseResult.getAsString());
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
   * Method under test: {@link JsonUtils#parse(Object)}
   */
  @Test
  void testParse3() {
    // Arrange and Act
    JsonElement actualParseResult = JsonUtils.parse(42L);

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    assertEquals("42", actualParseResult.getAsString());
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
   * Method under test: {@link JsonUtils#parse(Object)}
   */
  @Test
  void testParse4() {
    // Arrange and Act
    JsonElement actualParseResult = JsonUtils.parse("42");

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
   * Method under test: {@link JsonUtils#parse(Object)}
   */
  @Test
  void testParse5() {
    // Arrange and Act
    JsonElement actualParseResult = JsonUtils.parse(true);

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    assertEquals('t', actualParseResult.getAsCharacter());
    assertFalse(actualParseResult.isJsonArray());
    assertFalse(actualParseResult.isJsonNull());
    assertFalse(actualParseResult.isJsonObject());
    assertFalse(((JsonPrimitive) actualParseResult).isNumber());
    assertFalse(((JsonPrimitive) actualParseResult).isString());
    assertTrue(actualParseResult.getAsBoolean());
    assertTrue(actualParseResult.isJsonPrimitive());
    assertTrue(((JsonPrimitive) actualParseResult).isBoolean());
    String expectedAsString = Boolean.TRUE.toString();
    assertEquals(expectedAsString, actualParseResult.getAsString());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Method under test: {@link JsonUtils#parse(Object)}
   */
  @Test
  void testParse6() {
    // Arrange and Act
    JsonElement actualParseResult = JsonUtils.parse(10.0d);

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    assertEquals("10.0", actualParseResult.getAsString());
    assertEquals('1', actualParseResult.getAsCharacter());
    assertEquals(10, actualParseResult.getAsInt());
    assertEquals(10.0d, actualParseResult.getAsDouble());
    assertEquals(10.0d, actualParseResult.getAsNumber().doubleValue());
    assertEquals(10.0f, actualParseResult.getAsFloat());
    assertEquals(10L, actualParseResult.getAsLong());
    assertEquals((short) 10, actualParseResult.getAsShort());
    assertFalse(actualParseResult.getAsBoolean());
    assertFalse(actualParseResult.isJsonArray());
    assertFalse(actualParseResult.isJsonNull());
    assertFalse(actualParseResult.isJsonObject());
    assertFalse(((JsonPrimitive) actualParseResult).isBoolean());
    assertFalse(((JsonPrimitive) actualParseResult).isString());
    assertTrue(actualParseResult.isJsonPrimitive());
    assertTrue(((JsonPrimitive) actualParseResult).isNumber());
    BigDecimal expectedAsBigDecimal = new BigDecimal("10.0");
    assertEquals(expectedAsBigDecimal, actualParseResult.getAsBigDecimal());
    assertEquals('\n', actualParseResult.getAsByte());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Method under test: {@link JsonUtils#parse(Object)}
   */
  @Test
  void testParse7() {
    // Arrange and Act
    JsonElement actualParseResult = JsonUtils.parse(10.0f);

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    assertEquals("10.0", actualParseResult.getAsString());
    assertEquals('1', actualParseResult.getAsCharacter());
    assertEquals(10, actualParseResult.getAsInt());
    assertEquals(10.0d, actualParseResult.getAsDouble());
    assertEquals(10.0f, actualParseResult.getAsFloat());
    assertEquals(10.0f, actualParseResult.getAsNumber().floatValue());
    assertEquals(10L, actualParseResult.getAsLong());
    assertEquals((short) 10, actualParseResult.getAsShort());
    assertFalse(actualParseResult.getAsBoolean());
    assertFalse(actualParseResult.isJsonArray());
    assertFalse(actualParseResult.isJsonNull());
    assertFalse(actualParseResult.isJsonObject());
    assertFalse(((JsonPrimitive) actualParseResult).isBoolean());
    assertFalse(((JsonPrimitive) actualParseResult).isString());
    assertTrue(actualParseResult.isJsonPrimitive());
    assertTrue(((JsonPrimitive) actualParseResult).isNumber());
    BigDecimal expectedAsBigDecimal = new BigDecimal("10.0");
    assertEquals(expectedAsBigDecimal, actualParseResult.getAsBigDecimal());
    assertEquals('\n', actualParseResult.getAsByte());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Method under test: {@link JsonUtils#parse(Object)}
   */
  @Test
  void testParse8() {
    // Arrange and Act
    JsonElement actualParseResult = JsonUtils.parse("");

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
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  void testConvertToJsonObject() {
    // Arrange and Act
    JsonObject actualConvertToJsonObjectResult = JsonUtils.convertToJsonObject(new HashMap<>());

    // Assert
    assertEquals(0, actualConvertToJsonObjectResult.size());
    assertFalse(actualConvertToJsonObjectResult.isJsonArray());
    assertFalse(actualConvertToJsonObjectResult.isJsonNull());
    assertFalse(actualConvertToJsonObjectResult.isJsonPrimitive());
    assertTrue(actualConvertToJsonObjectResult.isJsonObject());
    assertTrue(actualConvertToJsonObjectResult.isEmpty());
    assertSame(actualConvertToJsonObjectResult, actualConvertToJsonObjectResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  void testConvertToJsonObject2() {
    // Arrange
    HashMap<String, Object> map = new HashMap<>();
    map.put("foo", "42");

    // Act
    JsonObject actualConvertToJsonObjectResult = JsonUtils.convertToJsonObject(map);

    // Assert
    assertEquals(1, actualConvertToJsonObjectResult.size());
    assertFalse(actualConvertToJsonObjectResult.isJsonArray());
    assertFalse(actualConvertToJsonObjectResult.isJsonNull());
    assertFalse(actualConvertToJsonObjectResult.isJsonPrimitive());
    assertFalse(actualConvertToJsonObjectResult.isEmpty());
    assertTrue(actualConvertToJsonObjectResult.isJsonObject());
    assertSame(actualConvertToJsonObjectResult, actualConvertToJsonObjectResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  void testConvertToJsonObject3() {
    // Arrange
    HashMap<String, Object> map = new HashMap<>();
    map.put("42", "42");
    map.put("foo", "42");

    // Act
    JsonObject actualConvertToJsonObjectResult = JsonUtils.convertToJsonObject(map);

    // Assert
    assertEquals(2, actualConvertToJsonObjectResult.size());
    assertFalse(actualConvertToJsonObjectResult.isJsonArray());
    assertFalse(actualConvertToJsonObjectResult.isJsonNull());
    assertFalse(actualConvertToJsonObjectResult.isJsonPrimitive());
    assertFalse(actualConvertToJsonObjectResult.isEmpty());
    assertTrue(actualConvertToJsonObjectResult.isJsonObject());
    assertSame(actualConvertToJsonObjectResult, actualConvertToJsonObjectResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  void testConvertToJsonObject4() {
    // Arrange
    HashMap<String, Object> map = new HashMap<>();
    map.computeIfPresent("foo", mock(BiFunction.class));
    map.put("foo", "42");

    // Act
    JsonObject actualConvertToJsonObjectResult = JsonUtils.convertToJsonObject(map);

    // Assert
    assertEquals(1, actualConvertToJsonObjectResult.size());
    assertFalse(actualConvertToJsonObjectResult.isJsonArray());
    assertFalse(actualConvertToJsonObjectResult.isJsonNull());
    assertFalse(actualConvertToJsonObjectResult.isJsonPrimitive());
    assertFalse(actualConvertToJsonObjectResult.isEmpty());
    assertTrue(actualConvertToJsonObjectResult.isJsonObject());
    assertSame(actualConvertToJsonObjectResult, actualConvertToJsonObjectResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  void testConvertToJsonObject5() {
    // Arrange
    MapEntry<Object, Object> mapEntry = new MapEntry<>();
    mapEntry.setKey("Key");
    mapEntry.setValue("Value");

    HashMap<String, Object> map = new HashMap<>();
    map.put("foo", mapEntry);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsonUtils.convertToJsonObject(map));
  }

  /**
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  void testConvertToJsonObject6() {
    // Arrange
    HashMap<String, Object> map = new HashMap<>();
    map.put("foo", 1);

    // Act
    JsonObject actualConvertToJsonObjectResult = JsonUtils.convertToJsonObject(map);

    // Assert
    assertEquals(1, actualConvertToJsonObjectResult.size());
    assertFalse(actualConvertToJsonObjectResult.isJsonArray());
    assertFalse(actualConvertToJsonObjectResult.isJsonNull());
    assertFalse(actualConvertToJsonObjectResult.isJsonPrimitive());
    assertFalse(actualConvertToJsonObjectResult.isEmpty());
    assertTrue(actualConvertToJsonObjectResult.isJsonObject());
    assertSame(actualConvertToJsonObjectResult, actualConvertToJsonObjectResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  void testConvertToJsonObject7() {
    // Arrange
    HashMap<String, Object> map = new HashMap<>();
    map.put("foo", 1L);

    // Act
    JsonObject actualConvertToJsonObjectResult = JsonUtils.convertToJsonObject(map);

    // Assert
    assertEquals(1, actualConvertToJsonObjectResult.size());
    assertFalse(actualConvertToJsonObjectResult.isJsonArray());
    assertFalse(actualConvertToJsonObjectResult.isJsonNull());
    assertFalse(actualConvertToJsonObjectResult.isJsonPrimitive());
    assertFalse(actualConvertToJsonObjectResult.isEmpty());
    assertTrue(actualConvertToJsonObjectResult.isJsonObject());
    assertSame(actualConvertToJsonObjectResult, actualConvertToJsonObjectResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  void testConvertToJsonObject8() {
    // Arrange
    HashMap<String, Object> map = new HashMap<>();
    map.put("foo", "foo");

    // Act
    JsonObject actualConvertToJsonObjectResult = JsonUtils.convertToJsonObject(map);

    // Assert
    assertEquals(1, actualConvertToJsonObjectResult.size());
    assertFalse(actualConvertToJsonObjectResult.isJsonArray());
    assertFalse(actualConvertToJsonObjectResult.isJsonNull());
    assertFalse(actualConvertToJsonObjectResult.isJsonPrimitive());
    assertFalse(actualConvertToJsonObjectResult.isEmpty());
    assertTrue(actualConvertToJsonObjectResult.isJsonObject());
    assertSame(actualConvertToJsonObjectResult, actualConvertToJsonObjectResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  void testConvertToJsonObject9() {
    // Arrange
    HashMap<String, Object> map = new HashMap<>();
    map.put("foo", "");

    // Act
    JsonObject actualConvertToJsonObjectResult = JsonUtils.convertToJsonObject(map);

    // Assert
    assertEquals(1, actualConvertToJsonObjectResult.size());
    assertFalse(actualConvertToJsonObjectResult.isJsonArray());
    assertFalse(actualConvertToJsonObjectResult.isJsonNull());
    assertFalse(actualConvertToJsonObjectResult.isJsonPrimitive());
    assertFalse(actualConvertToJsonObjectResult.isEmpty());
    assertTrue(actualConvertToJsonObjectResult.isJsonObject());
    assertSame(actualConvertToJsonObjectResult, actualConvertToJsonObjectResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  void testConvertToJsonObject10() {
    // Arrange
    HashMap<String, Object> map = new HashMap<>();
    map.put("", "42");
    map.put("42", "42");
    map.put("foo", "42");

    // Act
    JsonObject actualConvertToJsonObjectResult = JsonUtils.convertToJsonObject(map);

    // Assert
    assertEquals(3, actualConvertToJsonObjectResult.size());
    assertFalse(actualConvertToJsonObjectResult.isJsonArray());
    assertFalse(actualConvertToJsonObjectResult.isJsonNull());
    assertFalse(actualConvertToJsonObjectResult.isJsonPrimitive());
    assertFalse(actualConvertToJsonObjectResult.isEmpty());
    assertTrue(actualConvertToJsonObjectResult.isJsonObject());
    assertSame(actualConvertToJsonObjectResult, actualConvertToJsonObjectResult.getAsJsonObject());
  }

  /**
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  void testConvertToJsonObject11() {
    // Arrange
    HashMap<String, Object> map = new HashMap<>();
    map.put("42", "");
    map.put("foo", "42");

    // Act
    JsonObject actualConvertToJsonObjectResult = JsonUtils.convertToJsonObject(map);

    // Assert
    assertEquals(2, actualConvertToJsonObjectResult.size());
    assertFalse(actualConvertToJsonObjectResult.isJsonArray());
    assertFalse(actualConvertToJsonObjectResult.isJsonNull());
    assertFalse(actualConvertToJsonObjectResult.isJsonPrimitive());
    assertFalse(actualConvertToJsonObjectResult.isEmpty());
    assertTrue(actualConvertToJsonObjectResult.isJsonObject());
    assertSame(actualConvertToJsonObjectResult, actualConvertToJsonObjectResult.getAsJsonObject());
  }
}
