package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.TsValue;

class ReadTsKvQueryResultDiffblueTest {
  /**
   * Test {@link ReadTsKvQueryResult#toTsValues()}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryResult#toTsValues()}
   */
  @Test
  @DisplayName("Test toTsValues(); then return array length is zero")
  void testToTsValues_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new ReadTsKvQueryResult(1, new ArrayList<>(), 1L)).toTsValues().length);
  }

  /**
   * Test {@link ReadTsKvQueryResult#toTsValues()}.
   * <ul>
   *   <li>Then return first element Count is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryResult#toTsValues()}
   */
  @Test
  @DisplayName("Test toTsValues(); then return first element Count is 'null'")
  void testToTsValues_thenReturnFirstElementCountIsNull() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    TsValue[] actualToTsValuesResult = (new ReadTsKvQueryResult(1, data, 1L)).toTsValues();

    // Assert
    TsValue tsValue = actualToTsValuesResult[0];
    assertEquals("42", tsValue.getValue());
    assertNull(tsValue.getCount());
    assertEquals(1, actualToTsValuesResult.length);
    assertEquals(1L, tsValue.getTs());
  }

  /**
   * Test {@link ReadTsKvQueryResult#toTsValues()}.
   * <ul>
   *   <li>Then return first element Count longValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryResult#toTsValues()}
   */
  @Test
  @DisplayName("Test toTsValues(); then return first element Count longValue is three")
  void testToTsValues_thenReturnFirstElementCountLongValueIsThree() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L));

    // Act
    TsValue[] actualToTsValuesResult = (new ReadTsKvQueryResult(1, data, 1L)).toTsValues();

    // Assert
    TsValue tsValue = actualToTsValuesResult[0];
    assertEquals("42", tsValue.getValue());
    assertEquals(1, actualToTsValuesResult.length);
    assertEquals(1L, tsValue.getTs());
    assertEquals(3L, tsValue.getCount().longValue());
  }

  /**
   * Test {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}.
   * <ul>
   *   <li>Then return Count is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}
   */
  @Test
  @DisplayName("Test toTsValue(ReadTsKvQuery); then return Count is 'null'")
  void testToTsValue_thenReturnCountIsNull() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, data, 1L);

    // Act
    TsValue actualToTsValueResult = readTsKvQueryResult.toTsValue(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Assert
    assertEquals("42", actualToTsValueResult.getValue());
    assertNull(actualToTsValueResult.getCount());
    assertEquals(1L, actualToTsValueResult.getTs());
  }

  /**
   * Test {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}.
   * <ul>
   *   <li>Then return Count longValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}
   */
  @Test
  @DisplayName("Test toTsValue(ReadTsKvQuery); then return Count longValue is three")
  void testToTsValue_thenReturnCountLongValueIsThree() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L));
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, data, 1L);

    // Act
    TsValue actualToTsValueResult = readTsKvQueryResult.toTsValue(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Assert
    assertEquals("42", actualToTsValueResult.getValue());
    assertEquals(1L, actualToTsValueResult.getTs());
    assertEquals(3L, actualToTsValueResult.getCount().longValue());
  }

  /**
   * Test {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}.
   * <ul>
   *   <li>Then return {@link TsValue#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}
   */
  @Test
  @DisplayName("Test toTsValue(ReadTsKvQuery); then return EMPTY")
  void testToTsValue_thenReturnEmpty() {
    // Arrange
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, new ArrayList<>(), 1L);

    // Act
    TsValue actualToTsValueResult = readTsKvQueryResult.toTsValue(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Assert
    assertSame(actualToTsValueResult.EMPTY, actualToTsValueResult);
  }

  /**
   * Test {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}
   */
  @Test
  @DisplayName("Test toTsValue(ReadTsKvQuery); then throw RuntimeException")
  void testToTsValue_thenThrowRuntimeException() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, data, 1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> readTsKvQueryResult.toTsValue(new BaseReadTsKvQuery("Key", 1L, 1L)));
  }

  /**
   * Test {@link ReadTsKvQueryResult#equals(Object)}, and
   * {@link ReadTsKvQueryResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReadTsKvQueryResult#equals(Object)}
   *   <li>{@link ReadTsKvQueryResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, new ArrayList<>(), 1L);
    ReadTsKvQueryResult readTsKvQueryResult2 = new ReadTsKvQueryResult(1, new ArrayList<>(), 1L);

    // Act and Assert
    assertEquals(readTsKvQueryResult, readTsKvQueryResult2);
    int expectedHashCodeResult = readTsKvQueryResult.hashCode();
    assertEquals(expectedHashCodeResult, readTsKvQueryResult2.hashCode());
  }

  /**
   * Test {@link ReadTsKvQueryResult#equals(Object)}, and
   * {@link ReadTsKvQueryResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReadTsKvQueryResult#equals(Object)}
   *   <li>{@link ReadTsKvQueryResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, new ArrayList<>(), 1L);

    // Act and Assert
    assertEquals(readTsKvQueryResult, readTsKvQueryResult);
    int expectedHashCodeResult = readTsKvQueryResult.hashCode();
    assertEquals(expectedHashCodeResult, readTsKvQueryResult.hashCode());
  }

  /**
   * Test {@link ReadTsKvQueryResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(2, new ArrayList<>(), 1L);

    // Act and Assert
    assertNotEquals(readTsKvQueryResult, new ReadTsKvQueryResult(1, new ArrayList<>(), 1L));
  }

  /**
   * Test {@link ReadTsKvQueryResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, data, 1L);

    // Act and Assert
    assertNotEquals(readTsKvQueryResult, new ReadTsKvQueryResult(1, new ArrayList<>(), 1L));
  }

  /**
   * Test {@link ReadTsKvQueryResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, new ArrayList<>(), 3L);

    // Act and Assert
    assertNotEquals(readTsKvQueryResult, new ReadTsKvQueryResult(1, new ArrayList<>(), 1L));
  }

  /**
   * Test {@link ReadTsKvQueryResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(new BasicTsKvEntry(1L, mock(KvEntry.class)));
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, data, 1L);

    // Act and Assert
    assertNotEquals(readTsKvQueryResult, new ReadTsKvQueryResult(1, new ArrayList<>(), 1L));
  }

  /**
   * Test {@link ReadTsKvQueryResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReadTsKvQueryResult(1, new ArrayList<>(), 1L), null);
  }

  /**
   * Test {@link ReadTsKvQueryResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReadTsKvQueryResult(1, new ArrayList<>(), 1L), "Different type to ReadTsKvQueryResult");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReadTsKvQueryResult#ReadTsKvQueryResult(int, List, long)}
   *   <li>{@link ReadTsKvQueryResult#toString()}
   *   <li>{@link ReadTsKvQueryResult#getData()}
   *   <li>{@link ReadTsKvQueryResult#getLastEntryTs()}
   *   <li>{@link ReadTsKvQueryResult#getQueryId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();

    // Act
    ReadTsKvQueryResult actualReadTsKvQueryResult = new ReadTsKvQueryResult(1, data, 1L);
    String actualToStringResult = actualReadTsKvQueryResult.toString();
    List<TsKvEntry> actualData = actualReadTsKvQueryResult.getData();
    long actualLastEntryTs = actualReadTsKvQueryResult.getLastEntryTs();

    // Assert
    assertEquals("ReadTsKvQueryResult(queryId=1, data=[], lastEntryTs=1)", actualToStringResult);
    assertEquals(1, actualReadTsKvQueryResult.getQueryId());
    assertEquals(1L, actualLastEntryTs);
    assertTrue(actualData.isEmpty());
    assertSame(data, actualData);
  }
}
