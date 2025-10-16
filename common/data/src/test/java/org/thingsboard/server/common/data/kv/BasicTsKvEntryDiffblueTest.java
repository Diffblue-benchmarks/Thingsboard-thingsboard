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
package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BasicTsKvEntryDiffblueTest {
  /**
   * Test {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)}.
   *
   * <p>Method under test: {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)}
   */
  @Test
  @DisplayName("Test new BasicTsKvEntry(long, KvEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicTsKvEntry.<init>(long, KvEntry)"})
  void testNewBasicTsKvEntry() {
    // Arrange
    JsonDataEntry kv = new JsonDataEntry("Key", "42");

    // Act
    BasicTsKvEntry actualBasicTsKvEntry = new BasicTsKvEntry(1L, kv);

    // Assert
    KvEntry kv2 = actualBasicTsKvEntry.getKv();
    assertTrue(kv2 instanceof JsonDataEntry);
    assertEquals("42", actualBasicTsKvEntry.getValueAsString());
    assertEquals("42", actualBasicTsKvEntry.getValue());
    assertEquals("Key", actualBasicTsKvEntry.getKey());
    assertNull(actualBasicTsKvEntry.getVersion());
    assertEquals(1, actualBasicTsKvEntry.getDataPoints());
    assertEquals(1L, actualBasicTsKvEntry.getTs());
    assertEquals(DataType.JSON, actualBasicTsKvEntry.getDataType());
    Optional<Boolean> booleanValue = actualBasicTsKvEntry.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertSame(kv, kv2);
    assertSame(booleanValue, actualBasicTsKvEntry.getDoubleValue());
    assertSame(booleanValue, actualBasicTsKvEntry.getLongValue());
    assertSame(booleanValue, actualBasicTsKvEntry.getStrValue());
  }

  /**
   * Test {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry, Long)}.
   *
   * <p>Method under test: {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry, Long)}
   */
  @Test
  @DisplayName("Test new BasicTsKvEntry(long, KvEntry, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicTsKvEntry.<init>(long, KvEntry, Long)"})
  void testNewBasicTsKvEntry2() {
    // Arrange
    JsonDataEntry kv = new JsonDataEntry("Key", "42");

    // Act
    BasicTsKvEntry actualBasicTsKvEntry = new BasicTsKvEntry(1L, kv, 1L);

    // Assert
    KvEntry kv2 = actualBasicTsKvEntry.getKv();
    assertTrue(kv2 instanceof JsonDataEntry);
    assertEquals("42", actualBasicTsKvEntry.getValueAsString());
    assertEquals("42", actualBasicTsKvEntry.getValue());
    assertEquals("Key", actualBasicTsKvEntry.getKey());
    assertEquals(1, actualBasicTsKvEntry.getDataPoints());
    assertEquals(1L, actualBasicTsKvEntry.getVersion().longValue());
    assertEquals(1L, actualBasicTsKvEntry.getTs());
    assertEquals(DataType.JSON, actualBasicTsKvEntry.getDataType());
    Optional<Boolean> booleanValue = actualBasicTsKvEntry.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertSame(kv, kv2);
    assertSame(booleanValue, actualBasicTsKvEntry.getDoubleValue());
    assertSame(booleanValue, actualBasicTsKvEntry.getLongValue());
    assertSame(booleanValue, actualBasicTsKvEntry.getStrValue());
  }

  /**
   * Test {@link BasicTsKvEntry#getKey()}.
   *
   * <ul>
   *   <li>Given {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)} and count is three.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getKey()}
   */
  @Test
  @DisplayName(
      "Test getKey(); given AggTsKvEntry(long, KvEntry, long) with ts is one and kv is JsonDataEntry(String, String) and count is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BasicTsKvEntry.getKey()"})
  void testGetKey_givenAggTsKvEntryWithTsIsOneAndKvIsJsonDataEntryAndCountIsThree() {
    // Arrange
    AggTsKvEntry kv = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    // Act and Assert
    assertEquals("Key", basicTsKvEntry.getKey());
  }

  /**
   * Test {@link BasicTsKvEntry#getKey()}.
   *
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)}.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getKey()}
   */
  @Test
  @DisplayName(
      "Test getKey(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String); then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BasicTsKvEntry.getKey()"})
  void testGetKey_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry_thenReturnKey() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertEquals("Key", basicTsKvEntry.getKey());
  }

  /**
   * Test {@link BasicTsKvEntry#getDataType()}.
   *
   * <ul>
   *   <li>Given {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)} and count is three.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getDataType()}
   */
  @Test
  @DisplayName(
      "Test getDataType(); given AggTsKvEntry(long, KvEntry, long) with ts is one and kv is JsonDataEntry(String, String) and count is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataType BasicTsKvEntry.getDataType()"})
  void testGetDataType_givenAggTsKvEntryWithTsIsOneAndKvIsJsonDataEntryAndCountIsThree() {
    // Arrange
    AggTsKvEntry kv = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    // Act and Assert
    assertEquals(DataType.JSON, basicTsKvEntry.getDataType());
  }

  /**
   * Test {@link BasicTsKvEntry#getDataType()}.
   *
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getDataType()}
   */
  @Test
  @DisplayName(
      "Test getDataType(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataType BasicTsKvEntry.getDataType()"})
  void testGetDataType_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertEquals(DataType.JSON, basicTsKvEntry.getDataType());
  }

  /**
   * Test {@link BasicTsKvEntry#getStrValue()}.
   *
   * <ul>
   *   <li>Given {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)} and count is three.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getStrValue()}
   */
  @Test
  @DisplayName(
      "Test getStrValue(); given AggTsKvEntry(long, KvEntry, long) with ts is one and kv is JsonDataEntry(String, String) and count is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BasicTsKvEntry.getStrValue()"})
  void testGetStrValue_givenAggTsKvEntryWithTsIsOneAndKvIsJsonDataEntryAndCountIsThree() {
    // Arrange
    AggTsKvEntry kv = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    // Act and Assert
    assertFalse(basicTsKvEntry.getStrValue().isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getStrValue()}.
   *
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getStrValue()}
   */
  @Test
  @DisplayName(
      "Test getStrValue(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BasicTsKvEntry.getStrValue()"})
  void testGetStrValue_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertFalse(basicTsKvEntry.getStrValue().isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getLongValue()}.
   *
   * <ul>
   *   <li>Given {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)} and count is three.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getLongValue()}
   */
  @Test
  @DisplayName(
      "Test getLongValue(); given AggTsKvEntry(long, KvEntry, long) with ts is one and kv is JsonDataEntry(String, String) and count is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BasicTsKvEntry.getLongValue()"})
  void testGetLongValue_givenAggTsKvEntryWithTsIsOneAndKvIsJsonDataEntryAndCountIsThree() {
    // Arrange
    AggTsKvEntry kv = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    // Act and Assert
    assertFalse(basicTsKvEntry.getLongValue().isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getLongValue()}.
   *
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getLongValue()}
   */
  @Test
  @DisplayName(
      "Test getLongValue(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BasicTsKvEntry.getLongValue()"})
  void testGetLongValue_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertFalse(basicTsKvEntry.getLongValue().isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getBooleanValue()}.
   *
   * <p>Method under test: {@link BasicTsKvEntry#getBooleanValue()}
   */
  @Test
  @DisplayName("Test getBooleanValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BasicTsKvEntry.getBooleanValue()"})
  void testGetBooleanValue() {
    // Arrange
    AggTsKvEntry kv = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    // Act and Assert
    assertFalse(basicTsKvEntry.getBooleanValue().isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getBooleanValue()}.
   *
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getBooleanValue()}
   */
  @Test
  @DisplayName(
      "Test getBooleanValue(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BasicTsKvEntry.getBooleanValue()"})
  void testGetBooleanValue_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertFalse(basicTsKvEntry.getBooleanValue().isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getDoubleValue()}.
   *
   * <p>Method under test: {@link BasicTsKvEntry#getDoubleValue()}
   */
  @Test
  @DisplayName("Test getDoubleValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BasicTsKvEntry.getDoubleValue()"})
  void testGetDoubleValue() {
    // Arrange
    AggTsKvEntry kv = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    // Act and Assert
    assertFalse(basicTsKvEntry.getDoubleValue().isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getDoubleValue()}.
   *
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getDoubleValue()}
   */
  @Test
  @DisplayName(
      "Test getDoubleValue(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BasicTsKvEntry.getDoubleValue()"})
  void testGetDoubleValue_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertFalse(basicTsKvEntry.getDoubleValue().isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getJsonValue()}.
   *
   * <ul>
   *   <li>Given {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)} and count is three.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getJsonValue()}
   */
  @Test
  @DisplayName(
      "Test getJsonValue(); given AggTsKvEntry(long, KvEntry, long) with ts is one and kv is JsonDataEntry(String, String) and count is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BasicTsKvEntry.getJsonValue()"})
  void testGetJsonValue_givenAggTsKvEntryWithTsIsOneAndKvIsJsonDataEntryAndCountIsThree() {
    // Arrange
    AggTsKvEntry kv = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    // Act
    Optional<String> actualJsonValue = basicTsKvEntry.getJsonValue();

    // Assert
    assertEquals("42", actualJsonValue.get());
    assertTrue(actualJsonValue.isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getJsonValue()}.
   *
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getJsonValue()}
   */
  @Test
  @DisplayName(
      "Test getJsonValue(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BasicTsKvEntry.getJsonValue()"})
  void testGetJsonValue_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act
    Optional<String> actualJsonValue = basicTsKvEntry.getJsonValue();

    // Assert
    assertEquals("42", actualJsonValue.get());
    assertTrue(actualJsonValue.isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getValue()}.
   *
   * <ul>
   *   <li>Given {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)} and count is three.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getValue()}
   */
  @Test
  @DisplayName(
      "Test getValue(); given AggTsKvEntry(long, KvEntry, long) with ts is one and kv is JsonDataEntry(String, String) and count is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BasicTsKvEntry.getValue()"})
  void testGetValue_givenAggTsKvEntryWithTsIsOneAndKvIsJsonDataEntryAndCountIsThree() {
    // Arrange
    AggTsKvEntry kv = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    // Act and Assert
    assertEquals("42", basicTsKvEntry.getValue());
  }

  /**
   * Test {@link BasicTsKvEntry#getValue()}.
   *
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getValue()}
   */
  @Test
  @DisplayName(
      "Test getValue(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String); then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BasicTsKvEntry.getValue()"})
  void testGetValue_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry_thenReturn42() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertEquals("42", basicTsKvEntry.getValue());
  }

  /**
   * Test {@link BasicTsKvEntry#getValue()}.
   *
   * <ul>
   *   <li>Given {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with {@code Key} and
   *       value is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getValue()}
   */
  @Test
  @DisplayName(
      "Test getValue(); given BooleanDataEntry(String, Boolean) with 'Key' and value is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BasicTsKvEntry.getValue()"})
  void testGetValue_givenBooleanDataEntryWithKeyAndValueIsFalse_thenReturnFalse() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new BooleanDataEntry("Key", false));

    // Act and Assert
    assertFalse((Boolean) basicTsKvEntry.getValue());
  }

  /**
   * Test {@link BasicTsKvEntry#getValue()}.
   *
   * <ul>
   *   <li>Given {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with {@code Key} and
   *       value is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getValue()}
   */
  @Test
  @DisplayName(
      "Test getValue(); given BooleanDataEntry(String, Boolean) with 'Key' and value is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BasicTsKvEntry.getValue()"})
  void testGetValue_givenBooleanDataEntryWithKeyAndValueIsTrue_thenReturnTrue() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new BooleanDataEntry("Key", true));

    // Act and Assert
    assertTrue((Boolean) basicTsKvEntry.getValue());
  }

  /**
   * Test {@link BasicTsKvEntry#getValueAsString()}.
   *
   * <p>Method under test: {@link BasicTsKvEntry#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BasicTsKvEntry.getValueAsString()"})
  void testGetValueAsString() {
    // Arrange
    AggTsKvEntry kv = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    // Act and Assert
    assertEquals("42", basicTsKvEntry.getValueAsString());
  }

  /**
   * Test {@link BasicTsKvEntry#getValueAsString()}.
   *
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getValueAsString()}
   */
  @Test
  @DisplayName(
      "Test getValueAsString(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BasicTsKvEntry.getValueAsString()"})
  void testGetValueAsString_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertEquals("42", basicTsKvEntry.getValueAsString());
  }

  /**
   * Test {@link BasicTsKvEntry#getDataPoints()}.
   *
   * <p>Method under test: {@link BasicTsKvEntry#getDataPoints()}
   */
  @Test
  @DisplayName("Test getDataPoints()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BasicTsKvEntry.getDataPoints()"})
  void testGetDataPoints() {
    // Arrange
    AggTsKvEntry kv = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    // Act and Assert
    assertEquals(1, basicTsKvEntry.getDataPoints());
  }

  /**
   * Test {@link BasicTsKvEntry#getDataPoints()}.
   *
   * <p>Method under test: {@link BasicTsKvEntry#getDataPoints()}
   */
  @Test
  @DisplayName("Test getDataPoints()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BasicTsKvEntry.getDataPoints()"})
  void testGetDataPoints2() {
    // Arrange
    AggTsKvEntry kv = new AggTsKvEntry(1L, new StringDataEntry("Key", "42"), 3L);
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    // Act and Assert
    assertEquals(1, basicTsKvEntry.getDataPoints());
  }

  /**
   * Test {@link BasicTsKvEntry#getDataPoints()}.
   *
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getDataPoints()}
   */
  @Test
  @DisplayName(
      "Test getDataPoints(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BasicTsKvEntry.getDataPoints()"})
  void testGetDataPoints_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertEquals(1, basicTsKvEntry.getDataPoints());
  }

  /**
   * Test {@link BasicTsKvEntry#getDataPoints()}.
   *
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is
   *       {@link StringDataEntry#StringDataEntry(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getDataPoints()}
   */
  @Test
  @DisplayName(
      "Test getDataPoints(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is StringDataEntry(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BasicTsKvEntry.getDataPoints()"})
  void testGetDataPoints_givenBasicTsKvEntryWithTsIsOneAndKvIsStringDataEntry() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new StringDataEntry("Key", "42"));

    // Act and Assert
    assertEquals(1, basicTsKvEntry.getDataPoints());
  }

  /**
   * Test {@link BasicTsKvEntry#getDataPoints()}.
   *
   * <ul>
   *   <li>Given {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with {@code Key} and
   *       value is {@code true}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#getDataPoints()}
   */
  @Test
  @DisplayName(
      "Test getDataPoints(); given BooleanDataEntry(String, Boolean) with 'Key' and value is 'true'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BasicTsKvEntry.getDataPoints()"})
  void testGetDataPoints_givenBooleanDataEntryWithKeyAndValueIsTrue_thenReturnOne() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new BooleanDataEntry("Key", true));

    // Act and Assert
    assertEquals(1, basicTsKvEntry.getDataPoints());
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}, and {@link BasicTsKvEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BasicTsKvEntry#equals(Object)}
   *   <li>{@link BasicTsKvEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    BasicTsKvEntry basicTsKvEntry2 = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertEquals(basicTsKvEntry, basicTsKvEntry2);
    assertEquals(basicTsKvEntry.hashCode(), basicTsKvEntry2.hashCode());
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}, and {@link BasicTsKvEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BasicTsKvEntry#equals(Object)}
   *   <li>{@link BasicTsKvEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, null);

    AggTsKvEntry aggTsKvEntry = mock(AggTsKvEntry.class);
    when(aggTsKvEntry.getKv()).thenReturn(null);
    when(aggTsKvEntry.getVersion()).thenReturn(null);
    when(aggTsKvEntry.getTs()).thenReturn(1L);
    when(aggTsKvEntry.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(basicTsKvEntry, aggTsKvEntry);
    assertNotEquals(basicTsKvEntry.hashCode(), aggTsKvEntry.hashCode());
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}, and {@link BasicTsKvEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BasicTsKvEntry#equals(Object)}
   *   <li>{@link BasicTsKvEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertEquals(basicTsKvEntry, basicTsKvEntry);
    int expectedHashCodeResult = basicTsKvEntry.hashCode();
    assertEquals(expectedHashCodeResult, basicTsKvEntry.hashCode());
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(3L, new JsonDataEntry("Key", "42"));
    BasicTsKvEntry basicTsKvEntry2 = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, basicTsKvEntry2);
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry(null, "42"));
    BasicTsKvEntry basicTsKvEntry2 = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, basicTsKvEntry2);
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AggTsKvEntry kv = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);
    BasicTsKvEntry basicTsKvEntry2 = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, basicTsKvEntry2);
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, null);
    BasicTsKvEntry basicTsKvEntry2 = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, basicTsKvEntry2);
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"), 1L);
    BasicTsKvEntry basicTsKvEntry2 = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, basicTsKvEntry2);
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"), 1L));
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    AggTsKvEntry aggTsKvEntry = mock(AggTsKvEntry.class);
    when(aggTsKvEntry.canEqual(Mockito.<Object>any())).thenReturn(false);

    // Act and Assert
    assertNotEquals(basicTsKvEntry, aggTsKvEntry);
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    AggTsKvEntry aggTsKvEntry = mock(AggTsKvEntry.class);
    when(aggTsKvEntry.getVersion()).thenReturn(1L);
    when(aggTsKvEntry.getTs()).thenReturn(1L);
    when(aggTsKvEntry.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(basicTsKvEntry, aggTsKvEntry);
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    AggTsKvEntry aggTsKvEntry = mock(AggTsKvEntry.class);
    when(aggTsKvEntry.getKv()).thenReturn(null);
    when(aggTsKvEntry.getVersion()).thenReturn(null);
    when(aggTsKvEntry.getTs()).thenReturn(1L);
    when(aggTsKvEntry.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(basicTsKvEntry, aggTsKvEntry);
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"), 1L);

    AggTsKvEntry aggTsKvEntry = mock(AggTsKvEntry.class);
    when(aggTsKvEntry.getKv()).thenReturn(null);
    when(aggTsKvEntry.getVersion()).thenReturn(1L);
    when(aggTsKvEntry.getTs()).thenReturn(1L);
    when(aggTsKvEntry.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(basicTsKvEntry, aggTsKvEntry);
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, null);
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, "Different type to BasicTsKvEntry");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BasicTsKvEntry#toString()}
   *   <li>{@link BasicTsKvEntry#getKv()}
   *   <li>{@link BasicTsKvEntry#getTs()}
   *   <li>{@link BasicTsKvEntry#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "KvEntry BasicTsKvEntry.getKv()",
    "long BasicTsKvEntry.getTs()",
    "Long BasicTsKvEntry.getVersion()",
    "String BasicTsKvEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    JsonDataEntry kv = new JsonDataEntry("Key", "42");
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    // Act
    String actualToStringResult = basicTsKvEntry.toString();
    KvEntry actualKv = basicTsKvEntry.getKv();
    long actualTs = basicTsKvEntry.getTs();

    // Assert
    assertEquals(
        "BasicTsKvEntry(ts=1, kv=JsonDataEntry{value=42} BasicKvEntry{key='Key'}, version=null)",
        actualToStringResult);
    assertNull(basicTsKvEntry.getVersion());
    assertEquals(1L, actualTs);
    assertSame(kv, actualKv);
  }
}
