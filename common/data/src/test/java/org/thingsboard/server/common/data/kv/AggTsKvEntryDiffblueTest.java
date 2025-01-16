package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.TsValue;

class AggTsKvEntryDiffblueTest {
  /**
   * Test {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)}.
   * <p>
   * Method under test: {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)}
   */
  @Test
  @DisplayName("Test new AggTsKvEntry(long, KvEntry, long)")
  void testNewAggTsKvEntry() {
    // Arrange
    JsonDataEntry kv = new JsonDataEntry("Key", "42");

    // Act
    AggTsKvEntry actualAggTsKvEntry = new AggTsKvEntry(1L, kv, 3L);

    // Assert
    Optional<String> jsonValue = actualAggTsKvEntry.getJsonValue();
    assertEquals("42", jsonValue.get());
    assertEquals("42", actualAggTsKvEntry.getValueAsString());
    TsValue toTsValueResult = actualAggTsKvEntry.toTsValue();
    assertEquals("42", toTsValueResult.getValue());
    assertEquals("42", actualAggTsKvEntry.getValue());
    assertEquals("Key", actualAggTsKvEntry.getKey());
    assertNull(actualAggTsKvEntry.getVersion());
    assertEquals(1, actualAggTsKvEntry.getDataPoints());
    assertEquals(1L, actualAggTsKvEntry.getTs());
    assertEquals(1L, toTsValueResult.getTs());
    assertEquals(3L, toTsValueResult.getCount().longValue());
    assertEquals(DataType.JSON, actualAggTsKvEntry.getDataType());
    Optional<Boolean> booleanValue = actualAggTsKvEntry.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(jsonValue.isPresent());
    assertSame(kv, actualAggTsKvEntry.getKv());
    assertSame(booleanValue, actualAggTsKvEntry.getDoubleValue());
    assertSame(booleanValue, actualAggTsKvEntry.getLongValue());
    assertSame(booleanValue, actualAggTsKvEntry.getStrValue());
  }

  /**
   * Test {@link AggTsKvEntry#toTsValue()}.
   * <ul>
   *   <li>Given {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)} with ts is
   * one and kv is {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)} and
   * count is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggTsKvEntry#toTsValue()}
   */
  @Test
  @DisplayName("Test toTsValue(); given AggTsKvEntry(long, KvEntry, long) with ts is one and kv is AggTsKvEntry(long, KvEntry, long) and count is three")
  void testToTsValue_givenAggTsKvEntryWithTsIsOneAndKvIsAggTsKvEntryAndCountIsThree() {
    // Arrange and Act
    TsValue actualToTsValueResult = (new AggTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L), 3L))
        .toTsValue();

    // Assert
    assertEquals("42", actualToTsValueResult.getValue());
    assertEquals(1L, actualToTsValueResult.getTs());
    assertEquals(3L, actualToTsValueResult.getCount().longValue());
  }

  /**
   * Test {@link AggTsKvEntry#toTsValue()}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with
   * {@code Key} and value is {@code 42}.</li>
   *   <li>Then return Value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggTsKvEntry#toTsValue()}
   */
  @Test
  @DisplayName("Test toTsValue(); given JsonDataEntry(String, String) with 'Key' and value is '42'; then return Value is '42'")
  void testToTsValue_givenJsonDataEntryWithKeyAndValueIs42_thenReturnValueIs42() {
    // Arrange and Act
    TsValue actualToTsValueResult = (new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L)).toTsValue();

    // Assert
    assertEquals("42", actualToTsValueResult.getValue());
    assertEquals(1L, actualToTsValueResult.getTs());
    assertEquals(3L, actualToTsValueResult.getCount().longValue());
  }

  /**
   * Test {@link AggTsKvEntry#toString()}.
   * <p>
   * Method under test: {@link AggTsKvEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("AggTsKvEntry(count=3)", (new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L)).toString());
  }
}
