package org.thingsboard.script.api.tbel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.time.format.FormatStyle;
import java.util.TimeZone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateTimeFormatOptionsDiffblueTest {
  /**
   * Test {@link DateTimeFormatOptions#equals(Object)}, and
   * {@link DateTimeFormatOptions#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DateTimeFormatOptions#equals(Object)}
   *   <li>{@link DateTimeFormatOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions("UTC");
    DateTimeFormatOptions dateTimeFormatOptions2 = new DateTimeFormatOptions("UTC");

    // Act and Assert
    assertEquals(dateTimeFormatOptions, dateTimeFormatOptions2);
    int expectedHashCodeResult = dateTimeFormatOptions.hashCode();
    assertEquals(expectedHashCodeResult, dateTimeFormatOptions2.hashCode());
  }

  /**
   * Test {@link DateTimeFormatOptions#equals(Object)}, and
   * {@link DateTimeFormatOptions#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DateTimeFormatOptions#equals(Object)}
   *   <li>{@link DateTimeFormatOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions("UTC");
    dateTimeFormatOptions.setDateStyle("2020-03-01");
    DateTimeFormatOptions dateTimeFormatOptions2 = new DateTimeFormatOptions("UTC");

    // Act and Assert
    assertEquals(dateTimeFormatOptions, dateTimeFormatOptions2);
    int expectedHashCodeResult = dateTimeFormatOptions.hashCode();
    assertEquals(expectedHashCodeResult, dateTimeFormatOptions2.hashCode());
  }

  /**
   * Test {@link DateTimeFormatOptions#equals(Object)}, and
   * {@link DateTimeFormatOptions#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DateTimeFormatOptions#equals(Object)}
   *   <li>{@link DateTimeFormatOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions("UTC");
    dateTimeFormatOptions.setPattern("Pattern");

    DateTimeFormatOptions dateTimeFormatOptions2 = new DateTimeFormatOptions("UTC");
    dateTimeFormatOptions2.setPattern("Pattern");

    // Act and Assert
    assertEquals(dateTimeFormatOptions, dateTimeFormatOptions2);
    int expectedHashCodeResult = dateTimeFormatOptions.hashCode();
    assertEquals(expectedHashCodeResult, dateTimeFormatOptions2.hashCode());
  }

  /**
   * Test {@link DateTimeFormatOptions#equals(Object)}, and
   * {@link DateTimeFormatOptions#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DateTimeFormatOptions#equals(Object)}
   *   <li>{@link DateTimeFormatOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions("UTC");

    // Act and Assert
    assertEquals(dateTimeFormatOptions, dateTimeFormatOptions);
    int expectedHashCodeResult = dateTimeFormatOptions.hashCode();
    assertEquals(expectedHashCodeResult, dateTimeFormatOptions.hashCode());
  }

  /**
   * Test {@link DateTimeFormatOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeFormatOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions(System.getProperty("user.timezone"));

    // Act and Assert
    assertNotEquals(dateTimeFormatOptions, new DateTimeFormatOptions("UTC"));
  }

  /**
   * Test {@link DateTimeFormatOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeFormatOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions(null);

    // Act and Assert
    assertNotEquals(dateTimeFormatOptions, new DateTimeFormatOptions("UTC"));
  }

  /**
   * Test {@link DateTimeFormatOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeFormatOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions("UTC");
    dateTimeFormatOptions.setPattern("Pattern");

    // Act and Assert
    assertNotEquals(dateTimeFormatOptions, new DateTimeFormatOptions("UTC"));
  }

  /**
   * Test {@link DateTimeFormatOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeFormatOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions("UTC");

    DateTimeFormatOptions dateTimeFormatOptions2 = new DateTimeFormatOptions("UTC");
    dateTimeFormatOptions2.setPattern("Pattern");

    // Act and Assert
    assertNotEquals(dateTimeFormatOptions, dateTimeFormatOptions2);
  }

  /**
   * Test {@link DateTimeFormatOptions#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeFormatOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DateTimeFormatOptions("UTC"), null);
  }

  /**
   * Test {@link DateTimeFormatOptions#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeFormatOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DateTimeFormatOptions("UTC"), "Different type to DateTimeFormatOptions");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DateTimeFormatOptions#DateTimeFormatOptions()}
   *   <li>{@link DateTimeFormatOptions#setDateStyle(String)}
   *   <li>{@link DateTimeFormatOptions#setPattern(String)}
   *   <li>{@link DateTimeFormatOptions#setTimeStyle(String)}
   *   <li>{@link DateTimeFormatOptions#setTimeZone(String)}
   *   <li>{@link DateTimeFormatOptions#toString()}
   *   <li>{@link DateTimeFormatOptions#getPattern()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    DateTimeFormatOptions actualDateTimeFormatOptions = new DateTimeFormatOptions();
    actualDateTimeFormatOptions.setDateStyle("2020-03-01");
    actualDateTimeFormatOptions.setPattern("Pattern");
    actualDateTimeFormatOptions.setTimeStyle("Time Style");
    actualDateTimeFormatOptions.setTimeZone("UTC");
    String actualToStringResult = actualDateTimeFormatOptions.toString();

    // Assert that nothing has changed
    assertEquals(
        "DateTimeFormatOptions(timeZone=sun.util.calendar.ZoneInfo[id=\"UTC\",offset=0,dstSavings=0,useDaylight"
            + "=false,transitions=0,lastRule=null], dateStyle=SHORT, timeStyle=MEDIUM, pattern=Pattern)",
        actualToStringResult);
    assertEquals("Pattern", actualDateTimeFormatOptions.getPattern());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code UTC}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DateTimeFormatOptions#DateTimeFormatOptions(String)}
   *   <li>{@link DateTimeFormatOptions#setDateStyle(String)}
   *   <li>{@link DateTimeFormatOptions#setPattern(String)}
   *   <li>{@link DateTimeFormatOptions#setTimeStyle(String)}
   *   <li>{@link DateTimeFormatOptions#setTimeZone(String)}
   *   <li>{@link DateTimeFormatOptions#toString()}
   *   <li>{@link DateTimeFormatOptions#getPattern()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'UTC'")
  void testGettersAndSetters_whenUtc() {
    // Arrange and Act
    DateTimeFormatOptions actualDateTimeFormatOptions = new DateTimeFormatOptions("UTC");
    actualDateTimeFormatOptions.setDateStyle("2020-03-01");
    actualDateTimeFormatOptions.setPattern("Pattern");
    actualDateTimeFormatOptions.setTimeStyle("Time Style");
    actualDateTimeFormatOptions.setTimeZone("UTC");
    String actualToStringResult = actualDateTimeFormatOptions.toString();

    // Assert that nothing has changed
    assertEquals(
        "DateTimeFormatOptions(timeZone=sun.util.calendar.ZoneInfo[id=\"UTC\",offset=0,dstSavings=0,useDaylight"
            + "=false,transitions=0,lastRule=null], dateStyle=SHORT, timeStyle=MEDIUM, pattern=Pattern)",
        actualToStringResult);
    assertEquals("Pattern", actualDateTimeFormatOptions.getPattern());
  }

  /**
   * Test {@link DateTimeFormatOptions#getTimeZone()}.
   * <ul>
   *   <li>Then return DisplayName is {@code Coordinated Universal Time}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeFormatOptions#getTimeZone()}
   */
  @Test
  @DisplayName("Test getTimeZone(); then return DisplayName is 'Coordinated Universal Time'")
  void testGetTimeZone_thenReturnDisplayNameIsCoordinatedUniversalTime() {
    // Arrange and Act
    TimeZone actualTimeZone = (new DateTimeFormatOptions("UTC")).getTimeZone();

    // Assert
    assertEquals("Coordinated Universal Time", actualTimeZone.getDisplayName());
    assertEquals("UTC", actualTimeZone.getID());
    assertEquals(0, actualTimeZone.getDSTSavings());
  }

  /**
   * Test {@link DateTimeFormatOptions#getDateStyle()}.
   * <p>
   * Method under test: {@link DateTimeFormatOptions#getDateStyle()}
   */
  @Test
  @DisplayName("Test getDateStyle()")
  void testGetDateStyle() {
    // Arrange
    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions("UTC");
    dateTimeFormatOptions.setDateStyle("");

    // Act and Assert
    assertEquals(FormatStyle.SHORT, dateTimeFormatOptions.getDateStyle());
  }

  /**
   * Test {@link DateTimeFormatOptions#getDateStyle()}.
   * <ul>
   *   <li>Given {@link DateTimeFormatOptions#DateTimeFormatOptions(String)} with
   * timeZone is {@code UTC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeFormatOptions#getDateStyle()}
   */
  @Test
  @DisplayName("Test getDateStyle(); given DateTimeFormatOptions(String) with timeZone is 'UTC'")
  void testGetDateStyle_givenDateTimeFormatOptionsWithTimeZoneIsUtc() {
    // Arrange, Act and Assert
    assertEquals(FormatStyle.SHORT, (new DateTimeFormatOptions("UTC")).getDateStyle());
  }

  /**
   * Test {@link DateTimeFormatOptions#getDateStyle()}.
   * <ul>
   *   <li>Given {@link DateTimeFormatOptions#DateTimeFormatOptions(String)} with
   * timeZone is {@code UTC} DateStyle is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeFormatOptions#getDateStyle()}
   */
  @Test
  @DisplayName("Test getDateStyle(); given DateTimeFormatOptions(String) with timeZone is 'UTC' DateStyle is 'foo'")
  void testGetDateStyle_givenDateTimeFormatOptionsWithTimeZoneIsUtcDateStyleIsFoo() {
    // Arrange
    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions("UTC");
    dateTimeFormatOptions.setDateStyle("foo");

    // Act and Assert
    assertEquals(FormatStyle.SHORT, dateTimeFormatOptions.getDateStyle());
  }

  /**
   * Test {@link DateTimeFormatOptions#getTimeStyle()}.
   * <p>
   * Method under test: {@link DateTimeFormatOptions#getTimeStyle()}
   */
  @Test
  @DisplayName("Test getTimeStyle()")
  void testGetTimeStyle() {
    // Arrange
    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions("UTC");
    dateTimeFormatOptions.setTimeStyle("");

    // Act and Assert
    assertEquals(FormatStyle.MEDIUM, dateTimeFormatOptions.getTimeStyle());
  }

  /**
   * Test {@link DateTimeFormatOptions#getTimeStyle()}.
   * <ul>
   *   <li>Given {@link DateTimeFormatOptions#DateTimeFormatOptions(String)} with
   * timeZone is {@code UTC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeFormatOptions#getTimeStyle()}
   */
  @Test
  @DisplayName("Test getTimeStyle(); given DateTimeFormatOptions(String) with timeZone is 'UTC'")
  void testGetTimeStyle_givenDateTimeFormatOptionsWithTimeZoneIsUtc() {
    // Arrange, Act and Assert
    assertEquals(FormatStyle.MEDIUM, (new DateTimeFormatOptions("UTC")).getTimeStyle());
  }

  /**
   * Test {@link DateTimeFormatOptions#getTimeStyle()}.
   * <ul>
   *   <li>Given {@link DateTimeFormatOptions#DateTimeFormatOptions(String)} with
   * timeZone is {@code UTC} TimeStyle is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateTimeFormatOptions#getTimeStyle()}
   */
  @Test
  @DisplayName("Test getTimeStyle(); given DateTimeFormatOptions(String) with timeZone is 'UTC' TimeStyle is 'foo'")
  void testGetTimeStyle_givenDateTimeFormatOptionsWithTimeZoneIsUtcTimeStyleIsFoo() {
    // Arrange
    DateTimeFormatOptions dateTimeFormatOptions = new DateTimeFormatOptions("UTC");
    dateTimeFormatOptions.setTimeStyle("foo");

    // Act and Assert
    assertEquals(FormatStyle.MEDIUM, dateTimeFormatOptions.getTimeStyle());
  }
}
