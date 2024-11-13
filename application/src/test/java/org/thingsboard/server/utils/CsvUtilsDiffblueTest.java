package org.thingsboard.server.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CsvUtilsDiffblueTest {
  /**
   * Test {@link CsvUtils#parseCsv(String, Character)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return first first is {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvUtils#parseCsv(String, Character)}
   */
  @Test
  @DisplayName("Test parseCsv(String, Character); when 'A'; then return first first is 'Not all who wander are lost'")
  void testParseCsv_whenA_thenReturnFirstFirstIsNotAllWhoWanderAreLost() throws Exception {
    // Arrange and Act
    List<List<String>> actualParseCsvResult = CsvUtils.parseCsv("Not all who wander are lost", 'A');

    // Assert
    assertEquals(1, actualParseCsvResult.size());
    List<String> getResult = actualParseCsvResult.get(0);
    assertEquals(1, getResult.size());
    assertEquals("Not all who wander are lost", getResult.get(0));
  }

  /**
   * Test {@link CsvUtils#parseCsv(String, Character)}.
   * <ul>
   *   <li>When {@code a}.</li>
   *   <li>Then return first size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvUtils#parseCsv(String, Character)}
   */
  @Test
  @DisplayName("Test parseCsv(String, Character); when 'a'; then return first size is four")
  void testParseCsv_whenA_thenReturnFirstSizeIsFour() throws Exception {
    // Arrange and Act
    List<List<String>> actualParseCsvResult = CsvUtils.parseCsv("Not all who wander are lost", 'a');

    // Assert
    assertEquals(1, actualParseCsvResult.size());
    List<String> getResult = actualParseCsvResult.get(0);
    assertEquals(4, getResult.size());
    assertEquals("Not ", getResult.get(0));
    assertEquals("ll who w", getResult.get(1));
    assertEquals("nder ", getResult.get(2));
    assertEquals("re lost", getResult.get(3));
  }

  /**
   * Test {@link CsvUtils#parseCsv(String, Character)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then return first first is {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvUtils#parseCsv(String, Character)}
   */
  @Test
  @DisplayName("Test parseCsv(String, Character); when ','; then return first first is 'Not all who wander are lost'")
  void testParseCsv_whenComma_thenReturnFirstFirstIsNotAllWhoWanderAreLost() throws Exception {
    // Arrange and Act
    List<List<String>> actualParseCsvResult = CsvUtils.parseCsv("Not all who wander are lost", ',');

    // Assert
    assertEquals(1, actualParseCsvResult.size());
    List<String> getResult = actualParseCsvResult.get(0);
    assertEquals(1, getResult.size());
    assertEquals("Not all who wander are lost", getResult.get(0));
  }

  /**
   * Test {@link CsvUtils#parseCsv(String, Character)}.
   * <ul>
   *   <li>When {@code Content}.</li>
   *   <li>Then return first first is {@code Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvUtils#parseCsv(String, Character)}
   */
  @Test
  @DisplayName("Test parseCsv(String, Character); when 'Content'; then return first first is 'Content'")
  void testParseCsv_whenContent_thenReturnFirstFirstIsContent() throws Exception {
    // Arrange and Act
    List<List<String>> actualParseCsvResult = CsvUtils.parseCsv("Content", 'A');

    // Assert
    assertEquals(1, actualParseCsvResult.size());
    List<String> getResult = actualParseCsvResult.get(0);
    assertEquals(1, getResult.size());
    assertEquals("Content", getResult.get(0));
  }

  /**
   * Test {@link CsvUtils#parseCsv(String, Character)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvUtils#parseCsv(String, Character)}
   */
  @Test
  @DisplayName("Test parseCsv(String, Character); when empty string; then return Empty")
  void testParseCsv_whenEmptyString_thenReturnEmpty() throws Exception {
    // Arrange and Act
    List<List<String>> actualParseCsvResult = CsvUtils.parseCsv("", 'A');

    // Assert
    assertTrue(actualParseCsvResult.isEmpty());
  }
}
