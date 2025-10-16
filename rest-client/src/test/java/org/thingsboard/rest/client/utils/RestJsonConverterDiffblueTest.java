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
package org.thingsboard.rest.client.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;

class RestJsonConverterDiffblueTest {
  /**
   * Test {@link RestJsonConverter#toAttributes(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RestJsonConverter#toAttributes(List)}
   */
  @Test
  @DisplayName("Test toAttributes(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RestJsonConverter.toAttributes(List)"})
  void testToAttributes_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<AttributeKvEntry> actualToAttributesResult =
        RestJsonConverter.toAttributes(new ArrayList<>());

    // Assert
    assertTrue(actualToAttributesResult.isEmpty());
  }

  /**
   * Test {@link RestJsonConverter#toTimeseries(Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RestJsonConverter#toTimeseries(Map)}
   */
  @Test
  @DisplayName(
      "Test toTimeseries(Map); given '42'; when HashMap() '42' is ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RestJsonConverter.toTimeseries(Map)"})
  void testToTimeseries_given42_whenHashMap42IsArrayList_thenReturnEmpty() {
    // Arrange
    HashMap<String, List<JsonNode>> timeseries = new HashMap<>();
    timeseries.put("42", new ArrayList<>());
    timeseries.put("foo", new ArrayList<>());

    // Act
    List<TsKvEntry> actualToTimeseriesResult = RestJsonConverter.toTimeseries(timeseries);

    // Assert
    assertTrue(actualToTimeseriesResult.isEmpty());
  }

  /**
   * Test {@link RestJsonConverter#toTimeseries(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RestJsonConverter#toTimeseries(Map)}
   */
  @Test
  @DisplayName(
      "Test toTimeseries(Map); given ArrayList(); when HashMap() 'foo' is ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RestJsonConverter.toTimeseries(Map)"})
  void testToTimeseries_givenArrayList_whenHashMapFooIsArrayList_thenReturnEmpty() {
    // Arrange
    HashMap<String, List<JsonNode>> timeseries = new HashMap<>();
    timeseries.put("foo", new ArrayList<>());

    // Act
    List<TsKvEntry> actualToTimeseriesResult = RestJsonConverter.toTimeseries(timeseries);

    // Assert
    assertTrue(actualToTimeseriesResult.isEmpty());
  }

  /**
   * Test {@link RestJsonConverter#toTimeseries(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RestJsonConverter#toTimeseries(Map)}
   */
  @Test
  @DisplayName("Test toTimeseries(Map); when HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RestJsonConverter.toTimeseries(Map)"})
  void testToTimeseries_whenHashMap_thenReturnEmpty() {
    // Arrange and Act
    List<TsKvEntry> actualToTimeseriesResult = RestJsonConverter.toTimeseries(new HashMap<>());

    // Assert
    assertTrue(actualToTimeseriesResult.isEmpty());
  }
}
