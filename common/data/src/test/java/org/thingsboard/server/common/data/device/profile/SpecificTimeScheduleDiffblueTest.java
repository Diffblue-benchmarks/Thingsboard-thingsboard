package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.DynamicValue;
import org.thingsboard.server.common.data.query.DynamicValueSourceType;

class SpecificTimeScheduleDiffblueTest {
  /**
   * Test {@link SpecificTimeSchedule#equals(Object)}, and {@link SpecificTimeSchedule#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SpecificTimeSchedule#equals(Object)}
   *   <li>{@link SpecificTimeSchedule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SpecificTimeSchedule.equals(Object)",
    "int SpecificTimeSchedule.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SpecificTimeSchedule specificTimeSchedule = new SpecificTimeSchedule();
    specificTimeSchedule.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule.setEndsOn(1L);
    specificTimeSchedule.setStartsOn(1L);
    specificTimeSchedule.setTimezone("UTC");

    SpecificTimeSchedule specificTimeSchedule2 = new SpecificTimeSchedule();
    specificTimeSchedule2.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule2.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule2.setEndsOn(1L);
    specificTimeSchedule2.setStartsOn(1L);
    specificTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertEquals(specificTimeSchedule, specificTimeSchedule2);
    int expectedHashCodeResult = specificTimeSchedule.hashCode();
    assertEquals(expectedHashCodeResult, specificTimeSchedule2.hashCode());
  }

  /**
   * Test {@link SpecificTimeSchedule#equals(Object)}, and {@link SpecificTimeSchedule#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SpecificTimeSchedule#equals(Object)}
   *   <li>{@link SpecificTimeSchedule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SpecificTimeSchedule.equals(Object)",
    "int SpecificTimeSchedule.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SpecificTimeSchedule specificTimeSchedule = new SpecificTimeSchedule();
    specificTimeSchedule.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule.setDynamicValue(null);
    specificTimeSchedule.setEndsOn(1L);
    specificTimeSchedule.setStartsOn(1L);
    specificTimeSchedule.setTimezone("UTC");

    SpecificTimeSchedule specificTimeSchedule2 = new SpecificTimeSchedule();
    specificTimeSchedule2.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule2.setDynamicValue(null);
    specificTimeSchedule2.setEndsOn(1L);
    specificTimeSchedule2.setStartsOn(1L);
    specificTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertEquals(specificTimeSchedule, specificTimeSchedule2);
    int expectedHashCodeResult = specificTimeSchedule.hashCode();
    assertEquals(expectedHashCodeResult, specificTimeSchedule2.hashCode());
  }

  /**
   * Test {@link SpecificTimeSchedule#equals(Object)}, and {@link SpecificTimeSchedule#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SpecificTimeSchedule#equals(Object)}
   *   <li>{@link SpecificTimeSchedule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SpecificTimeSchedule.equals(Object)",
    "int SpecificTimeSchedule.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SpecificTimeSchedule specificTimeSchedule = new SpecificTimeSchedule();
    specificTimeSchedule.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule.setEndsOn(1L);
    specificTimeSchedule.setStartsOn(1L);
    specificTimeSchedule.setTimezone(null);

    SpecificTimeSchedule specificTimeSchedule2 = new SpecificTimeSchedule();
    specificTimeSchedule2.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule2.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule2.setEndsOn(1L);
    specificTimeSchedule2.setStartsOn(1L);
    specificTimeSchedule2.setTimezone(null);

    // Act and Assert
    assertEquals(specificTimeSchedule, specificTimeSchedule2);
    int expectedHashCodeResult = specificTimeSchedule.hashCode();
    assertEquals(expectedHashCodeResult, specificTimeSchedule2.hashCode());
  }

  /**
   * Test {@link SpecificTimeSchedule#equals(Object)}, and {@link SpecificTimeSchedule#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SpecificTimeSchedule#equals(Object)}
   *   <li>{@link SpecificTimeSchedule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SpecificTimeSchedule.equals(Object)",
    "int SpecificTimeSchedule.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SpecificTimeSchedule specificTimeSchedule = new SpecificTimeSchedule();
    specificTimeSchedule.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule.setEndsOn(1L);
    specificTimeSchedule.setStartsOn(1L);
    specificTimeSchedule.setTimezone("UTC");

    // Act and Assert
    assertEquals(specificTimeSchedule, specificTimeSchedule);
    int expectedHashCodeResult = specificTimeSchedule.hashCode();
    assertEquals(expectedHashCodeResult, specificTimeSchedule.hashCode());
  }

  /**
   * Test {@link SpecificTimeSchedule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificTimeSchedule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SpecificTimeSchedule.equals(Object)",
    "int SpecificTimeSchedule.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<Integer> daysOfWeek = new HashSet<>();
    daysOfWeek.add(2);

    SpecificTimeSchedule specificTimeSchedule = new SpecificTimeSchedule();
    specificTimeSchedule.setDaysOfWeek(daysOfWeek);
    specificTimeSchedule.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule.setEndsOn(1L);
    specificTimeSchedule.setStartsOn(1L);
    specificTimeSchedule.setTimezone("UTC");

    SpecificTimeSchedule specificTimeSchedule2 = new SpecificTimeSchedule();
    specificTimeSchedule2.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule2.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule2.setEndsOn(1L);
    specificTimeSchedule2.setStartsOn(1L);
    specificTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(specificTimeSchedule, specificTimeSchedule2);
  }

  /**
   * Test {@link SpecificTimeSchedule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificTimeSchedule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SpecificTimeSchedule.equals(Object)",
    "int SpecificTimeSchedule.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SpecificTimeSchedule specificTimeSchedule = new SpecificTimeSchedule();
    specificTimeSchedule.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule.setDynamicValue(new DynamicValue<>(null, "Source Attribute"));
    specificTimeSchedule.setEndsOn(1L);
    specificTimeSchedule.setStartsOn(1L);
    specificTimeSchedule.setTimezone("UTC");

    SpecificTimeSchedule specificTimeSchedule2 = new SpecificTimeSchedule();
    specificTimeSchedule2.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule2.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule2.setEndsOn(1L);
    specificTimeSchedule2.setStartsOn(1L);
    specificTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(specificTimeSchedule, specificTimeSchedule2);
  }

  /**
   * Test {@link SpecificTimeSchedule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificTimeSchedule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SpecificTimeSchedule.equals(Object)",
    "int SpecificTimeSchedule.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SpecificTimeSchedule specificTimeSchedule = new SpecificTimeSchedule();
    specificTimeSchedule.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule.setDynamicValue(null);
    specificTimeSchedule.setEndsOn(1L);
    specificTimeSchedule.setStartsOn(1L);
    specificTimeSchedule.setTimezone("UTC");

    SpecificTimeSchedule specificTimeSchedule2 = new SpecificTimeSchedule();
    specificTimeSchedule2.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule2.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule2.setEndsOn(1L);
    specificTimeSchedule2.setStartsOn(1L);
    specificTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(specificTimeSchedule, specificTimeSchedule2);
  }

  /**
   * Test {@link SpecificTimeSchedule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificTimeSchedule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SpecificTimeSchedule.equals(Object)",
    "int SpecificTimeSchedule.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SpecificTimeSchedule specificTimeSchedule = new SpecificTimeSchedule();
    specificTimeSchedule.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule.setEndsOn(3L);
    specificTimeSchedule.setStartsOn(1L);
    specificTimeSchedule.setTimezone("UTC");

    SpecificTimeSchedule specificTimeSchedule2 = new SpecificTimeSchedule();
    specificTimeSchedule2.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule2.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule2.setEndsOn(1L);
    specificTimeSchedule2.setStartsOn(1L);
    specificTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(specificTimeSchedule, specificTimeSchedule2);
  }

  /**
   * Test {@link SpecificTimeSchedule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificTimeSchedule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SpecificTimeSchedule.equals(Object)",
    "int SpecificTimeSchedule.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SpecificTimeSchedule specificTimeSchedule = new SpecificTimeSchedule();
    specificTimeSchedule.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule.setEndsOn(1L);
    specificTimeSchedule.setStartsOn(3L);
    specificTimeSchedule.setTimezone("UTC");

    SpecificTimeSchedule specificTimeSchedule2 = new SpecificTimeSchedule();
    specificTimeSchedule2.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule2.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule2.setEndsOn(1L);
    specificTimeSchedule2.setStartsOn(1L);
    specificTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(specificTimeSchedule, specificTimeSchedule2);
  }

  /**
   * Test {@link SpecificTimeSchedule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificTimeSchedule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SpecificTimeSchedule.equals(Object)",
    "int SpecificTimeSchedule.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SpecificTimeSchedule specificTimeSchedule = new SpecificTimeSchedule();
    specificTimeSchedule.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule.setEndsOn(1L);
    specificTimeSchedule.setStartsOn(1L);
    specificTimeSchedule.setTimezone(System.getProperty("user.timezone"));

    SpecificTimeSchedule specificTimeSchedule2 = new SpecificTimeSchedule();
    specificTimeSchedule2.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule2.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule2.setEndsOn(1L);
    specificTimeSchedule2.setStartsOn(1L);
    specificTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(specificTimeSchedule, specificTimeSchedule2);
  }

  /**
   * Test {@link SpecificTimeSchedule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificTimeSchedule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SpecificTimeSchedule.equals(Object)",
    "int SpecificTimeSchedule.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SpecificTimeSchedule specificTimeSchedule = new SpecificTimeSchedule();
    specificTimeSchedule.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule.setEndsOn(1L);
    specificTimeSchedule.setStartsOn(1L);
    specificTimeSchedule.setTimezone(null);

    SpecificTimeSchedule specificTimeSchedule2 = new SpecificTimeSchedule();
    specificTimeSchedule2.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule2.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule2.setEndsOn(1L);
    specificTimeSchedule2.setStartsOn(1L);
    specificTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(specificTimeSchedule, specificTimeSchedule2);
  }

  /**
   * Test {@link SpecificTimeSchedule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificTimeSchedule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SpecificTimeSchedule.equals(Object)",
    "int SpecificTimeSchedule.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SpecificTimeSchedule specificTimeSchedule = new SpecificTimeSchedule();
    specificTimeSchedule.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule.setEndsOn(1L);
    specificTimeSchedule.setStartsOn(1L);
    specificTimeSchedule.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(specificTimeSchedule, null);
  }

  /**
   * Test {@link SpecificTimeSchedule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificTimeSchedule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SpecificTimeSchedule.equals(Object)",
    "int SpecificTimeSchedule.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SpecificTimeSchedule specificTimeSchedule = new SpecificTimeSchedule();
    specificTimeSchedule.setDaysOfWeek(new HashSet<>());
    specificTimeSchedule.setDynamicValue(
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    specificTimeSchedule.setEndsOn(1L);
    specificTimeSchedule.setStartsOn(1L);
    specificTimeSchedule.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(specificTimeSchedule, "Different type to SpecificTimeSchedule");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SpecificTimeSchedule}
   *   <li>{@link SpecificTimeSchedule#setDaysOfWeek(Set)}
   *   <li>{@link SpecificTimeSchedule#setDynamicValue(DynamicValue)}
   *   <li>{@link SpecificTimeSchedule#setEndsOn(long)}
   *   <li>{@link SpecificTimeSchedule#setStartsOn(long)}
   *   <li>{@link SpecificTimeSchedule#setTimezone(String)}
   *   <li>{@link SpecificTimeSchedule#toString()}
   *   <li>{@link SpecificTimeSchedule#getDaysOfWeek()}
   *   <li>{@link SpecificTimeSchedule#getDynamicValue()}
   *   <li>{@link SpecificTimeSchedule#getEndsOn()}
   *   <li>{@link SpecificTimeSchedule#getStartsOn()}
   *   <li>{@link SpecificTimeSchedule#getTimezone()}
   *   <li>{@link SpecificTimeSchedule#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void SpecificTimeSchedule.<init>()",
    "Set SpecificTimeSchedule.getDaysOfWeek()",
    "DynamicValue SpecificTimeSchedule.getDynamicValue()",
    "long SpecificTimeSchedule.getEndsOn()",
    "long SpecificTimeSchedule.getStartsOn()",
    "String SpecificTimeSchedule.getTimezone()",
    "AlarmScheduleType SpecificTimeSchedule.getType()",
    "void SpecificTimeSchedule.setDaysOfWeek(Set)",
    "void SpecificTimeSchedule.setDynamicValue(DynamicValue)",
    "void SpecificTimeSchedule.setEndsOn(long)",
    "void SpecificTimeSchedule.setStartsOn(long)",
    "void SpecificTimeSchedule.setTimezone(String)",
    "String SpecificTimeSchedule.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SpecificTimeSchedule actualSpecificTimeSchedule = new SpecificTimeSchedule();
    HashSet<Integer> daysOfWeek = new HashSet<>();
    actualSpecificTimeSchedule.setDaysOfWeek(daysOfWeek);
    DynamicValue<String> dynamicValue =
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    actualSpecificTimeSchedule.setDynamicValue(dynamicValue);
    actualSpecificTimeSchedule.setEndsOn(1L);
    actualSpecificTimeSchedule.setStartsOn(1L);
    actualSpecificTimeSchedule.setTimezone("UTC");
    String actualToStringResult = actualSpecificTimeSchedule.toString();
    Set<Integer> actualDaysOfWeek = actualSpecificTimeSchedule.getDaysOfWeek();
    DynamicValue<String> actualDynamicValue = actualSpecificTimeSchedule.getDynamicValue();
    long actualEndsOn = actualSpecificTimeSchedule.getEndsOn();
    long actualStartsOn = actualSpecificTimeSchedule.getStartsOn();
    String actualTimezone = actualSpecificTimeSchedule.getTimezone();

    // Assert
    assertEquals(
        "SpecificTimeSchedule(timezone=UTC, daysOfWeek=[], startsOn=1, endsOn=1, dynamicValue=DynamicValue"
            + "(resolvedValue=null, sourceType=CURRENT_TENANT, sourceAttribute=Source Attribute, inherit=false))",
        actualToStringResult);
    assertEquals("UTC", actualTimezone);
    assertEquals(1L, actualEndsOn);
    assertEquals(1L, actualStartsOn);
    assertEquals(AlarmScheduleType.SPECIFIC_TIME, actualSpecificTimeSchedule.getType());
    assertTrue(actualDaysOfWeek.isEmpty());
    assertSame(daysOfWeek, actualDaysOfWeek);
    assertSame(dynamicValue, actualDynamicValue);
  }
}
