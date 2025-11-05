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
    timeseries.put("Key", new ArrayList<>());

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
   *   <li>When {@link HashMap#HashMap()} {@code Key} is {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RestJsonConverter#toTimeseries(Map)}
   */
  @Test
  @DisplayName(
      "Test toTimeseries(Map); given ArrayList(); when HashMap() 'Key' is ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RestJsonConverter.toTimeseries(Map)"})
  void testToTimeseries_givenArrayList_whenHashMapKeyIsArrayList_thenReturnEmpty() {
    // Arrange
    HashMap<String, List<JsonNode>> timeseries = new HashMap<>();
    timeseries.put("Key", new ArrayList<>());

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
