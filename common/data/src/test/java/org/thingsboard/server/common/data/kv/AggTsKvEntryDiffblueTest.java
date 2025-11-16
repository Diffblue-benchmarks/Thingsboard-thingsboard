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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.TsValue;

class AggTsKvEntryDiffblueTest {
  /**
   * Test {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)}.
   *
   * <p>Method under test: {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)}
   */
  @Test
  @DisplayName("Test new AggTsKvEntry(long, KvEntry, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AggTsKvEntry.<init>(long, KvEntry, long)"})
  void testNewAggTsKvEntry() {
    // Arrange
    JsonDataEntry kv = new JsonDataEntry("Key", "42");

    // Act
    AggTsKvEntry actualAggTsKvEntry = new AggTsKvEntry(1L, kv, 3L);

    // Assert
    KvEntry kv2 = actualAggTsKvEntry.getKv();
    assertTrue(kv2 instanceof JsonDataEntry);
    assertEquals("42", actualAggTsKvEntry.getValueAsString());
    assertEquals("42", actualAggTsKvEntry.getValue());
    assertEquals("Key", actualAggTsKvEntry.getKey());
    assertNull(actualAggTsKvEntry.getVersion());
    assertEquals(1, actualAggTsKvEntry.getDataPoints());
    assertEquals(1L, actualAggTsKvEntry.getTs());
    assertEquals(DataType.JSON, actualAggTsKvEntry.getDataType());
    Optional<Boolean> booleanValue = actualAggTsKvEntry.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertSame(kv, kv2);
    assertSame(booleanValue, actualAggTsKvEntry.getDoubleValue());
    assertSame(booleanValue, actualAggTsKvEntry.getLongValue());
    assertSame(booleanValue, actualAggTsKvEntry.getStrValue());
  }

  /**
   * Test {@link AggTsKvEntry#toTsValue()}.
   *
   * <ul>
   *   <li>Given {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)} with ts is one and kv is
   *       {@link AggTsKvEntry#AggTsKvEntry(long, KvEntry, long)} and count is three.
   * </ul>
   *
   * <p>Method under test: {@link AggTsKvEntry#toTsValue()}
   */
  @Test
  @DisplayName(
      "Test toTsValue(); given AggTsKvEntry(long, KvEntry, long) with ts is one and kv is AggTsKvEntry(long, KvEntry, long) and count is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsValue AggTsKvEntry.toTsValue()"})
  void testToTsValue_givenAggTsKvEntryWithTsIsOneAndKvIsAggTsKvEntryAndCountIsThree() {
    // Arrange
    AggTsKvEntry kv = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);
    AggTsKvEntry aggTsKvEntry = new AggTsKvEntry(1L, kv, 3L);

    // Act
    TsValue actualToTsValueResult = aggTsKvEntry.toTsValue();

    // Assert
    assertEquals("42", actualToTsValueResult.getValue());
    assertEquals(1L, actualToTsValueResult.getTs());
    assertEquals(3L, actualToTsValueResult.getCount().longValue());
  }

  /**
   * Test {@link AggTsKvEntry#toTsValue()}.
   *
   * <ul>
   *   <li>Then return Ts is one.
   * </ul>
   *
   * <p>Method under test: {@link AggTsKvEntry#toTsValue()}
   */
  @Test
  @DisplayName("Test toTsValue(); then return Ts is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsValue AggTsKvEntry.toTsValue()"})
  void testToTsValue_thenReturnTsIsOne() {
    // Arrange
    AggTsKvEntry aggTsKvEntry = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);

    // Act
    TsValue actualToTsValueResult = aggTsKvEntry.toTsValue();

    // Assert
    assertEquals("42", actualToTsValueResult.getValue());
    assertEquals(1L, actualToTsValueResult.getTs());
    assertEquals(3L, actualToTsValueResult.getCount().longValue());
  }

  /**
   * Test {@link AggTsKvEntry#toTsValue()}.
   *
   * <ul>
   *   <li>Then return Ts is zero.
   * </ul>
   *
   * <p>Method under test: {@link AggTsKvEntry#toTsValue()}
   */
  @Test
  @DisplayName("Test toTsValue(); then return Ts is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsValue AggTsKvEntry.toTsValue()"})
  void testToTsValue_thenReturnTsIsZero() {
    // Arrange
    AggTsKvEntry aggTsKvEntry = new AggTsKvEntry(0L, new JsonDataEntry("Key", "42"), 3L);

    // Act
    TsValue actualToTsValueResult = aggTsKvEntry.toTsValue();

    // Assert
    assertEquals("42", actualToTsValueResult.getValue());
    assertEquals(0L, actualToTsValueResult.getTs());
    assertEquals(3L, actualToTsValueResult.getCount().longValue());
  }

  /**
   * Test {@link AggTsKvEntry#toString()}.
   *
   * <p>Method under test: {@link AggTsKvEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AggTsKvEntry.toString()"})
  void testToString() {
    // Arrange
    AggTsKvEntry aggTsKvEntry = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);

    // Act and Assert
    assertEquals("AggTsKvEntry(count=3)", aggTsKvEntry.toString());
  }
}
