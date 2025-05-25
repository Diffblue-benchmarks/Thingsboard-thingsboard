package org.thingsboard.server.common.transport.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.amazonaws.transform.MapEntry;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JsonUtilsDiffblueTest {
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
