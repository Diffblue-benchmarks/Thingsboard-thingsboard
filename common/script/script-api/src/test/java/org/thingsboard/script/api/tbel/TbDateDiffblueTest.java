package org.thingsboard.script.api.tbel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mvel2.ConversionException;

class TbDateDiffblueTest {
  /**
   * Test {@link TbDate#TbDate(int, int, int)}.
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int)"})
  void testNewTbDate() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(100, 1, 1);

    // Assert
    assertEquals(
        "0100-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("0100-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(100, actualTbDate.getUTCFullYear());
    assertEquals(5, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, String)}.
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, String)}
   */
  @Test
  @DisplayName("Test new TbDate(int, int, int, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, String)"})
  void testNewTbDate2() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(100, 1, 1, null);

    // Assert
    assertEquals(
        "0100-01-01", actualTbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("0100-01-01", actualTbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(100, actualTbDate.getUTCFullYear());
    assertEquals(5, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(long)}.
   *
   * <p>Method under test: {@link TbDate#TbDate(long)}
   */
  @Test
  @DisplayName("Test new TbDate(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(long)"})
  void testNewTbDate3() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1L);

    // Assert
    assertEquals("1970 Jan 1, Thu 00:00:00", actualTbDate.toUTCString());
    assertEquals("1970 Jan 1, Thu", actualTbDate.toDateString());
    assertEquals("1970 Jan 1, Thu", actualTbDate.toLocaleDateString());
    assertEquals("1970-01-01T00:00:00.001Z", actualTbDate.toISOString());
    assertEquals("1970-01-01T00:00:00.001Z", actualTbDate.toJSON());
    assertEquals(0, actualTbDate.getMinutes());
    assertEquals(0, actualTbDate.getSeconds());
    assertEquals(0, actualTbDate.getUTCHours());
    assertEquals(0, actualTbDate.getUTCMinutes());
    assertEquals(0, actualTbDate.getUTCSeconds());
    assertEquals(1, actualTbDate.getMilliseconds());
    assertEquals(1, actualTbDate.getUTCDate());
    assertEquals(1, actualTbDate.getUTCMilliseconds());
    assertEquals(1, actualTbDate.getUTCMonth());
    assertEquals(1970, actualTbDate.getUTCFullYear());
    assertEquals(1L, actualTbDate.getTime());
    assertEquals(4, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(String)}
   */
  @Test
  @DisplayName("Test new TbDate(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(String)"})
  void testNewTbDate_when42() {
    // Arrange, Act and Assert
    assertThrows(ConversionException.class, () -> new TbDate("42"));
  }

  /**
   * Test {@link TbDate#TbDate(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link ConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(String, String)}
   */
  @Test
  @DisplayName("Test new TbDate(String, String); when '42'; then throw ConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(String, String)"})
  void testNewTbDate_when42_thenThrowConversionException() {
    // Arrange, Act and Assert
    assertThrows(ConversionException.class, () -> new TbDate("42", "42"));
  }

  /**
   * Test {@link TbDate#TbDate(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link ConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(String, String, String)}
   */
  @Test
  @DisplayName("Test new TbDate(String, String, String); when '42'; then throw ConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(String, String, String)"})
  void testNewTbDate_when42_thenThrowConversionException2() {
    // Arrange, Act and Assert
    assertThrows(ConversionException.class, () -> new TbDate("42", "42", "en"));
  }

  /**
   * Test {@link TbDate#TbDate(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(String)}
   */
  @Test
  @DisplayName("Test new TbDate(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(String)"})
  void testNewTbDate_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(ConversionException.class, () -> new TbDate(""));
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, int, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return toDateString is {@code 2001 Jan 1, Mon}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, int, int, String)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, int, int, String); when empty string; then return toDateString is '2001 Jan 1, Mon'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, int, int, String)"})
  void testNewTbDate_whenEmptyString_thenReturnToDateStringIs2001Jan1Mon() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1, 1, 1, 1, 1, 1, 1, "");

    // Assert
    assertEquals("2001 Jan 1, Mon", actualTbDate.toDateString());
    assertEquals("2001 Jan 1, Mon", actualTbDate.toLocaleDateString());
    assertEquals(1, actualTbDate.getDay());
    assertEquals(1, actualTbDate.getUTCDay());
    assertEquals(2001, actualTbDate.getFullYear());
    assertEquals(2001, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return toDateString is {@code 2001 Jan 1, Mon}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, int, String)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, int, String); when empty string; then return toDateString is '2001 Jan 1, Mon'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, int, String)"})
  void testNewTbDate_whenEmptyString_thenReturnToDateStringIs2001Jan1Mon2() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1, 1, 1, 1, 1, 1, "");

    // Assert
    assertEquals("2001 Jan 1, Mon", actualTbDate.toDateString());
    assertEquals("2001 Jan 1, Mon", actualTbDate.toLocaleDateString());
    assertEquals(1, actualTbDate.getDay());
    assertEquals(1, actualTbDate.getUTCDay());
    assertEquals(2001, actualTbDate.getFullYear());
    assertEquals(2001, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return toDateString is {@code 2001 Jan 1, Mon}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, String)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, String); when empty string; then return toDateString is '2001 Jan 1, Mon'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, String)"})
  void testNewTbDate_whenEmptyString_thenReturnToDateStringIs2001Jan1Mon3() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1, 1, 1, 1, 1, "");

    // Assert
    assertEquals("2001 Jan 1, Mon", actualTbDate.toDateString());
    assertEquals("2001 Jan 1, Mon", actualTbDate.toLocaleDateString());
    assertEquals(1, actualTbDate.getDay());
    assertEquals(1, actualTbDate.getUTCDay());
    assertEquals(2001, actualTbDate.getFullYear());
    assertEquals(2001, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return toDateString is {@code 2001 Jan 1, Mon}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, String)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, String); when empty string; then return toDateString is '2001 Jan 1, Mon'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, String)"})
  void testNewTbDate_whenEmptyString_thenReturnToDateStringIs2001Jan1Mon4() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1, 1, 1, "");

    // Assert
    assertEquals("2001 Jan 1, Mon", actualTbDate.toDateString());
    assertEquals("2001 Jan 1, Mon", actualTbDate.toLocaleDateString());
    assertEquals(1, actualTbDate.getDay());
    assertEquals(1, actualTbDate.getUTCDay());
    assertEquals(2001, actualTbDate.getFullYear());
    assertEquals(2001, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(String)}
   */
  @Test
  @DisplayName("Test new TbDate(String); when 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(String)"})
  void testNewTbDate_whenFoo() {
    // Arrange, Act and Assert
    assertThrows(ConversionException.class, () -> new TbDate("foo"));
  }

  /**
   * Test {@link TbDate#TbDate(String, String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then throw {@link ConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(String, String)}
   */
  @Test
  @DisplayName("Test new TbDate(String, String); when 'foo'; then throw ConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(String, String)"})
  void testNewTbDate_whenFoo_thenThrowConversionException() {
    // Arrange, Act and Assert
    assertThrows(ConversionException.class, () -> new TbDate("foo", "42"));
  }

  /**
   * Test {@link TbDate#TbDate(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then throw {@link ConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(String, String, String); when 'foo'; then throw ConversionException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(String, String, String)"})
  void testNewTbDate_whenFoo_thenThrowConversionException2() {
    // Arrange, Act and Assert
    assertThrows(ConversionException.class, () -> new TbDate("foo", "42", "en"));
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int)}.
   *
   * <ul>
   *   <li>When one hundred.
   *   <li>Then return toDateString is {@code 100 Jan 1, Fri}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int); when one hundred; then return toDateString is '100 Jan 1, Fri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int)"})
  void testNewTbDate_whenOneHundred_thenReturnToDateStringIs100Jan1Fri() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(100, 1, 1, 1, 1);

    // Assert
    assertEquals("100 Jan 1, Fri", actualTbDate.toDateString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toLocaleDateString());
    assertEquals(100, actualTbDate.getFullYear());
    assertEquals(100, actualTbDate.getUTCFullYear());
    assertEquals(5, actualTbDate.getDay());
    assertEquals(5, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int)}.
   *
   * <ul>
   *   <li>When one hundred.
   *   <li>Then return toDateString is {@code 100 Jan 1, Fri}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, int); when one hundred; then return toDateString is '100 Jan 1, Fri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, int)"})
  void testNewTbDate_whenOneHundred_thenReturnToDateStringIs100Jan1Fri2() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(100, 1, 1, 1, 1, 1);

    // Assert
    assertEquals("100 Jan 1, Fri", actualTbDate.toDateString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toLocaleDateString());
    assertEquals(100, actualTbDate.getFullYear());
    assertEquals(100, actualTbDate.getUTCFullYear());
    assertEquals(5, actualTbDate.getDay());
    assertEquals(5, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, int)}.
   *
   * <ul>
   *   <li>When one hundred.
   *   <li>Then return toDateString is {@code 100 Jan 1, Fri}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, int, int); when one hundred; then return toDateString is '100 Jan 1, Fri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, int, int)"})
  void testNewTbDate_whenOneHundred_thenReturnToDateStringIs100Jan1Fri3() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(100, 1, 1, 1, 1, 1, 1);

    // Assert
    assertEquals("100 Jan 1, Fri", actualTbDate.toDateString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toLocaleDateString());
    assertEquals(100, actualTbDate.getFullYear());
    assertEquals(100, actualTbDate.getUTCFullYear());
    assertEquals(5, actualTbDate.getDay());
    assertEquals(5, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, int, String)}.
   *
   * <ul>
   *   <li>When one hundred.
   *   <li>Then return toDateString is {@code 100 Jan 1, Fri}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, int, int, String)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, int, int, String); when one hundred; then return toDateString is '100 Jan 1, Fri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, int, int, String)"})
  void testNewTbDate_whenOneHundred_thenReturnToDateStringIs100Jan1Fri4() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(100, 1, 1, 1, 1, 1, 1, null);

    // Assert
    assertEquals("100 Jan 1, Fri", actualTbDate.toDateString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toLocaleDateString());
    assertEquals(100, actualTbDate.getFullYear());
    assertEquals(100, actualTbDate.getUTCFullYear());
    assertEquals(5, actualTbDate.getDay());
    assertEquals(5, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, String)}.
   *
   * <ul>
   *   <li>When one hundred.
   *   <li>Then return toDateString is {@code 100 Jan 1, Fri}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, int, String)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, int, String); when one hundred; then return toDateString is '100 Jan 1, Fri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, int, String)"})
  void testNewTbDate_whenOneHundred_thenReturnToDateStringIs100Jan1Fri5() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(100, 1, 1, 1, 1, 1, null);

    // Assert
    assertEquals("100 Jan 1, Fri", actualTbDate.toDateString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toLocaleDateString());
    assertEquals(100, actualTbDate.getFullYear());
    assertEquals(100, actualTbDate.getUTCFullYear());
    assertEquals(5, actualTbDate.getDay());
    assertEquals(5, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, String)}.
   *
   * <ul>
   *   <li>When one hundred.
   *   <li>Then return toDateString is {@code 100 Jan 1, Fri}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, String)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, String); when one hundred; then return toDateString is '100 Jan 1, Fri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, String)"})
  void testNewTbDate_whenOneHundred_thenReturnToDateStringIs100Jan1Fri6() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(100, 1, 1, 1, 1, null);

    // Assert
    assertEquals("100 Jan 1, Fri", actualTbDate.toDateString());
    assertEquals("100 Jan 1, Fri", actualTbDate.toLocaleDateString());
    assertEquals(100, actualTbDate.getFullYear());
    assertEquals(100, actualTbDate.getUTCFullYear());
    assertEquals(5, actualTbDate.getDay());
    assertEquals(5, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toDateString is {@code 2001 Jan 1, Mon}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int); when one; then return toDateString is '2001 Jan 1, Mon'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int)"})
  void testNewTbDate_whenOne_thenReturnToDateStringIs2001Jan1Mon() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1, 1, 1);

    // Assert
    assertEquals("2001 Jan 1, Mon", actualTbDate.toDateString());
    assertEquals("2001 Jan 1, Mon", actualTbDate.toLocaleDateString());
    assertEquals(1, actualTbDate.getDay());
    assertEquals(1, actualTbDate.getUTCDay());
    assertEquals(2001, actualTbDate.getFullYear());
    assertEquals(2001, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toDateString is {@code 2001 Jan 1, Mon}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int); when one; then return toDateString is '2001 Jan 1, Mon'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int)"})
  void testNewTbDate_whenOne_thenReturnToDateStringIs2001Jan1Mon2() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1, 1, 1, 1, 1);

    // Assert
    assertEquals("2001 Jan 1, Mon", actualTbDate.toDateString());
    assertEquals("2001 Jan 1, Mon", actualTbDate.toLocaleDateString());
    assertEquals(1, actualTbDate.getDay());
    assertEquals(1, actualTbDate.getUTCDay());
    assertEquals(2001, actualTbDate.getFullYear());
    assertEquals(2001, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toDateString is {@code 2001 Jan 1, Mon}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, int); when one; then return toDateString is '2001 Jan 1, Mon'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, int)"})
  void testNewTbDate_whenOne_thenReturnToDateStringIs2001Jan1Mon3() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1, 1, 1, 1, 1, 1);

    // Assert
    assertEquals("2001 Jan 1, Mon", actualTbDate.toDateString());
    assertEquals("2001 Jan 1, Mon", actualTbDate.toLocaleDateString());
    assertEquals(1, actualTbDate.getDay());
    assertEquals(1, actualTbDate.getUTCDay());
    assertEquals(2001, actualTbDate.getFullYear());
    assertEquals(2001, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toDateString is {@code 2001 Jan 1, Mon}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, int, int); when one; then return toDateString is '2001 Jan 1, Mon'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, int, int)"})
  void testNewTbDate_whenOne_thenReturnToDateStringIs2001Jan1Mon4() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(1, 1, 1, 1, 1, 1, 1);

    // Assert
    assertEquals("2001 Jan 1, Mon", actualTbDate.toDateString());
    assertEquals("2001 Jan 1, Mon", actualTbDate.toLocaleDateString());
    assertEquals(1, actualTbDate.getDay());
    assertEquals(1, actualTbDate.getUTCDay());
    assertEquals(2001, actualTbDate.getFullYear());
    assertEquals(2001, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int)}.
   *
   * <ul>
   *   <li>When seventy.
   *   <li>Then return toDateString is {@code 1970 Jan 1, Thu}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int); when seventy; then return toDateString is '1970 Jan 1, Thu'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int)"})
  void testNewTbDate_whenSeventy_thenReturnToDateStringIs1970Jan1Thu() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(70, 1, 1, 1, 1);

    // Assert
    assertEquals("1970 Jan 1, Thu", actualTbDate.toDateString());
    assertEquals("1970 Jan 1, Thu", actualTbDate.toLocaleDateString());
    assertEquals(1970, actualTbDate.getFullYear());
    assertEquals(1970, actualTbDate.getUTCFullYear());
    assertEquals(4, actualTbDate.getDay());
    assertEquals(4, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int)}.
   *
   * <ul>
   *   <li>When seventy.
   *   <li>Then return toDateString is {@code 1970 Jan 1, Thu}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, int); when seventy; then return toDateString is '1970 Jan 1, Thu'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, int)"})
  void testNewTbDate_whenSeventy_thenReturnToDateStringIs1970Jan1Thu2() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(70, 1, 1, 1, 1, 1);

    // Assert
    assertEquals("1970 Jan 1, Thu", actualTbDate.toDateString());
    assertEquals("1970 Jan 1, Thu", actualTbDate.toLocaleDateString());
    assertEquals(1970, actualTbDate.getFullYear());
    assertEquals(1970, actualTbDate.getUTCFullYear());
    assertEquals(4, actualTbDate.getDay());
    assertEquals(4, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, int)}.
   *
   * <ul>
   *   <li>When seventy.
   *   <li>Then return toDateString is {@code 1970 Jan 1, Thu}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, int, int); when seventy; then return toDateString is '1970 Jan 1, Thu'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, int, int)"})
  void testNewTbDate_whenSeventy_thenReturnToDateStringIs1970Jan1Thu3() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(70, 1, 1, 1, 1, 1, 1);

    // Assert
    assertEquals("1970 Jan 1, Thu", actualTbDate.toDateString());
    assertEquals("1970 Jan 1, Thu", actualTbDate.toLocaleDateString());
    assertEquals(1970, actualTbDate.getFullYear());
    assertEquals(1970, actualTbDate.getUTCFullYear());
    assertEquals(4, actualTbDate.getDay());
    assertEquals(4, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, int, String)}.
   *
   * <ul>
   *   <li>When seventy.
   *   <li>Then return toDateString is {@code 1970 Jan 1, Thu}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, int, int, String)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, int, int, String); when seventy; then return toDateString is '1970 Jan 1, Thu'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, int, int, String)"})
  void testNewTbDate_whenSeventy_thenReturnToDateStringIs1970Jan1Thu4() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(70, 1, 1, 1, 1, 1, 1, null);

    // Assert
    assertEquals("1970 Jan 1, Thu", actualTbDate.toDateString());
    assertEquals("1970 Jan 1, Thu", actualTbDate.toLocaleDateString());
    assertEquals(1970, actualTbDate.getFullYear());
    assertEquals(1970, actualTbDate.getUTCFullYear());
    assertEquals(4, actualTbDate.getDay());
    assertEquals(4, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, String)}.
   *
   * <ul>
   *   <li>When seventy.
   *   <li>Then return toDateString is {@code 1970 Jan 1, Thu}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, int, String)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, int, String); when seventy; then return toDateString is '1970 Jan 1, Thu'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, int, String)"})
  void testNewTbDate_whenSeventy_thenReturnToDateStringIs1970Jan1Thu5() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(70, 1, 1, 1, 1, 1, null);

    // Assert
    assertEquals("1970 Jan 1, Thu", actualTbDate.toDateString());
    assertEquals("1970 Jan 1, Thu", actualTbDate.toLocaleDateString());
    assertEquals(1970, actualTbDate.getFullYear());
    assertEquals(1970, actualTbDate.getUTCFullYear());
    assertEquals(4, actualTbDate.getDay());
    assertEquals(4, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, String)}.
   *
   * <ul>
   *   <li>When seventy.
   *   <li>Then return toDateString is {@code 1970 Jan 1, Thu}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, String)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, String); when seventy; then return toDateString is '1970 Jan 1, Thu'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, String)"})
  void testNewTbDate_whenSeventy_thenReturnToDateStringIs1970Jan1Thu6() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(70, 1, 1, 1, 1, null);

    // Assert
    assertEquals("1970 Jan 1, Thu", actualTbDate.toDateString());
    assertEquals("1970 Jan 1, Thu", actualTbDate.toLocaleDateString());
    assertEquals(1970, actualTbDate.getFullYear());
    assertEquals(1970, actualTbDate.getUTCFullYear());
    assertEquals(4, actualTbDate.getDay());
    assertEquals(4, actualTbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, int, String)}.
   *
   * <ul>
   *   <li>When sixty-nine.
   *   <li>Then return toDateString is {@code 2069 Jan 1, Tue}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, int, int, String)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, int, int, String); when sixty-nine; then return toDateString is '2069 Jan 1, Tue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, int, int, String)"})
  void testNewTbDate_whenSixtyNine_thenReturnToDateStringIs2069Jan1Tue() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(69, 1, 1, 1, 1, 1, 1, null);

    // Assert
    assertEquals("2069 Jan 1, Tue", actualTbDate.toDateString());
    assertEquals("2069 Jan 1, Tue", actualTbDate.toLocaleDateString());
    assertEquals(2, actualTbDate.getDay());
    assertEquals(2, actualTbDate.getUTCDay());
    assertEquals(2069, actualTbDate.getFullYear());
    assertEquals(2069, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, int, String)}.
   *
   * <ul>
   *   <li>When sixty-nine.
   *   <li>Then return toDateString is {@code 2069 Jan 1, Tue}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, int, String)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, int, String); when sixty-nine; then return toDateString is '2069 Jan 1, Tue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, int, String)"})
  void testNewTbDate_whenSixtyNine_thenReturnToDateStringIs2069Jan1Tue2() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(69, 1, 1, 1, 1, 1, null);

    // Assert
    assertEquals("2069 Jan 1, Tue", actualTbDate.toDateString());
    assertEquals("2069 Jan 1, Tue", actualTbDate.toLocaleDateString());
    assertEquals(2, actualTbDate.getDay());
    assertEquals(2, actualTbDate.getUTCDay());
    assertEquals(2069, actualTbDate.getFullYear());
    assertEquals(2069, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, int, int, String)}.
   *
   * <ul>
   *   <li>When sixty-nine.
   *   <li>Then return toDateString is {@code 2069 Jan 1, Tue}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, int, int, String)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, int, int, String); when sixty-nine; then return toDateString is '2069 Jan 1, Tue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, int, int, String)"})
  void testNewTbDate_whenSixtyNine_thenReturnToDateStringIs2069Jan1Tue3() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(69, 1, 1, 1, 1, null);

    // Assert
    assertEquals("2069 Jan 1, Tue", actualTbDate.toDateString());
    assertEquals("2069 Jan 1, Tue", actualTbDate.toLocaleDateString());
    assertEquals(2, actualTbDate.getDay());
    assertEquals(2, actualTbDate.getUTCDay());
    assertEquals(2069, actualTbDate.getFullYear());
    assertEquals(2069, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#TbDate(int, int, int, String)}.
   *
   * <ul>
   *   <li>When sixty-nine.
   *   <li>Then return toDateString is {@code 2069 Jan 1, Tue}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#TbDate(int, int, int, String)}
   */
  @Test
  @DisplayName(
      "Test new TbDate(int, int, int, String); when sixty-nine; then return toDateString is '2069 Jan 1, Tue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.<init>(int, int, int, String)"})
  void testNewTbDate_whenSixtyNine_thenReturnToDateStringIs2069Jan1Tue4() {
    // Arrange and Act
    TbDate actualTbDate = new TbDate(69, 1, 1, null);

    // Assert
    assertEquals("2069 Jan 1, Tue", actualTbDate.toDateString());
    assertEquals("2069 Jan 1, Tue", actualTbDate.toLocaleDateString());
    assertEquals(2, actualTbDate.getDay());
    assertEquals(2, actualTbDate.getUTCDay());
    assertEquals(2069, actualTbDate.getFullYear());
    assertEquals(2069, actualTbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#getZonedDateTime()}.
   *
   * <p>Method under test: {@link TbDate#getZonedDateTime()}
   */
  @Test
  @DisplayName("Test getZonedDateTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.time.ZonedDateTime TbDate.getZonedDateTime()"})
  void testGetZonedDateTime() {
    // Arrange, Act and Assert
    assertEquals("UTC", new TbDate().getZonedDateTime().getZone().toString());
  }

  /**
   * Test {@link TbDate#getZonedDateTime(ZoneId)} with {@code ZoneId}.
   *
   * <ul>
   *   <li>Then return Zone is ofTotalSeconds one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#getZonedDateTime(ZoneId)}
   */
  @Test
  @DisplayName(
      "Test getZonedDateTime(ZoneId) with 'ZoneId'; then return Zone is ofTotalSeconds one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.time.ZonedDateTime TbDate.getZonedDateTime(ZoneId)"})
  void testGetZonedDateTimeWithZoneId_thenReturnZoneIsOfTotalSecondsOne() {
    // Arrange
    ZoneOffset zoneId = ZoneOffset.ofTotalSeconds(1);

    // Act and Assert
    assertSame(zoneId, new TbDate().getZonedDateTime(zoneId).getZone());
  }

  /**
   * Test {@link TbDate#toDateString(String, String)} with {@code localeStr}, {@code optionsStr}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#toDateString(String, String)}
   */
  @Test
  @DisplayName(
      "Test toDateString(String, String) with 'localeStr', 'optionsStr'; given '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbDate.toDateString(String, String)"})
  void testToDateStringWithLocaleStrOptionsStr_given42_thenReturn42()
      throws JsonProcessingException {
    // Arrange
    TbDate tbDate = new TbDate();

    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions("UTC");
    dateTimeFormatOptions.setPattern("42");
    String optionsStr =
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(dateTimeFormatOptions);

    // Act and Assert
    assertEquals("42", tbDate.toDateString("not empty", optionsStr));
  }

  /**
   * Test {@link TbDate#toTimeString(String, String)} with {@code localeStr}, {@code optionsStr}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#toTimeString(String, String)}
   */
  @Test
  @DisplayName(
      "Test toTimeString(String, String) with 'localeStr', 'optionsStr'; given '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbDate.toTimeString(String, String)"})
  void testToTimeStringWithLocaleStrOptionsStr_given42_thenReturn42()
      throws JsonProcessingException {
    // Arrange
    TbDate tbDate = new TbDate();

    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions("UTC");
    dateTimeFormatOptions.setPattern("42");
    String optionsStr =
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(dateTimeFormatOptions);

    // Act and Assert
    assertEquals("42", tbDate.toTimeString("not empty", optionsStr));
  }

  /**
   * Test {@link TbDate#toString(String, String)} with {@code localeStr}, {@code optionsStr}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#toString(String, String)}
   */
  @Test
  @DisplayName(
      "Test toString(String, String) with 'localeStr', 'optionsStr'; given '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbDate.toString(String, String)"})
  void testToStringWithLocaleStrOptionsStr_given42_thenReturn42() throws JsonProcessingException {
    // Arrange
    TbDate tbDate = new TbDate();

    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions("UTC");
    dateTimeFormatOptions.setPattern("42");
    String optionsStr =
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(dateTimeFormatOptions);

    // Act and Assert
    assertEquals("42", tbDate.toString("not empty", optionsStr));
  }

  /**
   * Test {@link TbDate#toLocaleDateString(String, String)} with {@code localeStr}, {@code
   * optionsStr}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#toLocaleDateString(String, String)}
   */
  @Test
  @DisplayName(
      "Test toLocaleDateString(String, String) with 'localeStr', 'optionsStr'; given '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbDate.toLocaleDateString(String, String)"})
  void testToLocaleDateStringWithLocaleStrOptionsStr_given42_thenReturn42()
      throws JsonProcessingException {
    // Arrange
    TbDate tbDate = new TbDate();

    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions("UTC");
    dateTimeFormatOptions.setPattern("42");
    String optionsStr =
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(dateTimeFormatOptions);

    // Act and Assert
    assertEquals("42", tbDate.toLocaleDateString("not empty", optionsStr));
  }

  /**
   * Test {@link TbDate#toLocaleTimeString(String, String)} with {@code localeStr}, {@code
   * optionsStr}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#toLocaleTimeString(String, String)}
   */
  @Test
  @DisplayName(
      "Test toLocaleTimeString(String, String) with 'localeStr', 'optionsStr'; given '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbDate.toLocaleTimeString(String, String)"})
  void testToLocaleTimeStringWithLocaleStrOptionsStr_given42_thenReturn42()
      throws JsonProcessingException {
    // Arrange
    TbDate tbDate = new TbDate();

    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions("UTC");
    dateTimeFormatOptions.setPattern("42");
    String optionsStr =
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(dateTimeFormatOptions);

    // Act and Assert
    assertEquals("42", tbDate.toLocaleTimeString("not empty", optionsStr));
  }

  /**
   * Test {@link TbDate#toLocaleString(String, String, BiFunction)} with {@code localeStr}, {@code
   * optionsStr}, {@code formatterBuilder}.
   *
   * <p>Method under test: {@link TbDate#toLocaleString(String, String, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test toLocaleString(String, String, BiFunction) with 'localeStr', 'optionsStr', 'formatterBuilder'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbDate.toLocaleString(String, String, BiFunction)"})
  void testToLocaleStringWithLocaleStrOptionsStrFormatterBuilder() {
    // Arrange
    TbDate tbDate = new TbDate();

    BiFunction<Locale, DateTimeFormatOptions, DateTimeFormatter> formatterBuilder =
        mock(BiFunction.class);
    when(formatterBuilder.apply(Mockito.<Locale>any(), Mockito.<DateTimeFormatOptions>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> tbDate.toLocaleString("en", "en", formatterBuilder));
    verify(formatterBuilder).apply(isA(Locale.class), isA(DateTimeFormatOptions.class));
  }

  /**
   * Test {@link TbDate#toLocaleString(String, String)} with {@code localeStr}, {@code optionsStr}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#toLocaleString(String, String)}
   */
  @Test
  @DisplayName(
      "Test toLocaleString(String, String) with 'localeStr', 'optionsStr'; given '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbDate.toLocaleString(String, String)"})
  void testToLocaleStringWithLocaleStrOptionsStr_given42_thenReturn42()
      throws JsonProcessingException {
    // Arrange
    TbDate tbDate = new TbDate();

    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions("UTC");
    dateTimeFormatOptions.setPattern("42");
    String optionsStr =
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(dateTimeFormatOptions);

    // Act and Assert
    assertEquals("42", tbDate.toLocaleString("not empty", optionsStr));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int, int)} with {@code year}, {@code month},
   * {@code date}, {@code hrs}, {@code min}, {@code sec}, {@code ms}.
   *
   * <ul>
   *   <li>When {@code 2000}.
   *   <li>Then return {@code 952052463003}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec', 'ms'; when '2000'; then return '952052463003'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMinSecMs_when2000_thenReturn952052463003() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(2000, 3, 3, 3, 1, 3, 3);

    // Assert
    assertEquals(952052463003L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int, int)} with {@code year}, {@code month},
   * {@code date}, {@code hrs}, {@code min}, {@code sec}, {@code ms}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then return {@code 1046660463000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec', 'ms'; when MIN_VALUE; then return '1046660463000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMinSecMs_whenMin_value_thenReturn1046660463000() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(3, 3, 3, 3, 1, 3, Integer.MIN_VALUE);

    // Assert
    assertEquals(1046660463000L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int, int)} with {@code year}, {@code month},
   * {@code date}, {@code hrs}, {@code min}, {@code sec}, {@code ms}.
   *
   * <ul>
   *   <li>When seventy.
   *   <li>Then return {@code 5281263003}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec', 'ms'; when seventy; then return '5281263003'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMinSecMs_whenSeventy_thenReturn5281263003() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(70, 3, 3, 3, 1, 3, 3);

    // Assert
    assertEquals(5281263003L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int, int)} with {@code year}, {@code month},
   * {@code date}, {@code hrs}, {@code min}, {@code sec}, {@code ms}.
   *
   * <ul>
   *   <li>When seventy.
   *   <li>Then return {@code 1046660463070}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec', 'ms'; when seventy; then return '1046660463070'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMinSecMs_whenSeventy_thenReturn1046660463070() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(3, 3, 3, 3, 1, 3, 70);

    // Assert
    assertEquals(1046660463070L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int, int)} with {@code year}, {@code month},
   * {@code date}, {@code hrs}, {@code min}, {@code sec}, {@code ms}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 1046660463003}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec', 'ms'; when three; then return '1046660463003'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMinSecMs_whenThree_thenReturn1046660463003() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(3, 3, 3, 3, 1, 3, 3);

    // Assert
    assertEquals(1046660463003L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int, int)} with {@code year}, {@code month},
   * {@code date}, {@code hrs}, {@code min}, {@code sec}, {@code ms}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code 1046660463000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec', 'ms'; when zero; then return '1046660463000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMinSecMs_whenZero_thenReturn1046660463000() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(3, 3, 3, 3, 1, 3, 0);

    // Assert
    assertEquals(1046660463000L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int, int)} with {@code year}, {@code month},
   * {@code date}, {@code hrs}, {@code min}, {@code sec}, {@code ms}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code 1049079663003}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec', 'ms'; when zero; then return '1049079663003'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMinSecMs_whenZero_thenReturn1049079663003() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(3, 3, 0, 3, 1, 3, 3);

    // Assert
    assertEquals(1049079663003L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int, int)} with {@code year}, {@code month},
   * {@code date}, {@code hrs}, {@code min}, {@code sec}, {@code ms}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code 1070420463003}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec', 'ms'; when zero; then return '1070420463003'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMinSecMs_whenZero_thenReturn1070420463003() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(3, 0, 3, 3, 1, 3, 3);

    // Assert
    assertEquals(1070420463003L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int, int)} with {@code year}, {@code month},
   * {@code date}, {@code hrs}, {@code min}, {@code sec}, {@code ms}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code -2235243536997}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec', 'ms'; when zero; then return '-2235243536997'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMinSecMs_whenZero_thenReturn2235243536997() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(0, 3, 3, 3, 1, 3, 3);

    // Assert
    assertEquals(-2235243536997L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int)} with {@code year}, {@code month}, {@code
   * date}, {@code hrs}, {@code min}, {@code sec}.
   *
   * <ul>
   *   <li>When seventy.
   *   <li>Then return {@code 31460463000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec'; when seventy; then return '31460463000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMinSec_whenSeventy_thenReturn31460463000() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(70, 0, 0, 3, 1, 3);

    // Assert
    assertEquals(31460463000L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int)} with {@code year}, {@code month}, {@code
   * date}, {@code hrs}, {@code min}, {@code sec}.
   *
   * <ul>
   *   <li>When sixty-nine.
   *   <li>Then return {@code 3155684463000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec'; when sixty-nine; then return '3155684463000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMinSec_whenSixtyNine_thenReturn3155684463000() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(69, 0, 0, 3, 1, 3);

    // Assert
    assertEquals(3155684463000L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int)} with {@code year}, {@code month}, {@code
   * date}, {@code hrs}, {@code min}, {@code sec}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 1046660463000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec'; when three; then return '1046660463000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMinSec_whenThree_thenReturn1046660463000() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(3, 3, 3, 3, 1, 3);

    // Assert
    assertEquals(1046660463000L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int, int)} with {@code year}, {@code month}, {@code
   * date}, {@code hrs}, {@code min}, {@code sec}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code -2209064337000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min', 'sec'; when zero; then return '-2209064337000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMinSec_whenZero_thenReturn2209064337000() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(0, 0, 0, 3, 1, 3);

    // Assert
    assertEquals(-2209064337000L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int)} with {@code year}, {@code month}, {@code
   * date}, {@code hrs}, {@code min}.
   *
   * <ul>
   *   <li>When seventy.
   *   <li>Then return {@code 31460460000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min'; when seventy; then return '31460460000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMin_whenSeventy_thenReturn31460460000() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(70, 0, 0, 3, 1);

    // Assert
    assertEquals(31460460000L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int)} with {@code year}, {@code month}, {@code
   * date}, {@code hrs}, {@code min}.
   *
   * <ul>
   *   <li>When sixty-nine.
   *   <li>Then return {@code 3155684460000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min'; when sixty-nine; then return '3155684460000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMin_whenSixtyNine_thenReturn3155684460000() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(69, 0, 0, 3, 1);

    // Assert
    assertEquals(3155684460000L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int)} with {@code year}, {@code month}, {@code
   * date}, {@code hrs}, {@code min}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 1046660460000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min'; when three; then return '1046660460000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMin_whenThree_thenReturn1046660460000() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(3, 3, 3, 3, 1);

    // Assert
    assertEquals(1046660460000L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int, int)} with {@code year}, {@code month}, {@code
   * date}, {@code hrs}, {@code min}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code -2209064340000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int, int) with 'year', 'month', 'date', 'hrs', 'min'; when zero; then return '-2209064340000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int, int)"})
  void testUtcWithYearMonthDateHrsMin_whenZero_thenReturn2209064340000() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(0, 0, 0, 3, 1);

    // Assert
    assertEquals(-2209064340000L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int)} with {@code year}, {@code month}, {@code date},
   * {@code hrs}.
   *
   * <ul>
   *   <li>When seventy.
   *   <li>Then return {@code 31460400000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int) with 'year', 'month', 'date', 'hrs'; when seventy; then return '31460400000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int)"})
  void testUtcWithYearMonthDateHrs_whenSeventy_thenReturn31460400000() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(70, 0, 0, 3);

    // Assert
    assertEquals(31460400000L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int)} with {@code year}, {@code month}, {@code date},
   * {@code hrs}.
   *
   * <ul>
   *   <li>When sixty-nine.
   *   <li>Then return {@code 3155684400000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int) with 'year', 'month', 'date', 'hrs'; when sixty-nine; then return '3155684400000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int)"})
  void testUtcWithYearMonthDateHrs_whenSixtyNine_thenReturn3155684400000() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(69, 0, 0, 3);

    // Assert
    assertEquals(3155684400000L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int)} with {@code year}, {@code month}, {@code date},
   * {@code hrs}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 1046660400000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int) with 'year', 'month', 'date', 'hrs'; when three; then return '1046660400000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int)"})
  void testUtcWithYearMonthDateHrs_whenThree_thenReturn1046660400000() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(3, 3, 3, 3);

    // Assert
    assertEquals(1046660400000L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int, int)} with {@code year}, {@code month}, {@code date},
   * {@code hrs}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code -2209064400000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int, int) with 'year', 'month', 'date', 'hrs'; when zero; then return '-2209064400000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int, int)"})
  void testUtcWithYearMonthDateHrs_whenZero_thenReturn2209064400000() {
    // Arrange and Act
    long actualUTCResult = TbDate.UTC(0, 0, 0, 3);

    // Assert
    assertEquals(-2209064400000L, actualUTCResult);
  }

  /**
   * Test {@link TbDate#UTC(int, int, int)} with {@code year}, {@code month}, {@code date}.
   *
   * <ul>
   *   <li>When seventy.
   *   <li>Then return {@code 31449600000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int) with 'year', 'month', 'date'; when seventy; then return '31449600000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int)"})
  void testUtcWithYearMonthDate_whenSeventy_thenReturn31449600000() {
    // Arrange, Act and Assert
    assertEquals(31449600000L, TbDate.UTC(70, 0, 0));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int)} with {@code year}, {@code month}, {@code date}.
   *
   * <ul>
   *   <li>When sixty-nine.
   *   <li>Then return {@code 3155673600000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int) with 'year', 'month', 'date'; when sixty-nine; then return '3155673600000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int)"})
  void testUtcWithYearMonthDate_whenSixtyNine_thenReturn3155673600000() {
    // Arrange, Act and Assert
    assertEquals(3155673600000L, TbDate.UTC(69, 0, 0));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int)} with {@code year}, {@code month}, {@code date}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 1046649600000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int) with 'year', 'month', 'date'; when three; then return '1046649600000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int)"})
  void testUtcWithYearMonthDate_whenThree_thenReturn1046649600000() {
    // Arrange, Act and Assert
    assertEquals(1046649600000L, TbDate.UTC(3, 3, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int, int)} with {@code year}, {@code month}, {@code date}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code -2209075200000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int, int) with 'year', 'month', 'date'; when zero; then return '-2209075200000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int, int)"})
  void testUtcWithYearMonthDate_whenZero_thenReturn2209075200000() {
    // Arrange, Act and Assert
    assertEquals(-2209075200000L, TbDate.UTC(0, 0, 0));
  }

  /**
   * Test {@link TbDate#UTC(int, int)} with {@code year}, {@code month}.
   *
   * <ul>
   *   <li>When seventy.
   *   <li>Then return {@code 31449600000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int) with 'year', 'month'; when seventy; then return '31449600000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int)"})
  void testUtcWithYearMonth_whenSeventy_thenReturn31449600000() {
    // Arrange, Act and Assert
    assertEquals(31449600000L, TbDate.UTC(70, 0));
  }

  /**
   * Test {@link TbDate#UTC(int, int)} with {@code year}, {@code month}.
   *
   * <ul>
   *   <li>When sixty-nine.
   *   <li>Then return {@code 3155673600000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int)}
   */
  @Test
  @DisplayName(
      "Test UTC(int, int) with 'year', 'month'; when sixty-nine; then return '3155673600000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int)"})
  void testUtcWithYearMonth_whenSixtyNine_thenReturn3155673600000() {
    // Arrange, Act and Assert
    assertEquals(3155673600000L, TbDate.UTC(69, 0));
  }

  /**
   * Test {@link TbDate#UTC(int, int)} with {@code year}, {@code month}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 1049068800000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int) with 'year', 'month'; when three; then return '1049068800000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int)"})
  void testUtcWithYearMonth_whenThree_thenReturn1049068800000() {
    // Arrange, Act and Assert
    assertEquals(1049068800000L, TbDate.UTC(3, 3));
  }

  /**
   * Test {@link TbDate#UTC(int, int)} with {@code year}, {@code month}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code -2209075200000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int, int)}
   */
  @Test
  @DisplayName("Test UTC(int, int) with 'year', 'month'; when zero; then return '-2209075200000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int, int)"})
  void testUtcWithYearMonth_whenZero_thenReturn2209075200000() {
    // Arrange, Act and Assert
    assertEquals(-2209075200000L, TbDate.UTC(0, 0));
  }

  /**
   * Test {@link TbDate#UTC(int)} with {@code year}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 1009756800000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int)}
   */
  @Test
  @DisplayName("Test UTC(int) with 'year'; when one; then return '1009756800000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int)"})
  void testUtcWithYear_whenOne_thenReturn1009756800000() {
    // Arrange, Act and Assert
    assertEquals(1009756800000L, TbDate.UTC(1));
  }

  /**
   * Test {@link TbDate#UTC(int)} with {@code year}.
   *
   * <ul>
   *   <li>When seventy.
   *   <li>Then return {@code 31449600000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int)}
   */
  @Test
  @DisplayName("Test UTC(int) with 'year'; when seventy; then return '31449600000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int)"})
  void testUtcWithYear_whenSeventy_thenReturn31449600000() {
    // Arrange, Act and Assert
    assertEquals(31449600000L, TbDate.UTC(70));
  }

  /**
   * Test {@link TbDate#UTC(int)} with {@code year}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code -2209075200000}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#UTC(int)}
   */
  @Test
  @DisplayName("Test UTC(int) with 'year'; when zero; then return '-2209075200000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.UTC(int)"})
  void testUtcWithYear_whenZero_thenReturn2209075200000() {
    // Arrange, Act and Assert
    assertEquals(-2209075200000L, TbDate.UTC(0));
  }

  /**
   * Test {@link TbDate#setUTCFullYear(int)} with {@code year}.
   *
   * <p>Method under test: {@link TbDate#setUTCFullYear(int)}
   */
  @Test
  @DisplayName("Test setUTCFullYear(int) with 'year'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setUTCFullYear(int)"})
  void testSetUTCFullYearWithYear() {
    // Arrange
    TbDate tbDate = new TbDate();
    tbDate.setTime(-1L);

    // Act
    tbDate.setUTCFullYear(1);

    // Assert
    assertEquals(
        "0001-12-31", tbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
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
   * Test {@link TbDate#setUTCFullYear(int, int, int)} with {@code year}, {@code month}, {@code
   * date}.
   *
   * <p>Method under test: {@link TbDate#setUTCFullYear(int, int, int)}
   */
  @Test
  @DisplayName("Test setUTCFullYear(int, int, int) with 'year', 'month', 'date'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setUTCFullYear(int, int, int)"})
  void testSetUTCFullYearWithYearMonthDate() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCFullYear(1, 1, 1);

    // Assert
    assertEquals(
        "0001-01-01", tbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("0001-01-01", tbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals(1, tbDate.getUTCDay());
    assertEquals(1, tbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#setUTCFullYear(int, int)} with {@code year}, {@code month}.
   *
   * <ul>
   *   <li>Given {@link TbDate#TbDate()}.
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} UTCMonth is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setUTCFullYear(int, int)}
   */
  @Test
  @DisplayName(
      "Test setUTCFullYear(int, int) with 'year', 'month'; given TbDate(); when one; then TbDate() UTCMonth is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setUTCFullYear(int, int)"})
  void testSetUTCFullYearWithYearMonth_givenTbDate_whenOne_thenTbDateUTCMonthIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCFullYear(1, 1);

    // Assert
    assertEquals(1, tbDate.getUTCMonth());
  }

  /**
   * Test {@link TbDate#setUTCFullYear(int, int)} with {@code year}, {@code month}.
   *
   * <ul>
   *   <li>Then {@link TbDate#TbDate()} toISOString is {@code 0001-01-31T23:59:59.999Z}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setUTCFullYear(int, int)}
   */
  @Test
  @DisplayName(
      "Test setUTCFullYear(int, int) with 'year', 'month'; then TbDate() toISOString is '0001-01-31T23:59:59.999Z'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setUTCFullYear(int, int)"})
  void testSetUTCFullYearWithYearMonth_thenTbDateToISOStringIs00010131t235959999z() {
    // Arrange
    TbDate tbDate = new TbDate();
    tbDate.setTime(-1L);

    // Act
    tbDate.setUTCFullYear(1, 1);

    // Assert
    assertEquals("0001-01-31T23:59:59.999Z", tbDate.toISOString());
    assertEquals("0001-01-31T23:59:59.999Z", tbDate.toJSON());
    assertEquals("1 Jan 31, Wed 23:59:59", tbDate.toUTCString());
    assertEquals("1 Jan 31, Wed", tbDate.toDateString());
    assertEquals("1 Jan 31, Wed", tbDate.toLocaleDateString());
    assertEquals(-62132918400001L, tbDate.getTime());
    assertEquals(-62132918401L, tbDate.getInstant().getEpochSecond());
    assertEquals(1, tbDate.getMonth());
    assertEquals(1, tbDate.getUTCMonth());
    assertEquals(3, tbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#setUTCMonth(int)} with {@code month}.
   *
   * <ul>
   *   <li>Given {@link TbDate#TbDate()}.
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} UTCMonth is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setUTCMonth(int)}
   */
  @Test
  @DisplayName(
      "Test setUTCMonth(int) with 'month'; given TbDate(); when one; then TbDate() UTCMonth is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setUTCMonth(int)"})
  void testSetUTCMonthWithMonth_givenTbDate_whenOne_thenTbDateUTCMonthIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCMonth(1);

    // Assert that nothing has changed
    assertEquals(1, tbDate.getUTCMonth());
  }

  /**
   * Test {@link TbDate#setUTCMonth(int)} with {@code month}.
   *
   * <ul>
   *   <li>Then {@link TbDate#TbDate()} toUTCString is {@code 1969 Jan 31, Fri 23:59:59}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setUTCMonth(int)}
   */
  @Test
  @DisplayName(
      "Test setUTCMonth(int) with 'month'; then TbDate() toUTCString is '1969 Jan 31, Fri 23:59:59'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setUTCMonth(int)"})
  void testSetUTCMonthWithMonth_thenTbDateToUTCStringIs1969Jan31Fri235959() {
    // Arrange
    TbDate tbDate = new TbDate();
    tbDate.setTime(-1L);

    // Act
    tbDate.setUTCMonth(1);

    // Assert
    assertEquals("1969 Jan 31, Fri 23:59:59", tbDate.toUTCString());
    assertEquals(
        "1969-01-31", tbDate.getZonedDateTime().toLocalDateTime().toLocalDate().toString());
    assertEquals("1969-01-31", tbDate.getUTCDateTime().toLocalDate().toString());
    assertEquals("1969-01-31T23:59:59.999Z", tbDate.toISOString());
    assertEquals("1969-01-31T23:59:59.999Z", tbDate.toJSON());
    assertEquals(-28857600001L, tbDate.getTime());
    assertEquals(-28857601L, tbDate.getInstant().getEpochSecond());
    assertEquals(1, tbDate.getUTCMonth());
    assertEquals(5, tbDate.getUTCDay());
  }

  /**
   * Test {@link TbDate#setUTCHours(int, int, int, int)} with {@code hrs}, {@code minutes}, {@code
   * seconds}, {@code ms}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Milliseconds is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setUTCHours(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test setUTCHours(int, int, int, int) with 'hrs', 'minutes', 'seconds', 'ms'; when one; then TbDate() Milliseconds is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setUTCHours(int, int, int, int)"})
  void testSetUTCHoursWithHrsMinutesSecondsMs_whenOne_thenTbDateMillisecondsIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCHours(1, 1, 1, 1);

    // Assert
    assertEquals(1, tbDate.getMilliseconds());
    assertEquals(1, tbDate.getMinutes());
    assertEquals(1, tbDate.getSeconds());
    assertEquals(1, tbDate.getUTCHours());
    assertEquals(1, tbDate.getUTCMilliseconds());
    assertEquals(1, tbDate.getUTCMinutes());
    assertEquals(1, tbDate.getUTCSeconds());
  }

  /**
   * Test {@link TbDate#setUTCHours(int, int, int)} with {@code hrs}, {@code minutes}, {@code
   * seconds}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setUTCHours(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test setUTCHours(int, int, int) with 'hrs', 'minutes', 'seconds'; when one; then TbDate() Minutes is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setUTCHours(int, int, int)"})
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
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setUTCHours(int, int)}
   */
  @Test
  @DisplayName(
      "Test setUTCHours(int, int) with 'hrs', 'minutes'; when one; then TbDate() Minutes is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setUTCHours(int, int)"})
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
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} UTCHours is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setUTCHours(int)}
   */
  @Test
  @DisplayName("Test setUTCHours(int) with 'hrs'; when one; then TbDate() UTCHours is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setUTCHours(int)"})
  void testSetUTCHoursWithHrs_whenOne_thenTbDateUTCHoursIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setUTCHours(1);

    // Assert
    assertEquals(1, tbDate.getUTCHours());
  }

  /**
   * Test {@link TbDate#setUTCMinutes(int, int, int)} with {@code minutes}, {@code seconds}, {@code
   * ms}.
   *
   * <ul>
   *   <li>Then {@link TbDate#TbDate()} FullYear is {@code 2001}.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setUTCMinutes(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test setUTCMinutes(int, int, int) with 'minutes', 'seconds', 'ms'; then TbDate() FullYear is '2001'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setUTCMinutes(int, int, int)"})
  void testSetUTCMinutesWithMinutesSecondsMs_thenTbDateFullYearIs2001() {
    // Arrange
    TbDate tbDate = new TbDate();
    tbDate.setUTCFullYear(1);

    // Act
    tbDate.setUTCMinutes(1, 1, 70);

    // Assert
    assertEquals(2001, tbDate.getFullYear());
    assertEquals(2001, tbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#setUTCMinutes(int, int)} with {@code minutes}, {@code seconds}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setUTCMinutes(int, int)}
   */
  @Test
  @DisplayName(
      "Test setUTCMinutes(int, int) with 'minutes', 'seconds'; when one; then TbDate() Minutes is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setUTCMinutes(int, int)"})
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
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setUTCMinutes(int)}
   */
  @Test
  @DisplayName("Test setUTCMinutes(int) with 'minutes'; when one; then TbDate() Minutes is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setUTCMinutes(int)"})
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
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Milliseconds is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setUTCSeconds(int, int)}
   */
  @Test
  @DisplayName(
      "Test setUTCSeconds(int, int) with 'seconds', 'ms'; when one; then TbDate() Milliseconds is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setUTCSeconds(int, int)"})
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
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Seconds is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setUTCSeconds(int)}
   */
  @Test
  @DisplayName("Test setUTCSeconds(int) with 'seconds'; when one; then TbDate() Seconds is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setUTCSeconds(int)"})
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
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Milliseconds is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setUTCMilliseconds(int)}
   */
  @Test
  @DisplayName("Test setUTCMilliseconds(int); when one; then TbDate() Milliseconds is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setUTCMilliseconds(int)"})
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
   * Test {@link TbDate#setFullYear(int, int)} with {@code year}, {@code month}.
   *
   * <p>Method under test: {@link TbDate#setFullYear(int, int)}
   */
  @Test
  @DisplayName("Test setFullYear(int, int) with 'year', 'month'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setFullYear(int, int)"})
  void testSetFullYearWithYearMonth() {
    // Arrange
    TbDate tbDate = new TbDate(28L);
    tbDate.setUTCFullYear(1);

    // Act
    tbDate.setFullYear(1, 1);

    // Assert that nothing has changed
    assertEquals(1, tbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#setFullYear(int, int, int)} with {@code year}, {@code month}, {@code date}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} UTCFullYear is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setFullYear(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test setFullYear(int, int, int) with 'year', 'month', 'date'; when one; then TbDate() UTCFullYear is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setFullYear(int, int, int)"})
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
   *
   * <ul>
   *   <li>Given {@link TbDate#TbDate()}.
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} UTCFullYear is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setFullYear(int, int)}
   */
  @Test
  @DisplayName(
      "Test setFullYear(int, int) with 'year', 'month'; given TbDate(); when one; then TbDate() UTCFullYear is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setFullYear(int, int)"})
  void testSetFullYearWithYearMonth_givenTbDate_whenOne_thenTbDateUTCFullYearIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setFullYear(1, 1);

    // Assert
    assertEquals(1, tbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#setFullYear(int)} with {@code year}.
   *
   * <ul>
   *   <li>Given {@link TbDate#TbDate()}.
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} UTCFullYear is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setFullYear(int)}
   */
  @Test
  @DisplayName(
      "Test setFullYear(int) with 'year'; given TbDate(); when one; then TbDate() UTCFullYear is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setFullYear(int)"})
  void testSetFullYearWithYear_givenTbDate_whenOne_thenTbDateUTCFullYearIsOne() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setFullYear(1);

    // Assert
    assertEquals(1, tbDate.getUTCFullYear());
  }

  /**
   * Test {@link TbDate#setHours(int, int, int, int)} with {@code hrs}, {@code minutes}, {@code
   * seconds}, {@code ms}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Milliseconds is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setHours(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test setHours(int, int, int, int) with 'hrs', 'minutes', 'seconds', 'ms'; when one; then TbDate() Milliseconds is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setHours(int, int, int, int)"})
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
  }

  /**
   * Test {@link TbDate#setHours(int, int, int)} with {@code hrs}, {@code minutes}, {@code seconds}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setHours(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test setHours(int, int, int) with 'hrs', 'minutes', 'seconds'; when one; then TbDate() Minutes is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setHours(int, int, int)"})
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
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setHours(int, int)}
   */
  @Test
  @DisplayName(
      "Test setHours(int, int) with 'hrs', 'minutes'; when one; then TbDate() Minutes is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setHours(int, int)"})
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
   * Test {@link TbDate#setMinutes(int, int, int)} with {@code minutes}, {@code seconds}, {@code
   * ms}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Milliseconds is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setMinutes(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test setMinutes(int, int, int) with 'minutes', 'seconds', 'ms'; when one; then TbDate() Milliseconds is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setMinutes(int, int, int)"})
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
   * Test {@link TbDate#setMinutes(int, int)} with {@code minutes}, {@code seconds}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setMinutes(int, int)}
   */
  @Test
  @DisplayName(
      "Test setMinutes(int, int) with 'minutes', 'seconds'; when one; then TbDate() Minutes is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setMinutes(int, int)"})
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
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Minutes is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setMinutes(int)}
   */
  @Test
  @DisplayName("Test setMinutes(int) with 'minutes'; when one; then TbDate() Minutes is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setMinutes(int)"})
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
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Milliseconds is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setSeconds(int, int)}
   */
  @Test
  @DisplayName(
      "Test setSeconds(int, int) with 'seconds', 'ms'; when one; then TbDate() Milliseconds is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setSeconds(int, int)"})
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
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Seconds is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setSeconds(int)}
   */
  @Test
  @DisplayName("Test setSeconds(int) with 'seconds'; when one; then TbDate() Seconds is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setSeconds(int)"})
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
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbDate#TbDate()} Milliseconds is one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#setMilliseconds(int)}
   */
  @Test
  @DisplayName("Test setMilliseconds(int); when one; then TbDate() Milliseconds is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setMilliseconds(int)"})
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
   *
   * <p>Method under test: {@link TbDate#setTime(long)}
   */
  @Test
  @DisplayName("Test setTime(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDate.setTime(long)"})
  void testSetTime() {
    // Arrange
    TbDate tbDate = new TbDate();

    // Act
    tbDate.setTime(1L);

    // Assert
    assertEquals(
        "00:00:00.001", tbDate.getZonedDateTime().toLocalDateTime().toLocalTime().toString());
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
   *
   * <p>Method under test: {@link TbDate#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.parse(String)"})
  void testParseWithValue() {
    // Arrange, Act and Assert
    assertEquals(-1L, TbDate.parse("42"));
  }

  /**
   * Test {@link TbDate#parse(String, String)} with {@code value}, {@code format}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#parse(String, String)}
   */
  @Test
  @DisplayName(
      "Test parse(String, String) with 'value', 'format'; when empty string; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.parse(String, String)"})
  void testParseWithValueFormat_whenEmptyString_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1L, TbDate.parse("42", ""));
  }

  /**
   * Test {@link TbDate#parse(String, String)} with {@code value}, {@code format}.
   *
   * <ul>
   *   <li>When {@code Format}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbDate#parse(String, String)}
   */
  @Test
  @DisplayName(
      "Test parse(String, String) with 'value', 'format'; when 'Format'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbDate.parse(String, String)"})
  void testParseWithValueFormat_whenFormat_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1L, TbDate.parse("42", "Format"));
  }
}
