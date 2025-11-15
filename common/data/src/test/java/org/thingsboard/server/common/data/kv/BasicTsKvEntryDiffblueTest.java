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
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.query.TsValue;

class BasicTsKvEntryDiffblueTest {
  /**
   * Method under test: {@link BasicTsKvEntry#getKey()}
   */
  @Test
  void testGetKey() {
    // Arrange, Act and Assert
    assertEquals("Key", (new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getKey());
    assertEquals("Key", (new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getKey());
  }

  /**
   * Method under test: {@link BasicTsKvEntry#getDataType()}
   */
  @Test
  void testGetDataType() {
    // Arrange, Act and Assert
    assertEquals(DataType.JSON, (new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getDataType());
    assertEquals(DataType.JSON,
        (new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getDataType());
  }

  /**
   * Method under test: {@link BasicTsKvEntry#getStrValue()}
   */
  @Test
  void testGetStrValue() {
    // Arrange, Act and Assert
    assertFalse((new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getStrValue().isPresent());
    assertFalse(
        (new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getStrValue().isPresent());
  }

  /**
   * Method under test: {@link BasicTsKvEntry#getLongValue()}
   */
  @Test
  void testGetLongValue() {
    // Arrange, Act and Assert
    assertFalse((new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getLongValue().isPresent());
    assertFalse(
        (new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getLongValue().isPresent());
  }

  /**
   * Method under test: {@link BasicTsKvEntry#getBooleanValue()}
   */
  @Test
  void testGetBooleanValue() {
    // Arrange, Act and Assert
    assertFalse((new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getBooleanValue().isPresent());
    assertFalse((new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getBooleanValue()
        .isPresent());
  }

  /**
   * Method under test: {@link BasicTsKvEntry#getDoubleValue()}
   */
  @Test
  void testGetDoubleValue() {
    // Arrange, Act and Assert
    assertFalse((new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getDoubleValue().isPresent());
    assertFalse((new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getDoubleValue()
        .isPresent());
  }

  /**
   * Method under test: {@link BasicTsKvEntry#getJsonValue()}
   */
  @Test
  void testGetJsonValue() {
    // Arrange and Act
    Optional<String> actualJsonValue = (new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getJsonValue();

    // Assert
    assertEquals("42", actualJsonValue.get());
    assertTrue(actualJsonValue.isPresent());
  }

  /**
   * Method under test: {@link BasicTsKvEntry#getJsonValue()}
   */
  @Test
  void testGetJsonValue2() {
    // Arrange and Act
    Optional<String> actualJsonValue = (new BasicTsKvEntry(1L,
        new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getJsonValue();

    // Assert
    assertEquals("42", actualJsonValue.get());
    assertTrue(actualJsonValue.isPresent());
  }

  /**
   * Method under test: {@link BasicTsKvEntry#getValue()}
   */
  @Test
  void testGetValue() {
    // Arrange, Act and Assert
    assertEquals("42", (new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getValue());
    assertEquals("42", (new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getValue());
  }

  /**
   * Method under test: {@link BasicTsKvEntry#getValueAsString()}
   */
  @Test
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals("42", (new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getValueAsString());
    assertEquals("42",
        (new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getValueAsString());
  }

  /**
   * Method under test: {@link BasicTsKvEntry#getDataPoints()}
   */
  @Test
  void testGetDataPoints() {
    // Arrange, Act and Assert
    assertEquals(1, (new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))).getDataPoints());
    assertEquals(1, (new BasicTsKvEntry(1L, new StringDataEntry("Key", "42"))).getDataPoints());
    assertEquals(1, (new BasicTsKvEntry(2L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L))).getDataPoints());
    assertEquals(1,
        (new BasicTsKvEntry(2L, new AggTsKvEntry(1L, new StringDataEntry("Key", "42"), 3L))).getDataPoints());
    assertEquals(1, (new BasicTsKvEntry(2L, new BooleanDataEntry("Key", true))).getDataPoints());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BasicTsKvEntry#equals(Object)}
   *   <li>{@link BasicTsKvEntry#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link BasicTsKvEntry#equals(Object)}
   *   <li>{@link BasicTsKvEntry#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link BasicTsKvEntry#equals(Object)}
   *   <li>{@link BasicTsKvEntry#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertEquals(basicTsKvEntry, basicTsKvEntry);
    int expectedHashCodeResult = basicTsKvEntry.hashCode();
    assertEquals(expectedHashCodeResult, basicTsKvEntry.hashCode());
  }

  /**
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(3L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry(null, "42"));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, null);

    // Act and Assert
    assertNotEquals(basicTsKvEntry, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, mock(AggTsKvEntry.class));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"), 1L);

    // Act and Assert
    assertNotEquals(basicTsKvEntry, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertNotEquals(basicTsKvEntry, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"), 1L));
  }

  /**
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
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
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), null);
  }

  /**
   * Method under test: {@link BasicTsKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")), "Different type to BasicTsKvEntry");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BasicTsKvEntry#toString()}
   *   <li>{@link BasicTsKvEntry#getKv()}
   *   <li>{@link BasicTsKvEntry#getTs()}
   *   <li>{@link BasicTsKvEntry#getVersion()}
   * </ul>
   */
  @Test
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

  /**
   * Method under test: {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)}
   */
  @Test
  void testNewBasicTsKvEntry() {
    // Arrange
    JsonDataEntry kv = new JsonDataEntry("Key", "42");

    // Act
    BasicTsKvEntry actualBasicTsKvEntry = new BasicTsKvEntry(1L, kv);

    // Assert
    Optional<String> jsonValue = actualBasicTsKvEntry.getJsonValue();
    assertEquals("42", jsonValue.get());
    assertEquals("42", actualBasicTsKvEntry.getValueAsString());
    TsValue toTsValueResult = actualBasicTsKvEntry.toTsValue();
    assertEquals("42", toTsValueResult.getValue());
    assertEquals("42", actualBasicTsKvEntry.getValue());
    assertEquals("Key", actualBasicTsKvEntry.getKey());
    assertNull(actualBasicTsKvEntry.getVersion());
    assertNull(toTsValueResult.getCount());
    assertEquals(1, actualBasicTsKvEntry.getDataPoints());
    assertEquals(1L, actualBasicTsKvEntry.getTs());
    assertEquals(1L, toTsValueResult.getTs());
    assertEquals(DataType.JSON, actualBasicTsKvEntry.getDataType());
    Optional<Boolean> booleanValue = actualBasicTsKvEntry.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(jsonValue.isPresent());
    assertSame(kv, actualBasicTsKvEntry.getKv());
    assertSame(booleanValue, actualBasicTsKvEntry.getDoubleValue());
    assertSame(booleanValue, actualBasicTsKvEntry.getLongValue());
    assertSame(booleanValue, actualBasicTsKvEntry.getStrValue());
  }

  /**
   * Method under test: {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry, Long)}
   */
  @Test
  void testNewBasicTsKvEntry2() {
    // Arrange
    JsonDataEntry kv = new JsonDataEntry("Key", "42");

    // Act
    BasicTsKvEntry actualBasicTsKvEntry = new BasicTsKvEntry(1L, kv, 1L);

    // Assert
    Optional<String> jsonValue = actualBasicTsKvEntry.getJsonValue();
    assertEquals("42", jsonValue.get());
    assertEquals("42", actualBasicTsKvEntry.getValueAsString());
    TsValue toTsValueResult = actualBasicTsKvEntry.toTsValue();
    assertEquals("42", toTsValueResult.getValue());
    assertEquals("42", actualBasicTsKvEntry.getValue());
    assertEquals("Key", actualBasicTsKvEntry.getKey());
    assertNull(toTsValueResult.getCount());
    assertEquals(1, actualBasicTsKvEntry.getDataPoints());
    assertEquals(1L, actualBasicTsKvEntry.getVersion().longValue());
    assertEquals(1L, actualBasicTsKvEntry.getTs());
    assertEquals(1L, toTsValueResult.getTs());
    assertEquals(DataType.JSON, actualBasicTsKvEntry.getDataType());
    Optional<Boolean> booleanValue = actualBasicTsKvEntry.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(jsonValue.isPresent());
    assertSame(kv, actualBasicTsKvEntry.getKv());
    assertSame(booleanValue, actualBasicTsKvEntry.getDoubleValue());
    assertSame(booleanValue, actualBasicTsKvEntry.getLongValue());
    assertSame(booleanValue, actualBasicTsKvEntry.getStrValue());
  }
}
