package org.thingsboard.script.api.tbel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mvel2.ConversionException;

class TbDateDiffblueTest {
  /**
   * Test {@link TbDate#TbDate()}.
   * <p>
   * Method under test: {@link TbDate#TbDate()}
   */
  @Test
  @DisplayName("Test new TbDate()")
  void testNewTbDate() {
    // Arrange, Act and Assert
    assertEquals("UTC", (new TbDate()).getZonedDateTime().getZone().toString());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int)}.
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int)")
  void testNewTbDate2() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(100, 1, 1);

    // Assert
    assertEquals("0100-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("0100-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(100, actualTbDate.getUTCFullYear());
    assertEquals(5, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int)}.
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int)")
  void testNewTbDate3() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(100, 1, 1, 1, 1);

    // Assert
    assertEquals("0100-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("0100-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("0100-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toDateString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toLocaleDateString());
    assertEquals(100, actualTbDate.getFullYear());
    assertEquals(100, actualTbDate.getUTCFullYear());
    assertEquals(5, actualTbDate.getDay());
    assertEquals(5, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int)}.
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, int)")
  void testNewTbDate4() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(100, 1, 1, 1, 1, 1);

    // Assert
    assertEquals("0100-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("0100-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("0100-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toDateString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toLocaleDateString());
    assertEquals(100, actualTbDate.getFullYear());
    assertEquals(100, actualTbDate.getUTCFullYear());
    assertEquals(5, actualTbDate.getDay());
    assertEquals(5, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, int)}.
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, int, int)")
  void testNewTbDate5() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(100, 1, 1, 1, 1, 1, 1);

    // Assert
    assertEquals("0100-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("0100-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("0100-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toDateString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toLocaleDateString());
    assertEquals(100, actualTbDate.getFullYear());
    assertEquals(100, actualTbDate.getUTCFullYear());
    assertEquals(5, actualTbDate.getDay());
    assertEquals(5, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, int, String)}.
   * <p>
   * Method under test:
   * {@link TbDate#TbDate(int, int, int, int, int, int, int, String)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, int, int, String)")
  void testNewTbDate6() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(100, 1, 1, 1, 1, 1, 1, null);

    // Assert
    assertEquals("0100-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("0100-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("0100-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toDateString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toLocaleDateString());
    assertEquals(100, actualTbDate.getFullYear());
    assertEquals(100, actualTbDate.getUTCFullYear());
    assertEquals(5, actualTbDate.getDay());
    assertEquals(5, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, String)}.
   * <p>
   * Method under test:
   * {@link TbDate#TbDate(int, int, int, int, int, int, String)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, int, String)")
  void testNewTbDate7() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(100, 1, 1, 1, 1, 1, null);

    // Assert
    assertEquals("0100-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("0100-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("0100-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toDateString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toLocaleDateString());
    assertEquals(100, actualTbDate.getFullYear());
    assertEquals(100, actualTbDate.getUTCFullYear());
    assertEquals(5, actualTbDate.getDay());
    assertEquals(5, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, String)}.
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int, int, int, String)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, String)")
  void testNewTbDate8() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(100, 1, 1, 1, 1, null);

    // Assert
    assertEquals("0100-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("0100-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("0100-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toDateString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toLocaleDateString());
    assertEquals(100, actualTbDate.getFullYear());
    assertEquals(100, actualTbDate.getUTCFullYear());
    assertEquals(5, actualTbDate.getDay());
    assertEquals(5, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, String)}.
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int, String)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, String)")
  void testNewTbDate9() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(100, 1, 1, null);

    // Assert
    assertEquals("0100-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("0100-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(100, actualTbDate.getUTCFullYear());
    assertEquals(5, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(long)}.
   * <p>
   * Method under test: {@link TbDate#TbDate(long)}
   */
  @Test
  @DisplayName("Test new TbDate(long)")
  void testNewTbDate10() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1L);

    // Assert
    ZonedDateTime zonedDateTime = actualTbDate.getZonedDateTime();
    LocalDateTime toLocalDateTimeResult = zonedDateTime.toLocalDateTime();
    assertEquals("00:00:00.001", toLocalDateTimeResult.toLocalTime().toString());
    LocalDateTime uTCDateTime = actualTbDate.getUTCDateTime();
    assertEquals("00:00:00.001", uTCDateTime.toLocalTime().toString());
    assertEquals("1970 Jan 1, Thu 00:00:00", actualTbDate.toUTCString());
    assertEquals("1970 Jan 1, Thu", actualTbDate.toDateString());
    assertEquals("1970 Jan 1, Thu", actualTbDate.toLocaleDateString());
    assertEquals("1970-01-01", toLocalDateTimeResult.toLocalDate().toString());
    assertEquals("1970-01-01", uTCDateTime.toLocalDate().toString());
    assertEquals("1970-01-01T00:00:00.001Z", actualTbDate.toISOString());
    assertEquals("1970-01-01T00:00:00.001Z", actualTbDate.toJSON());
    assertEquals("UTC", zonedDateTime.getZone().toString());
    assertEquals(0, actualTbDate.getMinutes());
    assertEquals(0, actualTbDate.getSeconds());
    assertEquals(0, actualTbDate.getUTCHours());
    assertEquals(0, actualTbDate.getUTCMinutes());
    assertEquals(0, actualTbDate.getUTCSeconds());
    Instant instant = actualTbDate.getInstant();
    assertEquals(0L, instant.getEpochSecond());
    assertEquals(1, actualTbDate.getMilliseconds());
    assertEquals(1, actualTbDate.getUTCDate());
    assertEquals(1, actualTbDate.getUTCMilliseconds());
    assertEquals(1, actualTbDate.getUTCMonth());
    assertEquals(1000000, instant.getNano());
    assertEquals(1970, actualTbDate.getUTCFullYear());
    assertEquals(1L, actualTbDate.getTime());
    assertEquals(4, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(String)}
   */
  @Test
  @DisplayName("Test new TbDate(String); when '42'")
  void testNewTbDate_when42() {
    // Arrange, Act and Assert
    assertThrows(ConversionException.class, () -> new TbDate("42"));
  }

  /**
   * Test {@link TbDate#TbDate(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link ConversionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(String, String)}
   */
  @Test
  @DisplayName("Test new TbDate(String, String); when '42'; then throw ConversionException")
  void testNewTbDate_when42_thenThrowConversionException() {
    // Arrange, Act and Assert
    assertThrows(ConversionException.class, () -> new TbDate("42", "42"));

    assertThrows(ConversionException.class, () -> new TbDate("42", "42", "en"));
  }

  /**
   * Test {@link TbDate#TbDate(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(String)}
   */
  @Test
  @DisplayName("Test new TbDate(String); when empty string")
  void testNewTbDate_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(ConversionException.class, () -> new TbDate(""));
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, int, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return toDateString is {@code 2001 Jan 1, Mon}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDate#TbDate(int, int, int, int, int, int, int, String)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, int, int, String); when empty string; then return toDateString is '2001 Jan 1, Mon'")
  void testNewTbDate_whenEmptyString_thenReturnToDateStringIs2001Jan1Mon() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1, 1, 1, 1, 1, 1, 1, "");

    // Assert
    assertEquals("2001 Jan 1, Mon", actualTbDate.toDateString());
    assertEquals("2001 Jan 1, Mon", actualTbDate.toLocaleDateString());
    assertEquals("2001-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("2001-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("2001-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(1, actualTbDate.getDay());
    assertEquals(1, actualTbDate.getUTCDay());
    assertEquals(2001, actualTbDate.getFullYear());
    assertEquals(2001, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return toDateString is {@code 2001 Jan 1, Mon}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDate#TbDate(int, int, int, int, int, int, String)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, int, String); when empty string; then return toDateString is '2001 Jan 1, Mon'")
  void testNewTbDate_whenEmptyString_thenReturnToDateStringIs2001Jan1Mon2() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1, 1, 1, 1, 1, 1, "");

    // Assert
    assertEquals("2001 Jan 1, Mon", actualTbDate.toDateString());
    assertEquals("2001 Jan 1, Mon", actualTbDate.toLocaleDateString());
    assertEquals("2001-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("2001-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("2001-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(1, actualTbDate.getDay());
    assertEquals(1, actualTbDate.getUTCDay());
    assertEquals(2001, actualTbDate.getFullYear());
    assertEquals(2001, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return toDateString is {@code 2001 Jan 1, Mon}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int, int, int, String)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, String); when empty string; then return toDateString is '2001 Jan 1, Mon'")
  void testNewTbDate_whenEmptyString_thenReturnToDateStringIs2001Jan1Mon3() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1, 1, 1, 1, 1, "");

    // Assert
    assertEquals("2001 Jan 1, Mon", actualTbDate.toDateString());
    assertEquals("2001 Jan 1, Mon", actualTbDate.toLocaleDateString());
    assertEquals("2001-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("2001-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("2001-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(1, actualTbDate.getDay());
    assertEquals(1, actualTbDate.getUTCDay());
    assertEquals(2001, actualTbDate.getFullYear());
    assertEquals(2001, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return toDateString is {@code 2001 Jan 1, Mon}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int, String)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, String); when empty string; then return toDateString is '2001 Jan 1, Mon'")
  void testNewTbDate_whenEmptyString_thenReturnToDateStringIs2001Jan1Mon4() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1, 1, 1, "");

    // Assert
    assertEquals("2001 Jan 1, Mon", actualTbDate.toDateString());
    assertEquals("2001 Jan 1, Mon", actualTbDate.toLocaleDateString());
    assertEquals("2001-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("2001-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("2001-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(1, actualTbDate.getDay());
    assertEquals(1, actualTbDate.getUTCDay());
    assertEquals(2001, actualTbDate.getFullYear());
    assertEquals(2001, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(String)}
   */
  @Test
  @DisplayName("Test new TbDate(String); when 'foo'")
  void testNewTbDate_whenFoo() {
    // Arrange, Act and Assert
    assertThrows(ConversionException.class, () -> new TbDate("foo"));
  }

  /**
   * Test {@link TbDate#TbDate(String, String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then throw {@link ConversionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(String, String)}
   */
  @Test
  @DisplayName("Test new TbDate(String, String); when 'foo'; then throw ConversionException")
  void testNewTbDate_whenFoo_thenThrowConversionException() {
    // Arrange, Act and Assert
    assertThrows(ConversionException.class, () -> new TbDate("foo", "42"));

    assertThrows(ConversionException.class, () -> new TbDate("foo", "42", "en"));
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return toDateString is {@code 2001 Jan 1, Mon}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int); when one; then return toDateString is '2001 Jan 1, Mon'")
  void testNewTbDate_whenOne_thenReturnToDateStringIs2001Jan1Mon() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1, 1, 1);

    // Assert
    assertEquals("2001 Jan 1, Mon", actualTbDate.toDateString());
    assertEquals("2001 Jan 1, Mon", actualTbDate.toLocaleDateString());
    assertEquals("2001-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("2001-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("2001-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(1, actualTbDate.getDay());
    assertEquals(1, actualTbDate.getUTCDay());
    assertEquals(2001, actualTbDate.getFullYear());
    assertEquals(2001, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return toDateString is {@code 2001 Jan 1, Mon}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int); when one; then return toDateString is '2001 Jan 1, Mon'")
  void testNewTbDate_whenOne_thenReturnToDateStringIs2001Jan1Mon2() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1, 1, 1, 1, 1);

    // Assert
    assertEquals("2001 Jan 1, Mon", actualTbDate.toDateString());
    assertEquals("2001 Jan 1, Mon", actualTbDate.toLocaleDateString());
    assertEquals("2001-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("2001-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("2001-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(1, actualTbDate.getDay());
    assertEquals(1, actualTbDate.getUTCDay());
    assertEquals(2001, actualTbDate.getFullYear());
    assertEquals(2001, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return toDateString is {@code 2001 Jan 1, Mon}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, int); when one; then return toDateString is '2001 Jan 1, Mon'")
  void testNewTbDate_whenOne_thenReturnToDateStringIs2001Jan1Mon3() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1, 1, 1, 1, 1, 1);

    // Assert
    assertEquals("2001 Jan 1, Mon", actualTbDate.toDateString());
    assertEquals("2001 Jan 1, Mon", actualTbDate.toLocaleDateString());
    assertEquals("2001-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("2001-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("2001-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(1, actualTbDate.getDay());
    assertEquals(1, actualTbDate.getUTCDay());
    assertEquals(2001, actualTbDate.getFullYear());
    assertEquals(2001, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return toDateString is {@code 2001 Jan 1, Mon}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, int, int); when one; then return toDateString is '2001 Jan 1, Mon'")
  void testNewTbDate_whenOne_thenReturnToDateStringIs2001Jan1Mon4() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1, 1, 1, 1, 1, 1, 1);

    // Assert
    assertEquals("2001 Jan 1, Mon", actualTbDate.toDateString());
    assertEquals("2001 Jan 1, Mon", actualTbDate.toLocaleDateString());
    assertEquals("2001-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("2001-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("2001-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(1, actualTbDate.getDay());
    assertEquals(1, actualTbDate.getUTCDay());
    assertEquals(2001, actualTbDate.getFullYear());
    assertEquals(2001, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int)}.
   * <ul>
   *   <li>When seventy.</li>
   *   <li>Then return toDateString is {@code 1970 Jan 1, Thu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int); when seventy; then return toDateString is '1970 Jan 1, Thu'")
  void testNewTbDate_whenSeventy_thenReturnToDateStringIs1970Jan1Thu() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(70, 1, 1, 1, 1);

    // Assert
    assertEquals("1970 Jan 1, Thu", actualTbDate.toDateString());
    assertEquals("1970 Jan 1, Thu", actualTbDate.toLocaleDateString());
    assertEquals("1970-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("1970-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("1970-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(1970, actualTbDate.getFullYear());
    assertEquals(1970, actualTbDate.getUTCFullYear());
    assertEquals(4, actualTbDate.getDay());
    assertEquals(4, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int)}.
   * <ul>
   *   <li>When seventy.</li>
   *   <li>Then return toDateString is {@code 1970 Jan 1, Thu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, int); when seventy; then return toDateString is '1970 Jan 1, Thu'")
  void testNewTbDate_whenSeventy_thenReturnToDateStringIs1970Jan1Thu2() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(70, 1, 1, 1, 1, 1);

    // Assert
    assertEquals("1970 Jan 1, Thu", actualTbDate.toDateString());
    assertEquals("1970 Jan 1, Thu", actualTbDate.toLocaleDateString());
    assertEquals("1970-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("1970-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("1970-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(1970, actualTbDate.getFullYear());
    assertEquals(1970, actualTbDate.getUTCFullYear());
    assertEquals(4, actualTbDate.getDay());
    assertEquals(4, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, int)}.
   * <ul>
   *   <li>When seventy.</li>
   *   <li>Then return toDateString is {@code 1970 Jan 1, Thu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, int, int); when seventy; then return toDateString is '1970 Jan 1, Thu'")
  void testNewTbDate_whenSeventy_thenReturnToDateStringIs1970Jan1Thu3() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(70, 1, 1, 1, 1, 1, 1);

    // Assert
    assertEquals("1970 Jan 1, Thu", actualTbDate.toDateString());
    assertEquals("1970 Jan 1, Thu", actualTbDate.toLocaleDateString());
    assertEquals("1970-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("1970-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("1970-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(1970, actualTbDate.getFullYear());
    assertEquals(1970, actualTbDate.getUTCFullYear());
    assertEquals(4, actualTbDate.getDay());
    assertEquals(4, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, int, String)}.
   * <ul>
   *   <li>When seventy.</li>
   *   <li>Then return toDateString is {@code 1970 Jan 1, Thu}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDate#TbDate(int, int, int, int, int, int, int, String)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, int, int, String); when seventy; then return toDateString is '1970 Jan 1, Thu'")
  void testNewTbDate_whenSeventy_thenReturnToDateStringIs1970Jan1Thu4() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(70, 1, 1, 1, 1, 1, 1, null);

    // Assert
    assertEquals("1970 Jan 1, Thu", actualTbDate.toDateString());
    assertEquals("1970 Jan 1, Thu", actualTbDate.toLocaleDateString());
    assertEquals("1970-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("1970-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("1970-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(1970, actualTbDate.getFullYear());
    assertEquals(1970, actualTbDate.getUTCFullYear());
    assertEquals(4, actualTbDate.getDay());
    assertEquals(4, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, String)}.
   * <ul>
   *   <li>When seventy.</li>
   *   <li>Then return toDateString is {@code 1970 Jan 1, Thu}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDate#TbDate(int, int, int, int, int, int, String)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, int, String); when seventy; then return toDateString is '1970 Jan 1, Thu'")
  void testNewTbDate_whenSeventy_thenReturnToDateStringIs1970Jan1Thu5() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(70, 1, 1, 1, 1, 1, null);

    // Assert
    assertEquals("1970 Jan 1, Thu", actualTbDate.toDateString());
    assertEquals("1970 Jan 1, Thu", actualTbDate.toLocaleDateString());
    assertEquals("1970-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("1970-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("1970-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(1970, actualTbDate.getFullYear());
    assertEquals(1970, actualTbDate.getUTCFullYear());
    assertEquals(4, actualTbDate.getDay());
    assertEquals(4, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, String)}.
   * <ul>
   *   <li>When seventy.</li>
   *   <li>Then return toDateString is {@code 1970 Jan 1, Thu}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int, int, int, String)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, String); when seventy; then return toDateString is '1970 Jan 1, Thu'")
  void testNewTbDate_whenSeventy_thenReturnToDateStringIs1970Jan1Thu6() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(70, 1, 1, 1, 1, null);

    // Assert
    assertEquals("1970 Jan 1, Thu", actualTbDate.toDateString());
    assertEquals("1970 Jan 1, Thu", actualTbDate.toLocaleDateString());
    assertEquals("1970-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("1970-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("1970-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(1970, actualTbDate.getFullYear());
    assertEquals(1970, actualTbDate.getUTCFullYear());
    assertEquals(4, actualTbDate.getDay());
    assertEquals(4, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, int, String)}.
   * <ul>
   *   <li>When sixty-nine.</li>
   *   <li>Then return toDateString is {@code 2069 Jan 1, Tue}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDate#TbDate(int, int, int, int, int, int, int, String)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, int, int, String); when sixty-nine; then return toDateString is '2069 Jan 1, Tue'")
  void testNewTbDate_whenSixtyNine_thenReturnToDateStringIs2069Jan1Tue() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(69, 1, 1, 1, 1, 1, 1, null);

    // Assert
    assertEquals("2069 Jan 1, Tue", actualTbDate.toDateString());
    assertEquals("2069 Jan 1, Tue", actualTbDate.toLocaleDateString());
    assertEquals("2069-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("2069-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("2069-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(2, actualTbDate.getDay());
    assertEquals(2, actualTbDate.getUTCDay());
    assertEquals(2069, actualTbDate.getFullYear());
    assertEquals(2069, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, String)}.
   * <ul>
   *   <li>When sixty-nine.</li>
   *   <li>Then return toDateString is {@code 2069 Jan 1, Tue}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDate#TbDate(int, int, int, int, int, int, String)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, int, String); when sixty-nine; then return toDateString is '2069 Jan 1, Tue'")
  void testNewTbDate_whenSixtyNine_thenReturnToDateStringIs2069Jan1Tue2() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(69, 1, 1, 1, 1, 1, null);

    // Assert
    assertEquals("2069 Jan 1, Tue", actualTbDate.toDateString());
    assertEquals("2069 Jan 1, Tue", actualTbDate.toLocaleDateString());
    assertEquals("2069-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("2069-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("2069-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(2, actualTbDate.getDay());
    assertEquals(2, actualTbDate.getUTCDay());
    assertEquals(2069, actualTbDate.getFullYear());
    assertEquals(2069, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, String)}.
   * <ul>
   *   <li>When sixty-nine.</li>
   *   <li>Then return toDateString is {@code 2069 Jan 1, Tue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int, int, int, String)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, int, int, String); when sixty-nine; then return toDateString is '2069 Jan 1, Tue'")
  void testNewTbDate_whenSixtyNine_thenReturnToDateStringIs2069Jan1Tue3() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(69, 1, 1, 1, 1, null);

    // Assert
    assertEquals("2069 Jan 1, Tue", actualTbDate.toDateString());
    assertEquals("2069 Jan 1, Tue", actualTbDate.toLocaleDateString());
    assertEquals("2069-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("2069-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("2069-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(2, actualTbDate.getDay());
    assertEquals(2, actualTbDate.getUTCDay());
    assertEquals(2069, actualTbDate.getFullYear());
    assertEquals(2069, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, String)}.
   * <ul>
   *   <li>When sixty-nine.</li>
   *   <li>Then return toDateString is {@code 2069 Jan 1, Tue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#TbDate(int, int, int, String)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, String); when sixty-nine; then return toDateString is '2069 Jan 1, Tue'")
  void testNewTbDate_whenSixtyNine_thenReturnToDateStringIs2069Jan1Tue4() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(69, 1, 1, null);

    // Assert
    assertEquals("2069 Jan 1, Tue", actualTbDate.toDateString());
    assertEquals("2069 Jan 1, Tue", actualTbDate.toLocaleDateString());
    assertEquals("2069-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("2069-01-01", actualTbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("2069-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(2, actualTbDate.getDay());
    assertEquals(2, actualTbDate.getUTCDay());
    assertEquals(2069, actualTbDate.getFullYear());
    assertEquals(2069, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#getZonedDateTime()}.
   * <p>
   * Method under test: {@link TbDate#getZonedDateTime()}
   */
  @Test
  @DisplayName("Test getZonedDateTime()")
  void testGetZonedDateTime() {
    // Arrange, Act and Assert
    assertEquals("UTC", (new TbDate()).getZonedDateTime().getZone().toString());
  }

  /**
   * Test {@link TbDate#getZonedDateTime(ZoneId)} with {@code ZoneId}.
   * <ul>
   *   <li>Then return Zone is ofTotalSeconds one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#getZonedDateTime(ZoneId)}
   */
  @Test
  @DisplayName("Test getZonedDateTime(ZoneId) with 'ZoneId'; then return Zone is ofTotalSeconds one")
  void testGetZonedDateTimeWithZoneId_thenReturnZoneIsOfTotalSecondsOne() {
    // Arrange
    TbDate tbDate = new TbDate();
    ZoneOffset zoneId = ZoneOffset.ofTotalSeconds(1);

    // Act and Assert
    assertSame(zoneId, tbDate.getZonedDateTime(zoneId).getZone());
  }

  /**
   * Test {@link TbDate#toLocaleString(String, String, BiFunction)} with
   * {@code localeStr}, {@code optionsStr}, {@code formatterBuilder}.
   * <p>
   * Method under test: {@link TbDate#toLocaleString(String, String, BiFunction)}
   */
  @Test
  @DisplayName("Test toLocaleString(String, String, BiFunction) with 'localeStr', 'optionsStr', 'formatterBuilder'")
  void testToLocaleStringWithLocaleStrOptionsStrFormatterBuilder() {
    // Arrange
    TbDate tbDate = new TbDate();
    BiFunction<Locale, DateTimeFormatOptions, DateTimeFormatter> formatterBuilder = mock(BiFunction.class);
    when(formatterBuilder.apply(Mockito.<Locale>any(), Mockito.<DateTimeFormatOptions>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDate.toLocaleString("en", "en", formatterBuilder));
    verify(formatterBuilder).apply(isA(Locale.class), isA(DateTimeFormatOptions.class));
  }

  /**
   * Test {@link TbDate#toLocaleString(String, String, BiFunction)} with
   * {@code localeStr}, {@code optionsStr}, {@code formatterBuilder}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#toLocaleString(String, String, BiFunction)}
   */
  @Test
  @DisplayName("Test toLocaleString(String, String, BiFunction) with 'localeStr', 'optionsStr', 'formatterBuilder'; when '42'")
  void testToLocaleStringWithLocaleStrOptionsStrFormatterBuilder_when42() {
    // Arrange
    TbDate tbDate = new TbDate();
    BiFunction<Locale, DateTimeFormatOptions, DateTimeFormatter> formatterBuilder = mock(BiFunction.class);
    when(formatterBuilder.apply(Mockito.<Locale>any(), Mockito.<DateTimeFormatOptions>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDate.toLocaleString("en", "42", formatterBuilder));
    verify(formatterBuilder).apply(isA(Locale.class), isA(DateTimeFormatOptions.class));
  }

  /**
   * Test {@link TbDate#toLocaleString(String, String, BiFunction)} with
   * {@code localeStr}, {@code optionsStr}, {@code formatterBuilder}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#toLocaleString(String, String, BiFunction)}
   */
  @Test
  @DisplayName("Test toLocaleString(String, String, BiFunction) with 'localeStr', 'optionsStr', 'formatterBuilder'; when empty string")
  void testToLocaleStringWithLocaleStrOptionsStrFormatterBuilder_whenEmptyString() {
    // Arrange
    TbDate tbDate = new TbDate();
    BiFunction<Locale, DateTimeFormatOptions, DateTimeFormatter> formatterBuilder = mock(BiFunction.class);
    when(formatterBuilder.apply(Mockito.<Locale>any(), Mockito.<DateTimeFormatOptions>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDate.toLocaleString("", "en", formatterBuilder));
    verify(formatterBuilder).apply(isA(Locale.class), isA(DateTimeFormatOptions.class));
  }

  /**
   * Test {@link TbDate#toLocaleString(String, String, BiFunction)} with
   * {@code localeStr}, {@code optionsStr}, {@code formatterBuilder}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#toLocaleString(String, String, BiFunction)}
   */
  @Test
  @DisplayName("Test toLocaleString(String, String, BiFunction) with 'localeStr', 'optionsStr', 'formatterBuilder'; when 'null'")
  void testToLocaleStringWithLocaleStrOptionsStrFormatterBuilder_whenNull() {
    // Arrange
    TbDate tbDate = new TbDate();
    BiFunction<Locale, DateTimeFormatOptions, DateTimeFormatter> formatterBuilder = mock(BiFunction.class);
    when(formatterBuilder.apply(Mockito.<Locale>any(), Mockito.<DateTimeFormatOptions>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDate.toLocaleString(null, "en", formatterBuilder));
    verify(formatterBuilder).apply(isA(Locale.class), isA(DateTimeFormatOptions.class));
  }

  /**
   * Test {@link TbDate#toLocaleString(String, String, BiFunction)} with
   * {@code localeStr}, {@code optionsStr}, {@code formatterBuilder}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#toLocaleString(String, String, BiFunction)}
   */
  @Test
  @DisplayName("Test toLocaleString(String, String, BiFunction) with 'localeStr', 'optionsStr', 'formatterBuilder'; when 'null'")
  void testToLocaleStringWithLocaleStrOptionsStrFormatterBuilder_whenNull2() {
    // Arrange
    TbDate tbDate = new TbDate();
    BiFunction<Locale, DateTimeFormatOptions, DateTimeFormatter> formatterBuilder = mock(BiFunction.class);
    when(formatterBuilder.apply(Mockito.<Locale>any(), Mockito.<DateTimeFormatOptions>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDate.toLocaleString("en", null, formatterBuilder));
    verify(formatterBuilder).apply(isA(Locale.class), isA(DateTimeFormatOptions.class));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int, int)} with {@code year},
   * {@code month}, {@code date}, {@code hrs}, {@code min}, {@code sec},
   * {@code ms}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code 1046660463003}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec', 'ms'; when three; then return '1046660463003'")
  void testUtcWithYearMonthDateHrsMinSecMs_whenThree_thenReturn1046660463003() {
    // Arrange, Act and Assert
    assertEquals(1046660463003L, TbDate.UTC(3, 3, 3, 3, 1, 3, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int)} with {@code year},
   * {@code month}, {@code date}, {@code hrs}, {@code min}, {@code sec}.
   * <ul>
   *   <li>When ninety-nine.</li>
   *   <li>Then return {@code 946609263000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec'; when ninety-nine; then return '946609263000'")
  void testUtcWithYearMonthDateHrsMinSec_whenNinetyNine_thenReturn946609263000() {
    // Arrange, Act and Assert
    assertEquals(946609263000L, TbDate.UTC(99, 0, 0, 3, 1, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int)} with {@code year},
   * {@code month}, {@code date}, {@code hrs}, {@code min}, {@code sec}.
   * <ul>
   *   <li>When one hundred.</li>
   *   <li>Then return {@code -58979998737000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec'; when one hundred; then return '-58979998737000'")
  void testUtcWithYearMonthDateHrsMinSec_whenOneHundred_thenReturn58979998737000() {
    // Arrange, Act and Assert
    assertEquals(-58979998737000L, TbDate.UTC(100, 0, 0, 3, 1, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int)} with {@code year},
   * {@code month}, {@code date}, {@code hrs}, {@code min}, {@code sec}.
   * <ul>
   *   <li>When seventy.</li>
   *   <li>Then return {@code 31460463000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec'; when seventy; then return '31460463000'")
  void testUtcWithYearMonthDateHrsMinSec_whenSeventy_thenReturn31460463000() {
    // Arrange, Act and Assert
    assertEquals(31460463000L, TbDate.UTC(70, 0, 0, 3, 1, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int)} with {@code year},
   * {@code month}, {@code date}, {@code hrs}, {@code min}, {@code sec}.
   * <ul>
   *   <li>When sixty-nine.</li>
   *   <li>Then return {@code 3155684463000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec'; when sixty-nine; then return '3155684463000'")
  void testUtcWithYearMonthDateHrsMinSec_whenSixtyNine_thenReturn3155684463000() {
    // Arrange, Act and Assert
    assertEquals(3155684463000L, TbDate.UTC(69, 0, 0, 3, 1, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int)} with {@code year},
   * {@code month}, {@code date}, {@code hrs}, {@code min}, {@code sec}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code 1046660463000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec'; when three; then return '1046660463000'")
  void testUtcWithYearMonthDateHrsMinSec_whenThree_thenReturn1046660463000() {
    // Arrange, Act and Assert
    assertEquals(1046660463000L, TbDate.UTC(3, 3, 3, 3, 1, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int)} with {@code year},
   * {@code month}, {@code date}, {@code hrs}, {@code min}, {@code sec}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code -2209064337000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec'; when zero; then return '-2209064337000'")
  void testUtcWithYearMonthDateHrsMinSec_whenZero_thenReturn2209064337000() {
    // Arrange, Act and Assert
    assertEquals(-2209064337000L, TbDate.UTC(0, 0, 0, 3, 1, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int)} with {@code year},
   * {@code month}, {@code date}, {@code hrs}, {@code min}.
   * <ul>
   *   <li>When ninety-nine.</li>
   *   <li>Then return {@code 946609260000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min'; when ninety-nine; then return '946609260000'")
  void testUtcWithYearMonthDateHrsMin_whenNinetyNine_thenReturn946609260000() {
    // Arrange, Act and Assert
    assertEquals(946609260000L, TbDate.UTC(99, 0, 0, 3, 1));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int)} with {@code year},
   * {@code month}, {@code date}, {@code hrs}, {@code min}.
   * <ul>
   *   <li>When one hundred.</li>
   *   <li>Then return {@code -58979998740000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min'; when one hundred; then return '-58979998740000'")
  void testUtcWithYearMonthDateHrsMin_whenOneHundred_thenReturn58979998740000() {
    // Arrange, Act and Assert
    assertEquals(-58979998740000L, TbDate.UTC(100, 0, 0, 3, 1));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int)} with {@code year},
   * {@code month}, {@code date}, {@code hrs}, {@code min}.
   * <ul>
   *   <li>When seventy.</li>
   *   <li>Then return {@code 31460460000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min'; when seventy; then return '31460460000'")
  void testUtcWithYearMonthDateHrsMin_whenSeventy_thenReturn31460460000() {
    // Arrange, Act and Assert
    assertEquals(31460460000L, TbDate.UTC(70, 0, 0, 3, 1));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int)} with {@code year},
   * {@code month}, {@code date}, {@code hrs}, {@code min}.
   * <ul>
   *   <li>When sixty-nine.</li>
   *   <li>Then return {@code 3155684460000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min'; when sixty-nine; then return '3155684460000'")
  void testUtcWithYearMonthDateHrsMin_whenSixtyNine_thenReturn3155684460000() {
    // Arrange, Act and Assert
    assertEquals(3155684460000L, TbDate.UTC(69, 0, 0, 3, 1));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int)} with {@code year},
   * {@code month}, {@code date}, {@code hrs}, {@code min}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code 1046660460000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min'; when three; then return '1046660460000'")
  void testUtcWithYearMonthDateHrsMin_whenThree_thenReturn1046660460000() {
    // Arrange, Act and Assert
    assertEquals(1046660460000L, TbDate.UTC(3, 3, 3, 3, 1));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int)} with {@code year},
   * {@code month}, {@code date}, {@code hrs}, {@code min}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code -2209064340000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min'; when zero; then return '-2209064340000'")
  void testUtcWithYearMonthDateHrsMin_whenZero_thenReturn2209064340000() {
    // Arrange, Act and Assert
    assertEquals(-2209064340000L, TbDate.UTC(0, 0, 0, 3, 1));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int)} with {@code year}, {@code month},
   * {@code date}, {@code hrs}.
   * <ul>
   *   <li>When ninety-nine.</li>
   *   <li>Then return {@code 946609200000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int) with 'year', 'month', 'date', 'hrs'; when ninety-nine; then return '946609200000'")
  void testUtcWithYearMonthDateHrs_whenNinetyNine_thenReturn946609200000() {
    // Arrange, Act and Assert
    assertEquals(946609200000L, TbDate.UTC(99, 0, 0, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int)} with {@code year}, {@code month},
   * {@code date}, {@code hrs}.
   * <ul>
   *   <li>When one hundred.</li>
   *   <li>Then return {@code -58979998800000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int) with 'year', 'month', 'date', 'hrs'; when one hundred; then return '-58979998800000'")
  void testUtcWithYearMonthDateHrs_whenOneHundred_thenReturn58979998800000() {
    // Arrange, Act and Assert
    assertEquals(-58979998800000L, TbDate.UTC(100, 0, 0, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int)} with {@code year}, {@code month},
   * {@code date}, {@code hrs}.
   * <ul>
   *   <li>When seventy.</li>
   *   <li>Then return {@code 31460400000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int) with 'year', 'month', 'date', 'hrs'; when seventy; then return '31460400000'")
  void testUtcWithYearMonthDateHrs_whenSeventy_thenReturn31460400000() {
    // Arrange, Act and Assert
    assertEquals(31460400000L, TbDate.UTC(70, 0, 0, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int)} with {@code year}, {@code month},
   * {@code date}, {@code hrs}.
   * <ul>
   *   <li>When sixty-nine.</li>
   *   <li>Then return {@code 3155684400000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int) with 'year', 'month', 'date', 'hrs'; when sixty-nine; then return '3155684400000'")
  void testUtcWithYearMonthDateHrs_whenSixtyNine_thenReturn3155684400000() {
    // Arrange, Act and Assert
    assertEquals(3155684400000L, TbDate.UTC(69, 0, 0, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int)} with {@code year}, {@code month},
   * {@code date}, {@code hrs}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code 1046660400000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int) with 'year', 'month', 'date', 'hrs'; when three; then return '1046660400000'")
  void testUtcWithYearMonthDateHrs_whenThree_thenReturn1046660400000() {
    // Arrange, Act and Assert
    assertEquals(1046660400000L, TbDate.UTC(3, 3, 3, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int)} with {@code year}, {@code month},
   * {@code date}, {@code hrs}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code -2209064400000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int, int) with 'year', 'month', 'date', 'hrs'; when zero; then return '-2209064400000'")
  void testUtcWithYearMonthDateHrs_whenZero_thenReturn2209064400000() {
    // Arrange, Act and Assert
    assertEquals(-2209064400000L, TbDate.UTC(0, 0, 0, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int)} with {@code year}, {@code month},
   * {@code date}.
   * <ul>
   *   <li>When seventy.</li>
   *   <li>Then return {@code 31449600000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int) with 'year', 'month', 'date'; when seventy; then return '31449600000'")
  void testUtcWithYearMonthDate_whenSeventy_thenReturn31449600000() {
    // Arrange, Act and Assert
    assertEquals(31449600000L, TbDate.UTC(70, 0, 0));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int)} with {@code year}, {@code month},
   * {@code date}.
   * <ul>
   *   <li>When sixty-nine.</li>
   *   <li>Then return {@code 3155673600000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int) with 'year', 'month', 'date'; when sixty-nine; then return '3155673600000'")
  void testUtcWithYearMonthDate_whenSixtyNine_thenReturn3155673600000() {
    // Arrange, Act and Assert
    assertEquals(3155673600000L, TbDate.UTC(69, 0, 0));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int)} with {@code year}, {@code month},
   * {@code date}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code 1046649600000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int) with 'year', 'month', 'date'; when three; then return '1046649600000'")
  void testUtcWithYearMonthDate_whenThree_thenReturn1046649600000() {
    // Arrange, Act and Assert
    assertEquals(1046649600000L, TbDate.UTC(3, 3, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int)} with {@code year}, {@code month},
   * {@code date}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code -2209075200000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int, int) with 'year', 'month', 'date'; when zero; then return '-2209075200000'")
  void testUtcWithYearMonthDate_whenZero_thenReturn2209075200000() {
    // Arrange, Act and Assert
    assertEquals(-2209075200000L, TbDate.UTC(0, 0, 0));
  }

  /**
   * Test {@link TbDate#UTC(int, int)} with {@code year}, {@code month}.
   * <ul>
   *   <li>When ninety-nine.</li>
   *   <li>Then return {@code 946598400000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int) with 'year', 'month'; when ninety-nine; then return '946598400000'")
  void testUtcWithYearMonth_whenNinetyNine_thenReturn946598400000() {
    // Arrange, Act and Assert
    assertEquals(946598400000L, TbDate.UTC(99, 0));
  }

  /**
   * Test {@link TbDate#UTC(int, int)} with {@code year}, {@code month}.
   * <ul>
   *   <li>When one hundred.</li>
   *   <li>Then return {@code -58980009600000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int) with 'year', 'month'; when one hundred; then return '-58980009600000'")
  void testUtcWithYearMonth_whenOneHundred_thenReturn58980009600000() {
    // Arrange, Act and Assert
    assertEquals(-58980009600000L, TbDate.UTC(100, 0));
  }

  /**
   * Test {@link TbDate#UTC(int, int)} with {@code year}, {@code month}.
   * <ul>
   *   <li>When seventy.</li>
   *   <li>Then return {@code 31449600000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int) with 'year', 'month'; when seventy; then return '31449600000'")
  void testUtcWithYearMonth_whenSeventy_thenReturn31449600000() {
    // Arrange, Act and Assert
    assertEquals(31449600000L, TbDate.UTC(70, 0));
  }

  /**
   * Test {@link TbDate#UTC(int, int)} with {@code year}, {@code month}.
   * <ul>
   *   <li>When sixty-nine.</li>
   *   <li>Then return {@code 3155673600000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int) with 'year', 'month'; when sixty-nine; then return '3155673600000'")
  void testUtcWithYearMonth_whenSixtyNine_thenReturn3155673600000() {
    // Arrange, Act and Assert
    assertEquals(3155673600000L, TbDate.UTC(69, 0));
  }

  /**
   * Test {@link TbDate#UTC(int, int)} with {@code year}, {@code month}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code 1049068800000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int) with 'year', 'month'; when three; then return '1049068800000'")
  void testUtcWithYearMonth_whenThree_thenReturn1049068800000() {
    // Arrange, Act and Assert
    assertEquals(1049068800000L, TbDate.UTC(3, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int)} with {@code year}, {@code month}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code -2209075200000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int) with 'year', 'month'; when zero; then return '-2209075200000'")
  void testUtcWithYearMonth_whenZero_thenReturn2209075200000() {
    // Arrange, Act and Assert
    assertEquals(-2209075200000L, TbDate.UTC(0, 0));
  }

  /**
   * Test {@link TbDate#UTC(int)} with {@code year}.
   * <ul>
   *   <li>When one hundred.</li>
   *   <li>Then return {@code -58980009600000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int)}
   */
  @Test
  @DisplayName("Test UTC(int) with 'year'; when one hundred; then return '-58980009600000'")
  void testUtcWithYear_whenOneHundred_thenReturn58980009600000() {
    // Arrange, Act and Assert
    assertEquals(-58980009600000L, TbDate.UTC(100));
  }

  /**
   * Test {@link TbDate#UTC(int)} with {@code year}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code 1009756800000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int)}
   */
  @Test
  @DisplayName("Test UTC(int) with 'year'; when one; then return '1009756800000'")
  void testUtcWithYear_whenOne_thenReturn1009756800000() {
    // Arrange, Act and Assert
    assertEquals(1009756800000L, TbDate.UTC(1));
  }

  /**
   * Test {@link TbDate#UTC(int)} with {@code year}.
   * <ul>
   *   <li>When seventy.</li>
   *   <li>Then return {@code 31449600000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int)}
   */
  @Test
  @DisplayName("Test UTC(int) with 'year'; when seventy; then return '31449600000'")
  void testUtcWithYear_whenSeventy_thenReturn31449600000() {
    // Arrange, Act and Assert
    assertEquals(31449600000L, TbDate.UTC(70));
  }

  /**
   * Test {@link TbDate#UTC(int)} with {@code year}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code -2209075200000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#UTC(int)}
   */
  @Test
  @DisplayName("Test UTC(int) with 'year'; when zero; then return '-2209075200000'")
  void testUtcWithYear_whenZero_thenReturn2209075200000() {
    // Arrange, Act and Assert
    assertEquals(-2209075200000L, TbDate.UTC(0));
  }

  /**
   * Test {@link TbDate#setUTCFullYear(int)} with {@code year}.
   * <p>
   * Method under test: {@link TbDate#setUTCFullYear(int)}
   */
  @Test
  @DisplayName("Test setUTCFullYear(int) with 'year'")
  void testSetUTCFullYearWithYear() {
    // Arrange
    TbDate tbDate = new TbDate(-1L);

    // Act
    tbDate.setUTCFullYear(1);

    // Assert
    assertEquals("0001-12-31", tbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("0001-12-31", tbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("0001-12-31", tbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals("0001-12-31T23:59:59.999Z", tbDate.toISOString());
    assertEquals("0001-12-31T23:59:59.999Z", tbDate.toJSON());
    assertEquals("1 Dec 31, Mon 23:59:59", tbDate.toUTCString());
    assertEquals("1 Dec 31, Mon", tbDate.toDateString());
    assertEquals("1 Dec 31, Mon", tbDate.toLocaleDateString());
    assertEquals(-62104060800001L, tbDate.getTime());
    assertEquals(-62104060801L, tbDate.getInstant().getEpochSecond());
  }

  /**
   * Test {@link TbDate#setUTCFullYear(int, int)} with {@code year},
   * {@code month}.
   * <p>
   * Method under test: {@link TbDate#setUTCFullYear(int, int)}
   */
  @Test
  @DisplayName("Test setUTCFullYear(int, int) with 'year', 'month'")
  void testSetUTCFullYearWithYearMonth() {
    // Arrange
    TbDate tbDate = new TbDate(-1L);

    // Act
    tbDate.setUTCFullYear(1, 1);

    // Assert
    assertEquals("0001-01-31", tbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("0001-01-31", tbDate.getLocalDateTime().toLocalDate().toString());
    assertEquals("0001-01-31", tbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals("0001-01-31T23:59:59.999Z", tbDate.toISOString());
    assertEquals("0001-01-31T23:59:59.999Z", tbDate.toJSON());
    assertEquals("1 Jan 31, Wed 23:59:59", tbDate.toUTCString());
    assertEquals("1 Jan 31, Wed", tbDate.toDateString());
    assertEquals("1 Jan 31, Wed", tbDate.toLocaleDateString());
    assertEquals(-62132918400001L, tbDate.getTime());
    assertEquals(-62132918401L, tbDate.getInstant().getEpochSecond());
    assertEquals(1, tbDate.getMonth());
    assertEquals(1, tbDate.getUTCMonth());
    assertEquals(3, tbDate.getDay());
    assertEquals(3, tbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#setUTCFullYear(int, int, int)} with {@code year},
   * {@code month}, {@code date}.
   * <p>
   * Method under test: {@link TbDate#setUTCFullYear(int, int, int)}
   */
  @Test
  @DisplayName("Test setUTCFullYear(int, int, int) with 'year', 'month', 'date'")
  void testSetUTCFullYearWithYearMonthDate() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCFullYear(1, 1, 1);

    // Assert
    assertEquals("0001-01-01", tbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("0001-01-01", tbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(1, tbDate.getUTCDay());
    assertEquals(1, tbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#setUTCFullYear(int, int)} with {@code year},
   * {@code month}.
   * <ul>
   *   <li>Given {@link TbDate#TbDate()}.</li>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} UTCMonth is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setUTCFullYear(int, int)}
   */
  @Test
  @DisplayName("Test setUTCFullYear(int, int) with 'year', 'month'; given TbDate(); when one; then TbDate() UTCMonth is one")
  void testSetUTCFullYearWithYearMonth_givenTbDate_whenOne_thenTbDateUTCMonthIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCFullYear(1, 1);

    // Assert
    assertEquals(1, tbDate.getUTCMonth());
  }

  /**
   * Test {@link TbDate#setUTCMonth(int)} with {@code month}.
   * <p>
   * Method under test: {@link TbDate#setUTCMonth(int)}
   */
  @Test
  @DisplayName("Test setUTCMonth(int) with 'month'")
  void testSetUTCMonthWithMonth() {
    // Arrange
    TbDate tbDate = new TbDate(-1L);

    // Act
    tbDate.setUTCMonth(1);

    // Assert
    assertEquals("1969 Jan 31, Fri 23:59:59", tbDate.toUTCString());
    assertEquals("1969-01-31", tbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("1969-01-31", tbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals("1969-01-31T23:59:59.999Z", tbDate.toISOString());
    assertEquals("1969-01-31T23:59:59.999Z", tbDate.toJSON());
    assertEquals(-28857600001L, tbDate.getTime());
    assertEquals(-28857601L, tbDate.getInstant().getEpochSecond());
    assertEquals(1, tbDate.getUTCMonth());
    assertEquals(5, tbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#setUTCMonth(int)} with {@code month}.
   * <ul>
   *   <li>Given {@link TbDate#TbDate()}.</li>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Month is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setUTCMonth(int)}
   */
  @Test
  @DisplayName("Test setUTCMonth(int) with 'month'; given TbDate(); when one; then TbDate() Month is one")
  void testSetUTCMonthWithMonth_givenTbDate_whenOne_thenTbDateMonthIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCMonth(1);

    // Assert
    assertEquals(1, tbDate.getMonth());
    assertEquals(1, tbDate.getUTCMonth());
  }

  /**
   * Test {@link TbDate#setUTCHours(int, int, int, int)} with {@code hrs},
   * {@code minutes}, {@code seconds}, {@code ms}.
   * <p>
   * Method under test: {@link TbDate#setUTCHours(int, int, int, int)}
   */
  @Test
  @DisplayName("Test setUTCHours(int, int, int, int) with 'hrs', 'minutes', 'seconds', 'ms'")
  void testSetUTCHoursWithHrsMinutesSecondsMs() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCHours(1, 1, 1, 1);

    // Assert
    assertEquals("01:01:01.001", tbDate.getZonedDateTime().toLocalDateTime().toLocalTime().toString());
    assertEquals("01:01:01.001", tbDate.getUTCDateTime().toLocalTime().toString());
    assertEquals(1, tbDate.getMilliseconds());
    assertEquals(1, tbDate.getMinutes());
    assertEquals(1, tbDate.getSeconds());
    assertEquals(1, tbDate.getUTCHours());
    assertEquals(1, tbDate.getUTCMilliseconds());
    assertEquals(1, tbDate.getUTCMinutes());
    assertEquals(1, tbDate.getUTCSeconds());
    assertEquals(1000000, tbDate.getInstant().getNano());
  }

  /**
   * Test {@link TbDate#setUTCHours(int, int, int)} with {@code hrs},
   * {@code minutes}, {@code seconds}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setUTCHours(int, int, int)}
   */
  @Test
  @DisplayName("Test setUTCHours(int, int, int) with 'hrs', 'minutes', 'seconds'; when one; then TbDate() Minutes is one")
  void testSetUTCHoursWithHrsMinutesSeconds_whenOne_thenTbDateMinutesIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCHours(1, 1, 1);

    // Assert
    assertEquals(1, tbDate.getMinutes());
    assertEquals(1, tbDate.getSeconds());
    assertEquals(1, tbDate.getUTCHours());
    assertEquals(1, tbDate.getUTCMinutes());
    assertEquals(1, tbDate.getUTCSeconds());
  }

  /**
   * Test {@link TbDate#setUTCHours(int, int)} with {@code hrs}, {@code minutes}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setUTCHours(int, int)}
   */
  @Test
  @DisplayName("Test setUTCHours(int, int) with 'hrs', 'minutes'; when one; then TbDate() Minutes is one")
  void testSetUTCHoursWithHrsMinutes_whenOne_thenTbDateMinutesIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCHours(1, 1);

    // Assert
    assertEquals(1, tbDate.getMinutes());
    assertEquals(1, tbDate.getUTCHours());
    assertEquals(1, tbDate.getUTCMinutes());
  }

  /**
   * Test {@link TbDate#setUTCHours(int)} with {@code hrs}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} UTCHours is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setUTCHours(int)}
   */
  @Test
  @DisplayName("Test setUTCHours(int) with 'hrs'; when one; then TbDate() UTCHours is one")
  void testSetUTCHoursWithHrs_whenOne_thenTbDateUTCHoursIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCHours(1);

    // Assert
    assertEquals(1, tbDate.getUTCHours());
  }

  /**
   * Test {@link TbDate#setUTCMinutes(int, int, int)} with {@code minutes},
   * {@code seconds}, {@code ms}.
   * <ul>
   *   <li>When seventy.</li>
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setUTCMinutes(int, int, int)}
   */
  @Test
  @DisplayName("Test setUTCMinutes(int, int, int) with 'minutes', 'seconds', 'ms'; when seventy; then TbDate() Minutes is one")
  void testSetUTCMinutesWithMinutesSecondsMs_whenSeventy_thenTbDateMinutesIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCMinutes(1, 1, 70);

    // Assert
    assertEquals(1, tbDate.getMinutes());
    assertEquals(1, tbDate.getSeconds());
    assertEquals(1, tbDate.getUTCMinutes());
    assertEquals(1, tbDate.getUTCSeconds());
    assertEquals(70, tbDate.getMilliseconds());
    assertEquals(70, tbDate.getUTCMilliseconds());
    assertEquals(70000000, tbDate.getInstant().getNano());
  }

  /**
   * Test {@link TbDate#setUTCMinutes(int, int)} with {@code minutes},
   * {@code seconds}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setUTCMinutes(int, int)}
   */
  @Test
  @DisplayName("Test setUTCMinutes(int, int) with 'minutes', 'seconds'; when one; then TbDate() Minutes is one")
  void testSetUTCMinutesWithMinutesSeconds_whenOne_thenTbDateMinutesIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCMinutes(1, 1);

    // Assert
    assertEquals(1, tbDate.getMinutes());
    assertEquals(1, tbDate.getSeconds());
    assertEquals(1, tbDate.getUTCMinutes());
    assertEquals(1, tbDate.getUTCSeconds());
  }

  /**
   * Test {@link TbDate#setUTCMinutes(int)} with {@code minutes}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setUTCMinutes(int)}
   */
  @Test
  @DisplayName("Test setUTCMinutes(int) with 'minutes'; when one; then TbDate() Minutes is one")
  void testSetUTCMinutesWithMinutes_whenOne_thenTbDateMinutesIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCMinutes(1);

    // Assert
    assertEquals(1, tbDate.getMinutes());
    assertEquals(1, tbDate.getUTCMinutes());
  }

  /**
   * Test {@link TbDate#setUTCSeconds(int, int)} with {@code seconds}, {@code ms}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Milliseconds is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setUTCSeconds(int, int)}
   */
  @Test
  @DisplayName("Test setUTCSeconds(int, int) with 'seconds', 'ms'; when one; then TbDate() Milliseconds is one")
  void testSetUTCSecondsWithSecondsMs_whenOne_thenTbDateMillisecondsIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCSeconds(1, 1);

    // Assert
    assertEquals(1, tbDate.getMilliseconds());
    assertEquals(1, tbDate.getSeconds());
    assertEquals(1, tbDate.getUTCMilliseconds());
    assertEquals(1, tbDate.getUTCSeconds());
    assertEquals(1000000, tbDate.getInstant().getNano());
  }

  /**
   * Test {@link TbDate#setUTCSeconds(int)} with {@code seconds}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Seconds is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setUTCSeconds(int)}
   */
  @Test
  @DisplayName("Test setUTCSeconds(int) with 'seconds'; when one; then TbDate() Seconds is one")
  void testSetUTCSecondsWithSeconds_whenOne_thenTbDateSecondsIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCSeconds(1);

    // Assert
    assertEquals(1, tbDate.getSeconds());
    assertEquals(1, tbDate.getUTCSeconds());
  }

  /**
   * Test {@link TbDate#setUTCMilliseconds(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Milliseconds is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setUTCMilliseconds(int)}
   */
  @Test
  @DisplayName("Test setUTCMilliseconds(int); when one; then TbDate() Milliseconds is one")
  void testSetUTCMilliseconds_whenOne_thenTbDateMillisecondsIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCMilliseconds(1);

    // Assert
    assertEquals(1, tbDate.getMilliseconds());
    assertEquals(1, tbDate.getUTCMilliseconds());
    assertEquals(1000000, tbDate.getInstant().getNano());
  }

  /**
   * Test {@link TbDate#setFullYear(int, int, int)} with {@code year},
   * {@code month}, {@code date}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} UTCFullYear is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setFullYear(int, int, int)}
   */
  @Test
  @DisplayName("Test setFullYear(int, int, int) with 'year', 'month', 'date'; when one; then TbDate() UTCFullYear is one")
  void testSetFullYearWithYearMonthDate_whenOne_thenTbDateUTCFullYearIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setFullYear(1, 1, 1);

    // Assert
    assertEquals(1, tbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#setFullYear(int, int)} with {@code year}, {@code month}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} UTCFullYear is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setFullYear(int, int)}
   */
  @Test
  @DisplayName("Test setFullYear(int, int) with 'year', 'month'; when one; then TbDate() UTCFullYear is one")
  void testSetFullYearWithYearMonth_whenOne_thenTbDateUTCFullYearIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setFullYear(1, 1);

    // Assert
    assertEquals(1, tbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#setFullYear(int)} with {@code year}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} UTCFullYear is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setFullYear(int)}
   */
  @Test
  @DisplayName("Test setFullYear(int) with 'year'; when one; then TbDate() UTCFullYear is one")
  void testSetFullYearWithYear_whenOne_thenTbDateUTCFullYearIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setFullYear(1);

    // Assert
    assertEquals(1, tbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#setHours(int, int, int, int)} with {@code hrs},
   * {@code minutes}, {@code seconds}, {@code ms}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Milliseconds is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setHours(int, int, int, int)}
   */
  @Test
  @DisplayName("Test setHours(int, int, int, int) with 'hrs', 'minutes', 'seconds', 'ms'; when one; then TbDate() Milliseconds is one")
  void testSetHoursWithHrsMinutesSecondsMs_whenOne_thenTbDateMillisecondsIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setHours(1, 1, 1, 1);

    // Assert
    assertEquals(1, tbDate.getMilliseconds());
    assertEquals(1, tbDate.getMinutes());
    assertEquals(1, tbDate.getSeconds());
    assertEquals(1, tbDate.getUTCMilliseconds());
    assertEquals(1, tbDate.getUTCMinutes());
    assertEquals(1, tbDate.getUTCSeconds());
    assertEquals(1000000, tbDate.getInstant().getNano());
  }

  /**
   * Test {@link TbDate#setHours(int, int, int)} with {@code hrs},
   * {@code minutes}, {@code seconds}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setHours(int, int, int)}
   */
  @Test
  @DisplayName("Test setHours(int, int, int) with 'hrs', 'minutes', 'seconds'; when one; then TbDate() Minutes is one")
  void testSetHoursWithHrsMinutesSeconds_whenOne_thenTbDateMinutesIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setHours(1, 1, 1);

    // Assert
    assertEquals(1, tbDate.getMinutes());
    assertEquals(1, tbDate.getSeconds());
    assertEquals(1, tbDate.getUTCMinutes());
    assertEquals(1, tbDate.getUTCSeconds());
  }

  /**
   * Test {@link TbDate#setHours(int, int)} with {@code hrs}, {@code minutes}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setHours(int, int)}
   */
  @Test
  @DisplayName("Test setHours(int, int) with 'hrs', 'minutes'; when one; then TbDate() Minutes is one")
  void testSetHoursWithHrsMinutes_whenOne_thenTbDateMinutesIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setHours(1, 1);

    // Assert
    assertEquals(1, tbDate.getMinutes());
    assertEquals(1, tbDate.getUTCMinutes());
  }

  /**
   * Test {@link TbDate#setMinutes(int, int, int)} with {@code minutes},
   * {@code seconds}, {@code ms}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Milliseconds is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setMinutes(int, int, int)}
   */
  @Test
  @DisplayName("Test setMinutes(int, int, int) with 'minutes', 'seconds', 'ms'; when one; then TbDate() Milliseconds is one")
  void testSetMinutesWithMinutesSecondsMs_whenOne_thenTbDateMillisecondsIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setMinutes(1, 1, 1);

    // Assert
    assertEquals(1, tbDate.getMilliseconds());
    assertEquals(1, tbDate.getMinutes());
    assertEquals(1, tbDate.getSeconds());
    assertEquals(1, tbDate.getUTCMilliseconds());
    assertEquals(1, tbDate.getUTCMinutes());
    assertEquals(1, tbDate.getUTCSeconds());
    assertEquals(1000000, tbDate.getInstant().getNano());
  }

  /**
   * Test {@link TbDate#setMinutes(int, int)} with {@code minutes},
   * {@code seconds}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setMinutes(int, int)}
   */
  @Test
  @DisplayName("Test setMinutes(int, int) with 'minutes', 'seconds'; when one; then TbDate() Minutes is one")
  void testSetMinutesWithMinutesSeconds_whenOne_thenTbDateMinutesIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setMinutes(1, 1);

    // Assert
    assertEquals(1, tbDate.getMinutes());
    assertEquals(1, tbDate.getSeconds());
    assertEquals(1, tbDate.getUTCMinutes());
    assertEquals(1, tbDate.getUTCSeconds());
  }

  /**
   * Test {@link TbDate#setMinutes(int)} with {@code minutes}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setMinutes(int)}
   */
  @Test
  @DisplayName("Test setMinutes(int) with 'minutes'; when one; then TbDate() Minutes is one")
  void testSetMinutesWithMinutes_whenOne_thenTbDateMinutesIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setMinutes(1);

    // Assert
    assertEquals(1, tbDate.getMinutes());
    assertEquals(1, tbDate.getUTCMinutes());
  }

  /**
   * Test {@link TbDate#setSeconds(int, int)} with {@code seconds}, {@code ms}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Milliseconds is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setSeconds(int, int)}
   */
  @Test
  @DisplayName("Test setSeconds(int, int) with 'seconds', 'ms'; when one; then TbDate() Milliseconds is one")
  void testSetSecondsWithSecondsMs_whenOne_thenTbDateMillisecondsIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setSeconds(1, 1);

    // Assert
    assertEquals(1, tbDate.getMilliseconds());
    assertEquals(1, tbDate.getSeconds());
    assertEquals(1, tbDate.getUTCMilliseconds());
    assertEquals(1, tbDate.getUTCSeconds());
    assertEquals(1000000, tbDate.getInstant().getNano());
  }

  /**
   * Test {@link TbDate#setSeconds(int)} with {@code seconds}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Seconds is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setSeconds(int)}
   */
  @Test
  @DisplayName("Test setSeconds(int) with 'seconds'; when one; then TbDate() Seconds is one")
  void testSetSecondsWithSeconds_whenOne_thenTbDateSecondsIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setSeconds(1);

    // Assert
    assertEquals(1, tbDate.getSeconds());
    assertEquals(1, tbDate.getUTCSeconds());
  }

  /**
   * Test {@link TbDate#setMilliseconds(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbDate#TbDate()} Milliseconds is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#setMilliseconds(int)}
   */
  @Test
  @DisplayName("Test setMilliseconds(int); when one; then TbDate() Milliseconds is one")
  void testSetMilliseconds_whenOne_thenTbDateMillisecondsIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setMilliseconds(1);

    // Assert
    assertEquals(1, tbDate.getMilliseconds());
    assertEquals(1, tbDate.getUTCMilliseconds());
    assertEquals(1000000, tbDate.getInstant().getNano());
  }

  /**
   * Test {@link TbDate#setTime(long)}.
   * <p>
   * Method under test: {@link TbDate#setTime(long)}
   */
  @Test
  @DisplayName("Test setTime(long)")
  void testSetTime() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setTime(1L);

    // Assert
    assertEquals("00:00:00.001", tbDate.getZonedDateTime().toLocalDateTime().toLocalTime().toString());
    assertEquals("00:00:00.001", tbDate.getUTCDateTime().toLocalTime().toString());
    assertEquals("1970-01-01T00:00:00.001Z", tbDate.toISOString());
    assertEquals("1970-01-01T00:00:00.001Z", tbDate.toJSON());
    assertEquals(1, tbDate.getMilliseconds());
    assertEquals(1, tbDate.getUTCMilliseconds());
    assertEquals(1000000, tbDate.getInstant().getNano());
    assertEquals(1L, tbDate.getTime());
  }

  /**
   * Test {@link TbDate#parse(String)} with {@code value}.
   * <p>
   * Method under test: {@link TbDate#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'value'")
  void testParseWithValue() {
    // Arrange, Act and Assert
    assertEquals(-1L, TbDate.parse("42"));
  }

  /**
   * Test {@link TbDate#parse(String, String)} with {@code value}, {@code format}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#parse(String, String)}
   */
  @Test
  @DisplayName("Test parse(String, String) with 'value', 'format'; when empty string; then return minus one")
  void testParseWithValueFormat_whenEmptyString_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1L, TbDate.parse("42", ""));
  }

  /**
   * Test {@link TbDate#parse(String, String)} with {@code value}, {@code format}.
   * <ul>
   *   <li>When {@code Format}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDate#parse(String, String)}
   */
  @Test
  @DisplayName("Test parse(String, String) with 'value', 'format'; when 'Format'; then return minus one")
  void testParseWithValueFormat_whenFormat_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1L, TbDate.parse("42", "Format"));
  }
}
