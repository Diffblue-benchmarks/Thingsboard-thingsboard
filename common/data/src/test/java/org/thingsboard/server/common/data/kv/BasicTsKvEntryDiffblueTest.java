package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BasicTsKvEntryDiffblueTest {
  /**
   * Test {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)}.
   * <p>
   * Method under test: {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)}
   */
  @Test
  @DisplayName("Test new BasicTsKvEntry(long, KvEntry)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry, Long)}
   */
  @Test
  @DisplayName("Test new BasicTsKvEntry(long, KvEntry, Long)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)} with ts is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)} and count is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getKey()}
   */
  @Test
  @DisplayName("Test getKey(); given AggTsKvEntry(long, KvEntry, long) with ts is one and kv is JsonDataEntry(String, String) and count is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BasicTsKvEntry.getKey()"})
  void testGetKey_givenAggTsKvEntryWithTsIsOneAndKvIsJsonDataEntryAndCountIsThree() {
    // Arrange, Act and Assert
    assertEquals("Key", (new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getKey());
  }

  /**
   * Test {@link BasicTsKvEntry#getKey()}.
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)}.</li>
   *   <li>Then return {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getKey()}
   */
  @Test
  @DisplayName("Test getKey(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String); then return 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BasicTsKvEntry.getKey()"})
  void testGetKey_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry_thenReturnKey() {
    // Arrange, Act and Assert
    assertEquals("Key", (new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getKey());
  }

  /**
   * Test {@link BasicTsKvEntry#getDataType()}.
   * <ul>
   *   <li>Given {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)} with ts is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)} and count is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getDataType()}
   */
  @Test
  @DisplayName("Test getDataType(); given AggTsKvEntry(long, KvEntry, long) with ts is one and kv is JsonDataEntry(String, String) and count is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataType BasicTsKvEntry.getDataType()"})
  void testGetDataType_givenAggTsKvEntryWithTsIsOneAndKvIsJsonDataEntryAndCountIsThree() {
    // Arrange, Act and Assert
    assertEquals(DataType.JSON,
        (new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getDataType());
  }

  /**
   * Test {@link BasicTsKvEntry#getDataType()}.
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getDataType()}
   */
  @Test
  @DisplayName("Test getDataType(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataType BasicTsKvEntry.getDataType()"})
  void testGetDataType_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange, Act and Assert
    assertEquals(DataType.JSON, (new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getDataType());
  }

  /**
   * Test {@link BasicTsKvEntry#getStrValue()}.
   * <ul>
   *   <li>Given {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)} with ts is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)} and count is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getStrValue()}
   */
  @Test
  @DisplayName("Test getStrValue(); given AggTsKvEntry(long, KvEntry, long) with ts is one and kv is JsonDataEntry(String, String) and count is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BasicTsKvEntry.getStrValue()"})
  void testGetStrValue_givenAggTsKvEntryWithTsIsOneAndKvIsJsonDataEntryAndCountIsThree() {
    // Arrange, Act and Assert
    assertFalse(
        (new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getStrValue().isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getStrValue()}.
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getStrValue()}
   */
  @Test
  @DisplayName("Test getStrValue(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BasicTsKvEntry.getStrValue()"})
  void testGetStrValue_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange, Act and Assert
    assertFalse((new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getStrValue().isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getLongValue()}.
   * <ul>
   *   <li>Given {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)} with ts is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)} and count is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getLongValue()}
   */
  @Test
  @DisplayName("Test getLongValue(); given AggTsKvEntry(long, KvEntry, long) with ts is one and kv is JsonDataEntry(String, String) and count is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BasicTsKvEntry.getLongValue()"})
  void testGetLongValue_givenAggTsKvEntryWithTsIsOneAndKvIsJsonDataEntryAndCountIsThree() {
    // Arrange, Act and Assert
    assertFalse(
        (new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getLongValue().isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getLongValue()}.
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getLongValue()}
   */
  @Test
  @DisplayName("Test getLongValue(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BasicTsKvEntry.getLongValue()"})
  void testGetLongValue_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange, Act and Assert
    assertFalse((new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getLongValue().isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getBooleanValue()}.
   * <p>
   * Method under test: {@link BasicTsKvEntry#getBooleanValue()}
   */
  @Test
  @DisplayName("Test getBooleanValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BasicTsKvEntry.getBooleanValue()"})
  void testGetBooleanValue() {
    // Arrange, Act and Assert
    assertFalse((new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getBooleanValue()
        .isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getBooleanValue()}.
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getBooleanValue()}
   */
  @Test
  @DisplayName("Test getBooleanValue(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BasicTsKvEntry.getBooleanValue()"})
  void testGetBooleanValue_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange, Act and Assert
    assertFalse((new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getBooleanValue().isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getDoubleValue()}.
   * <p>
   * Method under test: {@link BasicTsKvEntry#getDoubleValue()}
   */
  @Test
  @DisplayName("Test getDoubleValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BasicTsKvEntry.getDoubleValue()"})
  void testGetDoubleValue() {
    // Arrange, Act and Assert
    assertFalse((new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getDoubleValue()
        .isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getDoubleValue()}.
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getDoubleValue()}
   */
  @Test
  @DisplayName("Test getDoubleValue(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BasicTsKvEntry.getDoubleValue()"})
  void testGetDoubleValue_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange, Act and Assert
    assertFalse((new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getDoubleValue().isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getJsonValue()}.
   * <ul>
   *   <li>Given {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)} with ts is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)} and count is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getJsonValue()}
   */
  @Test
  @DisplayName("Test getJsonValue(); given AggTsKvEntry(long, KvEntry, long) with ts is one and kv is JsonDataEntry(String, String) and count is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BasicTsKvEntry.getJsonValue()"})
  void testGetJsonValue_givenAggTsKvEntryWithTsIsOneAndKvIsJsonDataEntryAndCountIsThree() {
    // Arrange and Act
    Optional<String> actualJsonValue = (new BasicTsKvEntry(1L,
        new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getJsonValue();

    // Assert
    assertEquals("42", actualJsonValue.get());
    assertTrue(actualJsonValue.isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getJsonValue()}.
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getJsonValue()}
   */
  @Test
  @DisplayName("Test getJsonValue(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional BasicTsKvEntry.getJsonValue()"})
  void testGetJsonValue_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange and Act
    Optional<String> actualJsonValue = (new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getJsonValue();

    // Assert
    assertEquals("42", actualJsonValue.get());
    assertTrue(actualJsonValue.isPresent());
  }

  /**
   * Test {@link BasicTsKvEntry#getValue()}.
   * <ul>
   *   <li>Given {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)} with ts is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)} and count is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given AggTsKvEntry(long, KvEntry, long) with ts is one and kv is JsonDataEntry(String, String) and count is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BasicTsKvEntry.getValue()"})
  void testGetValue_givenAggTsKvEntryWithTsIsOneAndKvIsJsonDataEntryAndCountIsThree() {
    // Arrange, Act and Assert
    assertEquals("42", (new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getValue());
  }

  /**
   * Test {@link BasicTsKvEntry#getValue()}.
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String); then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BasicTsKvEntry.getValue()"})
  void testGetValue_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getValue());
  }

  /**
   * Test {@link BasicTsKvEntry#getValue()}.
   * <ul>
   *   <li>Given {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with {@code Key} and value is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given BooleanDataEntry(String, Boolean) with 'Key' and value is 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BasicTsKvEntry.getValue()"})
  void testGetValue_givenBooleanDataEntryWithKeyAndValueIsFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((Boolean) (new BasicTsKvEntry(1L, new BooleanDataEntry("Key", false))).getValue());
  }

  /**
   * Test {@link BasicTsKvEntry#getValue()}.
   * <ul>
   *   <li>Given {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with {@code Key} and value is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given BooleanDataEntry(String, Boolean) with 'Key' and value is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BasicTsKvEntry.getValue()"})
  void testGetValue_givenBooleanDataEntryWithKeyAndValueIsTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((Boolean) (new BasicTsKvEntry(1L, new BooleanDataEntry("Key", true))).getValue());
  }

  /**
   * Test {@link BasicTsKvEntry#getValueAsString()}.
   * <p>
   * Method under test: {@link BasicTsKvEntry#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BasicTsKvEntry.getValueAsString()"})
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals("42",
        (new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getValueAsString());
  }

  /**
   * Test {@link BasicTsKvEntry#getValueAsString()}.
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BasicTsKvEntry.getValueAsString()"})
  void testGetValueAsString_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange, Act and Assert
    assertEquals("42", (new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getValueAsString());
  }

  /**
   * Test {@link BasicTsKvEntry#getDataPoints()}.
   * <p>
   * Method under test: {@link BasicTsKvEntry#getDataPoints()}
   */
  @Test
  @DisplayName("Test getDataPoints()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BasicTsKvEntry.getDataPoints()"})
  void testGetDataPoints() {
    // Arrange, Act and Assert
    assertEquals(1, (new BasicTsKvEntry(2L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getDataPoints());
  }

  /**
   * Test {@link BasicTsKvEntry#getDataPoints()}.
   * <p>
   * Method under test: {@link BasicTsKvEntry#getDataPoints()}
   */
  @Test
  @DisplayName("Test getDataPoints()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BasicTsKvEntry.getDataPoints()"})
  void testGetDataPoints2() {
    // Arrange, Act and Assert
    assertEquals(1,
        (new BasicTsKvEntry(2L, new AggTsKvEntry(1L, new StringDataEntry("Key", "42"), 3L))).getDataPoints());
  }

  /**
   * Test {@link BasicTsKvEntry#getDataPoints()}.
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is {@link JsonDataEntry#JsonDataEntry(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getDataPoints()}
   */
  @Test
  @DisplayName("Test getDataPoints(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is JsonDataEntry(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BasicTsKvEntry.getDataPoints()"})
  void testGetDataPoints_givenBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange, Act and Assert
    assertEquals(1, (new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getDataPoints());
  }

  /**
   * Test {@link BasicTsKvEntry#getDataPoints()}.
   * <ul>
   *   <li>Given {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is {@link StringDataEntry#StringDataEntry(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getDataPoints()}
   */
  @Test
  @DisplayName("Test getDataPoints(); given BasicTsKvEntry(long, KvEntry) with ts is one and kv is StringDataEntry(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BasicTsKvEntry.getDataPoints()"})
  void testGetDataPoints_givenBasicTsKvEntryWithTsIsOneAndKvIsStringDataEntry() {
    // Arrange, Act and Assert
    assertEquals(1, (new BasicTsKvEntry(1L, new StringDataEntry("Key", "42"))).getDataPoints());
  }

  /**
   * Test {@link BasicTsKvEntry#getDataPoints()}.
   * <ul>
   *   <li>Given {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with {@code Key} and value is {@code true}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#getDataPoints()}
   */
  @Test
  @DisplayName("Test getDataPoints(); given BooleanDataEntry(String, Boolean) with 'Key' and value is 'true'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BasicTsKvEntry.getDataPoints()"})
  void testGetDataPoints_givenBooleanDataEntryWithKeyAndValueIsTrue_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new BasicTsKvEntry(2L, new BooleanDataEntry("Key", true))).getDataPoints());
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}, and {@link BasicTsKvEntry#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicTsKvEntry#equals(Object)}
   *   <li>{@link BasicTsKvEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    BasicTsKvEntry basicTsKvEntry2 = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertEquals(basicTsKvEntry, basicTsKvEntry2);
    int expectedHashCodeResult = basicTsKvEntry.hashCode();
    assertEquals(expectedHashCodeResult, basicTsKvEntry2.hashCode());
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}, and {@link BasicTsKvEntry#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicTsKvEntry#equals(Object)}
   *   <li>{@link BasicTsKvEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"), 1L);
    AggTsKvEntry aggTsKvEntry = mock(AggTsKvEntry.class);
    when(aggTsKvEntry.getKv()).thenReturn(new JsonDataEntry("Key", "42"));
    when(aggTsKvEntry.getVersion()).thenReturn(1L);
    when(aggTsKvEntry.getTs()).thenReturn(1L);
    when(aggTsKvEntry.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(basicTsKvEntry, aggTsKvEntry);
    int notExpectedHashCodeResult = basicTsKvEntry.hashCode();
    assertNotEquals(notExpectedHashCodeResult, aggTsKvEntry.hashCode());
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}, and {@link BasicTsKvEntry#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicTsKvEntry#equals(Object)}
   *   <li>{@link BasicTsKvEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(3L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry(null, "42"));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, null);

    // Act and Assert
    assertNotEquals(basicTsKvEntry, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"), 1L);

    // Act and Assert
    assertNotEquals(basicTsKvEntry, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"), 1L));
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"), 1L);
    AggTsKvEntry aggTsKvEntry = mock(AggTsKvEntry.class);
    when(aggTsKvEntry.getKv()).thenReturn(new JsonDataEntry("Key", "42"));
    when(aggTsKvEntry.getVersion()).thenReturn(1L);
    when(aggTsKvEntry.getTs()).thenReturn(1L);
    when(aggTsKvEntry.canEqual(Mockito.<Object>any())).thenReturn(false);

    // Act and Assert
    assertNotEquals(basicTsKvEntry, aggTsKvEntry);
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), null);
  }

  /**
   * Test {@link BasicTsKvEntry#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BasicTsKvEntry.equals(Object)", "int BasicTsKvEntry.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), "Different type to BasicTsKvEntry");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicTsKvEntry#toString()}
   *   <li>{@link BasicTsKvEntry#getKv()}
   *   <li>{@link BasicTsKvEntry#getTs()}
   *   <li>{@link BasicTsKvEntry#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KvEntry BasicTsKvEntry.getKv()", "long BasicTsKvEntry.getTs()",
      "Long BasicTsKvEntry.getVersion()", "String BasicTsKvEntry.toString()"})
  void testGettersAndSetters() {
    // Arrange
    JsonDataEntry kv = new JsonDataEntry("Key", "42");

    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, kv);

    // Act
    String actualToStringResult = basicTsKvEntry.toString();
    KvEntry actualKv = basicTsKvEntry.getKv();
    long actualTs = basicTsKvEntry.getTs();

    // Assert
    assertEquals("BasicTsKvEntry(ts=1, kv=JsonDataEntry{value=42} BasicKvEntry{key='Key'}, version=null)",
        actualToStringResult);
    assertNull(basicTsKvEntry.getVersion());
    assertEquals(1L, actualTs);
    assertSame(kv, actualKv);
  }
}
