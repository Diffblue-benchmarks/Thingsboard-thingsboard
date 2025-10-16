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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.TsValue;

class ReadTsKvQueryResultDiffblueTest {
  /**
   * Test {@link ReadTsKvQueryResult#toTsValues()}.
   *
   * <p>Method under test: {@link ReadTsKvQueryResult#toTsValues()}
   */
  @Test
  @DisplayName("Test toTsValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsValue[] ReadTsKvQueryResult.toTsValues()"})
  void testToTsValues() {
    // Arrange
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, null, 1L);

    // Act and Assert
    assertEquals(0, readTsKvQueryResult.toTsValues().length);
  }

  /**
   * Test {@link ReadTsKvQueryResult#toTsValues()}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link ReadTsKvQueryResult#toTsValues()}
   */
  @Test
  @DisplayName("Test toTsValues(); then return array length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsValue[] ReadTsKvQueryResult.toTsValues()"})
  void testToTsValues_thenReturnArrayLengthIsZero() {
    // Arrange
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, new ArrayList<>(), 1L);

    // Act and Assert
    assertEquals(0, readTsKvQueryResult.toTsValues().length);
  }

  /**
   * Test {@link ReadTsKvQueryResult#toTsValues()}.
   *
   * <ul>
   *   <li>Then return first element Count is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReadTsKvQueryResult#toTsValues()}
   */
  @Test
  @DisplayName("Test toTsValues(); then return first element Count is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsValue[] ReadTsKvQueryResult.toTsValues()"})
  void testToTsValues_thenReturnFirstElementCountIsNull() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    data.add(basicTsKvEntry);
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, data, 1L);

    // Act
    TsValue[] actualToTsValuesResult = readTsKvQueryResult.toTsValues();

    // Assert
    TsValue tsValue = actualToTsValuesResult[0];
    assertEquals("42", tsValue.getValue());
    assertNull(tsValue.getCount());
    assertEquals(1, actualToTsValuesResult.length);
    assertEquals(1L, tsValue.getTs());
  }

  /**
   * Test {@link ReadTsKvQueryResult#toTsValues()}.
   *
   * <ul>
   *   <li>Then return first element Count longValue is three.
   * </ul>
   *
   * <p>Method under test: {@link ReadTsKvQueryResult#toTsValues()}
   */
  @Test
  @DisplayName("Test toTsValues(); then return first element Count longValue is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsValue[] ReadTsKvQueryResult.toTsValues()"})
  void testToTsValues_thenReturnFirstElementCountLongValueIsThree() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    AggTsKvEntry aggTsKvEntry = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);
    data.add(aggTsKvEntry);
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, data, 1L);

    // Act
    TsValue[] actualToTsValuesResult = readTsKvQueryResult.toTsValues();

    // Assert
    TsValue tsValue = actualToTsValuesResult[0];
    assertEquals("42", tsValue.getValue());
    assertEquals(1, actualToTsValuesResult.length);
    assertEquals(1L, tsValue.getTs());
    assertEquals(3L, tsValue.getCount().longValue());
  }

  /**
   * Test {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}.
   *
   * <p>Method under test: {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}
   */
  @Test
  @DisplayName("Test toTsValue(ReadTsKvQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsValue ReadTsKvQueryResult.toTsValue(ReadTsKvQuery)"})
  void testToTsValue() {
    // Arrange
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, null, 1L);

    // Act
    TsValue actualToTsValueResult =
        readTsKvQueryResult.toTsValue(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Assert
    assertSame(TsValue.EMPTY, actualToTsValueResult);
  }

  /**
   * Test {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}.
   *
   * <ul>
   *   <li>Then return Count is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}
   */
  @Test
  @DisplayName("Test toTsValue(ReadTsKvQuery); then return Count is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsValue ReadTsKvQueryResult.toTsValue(ReadTsKvQuery)"})
  void testToTsValue_thenReturnCountIsNull() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    data.add(basicTsKvEntry);
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, data, 1L);

    // Act
    TsValue actualToTsValueResult =
        readTsKvQueryResult.toTsValue(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Assert
    assertEquals("42", actualToTsValueResult.getValue());
    assertNull(actualToTsValueResult.getCount());
    assertEquals(1L, actualToTsValueResult.getTs());
  }

  /**
   * Test {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}.
   *
   * <ul>
   *   <li>Then return Count longValue is three.
   * </ul>
   *
   * <p>Method under test: {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}
   */
  @Test
  @DisplayName("Test toTsValue(ReadTsKvQuery); then return Count longValue is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsValue ReadTsKvQueryResult.toTsValue(ReadTsKvQuery)"})
  void testToTsValue_thenReturnCountLongValueIsThree() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    AggTsKvEntry aggTsKvEntry = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);
    data.add(aggTsKvEntry);
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, data, 1L);

    // Act
    TsValue actualToTsValueResult =
        readTsKvQueryResult.toTsValue(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Assert
    assertEquals("42", actualToTsValueResult.getValue());
    assertEquals(1L, actualToTsValueResult.getTs());
    assertEquals(3L, actualToTsValueResult.getCount().longValue());
  }

  /**
   * Test {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}.
   *
   * <ul>
   *   <li>Then return {@link TsValue#EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}
   */
  @Test
  @DisplayName("Test toTsValue(ReadTsKvQuery); then return EMPTY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsValue ReadTsKvQueryResult.toTsValue(ReadTsKvQuery)"})
  void testToTsValue_thenReturnEmpty() {
    // Arrange
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, new ArrayList<>(), 1L);

    // Act
    TsValue actualToTsValueResult =
        readTsKvQueryResult.toTsValue(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Assert
    assertSame(TsValue.EMPTY, actualToTsValueResult);
  }

  /**
   * Test {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}
   */
  @Test
  @DisplayName("Test toTsValue(ReadTsKvQuery); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsValue ReadTsKvQueryResult.toTsValue(ReadTsKvQuery)"})
  void testToTsValue_thenThrowRuntimeException() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    data.add(basicTsKvEntry);
    BasicTsKvEntry basicTsKvEntry2 = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    data.add(basicTsKvEntry2);
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, data, 1L);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> readTsKvQueryResult.toTsValue(new BaseReadTsKvQuery("Key", 1L, 1L)));
  }

  /**
   * Test {@link ReadTsKvQueryResult#equals(Object)}, and {@link ReadTsKvQueryResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReadTsKvQueryResult#equals(Object)}
   *   <li>{@link ReadTsKvQueryResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReadTsKvQueryResult.equals(Object)",
    "int ReadTsKvQueryResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, new ArrayList<>(), 1L);
    ReadTsKvQueryResult readTsKvQueryResult2 = new ReadTsKvQueryResult(1, new ArrayList<>(), 1L);

    // Act and Assert
    assertEquals(readTsKvQueryResult, readTsKvQueryResult2);
    assertEquals(readTsKvQueryResult.hashCode(), readTsKvQueryResult2.hashCode());
  }

  /**
   * Test {@link ReadTsKvQueryResult#equals(Object)}, and {@link ReadTsKvQueryResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReadTsKvQueryResult#equals(Object)}
   *   <li>{@link ReadTsKvQueryResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReadTsKvQueryResult.equals(Object)",
    "int ReadTsKvQueryResult.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReadTsKvQueryResult.equals(Object)",
    "int ReadTsKvQueryResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(2, new ArrayList<>(), 1L);

    // Act and Assert
    assertNotEquals(readTsKvQueryResult, new ReadTsKvQueryResult(1, new ArrayList<>(), 1L));
  }

  /**
   * Test {@link ReadTsKvQueryResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReadTsKvQueryResult.equals(Object)",
    "int ReadTsKvQueryResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    data.add(basicTsKvEntry);
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, data, 1L);

    // Act and Assert
    assertNotEquals(readTsKvQueryResult, new ReadTsKvQueryResult(1, new ArrayList<>(), 1L));
  }

  /**
   * Test {@link ReadTsKvQueryResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReadTsKvQueryResult.equals(Object)",
    "int ReadTsKvQueryResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, new ArrayList<>(), 3L);

    // Act and Assert
    assertNotEquals(readTsKvQueryResult, new ReadTsKvQueryResult(1, new ArrayList<>(), 1L));
  }

  /**
   * Test {@link ReadTsKvQueryResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReadTsKvQueryResult.equals(Object)",
    "int ReadTsKvQueryResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReadTsKvQueryResult(1, new ArrayList<>(), 1L), null);
  }

  /**
   * Test {@link ReadTsKvQueryResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReadTsKvQueryResult.equals(Object)",
    "int ReadTsKvQueryResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ReadTsKvQueryResult(1, new ArrayList<>(), 1L), "Different type to ReadTsKvQueryResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReadTsKvQueryResult.<init>(int, List, long)",
    "List ReadTsKvQueryResult.getData()",
    "long ReadTsKvQueryResult.getLastEntryTs()",
    "int ReadTsKvQueryResult.getQueryId()",
    "String ReadTsKvQueryResult.toString()"
  })
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
