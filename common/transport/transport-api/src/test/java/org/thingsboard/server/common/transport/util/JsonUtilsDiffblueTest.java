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
import com.amazonaws.transform.MapEntry;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JsonUtilsDiffblueTest {
  /**
   * Test {@link JsonUtils#getJsonObject(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#getJsonObject(List)}
   */
  @Test
  @DisplayName("Test getJsonObject(List); when ArrayList(); then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonUtils.getJsonObject(List)"})
  void testGetJsonObject_whenArrayList_thenReturnSizeIsZero() {
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
   * Test {@link JsonUtils#parse(Object)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return AsNumber toString is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#parse(Object)}
   */
  @Test
  @DisplayName("Test parse(Object); when '42'; then return AsNumber toString is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonUtils.parse(Object)"})
  void testParse_when42_thenReturnAsNumberToStringIs42() {
    // Arrange and Act
    JsonElement actualParseResult = JsonUtils.parse("42");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("42", asNumber.toString());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
    assertArrayEquals(new byte[]{'*'}, actualParseResult.getAsBigInteger().toByteArray());
  }

  /**
   * Test {@link JsonUtils#parse(Object)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@link JsonNull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#parse(Object)}
   */
  @Test
  @DisplayName("Test parse(Object); when empty string; then return JsonNull")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonUtils.parse(Object)"})
  void testParse_whenEmptyString_thenReturnJsonNull() {
    // Arrange and Act
    JsonElement actualParseResult = JsonUtils.parse("");

    // Assert
    assertTrue(actualParseResult instanceof JsonNull);
    assertFalse(actualParseResult.isJsonPrimitive());
    assertTrue(actualParseResult.isJsonNull());
    JsonNull expectedAsJsonNull = ((JsonNull) actualParseResult).INSTANCE;
    assertSame(expectedAsJsonNull, actualParseResult.getAsJsonNull());
  }

  /**
   * Test {@link JsonUtils#parse(Object)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return AsNumber intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#parse(Object)}
   */
  @Test
  @DisplayName("Test parse(Object); when forty-two; then return AsNumber intValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonUtils.parse(Object)"})
  void testParse_whenFortyTwo_thenReturnAsNumberIntValueIsFortyTwo() {
    // Arrange and Act
    JsonElement actualParseResult = JsonUtils.parse(42);

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    assertEquals(42, actualParseResult.getAsNumber().intValue());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
    assertArrayEquals(new byte[]{'*'}, actualParseResult.getAsBigInteger().toByteArray());
  }

  /**
   * Test {@link JsonUtils#parse(Object)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return AsNumber longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#parse(Object)}
   */
  @Test
  @DisplayName("Test parse(Object); when forty-two; then return AsNumber longValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonUtils.parse(Object)"})
  void testParse_whenFortyTwo_thenReturnAsNumberLongValueIsFortyTwo() {
    // Arrange and Act
    JsonElement actualParseResult = JsonUtils.parse(42L);

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    assertEquals(42L, actualParseResult.getAsNumber().longValue());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
    assertArrayEquals(new byte[]{'*'}, actualParseResult.getAsBigInteger().toByteArray());
  }

  /**
   * Test {@link JsonUtils#parse(Object)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return AsNumber doubleValue is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#parse(Object)}
   */
  @Test
  @DisplayName("Test parse(Object); when ten; then return AsNumber doubleValue is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonUtils.parse(Object)"})
  void testParse_whenTen_thenReturnAsNumberDoubleValueIsTen() {
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
    BigDecimal expectedAsBigDecimal = new BigDecimal("10.0");
    assertEquals(expectedAsBigDecimal, actualParseResult.getAsBigDecimal());
    assertEquals('\n', actualParseResult.getAsByte());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonUtils#parse(Object)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return AsNumber floatValue is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#parse(Object)}
   */
  @Test
  @DisplayName("Test parse(Object); when ten; then return AsNumber floatValue is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonUtils.parse(Object)"})
  void testParse_whenTen_thenReturnAsNumberFloatValueIsTen() {
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
    BigDecimal expectedAsBigDecimal = new BigDecimal("10.0");
    assertEquals(expectedAsBigDecimal, actualParseResult.getAsBigDecimal());
    assertEquals('\n', actualParseResult.getAsByte());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonUtils#parse(Object)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return AsCharacter is {@code t}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#parse(Object)}
   */
  @Test
  @DisplayName("Test parse(Object); when 'true'; then return AsCharacter is 't'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonUtils.parse(Object)"})
  void testParse_whenTrue_thenReturnAsCharacterIsT() {
    // Arrange and Act
    JsonElement actualParseResult = JsonUtils.parse(true);

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    assertEquals('t', actualParseResult.getAsCharacter());
    assertTrue(actualParseResult.getAsBoolean());
    assertTrue(((JsonPrimitive) actualParseResult).isBoolean());
    String expectedAsString = Boolean.TRUE.toString();
    assertEquals(expectedAsString, actualParseResult.getAsString());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonUtils#parse(Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return AsString is {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#parse(Object)}
   */
  @Test
  @DisplayName("Test parse(Object); when 'Value'; then return AsString is 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonElement JsonUtils.parse(Object)"})
  void testParse_whenValue_thenReturnAsStringIsValue() {
    // Arrange and Act
    JsonElement actualParseResult = JsonUtils.parse("Value");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("Value", actualParseResult.getAsString());
    assertEquals("Value", asNumber.toString());
    assertEquals('V', actualParseResult.getAsCharacter());
    assertTrue(((JsonPrimitive) actualParseResult).isString());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonUtils#convertToJsonObject(Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  @DisplayName("Test convertToJsonObject(Map); given '42'; when HashMap() '42' is '42'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonUtils.convertToJsonObject(Map)"})
  void testConvertToJsonObject_given42_whenHashMap42Is42_thenReturnSizeIsTwo() {
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
   * Test {@link JsonUtils#convertToJsonObject(Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  @DisplayName("Test convertToJsonObject(Map); given '42'; when HashMap() 'foo' is '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonUtils.convertToJsonObject(Map)"})
  void testConvertToJsonObject_given42_whenHashMapFooIs42_thenReturnSizeIsOne() {
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
   * Test {@link JsonUtils#convertToJsonObject(Map)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  @DisplayName("Test convertToJsonObject(Map); given empty string; when HashMap() 'foo' is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonUtils.convertToJsonObject(Map)"})
  void testConvertToJsonObject_givenEmptyString_whenHashMapFooIsEmptyString() {
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
   * Test {@link JsonUtils#convertToJsonObject(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  @DisplayName("Test convertToJsonObject(Map); given 'foo'; when HashMap() 'foo' is 'foo'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonUtils.convertToJsonObject(Map)"})
  void testConvertToJsonObject_givenFoo_whenHashMapFooIsFoo_thenReturnSizeIsOne() {
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
   * Test {@link JsonUtils#convertToJsonObject(Map)}.
   * <ul>
   *   <li>Given {@link MapEntry} (default constructor) Key is {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  @DisplayName("Test convertToJsonObject(Map); given MapEntry (default constructor) Key is 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonUtils.convertToJsonObject(Map)"})
  void testConvertToJsonObject_givenMapEntryKeyIsKey_thenThrowIllegalArgumentException() {
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
   * Test {@link JsonUtils#convertToJsonObject(Map)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  @DisplayName("Test convertToJsonObject(Map); given one; when HashMap() 'foo' is one; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonUtils.convertToJsonObject(Map)"})
  void testConvertToJsonObject_givenOne_whenHashMapFooIsOne_thenReturnSizeIsOne() {
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
   * Test {@link JsonUtils#convertToJsonObject(Map)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  @DisplayName("Test convertToJsonObject(Map); given one; when HashMap() 'foo' is one; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonUtils.convertToJsonObject(Map)"})
  void testConvertToJsonObject_givenOne_whenHashMapFooIsOne_thenReturnSizeIsOne2() {
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
   * Test {@link JsonUtils#convertToJsonObject(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is empty string.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  @DisplayName("Test convertToJsonObject(Map); when HashMap() '42' is empty string; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonUtils.convertToJsonObject(Map)"})
  void testConvertToJsonObject_whenHashMap42IsEmptyString_thenReturnSizeIsTwo() {
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

  /**
   * Test {@link JsonUtils#convertToJsonObject(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} empty string is {@code 42}.</li>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  @DisplayName("Test convertToJsonObject(Map); when HashMap() empty string is '42'; then return size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonUtils.convertToJsonObject(Map)"})
  void testConvertToJsonObject_whenHashMapEmptyStringIs42_thenReturnSizeIsThree() {
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
   * Test {@link JsonUtils#convertToJsonObject(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonUtils#convertToJsonObject(Map)}
   */
  @Test
  @DisplayName("Test convertToJsonObject(Map); when HashMap(); then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject JsonUtils.convertToJsonObject(Map)"})
  void testConvertToJsonObject_whenHashMap_thenReturnSizeIsZero() {
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
}
