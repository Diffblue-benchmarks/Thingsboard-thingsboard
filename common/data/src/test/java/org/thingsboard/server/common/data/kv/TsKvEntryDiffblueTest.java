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
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.TsValue;

class TsKvEntryDiffblueTest {
  /**
   * Test {@link TsKvEntry#toTsValue()}.
   *
   * <ul>
   *   <li>Then return Count is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntry#toTsValue()}
   */
  @Test
  @DisplayName("Test toTsValue(); then return Count is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsValue TsKvEntry.toTsValue()"})
  void testToTsValue_thenReturnCountIsNull() {
    // Arrange
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act
    TsValue actualToTsValueResult = basicTsKvEntry.toTsValue();

    // Assert
    assertEquals("42", actualToTsValueResult.getValue());
    assertNull(actualToTsValueResult.getCount());
    assertEquals(1L, actualToTsValueResult.getTs());
  }

  /**
   * Test {@link TsKvEntry#toTsValue()}.
   *
   * <ul>
   *   <li>Then return Count longValue is three.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntry#toTsValue()}
   */
  @Test
  @DisplayName("Test toTsValue(); then return Count longValue is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TsValue TsKvEntry.toTsValue()"})
  void testToTsValue_thenReturnCountLongValueIsThree() {
    // Arrange
    AggTsKvEntry aggTsKvEntry = new AggTsKvEntry(1L, new JsonDataEntry("Key", "42"), 3L);

    // Act
    TsValue actualToTsValueResult = aggTsKvEntry.toTsValue();

    // Assert
    assertEquals("42", actualToTsValueResult.getValue());
    assertEquals(1L, actualToTsValueResult.getTs());
    assertEquals(3L, actualToTsValueResult.getCount().longValue());
  }
}
