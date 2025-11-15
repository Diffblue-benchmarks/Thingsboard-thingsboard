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
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.TsValue;

class ReadTsKvQueryResultDiffblueTest {
  /**
   * Method under test: {@link ReadTsKvQueryResult#toTsValues()}
   */
  @Test
  void testToTsValues() {
    // Arrange, Act and Assert
    assertEquals(0, (new ReadTsKvQueryResult(1, new ArrayList<>(), 1L)).toTsValues().length);
  }

  /**
   * Method under test: {@link ReadTsKvQueryResult#toTsValues()}
   */
  @Test
  void testToTsValues2() {
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
   * Method under test: {@link ReadTsKvQueryResult#toTsValues()}
   */
  @Test
  void testToTsValues3() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link ReadTsKvQueryResult#equals(Object)}
   *   <li>{@link ReadTsKvQueryResult#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}
   */
  @Test
  void testToTsValue() {
    // Arrange
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, new ArrayList<>(), 1L);

    // Act
    TsValue actualToTsValueResult = readTsKvQueryResult.toTsValue(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Assert
    assertSame(actualToTsValueResult.EMPTY, actualToTsValueResult);
  }

  /**
   * Method under test: {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}
   */
  @Test
  void testToTsValue2() {
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
   * Method under test: {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}
   */
  @Test
  void testToTsValue3() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, data, 1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> readTsKvQueryResult.toTsValue(new BaseReadTsKvQuery("Key", 1L, 1L)));
  }

  /**
   * Method under test: {@link ReadTsKvQueryResult#toTsValue(ReadTsKvQuery)}
   */
  @Test
  void testToTsValue4() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link ReadTsKvQueryResult#equals(Object)}
   *   <li>{@link ReadTsKvQueryResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, new ArrayList<>(), 1L);

    // Act and Assert
    assertEquals(readTsKvQueryResult, readTsKvQueryResult);
    int expectedHashCodeResult = readTsKvQueryResult.hashCode();
    assertEquals(expectedHashCodeResult, readTsKvQueryResult.hashCode());
  }

  /**
   * Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(2, new ArrayList<>(), 1L);

    // Act and Assert
    assertNotEquals(readTsKvQueryResult, new ReadTsKvQueryResult(1, new ArrayList<>(), 1L));
  }

  /**
   * Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, data, 1L);

    // Act and Assert
    assertNotEquals(readTsKvQueryResult, new ReadTsKvQueryResult(1, new ArrayList<>(), 1L));
  }

  /**
   * Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, new ArrayList<>(), 3L);

    // Act and Assert
    assertNotEquals(readTsKvQueryResult, new ReadTsKvQueryResult(1, new ArrayList<>(), 1L));
  }

  /**
   * Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(new BasicTsKvEntry(1L, mock(KvEntry.class)));
    ReadTsKvQueryResult readTsKvQueryResult = new ReadTsKvQueryResult(1, data, 1L);

    // Act and Assert
    assertNotEquals(readTsKvQueryResult, new ReadTsKvQueryResult(1, new ArrayList<>(), 1L));
  }

  /**
   * Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReadTsKvQueryResult(1, new ArrayList<>(), 1L), null);
  }

  /**
   * Method under test: {@link ReadTsKvQueryResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReadTsKvQueryResult(1, new ArrayList<>(), 1L), "Different type to ReadTsKvQueryResult");
  }

  /**
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
